package com.blankj.utilcode.util;

import com.blankj.utilcode.util.Utils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* loaded from: classes.dex */
public final class ShellUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    private ShellUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Utils.Task<CommandResult> execCmdAsync(String str, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{str}, z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> list, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(list == null ? null : (String[]) list.toArray(new String[0]), z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String[] strArr, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(strArr, z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String str, boolean z, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{str}, z, z2, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> list, boolean z, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(list == null ? null : (String[]) list.toArray(new String[0]), z, z2, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(final String[] strArr, final boolean z, final boolean z2, Utils.Consumer<CommandResult> consumer) {
        if (consumer == null) {
            throw new NullPointerException("Argument 'consumer' of type Utils.Consumer<CommandResult> (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return UtilsBridge.doAsync(new Utils.Task<CommandResult>(consumer) { // from class: com.blankj.utilcode.util.ShellUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public CommandResult doInBackground() {
                return ShellUtils.execCmd(strArr, z, z2);
            }
        });
    }

    public static CommandResult execCmd(String str, boolean z) {
        return execCmd(new String[]{str}, z, true);
    }

    public static CommandResult execCmd(List<String> list, boolean z) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static CommandResult execCmd(String[] strArr, boolean z) {
        return execCmd(strArr, z, true);
    }

    public static CommandResult execCmd(String str, boolean z, boolean z2) {
        return execCmd(new String[]{str}, z, z2);
    }

    public static CommandResult execCmd(List<String> list, boolean z, boolean z2) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x00f5 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CommandResult execCmd(String[] strArr, boolean z, boolean z2) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        BufferedReader bufferedReader4;
        ?? r10;
        ?? r12;
        DataOutputStream dataOutputStream;
        int i = -1;
        if (strArr == null || strArr.length == 0) {
            return new CommandResult(-1, "", "");
        }
        DataOutputStream dataOutputStream2 = null;
        BufferedReader bufferedReader5 = null;
        dataOutputStream2 = null;
        try {
            process = Runtime.getRuntime().exec(z ? "su" : "sh");
        } catch (Exception e) {
            e = e;
            process = null;
            bufferedReader2 = null;
        } catch (Throwable th) {
            th = th;
            process = null;
            bufferedReader = null;
        }
        try {
            dataOutputStream = new DataOutputStream(process.getOutputStream());
        } catch (Exception e2) {
            e = e2;
            bufferedReader2 = null;
            bufferedReader4 = bufferedReader2;
            bufferedReader = bufferedReader4;
            bufferedReader3 = bufferedReader;
            try {
                e.printStackTrace();
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                r10 = bufferedReader2;
                r12 = bufferedReader4;
                return new CommandResult(i, r10 == 0 ? "" : r10.toString(), r12 != 0 ? r12.toString() : "");
            } catch (Throwable th2) {
                th = th2;
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            bufferedReader3 = bufferedReader;
            if (dataOutputStream2 != null) {
            }
            if (bufferedReader != null) {
            }
            if (bufferedReader3 != null) {
            }
            if (process != null) {
            }
            throw th;
        }
        try {
            try {
                for (String str : strArr) {
                    if (str != null) {
                        dataOutputStream.write(str.getBytes());
                        dataOutputStream.writeBytes(LINE_SEP);
                        dataOutputStream.flush();
                    }
                }
                dataOutputStream.writeBytes("exit" + LINE_SEP);
                dataOutputStream.flush();
                i = process.waitFor();
                if (z2) {
                    ?? sb = new StringBuilder();
                    try {
                        ?? sb2 = new StringBuilder();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
                            try {
                                bufferedReader3 = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        sb.append(readLine);
                                        while (true) {
                                            String readLine2 = bufferedReader.readLine();
                                            if (readLine2 == null) {
                                                break;
                                            }
                                            sb.append(LINE_SEP);
                                            sb.append(readLine2);
                                        }
                                    }
                                    String readLine3 = bufferedReader3.readLine();
                                    if (readLine3 != null) {
                                        sb2.append(readLine3);
                                        while (true) {
                                            String readLine4 = bufferedReader3.readLine();
                                            if (readLine4 == null) {
                                                break;
                                            }
                                            sb2.append(LINE_SEP);
                                            sb2.append(readLine4);
                                        }
                                    }
                                    bufferedReader5 = bufferedReader;
                                    r10 = sb;
                                    r12 = sb2;
                                } catch (Exception e9) {
                                    e = e9;
                                    dataOutputStream2 = dataOutputStream;
                                    bufferedReader2 = sb;
                                    e = e;
                                    bufferedReader4 = sb2;
                                    e.printStackTrace();
                                    if (dataOutputStream2 != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (bufferedReader3 != null) {
                                    }
                                    if (process != null) {
                                    }
                                    r10 = bufferedReader2;
                                    r12 = bufferedReader4;
                                    return new CommandResult(i, r10 == 0 ? "" : r10.toString(), r12 != 0 ? r12.toString() : "");
                                } catch (Throwable th4) {
                                    th = th4;
                                    dataOutputStream2 = dataOutputStream;
                                    if (dataOutputStream2 != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (bufferedReader3 != null) {
                                    }
                                    if (process != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                bufferedReader3 = null;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader3 = null;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            bufferedReader = null;
                            bufferedReader3 = null;
                        }
                    } catch (Exception e12) {
                        bufferedReader4 = null;
                        bufferedReader = null;
                        bufferedReader3 = null;
                        dataOutputStream2 = dataOutputStream;
                        bufferedReader2 = sb;
                        e = e12;
                    }
                } else {
                    r10 = 0;
                    r12 = 0;
                    bufferedReader3 = null;
                }
                try {
                    dataOutputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                if (bufferedReader5 != null) {
                    try {
                        bufferedReader5.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e16) {
                e = e16;
                bufferedReader2 = null;
                bufferedReader4 = null;
                bufferedReader = null;
                bufferedReader3 = null;
                dataOutputStream2 = dataOutputStream;
            }
            return new CommandResult(i, r10 == 0 ? "" : r10.toString(), r12 != 0 ? r12.toString() : "");
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
            bufferedReader3 = null;
        }
    }

    /* loaded from: classes.dex */
    public static class CommandResult {
        public String errorMsg;
        public int result;
        public String successMsg;

        public CommandResult(int i, String str, String str2) {
            this.result = i;
            this.successMsg = str;
            this.errorMsg = str2;
        }

        public String toString() {
            return "result: " + this.result + "\nsuccessMsg: " + this.successMsg + "\nerrorMsg: " + this.errorMsg;
        }
    }
}
