.class public final enum Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;
.super Ljava/lang/Enum;
.source "ServiceEnum.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/rigol/scope/cil/ServiceEnum;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SpuTxType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

.field public static final enum CH_EYE:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

.field public static final enum CH_ROLL_COL:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

.field public static final enum CH_TRACE:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

.field public static final enum CH_WAVE_MAIN:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

.field public static final enum CH_WAVE_ZOOM:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

.field public static final enum LA_ROLL_COL:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

.field public static final enum LA_WAVE_MAIN:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

.field public static final enum LA_WAVE_ZOOM:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;


# instance fields
.field public final pic1:Ljava/lang/String;

.field public final pic2:Ljava/lang/String;

.field public final value1:I

.field public final value2:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 15

    .line 8828
    new-instance v7, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const-string v1, "CH_WAVE_MAIN"

    const/4 v2, 0x0

    const/4 v3, 0x0

    const-string v4, ""

    const-string v5, ""

    const-string v6, ""

    move-object v0, v7

    invoke-direct/range {v0 .. v6}, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v7, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_WAVE_MAIN:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    .line 8829
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const-string v9, "CH_WAVE_ZOOM"

    const/4 v10, 0x1

    const/4 v11, 0x1

    const-string v12, ""

    const-string v13, ""

    const-string v14, ""

    move-object v8, v0

    invoke-direct/range {v8 .. v14}, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_WAVE_ZOOM:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    .line 8830
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const-string v2, "LA_WAVE_MAIN"

    const/4 v3, 0x2

    const/4 v4, 0x2

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    move-object v1, v0

    invoke-direct/range {v1 .. v7}, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->LA_WAVE_MAIN:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    .line 8831
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const-string v9, "LA_WAVE_ZOOM"

    const/4 v10, 0x3

    const/4 v11, 0x3

    const-string v12, ""

    const-string v13, ""

    const-string v14, ""

    move-object v8, v0

    invoke-direct/range {v8 .. v14}, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->LA_WAVE_ZOOM:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    .line 8832
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const-string v2, "CH_ROLL_COL"

    const/4 v3, 0x4

    const/4 v4, 0x4

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    move-object v1, v0

    invoke-direct/range {v1 .. v7}, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_ROLL_COL:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    .line 8833
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const-string v9, "LA_ROLL_COL"

    const/4 v10, 0x5

    const/4 v11, 0x5

    const-string v12, ""

    const-string v13, ""

    const-string v14, ""

    move-object v8, v0

    invoke-direct/range {v8 .. v14}, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->LA_ROLL_COL:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    .line 8834
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const-string v2, "CH_TRACE"

    const/4 v3, 0x6

    const/4 v4, 0x6

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    move-object v1, v0

    invoke-direct/range {v1 .. v7}, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_TRACE:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    .line 8835
    new-instance v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const-string v9, "CH_EYE"

    const/4 v10, 0x7

    const/4 v11, 0x7

    const-string v12, ""

    const-string v13, ""

    const-string v14, ""

    move-object v8, v0

    invoke-direct/range {v8 .. v14}, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;-><init>(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_EYE:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const/16 v1, 0x8

    new-array v1, v1, [Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    .line 8826
    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_WAVE_MAIN:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const/4 v3, 0x0

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_WAVE_ZOOM:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const/4 v3, 0x1

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->LA_WAVE_MAIN:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const/4 v3, 0x2

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->LA_WAVE_ZOOM:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const/4 v3, 0x3

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_ROLL_COL:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const/4 v3, 0x4

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->LA_ROLL_COL:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const/4 v3, 0x5

    aput-object v2, v1, v3

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->CH_TRACE:Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    const/4 v3, 0x6

    aput-object v2, v1, v3

    const/4 v2, 0x7

    aput-object v0, v1, v2

    sput-object v1, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->$VALUES:[Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

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

    .line 8838
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 8839
    iput p3, p0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->value1:I

    .line 8840
    iput-object p4, p0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->value2:Ljava/lang/String;

    .line 8841
    iput-object p5, p0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->pic1:Ljava/lang/String;

    .line 8842
    iput-object p6, p0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->pic2:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;
    .locals 1

    .line 8826
    const-class v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    return-object p0
.end method

.method public static values()[Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;
    .locals 1

    .line 8826
    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->$VALUES:[Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    invoke-virtual {v0}, [Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/rigol/scope/cil/ServiceEnum$SpuTxType;

    return-object v0
.end method
