package javax.activation;
/* loaded from: classes2.dex */
public class ActivationDataFlavor {
    private String humanPresentableName;
    private MimeType mimeObject = null;
    private String mimeType;
    private Class representationClass;

    protected String normalizeMimeType(String str) {
        return str;
    }

    protected String normalizeMimeTypeParameter(String str, String str2) {
        return str2;
    }

    public ActivationDataFlavor(Class cls, String str, String str2) {
        this.mimeType = null;
        this.humanPresentableName = null;
        this.representationClass = null;
        this.mimeType = str;
        this.humanPresentableName = str2;
        this.representationClass = cls;
    }

    public ActivationDataFlavor(Class cls, String str) {
        this.mimeType = null;
        this.humanPresentableName = null;
        this.representationClass = null;
        this.mimeType = "application/x-java-serialized-object";
        this.representationClass = cls;
        this.humanPresentableName = str;
    }

    public ActivationDataFlavor(String str, String str2) {
        this.mimeType = null;
        this.humanPresentableName = null;
        this.representationClass = null;
        this.mimeType = str;
        try {
            this.representationClass = Class.forName("java.io.InputStream");
        } catch (ClassNotFoundException unused) {
        }
        this.humanPresentableName = str2;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Class getRepresentationClass() {
        return this.representationClass;
    }

    public String getHumanPresentableName() {
        return this.humanPresentableName;
    }

    public void setHumanPresentableName(String str) {
        this.humanPresentableName = str;
    }

    public boolean equals(ActivationDataFlavor activationDataFlavor) {
        return isMimeTypeEqual(activationDataFlavor.mimeType) && activationDataFlavor.getRepresentationClass() == this.representationClass;
    }

    public boolean isMimeTypeEqual(String str) {
        try {
            if (this.mimeObject == null) {
                this.mimeObject = new MimeType(this.mimeType);
            }
            return this.mimeObject.match(new MimeType(str));
        } catch (MimeTypeParseException unused) {
            return this.mimeType.equalsIgnoreCase(str);
        }
    }
}
