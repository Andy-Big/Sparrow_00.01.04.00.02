.class public final synthetic Lcom/rigol/scope/views/baseview/-$$Lambda$MainWaveformView$Fb8OcpXYYm7CQfRYsmUzvviKbnQ;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Landroidx/lifecycle/Observer;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/views/baseview/MainWaveformView;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/views/baseview/MainWaveformView;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/views/baseview/-$$Lambda$MainWaveformView$Fb8OcpXYYm7CQfRYsmUzvviKbnQ;->f$0:Lcom/rigol/scope/views/baseview/MainWaveformView;

    return-void
.end method


# virtual methods
.method public final onChanged(Ljava/lang/Object;)V
    .locals 1

    iget-object v0, p0, Lcom/rigol/scope/views/baseview/-$$Lambda$MainWaveformView$Fb8OcpXYYm7CQfRYsmUzvviKbnQ;->f$0:Lcom/rigol/scope/views/baseview/MainWaveformView;

    check-cast p1, Lcom/rigol/scope/data/SharedParam;

    invoke-virtual {v0, p1}, Lcom/rigol/scope/views/baseview/MainWaveformView;->lambda$init$5$MainWaveformView(Lcom/rigol/scope/data/SharedParam;)V

    return-void
.end method
