.class public final synthetic Lcom/rigol/scope/viewmodels/-$$Lambda$z-tarIOTQvB_bequvIW5VQCI6RI;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/views/baseview/BasePopupView;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/views/baseview/BasePopupView;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/viewmodels/-$$Lambda$z-tarIOTQvB_bequvIW5VQCI6RI;->f$0:Lcom/rigol/scope/views/baseview/BasePopupView;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lcom/rigol/scope/viewmodels/-$$Lambda$z-tarIOTQvB_bequvIW5VQCI6RI;->f$0:Lcom/rigol/scope/views/baseview/BasePopupView;

    invoke-virtual {v0}, Lcom/rigol/scope/views/baseview/BasePopupView;->show()V

    return-void
.end method
