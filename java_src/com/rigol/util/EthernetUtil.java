package com.rigol.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.EthernetManager;
import android.net.IpConfiguration;
import android.net.LinkAddress;
import android.net.NetworkUtils;
import android.net.ProxyInfo;
import android.net.StaticIpConfiguration;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class EthernetUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static String getMacAddress(Context context) {
        try {
            EthernetManager ethernetManager = (EthernetManager) context.getSystemService("ethernet");
            if (ethernetManager != null) {
                String ethernetMacAddress = ethernetManager.getEthernetMacAddress("eth0");
                return !TextUtils.isEmpty(ethernetMacAddress) ? ethernetMacAddress.toUpperCase() : ethernetMacAddress;
            }
            return "192.168.1.1";
        } catch (NoSuchMethodError e) {
            e.getMessage();
            return "192.168.1.1";
        }
    }

    public static String getVisaAddress(Context context) {
        try {
            EthernetManager ethernetManager = (EthernetManager) context.getSystemService("ethernet");
            if (ethernetManager != null) {
                return "TCPIP::" + ethernetManager.getIpAddress() + "::INSTR";
            }
            return "TCPIP::192.168.1.1::INSTR";
        } catch (NoSuchMethodError e) {
            e.getMessage();
            return "TCPIP::192.168.1.1::INSTR";
        }
    }

    public static String getIpAddress(Context context) {
        try {
            EthernetManager ethernetManager = (EthernetManager) context.getSystemService("ethernet");
            return ethernetManager != null ? ethernetManager.getIpAddress() : "192.168.1.1";
        } catch (NoSuchMethodError e) {
            e.getMessage();
            return "192.168.1.1";
        }
    }

    public static String getSubMask(Context context) {
        try {
            EthernetManager ethernetManager = (EthernetManager) context.getSystemService("ethernet");
            return ethernetManager != null ? ethernetManager.getNetmask() : "192.168.1.1";
        } catch (NoSuchMethodError e) {
            e.getMessage();
            return "192.168.1.1";
        }
    }

    public static String getDns(Context context) {
        String[] split;
        String str = "192.168.1.1";
        try {
            EthernetManager ethernetManager = (EthernetManager) context.getSystemService("ethernet");
            if (ethernetManager != null) {
                str = ethernetManager.getDns();
                if (str.contains(",")) {
                    for (String str2 : str.split(",")) {
                        if (!TextUtils.isEmpty(str2) && str2.matches("(\\d{1,3}).(\\d{1,3}).(\\d{1,3}).(\\d{1,3})")) {
                            return str2;
                        }
                    }
                }
            }
        } catch (NoSuchMethodError e) {
            e.getMessage();
        }
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [257=4, 245=4, 249=4, 253=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x00fa */
    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r1v16, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r1v30, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.lang.StringBuilder */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
        if (r3 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
        r3.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00fa, code lost:
        if (r3 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x011c, code lost:
        if (r3 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0120, code lost:
        if (r1 == 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x012c, code lost:
        if (r1.toString().contains("Unicast reply") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x012e, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x012f, code lost:
        return false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x013b A[Catch: IOException -> 0x0137, TryCatch #2 {IOException -> 0x0137, blocks: (B:101:0x0133, B:105:0x013b, B:107:0x0140), top: B:113:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0140 A[Catch: IOException -> 0x0137, TRY_LEAVE, TryCatch #2 {IOException -> 0x0137, blocks: (B:101:0x0133, B:105:0x013b, B:107:0x0140), top: B:113:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ee A[Catch: IOException -> 0x00ea, TryCatch #12 {IOException -> 0x00ea, blocks: (B:67:0x00e6, B:71:0x00ee, B:73:0x00f3), top: B:120:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f3 A[Catch: IOException -> 0x00ea, TRY_LEAVE, TryCatch #12 {IOException -> 0x00ea, blocks: (B:67:0x00e6, B:71:0x00ee, B:73:0x00f3), top: B:120:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110 A[Catch: IOException -> 0x010c, TryCatch #10 {IOException -> 0x010c, blocks: (B:83:0x0108, B:87:0x0110, B:89:0x0115), top: B:117:0x0108 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0115 A[Catch: IOException -> 0x010c, TRY_LEAVE, TryCatch #10 {IOException -> 0x010c, blocks: (B:83:0x0108, B:87:0x0110, B:89:0x0115), top: B:117:0x0108 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkConflict(String str) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Exception e;
        StringBuilder sb;
        IOException e2;
        Object obj;
        Object obj2;
        String[] strArr = {"/system/bin/arping -c 3 -f -D " + str};
        DataOutputStream dataOutputStream = null;
        try {
            try {
                process = Runtime.getRuntime().exec("su");
            } catch (IOException e3) {
                e = e3;
                process = null;
                bufferedReader = null;
            } catch (Exception e4) {
                e = e4;
                process = null;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                process = null;
                bufferedReader = null;
            }
            try {
                DataOutputStream dataOutputStream2 = new DataOutputStream(process.getOutputStream());
                for (int i = 0; i < 1; i++) {
                    try {
                        try {
                            String str2 = strArr[i];
                            if (str2 != null) {
                                dataOutputStream2.write(str2.getBytes());
                                dataOutputStream2.writeBytes("\n");
                                dataOutputStream2.flush();
                            }
                        } catch (IOException e5) {
                            bufferedReader = null;
                            bufferedReader2 = null;
                            e2 = e5;
                            obj2 = null;
                            dataOutputStream = dataOutputStream2;
                            sb = obj2;
                            e2.printStackTrace();
                            if (dataOutputStream != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        } catch (Exception e6) {
                            bufferedReader = null;
                            bufferedReader2 = null;
                            e = e6;
                            obj = null;
                            dataOutputStream = dataOutputStream2;
                            sb = obj;
                            e.printStackTrace();
                            if (dataOutputStream != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        bufferedReader2 = null;
                        dataOutputStream = dataOutputStream2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                                if (process != null) {
                                    process.destroy();
                                }
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (process != null) {
                        }
                        throw th;
                    }
                }
                dataOutputStream2.writeBytes("exit\n");
                dataOutputStream2.flush();
                process.waitFor();
                sb = new StringBuilder();
                try {
                    StringBuilder sb2 = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    try {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            } catch (IOException e8) {
                                e2 = e8;
                                obj2 = sb;
                                dataOutputStream = dataOutputStream2;
                                sb = obj2;
                                e2.printStackTrace();
                                if (dataOutputStream != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                if (bufferedReader2 != null) {
                                }
                            } catch (Exception e9) {
                                e = e9;
                                obj = sb;
                                dataOutputStream = dataOutputStream2;
                                sb = obj;
                                e.printStackTrace();
                                if (dataOutputStream != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                if (bufferedReader2 != null) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                dataOutputStream = dataOutputStream2;
                                if (dataOutputStream != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                if (bufferedReader2 != null) {
                                }
                                if (process != null) {
                                }
                                throw th;
                            }
                        }
                        while (true) {
                            String readLine2 = bufferedReader2.readLine();
                            if (readLine2 != null) {
                                sb2.append(readLine2);
                            } else {
                                try {
                                    break;
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        dataOutputStream2.close();
                        bufferedReader.close();
                        bufferedReader2.close();
                    } catch (IOException e11) {
                        e2 = e11;
                        bufferedReader2 = null;
                        obj2 = sb;
                    } catch (Exception e12) {
                        e = e12;
                        bufferedReader2 = null;
                        obj = sb;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader2 = null;
                    }
                } catch (IOException e13) {
                    e2 = e13;
                    bufferedReader = null;
                    bufferedReader2 = null;
                    obj2 = sb;
                } catch (Exception e14) {
                    e = e14;
                    bufferedReader = null;
                    bufferedReader2 = null;
                    obj = sb;
                }
            } catch (IOException e15) {
                e = e15;
                bufferedReader = null;
                bufferedReader2 = bufferedReader;
                e2 = e;
                sb = bufferedReader2;
                e2.printStackTrace();
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
            } catch (Exception e17) {
                e = e17;
                bufferedReader = null;
                bufferedReader2 = bufferedReader;
                e = e;
                sb = bufferedReader2;
                e.printStackTrace();
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                bufferedReader2 = bufferedReader;
                if (dataOutputStream != null) {
                }
                if (bufferedReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean checkInvalid(String str) throws Exception {
        return InetAddress.getByName(str).isReachable(3000);
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static EthernetManager getEthernetManager(Context context) {
        return (EthernetManager) context.getSystemService("ethernet");
    }

    public static String getDefaultGateway(Context context) {
        try {
            EthernetManager ethernetManager = (EthernetManager) context.getSystemService("ethernet");
            return ethernetManager != null ? ethernetManager.getGateway() : "192.168.1.1";
        } catch (NoSuchMethodError e) {
            e.getMessage();
            return "192.168.1.1";
        }
    }

    public static int getEthernetConnectState(Context context) {
        try {
            return ((EthernetManager) context.getSystemService("ethernet")).getEthernetConnectState();
        } catch (NoSuchMethodError unused) {
            return 0;
        }
    }

    public static void setDynamicIp(Context context) {
        try {
            EthernetManager ethernetManager = (EthernetManager) context.getSystemService("ethernet");
            if (ethernetManager != null) {
                ethernetManager.setConfiguration(new IpConfiguration(IpConfiguration.IpAssignment.DHCP, IpConfiguration.ProxySettings.NONE, (StaticIpConfiguration) null, (ProxyInfo) null));
                ethernetManager.disconnect("eth0");
                ethernetManager.reconnect("eth0");
            }
        } catch (NoSuchMethodError | SecurityException e) {
            e.getMessage();
        }
    }

    public static void setStaticIp(Context context, String str, String str2, String str3, String str4) {
        Class<?> cls;
        Constructor<?> constructor;
        try {
            StaticIpConfiguration staticIpConfiguration = new StaticIpConfiguration();
            InetAddress numericToInetAddress = NetworkUtils.numericToInetAddress(str);
            int i = 0;
            for (String str5 : str2.split("\\.")) {
                if ("255".equals(str5)) {
                    i++;
                }
            }
            int i2 = i * 8;
            try {
                cls = Class.forName("android.net.LinkAddress");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                cls = null;
            }
            try {
                constructor = cls.getConstructor(InetAddress.class, Integer.TYPE);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                constructor = null;
            }
            try {
                staticIpConfiguration.ipAddress = (LinkAddress) constructor.newInstance(numericToInetAddress, Integer.valueOf(i2));
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
                e3.printStackTrace();
            }
            InetAddress numericToInetAddress2 = NetworkUtils.numericToInetAddress(str3);
            ArrayList arrayList = new ArrayList();
            if (str4.contains(",")) {
                arrayList.add(NetworkUtils.numericToInetAddress(str4.split(",")[0]));
            } else {
                arrayList.add(NetworkUtils.numericToInetAddress(str4));
            }
            staticIpConfiguration.gateway = numericToInetAddress2;
            staticIpConfiguration.dnsServers.addAll(arrayList);
            IpConfiguration ipConfiguration = new IpConfiguration(IpConfiguration.IpAssignment.STATIC, IpConfiguration.ProxySettings.NONE, staticIpConfiguration, ProxyInfo.buildDirectProxy(null, 0));
            EthernetManager ethernetManager = (EthernetManager) context.getSystemService("ethernet");
            if (ethernetManager != null) {
                ethernetManager.setConfiguration(ipConfiguration);
                ethernetManager.disconnect("eth0");
                Log.e("szl", "disconnect");
                ethernetManager.reconnect("eth0");
                Log.e("szl", "reconnect");
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
