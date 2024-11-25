package com.just.agentweb;

import java.util.Map;
/* loaded from: classes.dex */
public interface IUrlLoader {
    HttpHeaders getHttpHeaders();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    void postUrl(String str, byte[] bArr);

    void reload();

    void stopLoading();
}
