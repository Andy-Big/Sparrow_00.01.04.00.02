package com.rigol.scope.data;

import android.view.KeyEvent;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KeyCodeUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BaseParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%J\u0012\u0010&\u001a\u00020'2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0004J\u0012\u0010+\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J,\u0010,\u001a\u00020\u00032\u0006\u0010!\u001a\u00020-2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010.\u001a\u00020/2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u00100\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0004J\u0018\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0004J\u0012\u00102\u001a\u00020-2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J,\u00103\u001a\u00020-2\u0006\u0010!\u001a\u00020-2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010.\u001a\u00020/2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u00104\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0004J,\u00104\u001a\u00020\u001a2\u0006\u00101\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0004J\b\u00106\u001a\u00020\u001aH\u0016J\u0016\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#J\u000e\u00109\u001a\u00020/2\u0006\u00108\u001a\u00020\u0003J\u0016\u00109\u001a\u00020/2\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003J\u000e\u0010;\u001a\u00020'2\u0006\u00108\u001a\u00020\u0003J\u0016\u0010;\u001a\u00020'2\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003J\u000e\u0010<\u001a\u00020=2\u0006\u00108\u001a\u00020\u0003J\u0016\u0010<\u001a\u00020=2\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003J\u000e\u0010>\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003J\u0016\u0010>\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003J\u000e\u0010?\u001a\u00020-2\u0006\u00108\u001a\u00020\u0003J\u0016\u0010?\u001a\u00020-2\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003J\u000e\u0010@\u001a\u00020A2\u0006\u00108\u001a\u00020\u0003J\u000e\u0010B\u001a\u00020)2\u0006\u00108\u001a\u00020\u0003J\u0016\u0010B\u001a\u00020)2\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003J\u0010\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u0006H\u0016J\b\u0010E\u001a\u00020\u001aH\u0016J\u0016\u0010F\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020/J\u0016\u0010G\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020/J\u0016\u0010G\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003J\u0016\u0010H\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020-J\u0016\u0010I\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020AJ\u0018\u0010J\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010)J\u0018\u0010K\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u00032\b\u0010L\u001a\u0004\u0018\u00010 J \u0010K\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\b\u0010L\u001a\u0004\u0018\u00010 J\u0018\u0010M\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0004¨\u0006N"}, d2 = {"Lcom/rigol/scope/data/BaseParam;", "Landroidx/databinding/BaseObservable;", "serviceId", "", "(I)V", "keyEvent", "Landroid/view/KeyEvent;", "getKeyEvent", "()Landroid/view/KeyEvent;", "setKeyEvent", "(Landroid/view/KeyEvent;)V", "maxFieldLength", "panelKeyViewModel", "Lcom/rigol/scope/viewmodels/PanelKeyViewModel;", "getPanelKeyViewModel", "()Lcom/rigol/scope/viewmodels/PanelKeyViewModel;", "setPanelKeyViewModel", "(Lcom/rigol/scope/viewmodels/PanelKeyViewModel;)V", "sb", "Ljava/lang/StringBuffer;", "getSb", "()Ljava/lang/StringBuffer;", "getServiceId", "()I", "setServiceId", "bindAll", "", "viewModel", "Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "checkAttrRang", "", "value", "attr", "Lcom/rigol/scope/cil/MessageAttr;", "clazz", "Ljava/lang/Class;", "getDoubleDef", "", "getFieldNameWithSpace", "", "fieldName", "getIntDef", "getIntStep", "", "isUp", "", "getLogPrefix", "className", "getLongDef", "getLongStep", "log", "field", "readAll", "readAttr", "mid", "readBool", "param", "readDouble", "readFloat", "", "readInt", "readLong", "readShort", "", "readStr", "releaseCurrentKeyEvent", "keyEvent1", "reset", "saveBool", "saveInt", "saveLong", "saveShort", "saveStr", "syncData", "data", "unbindAll", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class BaseParam extends BaseObservable {
    private KeyEvent keyEvent;
    private int maxFieldLength;
    private PanelKeyViewModel panelKeyViewModel;
    private final StringBuffer sb = new StringBuffer();
    private int serviceId;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void log(String fieldName, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    protected final void log(String className, String fieldName, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    public BaseParam(int i) {
        Field[] declaredFields;
        this.serviceId = i;
        for (Field f : getClass().getDeclaredFields()) {
            Intrinsics.checkNotNullExpressionValue(f, "f");
            if (f.getName().length() > this.maxFieldLength) {
                this.maxFieldLength = f.getName().length();
            }
        }
    }

    public final int getServiceId() {
        return this.serviceId;
    }

    public final void setServiceId(int i) {
        this.serviceId = i;
    }

    protected final StringBuffer getSb() {
        return this.sb;
    }

    protected final String getFieldNameWithSpace(String fieldName) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        this.sb.setLength(0);
        this.sb.append(fieldName);
        int length = this.maxFieldLength - fieldName.length();
        for (int i = 0; i < length; i++) {
            this.sb.append(" ");
        }
        String stringBuffer = this.sb.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "sb.toString()");
        return stringBuffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getLogPrefix(String fieldName) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        this.sb.setLength(0);
        this.sb.append(getClass().getSimpleName());
        this.sb.append(", ");
        this.sb.append(fieldName);
        int length = this.maxFieldLength - fieldName.length();
        for (int i = 0; i < length; i++) {
            this.sb.append(" ");
        }
        String stringBuffer = this.sb.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "sb.toString()");
        return stringBuffer;
    }

    protected final String getLogPrefix(String className, String fieldName) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        this.sb.setLength(0);
        this.sb.append(className);
        this.sb.append(", ");
        this.sb.append(fieldName);
        int length = this.maxFieldLength - fieldName.length();
        for (int i = 0; i < length; i++) {
            this.sb.append(" ");
        }
        String stringBuffer = this.sb.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "sb.toString()");
        return stringBuffer;
    }

    public final boolean readBool(int i) {
        return API.getInstance().UI_QueryBool(this.serviceId, i);
    }

    public final boolean readBool(int i, int i2) {
        return API.getInstance().UI_QueryBoolBy(this.serviceId, i, i2);
    }

    public final short readShort(int i) {
        return API.getInstance().UI_QueryInt16(this.serviceId, i);
    }

    public final int readInt(int i) {
        return API.getInstance().UI_QueryInt32(this.serviceId, i);
    }

    public final int readInt(int i, int i2) {
        return API.getInstance().UI_QueryInt32By(this.serviceId, i, i2);
    }

    public final long readLong(int i) {
        return API.getInstance().UI_QueryInt64(this.serviceId, i);
    }

    public final long readLong(int i, int i2) {
        return API.getInstance().UI_QueryInt64By(this.serviceId, i, i2);
    }

    public final float readFloat(int i) {
        return API.getInstance().UI_QueryFloat(this.serviceId, i);
    }

    public final float readFloat(int i, int i2) {
        return API.getInstance().UI_QueryFloatBy(this.serviceId, i, i2);
    }

    public final double readDouble(int i) {
        return API.getInstance().UI_QueryDouble(this.serviceId, i);
    }

    public final double readDouble(int i, int i2) {
        return API.getInstance().UI_QueryDoubleBy(this.serviceId, i, i2);
    }

    public final String readStr(int i) {
        String strData = API.getInstance().UI_QueryStr(this.serviceId, i);
        Intrinsics.checkNotNullExpressionValue(strData, "strData");
        return strData;
    }

    public final String readStr(int i, int i2) {
        String UI_QueryStrBy = API.getInstance().UI_QueryStrBy(this.serviceId, i, i2);
        Intrinsics.checkNotNullExpressionValue(UI_QueryStrBy, "API.getInstance().UI_Que…By(serviceId, mid, param)");
        return UI_QueryStrBy;
    }

    public final int readAttr(int i, MessageAttr attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        return API.getInstance().UI_QueryAttr(this.serviceId, i, attr);
    }

    public final int saveBool(int i, boolean z) {
        return API.getInstance().UI_PostBool(this.serviceId, i, z);
    }

    public final int saveShort(int i, short s) {
        return API.getInstance().UI_PostInt16(this.serviceId, i, s);
    }

    public final int saveInt(int i, int i2) {
        return API.getInstance().UI_PostInt32(this.serviceId, i, i2);
    }

    public final int saveInt(int i, boolean z) {
        return API.getInstance().UI_PostInt32(this.serviceId, i, z ? 1 : 0);
    }

    public final int saveLong(int i, long j) {
        return API.getInstance().UI_PostInt64(this.serviceId, i, j);
    }

    public final int saveStr(int i, String str) {
        return API.getInstance().UI_PostStr(this.serviceId, i, str);
    }

    public final void syncData(int i, Object obj) {
        MessageBus.getInstance().onSyncData(MessageBus.getKey(this.serviceId, i), obj);
    }

    public final void syncData(int i, int i2, Object obj) {
        MessageBus.getInstance().onSyncData(MessageBus.getKey(this.serviceId, i, i2), obj);
    }

    public final Object checkAttrRang(Object value, MessageAttr messageAttr, Class<?> clazz) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (messageAttr == null) {
            return value;
        }
        if (Intrinsics.areEqual(clazz, Long.TYPE) || Intrinsics.areEqual(clazz, Long.TYPE)) {
            if (((Long) value).longValue() > messageAttr.getMaxLongValue()) {
                return Long.valueOf(messageAttr.getMaxLongValue());
            }
            return ((Number) value).longValue() < messageAttr.getMinLongValue() ? Long.valueOf(messageAttr.getMinLongValue()) : value;
        } else if (Intrinsics.areEqual(clazz, Integer.TYPE) || Intrinsics.areEqual(clazz, Integer.TYPE)) {
            if (((Integer) value).intValue() > messageAttr.getMaxIntValue()) {
                return Integer.valueOf(messageAttr.getMaxIntValue());
            }
            return ((Number) value).intValue() < messageAttr.getMinIntValue() ? Integer.valueOf(messageAttr.getMinIntValue()) : value;
        } else if (Intrinsics.areEqual(clazz, Double.TYPE) || Intrinsics.areEqual(clazz, Double.TYPE)) {
            if (((Double) value).doubleValue() > messageAttr.getMaxDoubleValue()) {
                return Double.valueOf(messageAttr.getMaxDoubleValue());
            }
            return ((Number) value).doubleValue() < messageAttr.getMinDoubleValue() ? Double.valueOf(messageAttr.getMinDoubleValue()) : value;
        } else {
            return value;
        }
    }

    public void bindAll(UpdateUIViewModel viewModel, LifecycleOwner lifecycleOwner) {
        Field[] declaredFields;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        for (Field f : getClass().getDeclaredFields()) {
            Intrinsics.checkNotNullExpressionValue(f, "f");
            f.setAccessible(true);
            Object obj = f.get(this);
            if (obj instanceof BaseProperty) {
                BaseProperty baseProperty = (BaseProperty) obj;
                if (baseProperty.getReadable()) {
                    MutableLiveData<Boolean> mutableLiveData = viewModel.get(baseProperty.getServiceID(), baseProperty.getMessageID());
                    Intrinsics.checkNotNullExpressionValue(mutableLiveData, "viewModel.get(property.s…ceID, property.messageID)");
                    baseProperty.unbind(mutableLiveData);
                    MutableLiveData<Boolean> mutableLiveData2 = viewModel.get(baseProperty.getServiceID(), baseProperty.getMessageID());
                    Intrinsics.checkNotNullExpressionValue(mutableLiveData2, "viewModel.get(property.s…ceID, property.messageID)");
                    baseProperty.bind(mutableLiveData2, lifecycleOwner);
                }
            }
        }
    }

    public void unbindAll(UpdateUIViewModel viewModel, LifecycleOwner lifecycleOwner) {
        Field[] declaredFields;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        for (Field f : getClass().getDeclaredFields()) {
            Intrinsics.checkNotNullExpressionValue(f, "f");
            f.setAccessible(true);
            Object obj = f.get(this);
            if (obj instanceof BaseProperty) {
                BaseProperty baseProperty = (BaseProperty) obj;
                if (baseProperty.getReadable()) {
                    MutableLiveData<Boolean> mutableLiveData = viewModel.get(baseProperty.getServiceID(), baseProperty.getMessageID());
                    Intrinsics.checkNotNullExpressionValue(mutableLiveData, "viewModel.get(property.s…ceID, property.messageID)");
                    baseProperty.unbind(mutableLiveData);
                }
            }
        }
    }

    public void readAll() {
        Field[] declaredFields;
        for (Field f : getClass().getDeclaredFields()) {
            Intrinsics.checkNotNullExpressionValue(f, "f");
            f.setAccessible(true);
            Object obj = f.get(this);
            if (obj instanceof BaseProperty) {
                BaseProperty baseProperty = (BaseProperty) obj;
                if (baseProperty.getReadable()) {
                    baseProperty.read();
                    if (baseProperty.getAttr() != null) {
                        baseProperty.readAttr();
                    }
                }
            }
        }
    }

    public void reset() {
        Field[] declaredFields;
        for (Field f : getClass().getDeclaredFields()) {
            Intrinsics.checkNotNullExpressionValue(f, "f");
            f.setAccessible(true);
            Object obj = f.get(this);
            if (obj instanceof BaseProperty) {
                BaseProperty baseProperty = (BaseProperty) obj;
                if (baseProperty.getResetable()) {
                    baseProperty.reset();
                }
            }
        }
    }

    public long getLongStep(long j, MessageAttr messageAttr, boolean z, KeyEvent keyEvent) {
        long j2;
        long j3;
        int i = 1;
        if (keyEvent != null) {
            try {
                int repeatCount = keyEvent.getRepeatCount();
                if (KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 16 && Math.abs(repeatCount) > 1) {
                    repeatCount *= 2;
                }
                i = repeatCount;
                releaseCurrentKeyEvent(keyEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        long j4 = 1;
        if (messageAttr != null) {
            long maxLongValue = messageAttr.getMaxLongValue();
            long minLongValue = messageAttr.getMinLongValue();
            j4 = messageAttr.getStepValue();
            j3 = minLongValue;
            j2 = maxLongValue;
        } else {
            j2 = 1000;
            j3 = 1;
        }
        long j5 = z ? j + (j4 * i) : j - (j4 * i);
        return j5 > j2 ? j2 : j5 < j3 ? j3 : j5;
    }

    public int getIntStep(long j, MessageAttr messageAttr, boolean z, KeyEvent keyEvent) {
        long j2;
        long j3;
        long j4;
        int i = 1;
        if (keyEvent != null) {
            try {
                int repeatCount = keyEvent.getRepeatCount();
                if (KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 16 && Math.abs(repeatCount) > 1) {
                    repeatCount *= 2;
                }
                i = repeatCount;
                releaseCurrentKeyEvent(keyEvent);
            } catch (Exception e) {
                e.printStackTrace();
                j2 = 0;
            }
        }
        long j5 = 1;
        if (messageAttr != null) {
            long maxLongValue = messageAttr.getMaxLongValue();
            long minLongValue = messageAttr.getMinLongValue();
            j5 = messageAttr.getStepValue();
            j4 = minLongValue;
            j3 = maxLongValue;
        } else {
            j3 = 1000;
            j4 = 1;
        }
        j2 = z ? j + (j5 * i) : j - (j5 * i);
        if (j2 > j3) {
            j2 = j3;
        } else if (j2 < j4) {
            j2 = j4;
        }
        return Integer.parseInt(String.valueOf(j2));
    }

    public int getIntDef(MessageAttr messageAttr) {
        if (messageAttr != null) {
            try {
                return messageAttr.getDefIntValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 500;
    }

    public long getLongDef(MessageAttr messageAttr) {
        if (messageAttr != null) {
            try {
                return messageAttr.getDefLongValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 500L;
    }

    public double getDoubleDef(MessageAttr messageAttr) {
        if (messageAttr != null) {
            try {
                return messageAttr.getDefDoubleValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 500.0d;
    }

    public final KeyEvent getKeyEvent() {
        return this.keyEvent;
    }

    public final void setKeyEvent(KeyEvent keyEvent) {
        this.keyEvent = keyEvent;
    }

    public final PanelKeyViewModel getPanelKeyViewModel() {
        return this.panelKeyViewModel;
    }

    public final void setPanelKeyViewModel(PanelKeyViewModel panelKeyViewModel) {
        this.panelKeyViewModel = panelKeyViewModel;
    }

    public void releaseCurrentKeyEvent(KeyEvent keyEvent1) {
        MutableLiveData<KeyEvent> onKeyUpData;
        Intrinsics.checkNotNullParameter(keyEvent1, "keyEvent1");
        if (this.keyEvent == null) {
            this.keyEvent = new KeyEvent(keyEvent1.getDownTime(), keyEvent1.getEventTime(), keyEvent1.getAction(), 0, keyEvent1.getScanCode(), 0, -1, 0, keyEvent1.getFlags(), keyEvent1.getSource());
        }
        if (this.panelKeyViewModel == null) {
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        }
        PanelKeyViewModel panelKeyViewModel = this.panelKeyViewModel;
        if (panelKeyViewModel == null || (onKeyUpData = panelKeyViewModel.getOnKeyUpData()) == null) {
            return;
        }
        onKeyUpData.setValue(this.keyEvent);
    }
}
