.class public final synthetic Lcom/rigol/scope/views/presentation/-$$Lambda$MiniScreenPresentation$2$kAWw90Pj9ii7GvcLDW_HJ0u-lu0;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Lcom/rigol/scope/adapters/OnItemLongClickListener;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/views/presentation/MiniScreenPresentation$2;

.field public final synthetic f$1:Ljava/util/ArrayList;

.field public final synthetic f$2:Lcom/rigol/scope/adapters/BaseViewHolder;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/views/presentation/MiniScreenPresentation$2;Ljava/util/ArrayList;Lcom/rigol/scope/adapters/BaseViewHolder;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/views/presentation/-$$Lambda$MiniScreenPresentation$2$kAWw90Pj9ii7GvcLDW_HJ0u-lu0;->f$0:Lcom/rigol/scope/views/presentation/MiniScreenPresentation$2;

    iput-object p2, p0, Lcom/rigol/scope/views/presentation/-$$Lambda$MiniScreenPresentation$2$kAWw90Pj9ii7GvcLDW_HJ0u-lu0;->f$1:Ljava/util/ArrayList;

    iput-object p3, p0, Lcom/rigol/scope/views/presentation/-$$Lambda$MiniScreenPresentation$2$kAWw90Pj9ii7GvcLDW_HJ0u-lu0;->f$2:Lcom/rigol/scope/adapters/BaseViewHolder;

    return-void
.end method


# virtual methods
.method public final onItemLongClick(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)Z
    .locals 6

    iget-object v0, p0, Lcom/rigol/scope/views/presentation/-$$Lambda$MiniScreenPresentation$2$kAWw90Pj9ii7GvcLDW_HJ0u-lu0;->f$0:Lcom/rigol/scope/views/presentation/MiniScreenPresentation$2;

    iget-object v1, p0, Lcom/rigol/scope/views/presentation/-$$Lambda$MiniScreenPresentation$2$kAWw90Pj9ii7GvcLDW_HJ0u-lu0;->f$1:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/rigol/scope/views/presentation/-$$Lambda$MiniScreenPresentation$2$kAWw90Pj9ii7GvcLDW_HJ0u-lu0;->f$2:Lcom/rigol/scope/adapters/BaseViewHolder;

    move-object v3, p1

    move-object v4, p2

    move v5, p3

    invoke-virtual/range {v0 .. v5}, Lcom/rigol/scope/views/presentation/MiniScreenPresentation$2;->lambda$onCreateViewHolder$1$MiniScreenPresentation$2(Ljava/util/ArrayList;Lcom/rigol/scope/adapters/BaseViewHolder;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)Z

    move-result p1

    return p1
.end method
