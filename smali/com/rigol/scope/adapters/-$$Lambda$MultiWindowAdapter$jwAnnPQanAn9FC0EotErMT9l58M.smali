.class public final synthetic Lcom/rigol/scope/adapters/-$$Lambda$MultiWindowAdapter$jwAnnPQanAn9FC0EotErMT9l58M;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Landroidx/lifecycle/Observer;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/adapters/MultiWindowAdapter;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/adapters/MultiWindowAdapter;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/adapters/-$$Lambda$MultiWindowAdapter$jwAnnPQanAn9FC0EotErMT9l58M;->f$0:Lcom/rigol/scope/adapters/MultiWindowAdapter;

    return-void
.end method


# virtual methods
.method public final onChanged(Ljava/lang/Object;)V
    .locals 1

    iget-object v0, p0, Lcom/rigol/scope/adapters/-$$Lambda$MultiWindowAdapter$jwAnnPQanAn9FC0EotErMT9l58M;->f$0:Lcom/rigol/scope/adapters/MultiWindowAdapter;

    check-cast p1, Lcom/rigol/scope/data/OptionParam;

    invoke-virtual {v0, p1}, Lcom/rigol/scope/adapters/MultiWindowAdapter;->lambda$new$0$MultiWindowAdapter(Lcom/rigol/scope/data/OptionParam;)V

    return-void
.end method
