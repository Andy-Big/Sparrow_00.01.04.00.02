package com.just.agentweb;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.just.agentweb.AgentWeb;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class JsBaseInterfaceHolder implements JsInterfaceHolder {
    private AgentWeb.SecurityType mSecurityType;
    private WebCreator mWebCreator;

    /* JADX INFO: Access modifiers changed from: protected */
    public JsBaseInterfaceHolder(WebCreator webCreator, AgentWeb.SecurityType securityType) {
        this.mSecurityType = securityType;
        this.mWebCreator = webCreator;
    }

    @Override // com.just.agentweb.JsInterfaceHolder
    public boolean checkObject(Object obj) {
        if (Build.VERSION.SDK_INT >= 17 && this.mWebCreator.getWebViewType() != 2) {
            boolean z = false;
            for (Method method : obj.getClass().getMethods()) {
                Annotation[] annotations = method.getAnnotations();
                int length = annotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (annotations[i] instanceof JavascriptInterface) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    break;
                }
            }
            return z;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkSecurity() {
        return this.mSecurityType != AgentWeb.SecurityType.STRICT_CHECK || this.mWebCreator.getWebViewType() == 2 || Build.VERSION.SDK_INT > 17;
    }
}
