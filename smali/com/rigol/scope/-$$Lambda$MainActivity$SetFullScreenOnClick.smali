.class public final synthetic Lcom/rigol/scope/-$$Lambda$MainActivity$SetFullScreenOnClick;
.super Ljava/lang/Object;
.source "lambda"


# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/MainActivity;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/MainActivity;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/-$$Lambda$MainActivity$SetFullScreenOnClick;->f$0:Lcom/rigol/scope/MainActivity;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 3

    const-string v0, "[RIGOL-A002-DEBUG]"
    const-string v1, "========== SetFullScreenOnClick->onClick() begin =========="
    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/rigol/scope/-$$Lambda$MainActivity$SetFullScreenOnClick;->f$0:Lcom/rigol/scope/MainActivity;

    invoke-virtual {v0, p1}, Lcom/rigol/scope/MainActivity;->clickFullScreen(Landroid/view/View;)V

    const-string v0, "[RIGOL-A002-DEBUG]"
    const-string v1, "========== SetFullScreenOnClick->onClick() end =========="
    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method
