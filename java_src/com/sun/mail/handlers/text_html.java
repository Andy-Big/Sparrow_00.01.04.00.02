package com.sun.mail.handlers;

import javax.activation.ActivationDataFlavor;
/* loaded from: classes2.dex */
public class text_html extends text_plain {
    private static ActivationDataFlavor[] myDF = {new ActivationDataFlavor(String.class, "text/html", "HTML String")};

    @Override // com.sun.mail.handlers.text_plain, com.sun.mail.handlers.handler_base
    protected ActivationDataFlavor[] getDataFlavors() {
        return myDF;
    }
}
