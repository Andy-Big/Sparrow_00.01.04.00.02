.class public final enum Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;
.super Ljava/lang/Enum;
.source "ServiceEnum.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/rigol/scope/cil/ServiceEnum;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EyeTemplate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

.field public static final enum customize:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

.field public static final enum eth100:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

.field public static final enum hdmi:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

.field public static final enum usbFull:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

.field public static final enum usbHighFar:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

.field public static final enum usbHighNear:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

.field public static final enum usbLow:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;


# instance fields
.field public final pic1:Ljava/lang/String;

.field public final pic2:Ljava/lang/String;

.field public final value1:I

.field public final value2:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 15

    .line 6265
    new-instance v7, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const-string v1, "eth100"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const-string v4, ""

    const-string v5, ""

    const-string v6, ""

    move-object v0, v7

    invoke-direct/range {v0 .. v6}, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v7, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->eth100:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    .line 6266
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const-string v9, "usbLow"

    const/4 v10, 0x1

    const/4 v11, 0x1

    const-string v12, ""

    const-string v13, ""

    const-string v14, ""

    move-object v8, v0

    invoke-direct/range {v8 .. v14}, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->usbLow:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    .line 6267
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const-string v2, "usbFull"

    const/4 v3, 0x2

    const/4 v4, 0x2

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    move-object v1, v0

    invoke-direct/range {v1 .. v7}, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->usbFull:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    .line 6268
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const-string v9, "usbHighFar"

    const/4 v10, 0x3

    const/4 v11, 0x3

    const-string v12, ""

    const-string v13, ""

    const-string v14, ""

    move-object v8, v0

    invoke-direct/range {v8 .. v14}, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->usbHighFar:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    .line 6269
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const-string v2, "usbHighNear"

    const/4 v3, 0x4

    const/4 v4, 0x4

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    move-object v1, v0

    invoke-direct/range {v1 .. v7}, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->usbHighNear:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    .line 6270
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const-string v9, "hdmi"

    const/4 v10, 0x5

    const/4 v11, 0x5

    const-string v12, ""

    const-string v13, ""

    const-string v14, ""

    move-object v8, v0

    invoke-direct/range {v8 .. v14}, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->hdmi:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    .line 6271
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const-string v2, "customize"

    const/4 v3, 0x6

    const/4 v4, 0x6

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    move-object v1, v0

    invoke-direct/range {v1 .. v7}, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->customize:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const/4 v1, 0x7

    new-array v1, v1, [Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    .line 6263
    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->eth100:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const/4 v3, 0x0

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->usbLow:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const/4 v3, 0x1

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->usbFull:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const/4 v3, 0x2

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->usbHighFar:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const/4 v3, 0x3

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->usbHighNear:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const/4 v3, 0x4

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->hdmi:Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    const/4 v3, 0x5

    aput-object v2, v1, v3

    const/4 v2, 0x6

    aput-object v0, v1, v2

    sput-object v1, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->$VALUES:[Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .line 6274
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 6275
    iput p3, p0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->value1:I

    .line 6276
    iput-object p4, p0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->value2:Ljava/lang/String;

    .line 6277
    iput-object p5, p0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->pic1:Ljava/lang/String;

    .line 6278
    iput-object p6, p0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->pic2:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;
    .locals 1

    .line 6263
    const-class v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    return-object p0
.end method

.method public static values()[Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;
    .locals 1

    .line 6263
    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->$VALUES:[Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    invoke-virtual {v0}, [Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/rigol/scope/cil/ServiceEnum$EyeTemplate;

    return-object v0
.end method
