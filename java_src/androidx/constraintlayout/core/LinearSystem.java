package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    ArrayRow[] mRows;
    private Row mTempGoal;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int TABLE_SIZE = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    private int mPoolVariablesCount = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z);

        void updateFromSystem(LinearSystem linearSystem);
    }

    private String getDisplayStrength(int i) {
        return i == 1 ? "LOW" : i == 2 ? "MEDIUM" : i == 3 ? "HIGH" : i == 4 ? "HIGHEST" : i == 5 ? "EQUALITY" : i == 8 ? "FIXED" : i == 6 ? "BARRIER" : "NONE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[32];
        releaseRows();
        this.mCache = new Cache();
        this.mGoal = new PriorityGoalRow(this.mCache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i2 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mMaxColumns = i2;
        this.mMaxRows = i2;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            Metrics metrics2 = sMetrics;
            metrics2.maxTableSize = Math.max(metrics2.maxTableSize, this.TABLE_SIZE);
            Metrics metrics3 = sMetrics;
            metrics3.lastTableSize = metrics3.maxTableSize;
        }
    }

    private void releaseRows() {
        int i = 0;
        if (OPTIMIZED_ENGINE) {
            while (i < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i] = null;
                i++;
            }
            return;
        }
        while (i < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i];
            if (arrayRow2 != null) {
                this.mCache.arrayRowPool.release(arrayRow2);
            }
            this.mRows[i] = null;
            i++;
        }
    }

    public void reset() {
        for (int i = 0; i < this.mCache.mIndexedVariables.length; i++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
        }
        this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2] != null) {
                arrayRowArr[i2].used = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            if (solverVariable.id == -1 || solverVariable.id > this.mVariablesID || this.mCache.mIndexedVariables[solverVariable.id] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                int i = this.mVariablesID + 1;
                this.mVariablesID = i;
                this.mNumColumns++;
                solverVariable.id = i;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire;
        if (OPTIMIZED_ENGINE) {
            acquire = this.mCache.optimizedArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        } else {
            acquire = this.mCache.arrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private void addSingleError(ArrayRow arrayRow, int i) {
        addSingleError(arrayRow, i, 0);
    }

    void addSingleError(ArrayRow arrayRow, int i, int i2) {
        arrayRow.addSingleError(createErrorVariable(i2, null), i);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createErrorVariable(int i, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        acquireSolverVariable.id = i2;
        acquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.mCache.solverVariablePool.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i = this.mPoolVariablesCount;
        int i2 = POOL_SIZE;
        if (i >= i2) {
            int i3 = i2 * 2;
            POOL_SIZE = i3;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i3);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i4 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i4 + 1;
        solverVariableArr[i4] = acquire;
        return acquire;
    }

    Row getGoal() {
        return this.mGoal;
    }

    ArrayRow getRow(int i) {
        return this.mRows[i];
    }

    float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
        } else if (this.graphOptimizer || this.newgraphOptimizer) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.graphOptimizer++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.mNumRows) {
                    z = true;
                    break;
                } else if (!this.mRows[i].isSimpleDefinition) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                minimizeGoal(this.mGoal);
                return;
            }
            Metrics metrics3 = sMetrics;
            if (metrics3 != null) {
                metrics3.fullySolved++;
            }
            computeValues();
        } else {
            minimizeGoal(this.mGoal);
        }
    }

    void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            Metrics metrics2 = sMetrics;
            metrics2.maxVariables = Math.max(metrics2.maxVariables, this.mNumColumns);
            Metrics metrics3 = sMetrics;
            metrics3.maxRows = Math.max(metrics3.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    final void cleanupRows() {
        int i;
        int i2 = 0;
        while (i2 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                arrayRow.variable.computedValue = arrayRow.constantValue;
                arrayRow.variable.removeFromRow(arrayRow);
                int i3 = i2;
                while (true) {
                    i = this.mNumRows;
                    if (i3 >= i - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i4 = i3 + 1;
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.mRows[i - 1] = null;
                this.mNumRows = i - 1;
                i2--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.arrayRowPool.release(arrayRow);
                }
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addConstraint(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L3
            return
        L3:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.sMetrics
            r1 = 1
            if (r0 == 0) goto L19
            long r3 = r0.constraints
            long r3 = r3 + r1
            r0.constraints = r3
            boolean r0 = r8.isSimpleDefinition
            if (r0 == 0) goto L19
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.sMetrics
            long r3 = r0.simpleconstraints
            long r3 = r3 + r1
            r0.simpleconstraints = r3
        L19:
            int r0 = r7.mNumRows
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.mMaxRows
            if (r0 >= r4) goto L28
            int r0 = r7.mNumColumns
            int r0 = r0 + r3
            int r4 = r7.mMaxColumns
            if (r0 < r4) goto L2b
        L28:
            r7.increaseTableSize()
        L2b:
            r0 = 0
            boolean r4 = r8.isSimpleDefinition
            if (r4 != 0) goto La3
            r8.updateFromSystem(r7)
            boolean r4 = r8.isEmpty()
            if (r4 == 0) goto L3a
            return
        L3a:
            r8.ensurePositiveConstant()
            boolean r4 = r8.chooseSubject(r7)
            if (r4 == 0) goto L9a
            androidx.constraintlayout.core.SolverVariable r4 = r7.createExtraVariable()
            r8.variable = r4
            int r5 = r7.mNumRows
            r7.addRow(r8)
            int r6 = r7.mNumRows
            int r5 = r5 + r3
            if (r6 != r5) goto L9a
            androidx.constraintlayout.core.LinearSystem$Row r0 = r7.mTempGoal
            r0.initFromRow(r8)
            androidx.constraintlayout.core.LinearSystem$Row r0 = r7.mTempGoal
            r7.optimize(r0, r3)
            int r0 = r4.definitionId
            r5 = -1
            if (r0 != r5) goto L9b
            androidx.constraintlayout.core.SolverVariable r0 = r8.variable
            if (r0 != r4) goto L78
            androidx.constraintlayout.core.SolverVariable r0 = r8.pickPivot(r4)
            if (r0 == 0) goto L78
            androidx.constraintlayout.core.Metrics r4 = androidx.constraintlayout.core.LinearSystem.sMetrics
            if (r4 == 0) goto L75
            long r5 = r4.pivots
            long r5 = r5 + r1
            r4.pivots = r5
        L75:
            r8.pivot(r0)
        L78:
            boolean r0 = r8.isSimpleDefinition
            if (r0 != 0) goto L81
            androidx.constraintlayout.core.SolverVariable r0 = r8.variable
            r0.updateReferencesWithNewDefinition(r7, r8)
        L81:
            boolean r0 = androidx.constraintlayout.core.LinearSystem.OPTIMIZED_ENGINE
            if (r0 == 0) goto L8d
            androidx.constraintlayout.core.Cache r0 = r7.mCache
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.optimizedArrayRowPool
            r0.release(r8)
            goto L94
        L8d:
            androidx.constraintlayout.core.Cache r0 = r7.mCache
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.arrayRowPool
            r0.release(r8)
        L94:
            int r0 = r7.mNumRows
            int r0 = r0 - r3
            r7.mNumRows = r0
            goto L9b
        L9a:
            r3 = r0
        L9b:
            boolean r0 = r8.hasKeyVariable()
            if (r0 != 0) goto La2
            return
        La2:
            r0 = r3
        La3:
            if (r0 != 0) goto La8
            r7.addRow(r8)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.addConstraint(androidx.constraintlayout.core.ArrayRow):void");
    }

    private final void addRow(ArrayRow arrayRow) {
        int i;
        if (SIMPLIFY_SYNONYMS && arrayRow.isSimpleDefinition) {
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        } else {
            this.mRows[this.mNumRows] = arrayRow;
            arrayRow.variable.definitionId = this.mNumRows;
            this.mNumRows++;
            arrayRow.variable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i2 = 0;
            while (i2 < this.mNumRows) {
                if (this.mRows[i2] == null) {
                    System.out.println("WTF");
                }
                ArrayRow[] arrayRowArr = this.mRows;
                if (arrayRowArr[i2] != null && arrayRowArr[i2].isSimpleDefinition) {
                    ArrayRow arrayRow2 = this.mRows[i2];
                    arrayRow2.variable.setFinalValue(this, arrayRow2.constantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i2] = null;
                    int i3 = i2 + 1;
                    int i4 = i3;
                    while (true) {
                        i = this.mNumRows;
                        if (i3 >= i) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i5 = i3 - 1;
                        arrayRowArr2[i5] = arrayRowArr2[i3];
                        if (arrayRowArr2[i5].variable.definitionId == i3) {
                            this.mRows[i5].variable.definitionId = i5;
                        }
                        i4 = i3;
                        i3++;
                    }
                    if (i4 < i) {
                        this.mRows[i4] = null;
                    }
                    this.mNumRows--;
                    i2--;
                }
                i2++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    public void removeRow(ArrayRow arrayRow) {
        int i;
        if (!arrayRow.isSimpleDefinition || arrayRow.variable == null) {
            return;
        }
        if (arrayRow.variable.definitionId != -1) {
            int i2 = arrayRow.variable.definitionId;
            while (true) {
                i = this.mNumRows;
                if (i2 >= i - 1) {
                    break;
                }
                int i3 = i2 + 1;
                SolverVariable solverVariable = this.mRows[i3].variable;
                if (solverVariable.definitionId == i3) {
                    solverVariable.definitionId = i2;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                arrayRowArr[i2] = arrayRowArr[i3];
                i2 = i3;
            }
            this.mNumRows = i - 1;
        }
        if (!arrayRow.variable.isFinalValue) {
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        }
        if (OPTIMIZED_ENGINE) {
            this.mCache.optimizedArrayRowPool.release(arrayRow);
        } else {
            this.mCache.arrayRowPool.release(arrayRow);
        }
    }

    private final int optimize(Row row, boolean z) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i2++;
            if (i2 >= this.mNumColumns * 2) {
                return i2;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                if (this.mAlreadyTestedCandidates[pivotCandidate.id]) {
                    return i2;
                }
                this.mAlreadyTestedCandidates[pivotCandidate.id] = true;
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.mNumRows; i4++) {
                    ArrayRow arrayRow = this.mRows[i4];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f2 = arrayRow.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow.constantValue) / f2;
                            if (f3 < f) {
                                i3 = i4;
                                f = f3;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i3];
                    arrayRow2.variable.definitionId = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    arrayRow2.variable.definitionId = i3;
                    arrayRow2.variable.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z2 = true;
            }
        }
        return i2;
    }

    private int enforceBFS(Row row) throws Exception {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= this.mNumRows) {
                z = false;
                break;
            } else if (this.mRows[i].variable.mType != SolverVariable.Type.UNRESTRICTED && this.mRows[i].constantValue < 0.0f) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            boolean z2 = false;
            int i2 = 0;
            while (!z2) {
                Metrics metrics = sMetrics;
                if (metrics != null) {
                    metrics.bfs++;
                }
                i2++;
                float f = Float.MAX_VALUE;
                int i3 = -1;
                int i4 = -1;
                int i5 = 0;
                for (int i6 = 0; i6 < this.mNumRows; i6++) {
                    ArrayRow arrayRow = this.mRows[i6];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.constantValue < 0.0f) {
                        int i7 = 9;
                        if (SKIP_COLUMNS) {
                            int currentSize = arrayRow.variables.getCurrentSize();
                            int i8 = 0;
                            while (i8 < currentSize) {
                                SolverVariable variable = arrayRow.variables.getVariable(i8);
                                float f2 = arrayRow.variables.get(variable);
                                if (f2 > 0.0f) {
                                    int i9 = 0;
                                    while (i9 < i7) {
                                        float f3 = variable.strengthVector[i9] / f2;
                                        if ((f3 < f && i9 == i5) || i9 > i5) {
                                            i4 = variable.id;
                                            i5 = i9;
                                            i3 = i6;
                                            f = f3;
                                        }
                                        i9++;
                                        i7 = 9;
                                    }
                                }
                                i8++;
                                i7 = 9;
                            }
                        } else {
                            for (int i10 = 1; i10 < this.mNumColumns; i10++) {
                                SolverVariable solverVariable = this.mCache.mIndexedVariables[i10];
                                float f4 = arrayRow.variables.get(solverVariable);
                                if (f4 > 0.0f) {
                                    for (int i11 = 0; i11 < 9; i11++) {
                                        float f5 = solverVariable.strengthVector[i11] / f4;
                                        if ((f5 < f && i11 == i5) || i11 > i5) {
                                            i4 = i10;
                                            i5 = i11;
                                            i3 = i6;
                                            f = f5;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i3 != -1) {
                    ArrayRow arrayRow2 = this.mRows[i3];
                    arrayRow2.variable.definitionId = -1;
                    Metrics metrics2 = sMetrics;
                    if (metrics2 != null) {
                        metrics2.pivots++;
                    }
                    arrayRow2.pivot(this.mCache.mIndexedVariables[i4]);
                    arrayRow2.variable.definitionId = i3;
                    arrayRow2.variable.updateReferencesWithNewDefinition(this, arrayRow2);
                } else {
                    z2 = true;
                }
                if (i2 > this.mNumColumns / 2) {
                    z2 = true;
                }
            }
            return i2;
        }
        return 0;
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            str = (str + this.mRows[i]) + "\n";
        }
        System.out.println(str + this.mGoal + "\n");
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = " num vars " + this.mVariablesID + "\n";
        for (int i = 0; i < this.mVariablesID + 1; i++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String str2 = str + "\n";
        for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
            SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i2];
            if (solverVariable2 != null && solverVariable2.isSynonym) {
                str2 = str2 + " ~[" + i2 + "] => " + solverVariable2 + " = " + this.mCache.mIndexedVariables[solverVariable2.synonym] + " + " + solverVariable2.synonymDelta + "\n";
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            str3 = (str3 + this.mRows[i3].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str3 = str3 + "Goal: " + this.mGoal + "\n";
        }
        System.out.println(str3);
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i].toReadableString()) + "\n";
            }
        }
        System.out.println(str + this.mGoal + "\n");
    }

    public int getMemoryUsed() {
        int i = 0;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2] != null) {
                i += arrayRowArr[i2].sizeInBytes();
            }
        }
        return i;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    void displaySystemInformations() {
        int i = 0;
        for (int i2 = 0; i2 < this.TABLE_SIZE; i2++) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2] != null) {
                i += arrayRowArr[i2].sizeInBytes();
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.mNumRows; i4++) {
            ArrayRow[] arrayRowArr2 = this.mRows;
            if (arrayRowArr2[i4] != null) {
                i3 += arrayRowArr2[i4].sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Linear System -> Table size: ");
        sb.append(this.TABLE_SIZE);
        sb.append(" (");
        int i5 = this.TABLE_SIZE;
        sb.append(getDisplaySize(i5 * i5));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(i));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(i3));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append("/");
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append("/");
        sb.append(this.mMaxColumns);
        sb.append(" ");
        sb.append(0);
        sb.append(" occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private String getDisplaySize(int i) {
        int i2 = i * 4;
        int i3 = i2 / 1024;
        int i4 = i3 / 1024;
        if (i4 > 0) {
            return "" + i4 + " Mb";
        } else if (i3 > 0) {
            return "" + i3 + " Kb";
        } else {
            return "" + i2 + " bytes";
        }
    }

    public Cache getCache() {
        return this.mCache;
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i2);
        }
        addConstraint(createRow);
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i2);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 8) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        if (solverVariable.definitionId == -1 && i == 0) {
            if (solverVariable2.isSynonym) {
                float f = solverVariable2.synonymDelta;
                solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.synonym];
            }
            if (solverVariable.isSynonym) {
                float f2 = solverVariable.synonymDelta;
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.synonym];
                return;
            }
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
            return;
        }
        addEquality(solverVariable, solverVariable2, i, 8);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (USE_BASIC_SYNONYMS && i2 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i);
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        if (USE_BASIC_SYNONYMS && solverVariable.definitionId == -1) {
            float f = i;
            solverVariable.setFinalValue(this, f);
            for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i2];
                if (solverVariable2 != null && solverVariable2.isSynonym && solverVariable2.synonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.synonymDelta + f);
                }
            }
            return;
        }
        int i3 = solverVariable.definitionId;
        if (solverVariable.definitionId != -1) {
            ArrayRow arrayRow = this.mRows[i3];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = i;
                return;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = i;
                return;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i);
                addConstraint(createRow);
                return;
            }
        }
        ArrayRow createRow2 = createRow();
        createRow2.createRowDefinition(solverVariable, i);
        addConstraint(createRow2);
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow createRow = createRow();
        double d = f;
        double d2 = i;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d) * d2));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d) * d2));
        addConstraint(createRow2);
    }
}
