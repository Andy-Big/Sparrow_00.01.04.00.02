.class public final synthetic Lcom/rigol/scope/views/search/-$$Lambda$SearchMarkerView$vls2y90iplE8EX_o8kfOkP1tD0o;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Landroidx/lifecycle/Observer;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/views/search/SearchMarkerView;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/views/search/SearchMarkerView;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/views/search/-$$Lambda$SearchMarkerView$vls2y90iplE8EX_o8kfOkP1tD0o;->f$0:Lcom/rigol/scope/views/search/SearchMarkerView;

    return-void
.end method


# virtual methods
.method public final onChanged(Ljava/lang/Object;)V
    .locals 1

    iget-object v0, p0, Lcom/rigol/scope/views/search/-$$Lambda$SearchMarkerView$vls2y90iplE8EX_o8kfOkP1tD0o;->f$0:Lcom/rigol/scope/views/search/SearchMarkerView;

    check-cast p1, Lcom/rigol/scope/data/SearchParam;

    invoke-virtual {v0, p1}, Lcom/rigol/scope/views/search/SearchMarkerView;->lambda$new$0$SearchMarkerView(Lcom/rigol/scope/data/SearchParam;)V

    return-void
.end method
