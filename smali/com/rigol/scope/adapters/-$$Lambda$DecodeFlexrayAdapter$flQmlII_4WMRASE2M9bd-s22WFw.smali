.class public final synthetic Lcom/rigol/scope/adapters/-$$Lambda$DecodeFlexrayAdapter$flQmlII_4WMRASE2M9bd-s22WFw;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Lcom/rigol/scope/views/spinner/PopupSpinner$OnItemClickListener;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/adapters/DecodeFlexrayAdapter;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/adapters/DecodeFlexrayAdapter;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/adapters/-$$Lambda$DecodeFlexrayAdapter$flQmlII_4WMRASE2M9bd-s22WFw;->f$0:Lcom/rigol/scope/adapters/DecodeFlexrayAdapter;

    return-void
.end method


# virtual methods
.method public final onItemClick(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/lang/Object;)V
    .locals 1

    iget-object v0, p0, Lcom/rigol/scope/adapters/-$$Lambda$DecodeFlexrayAdapter$flQmlII_4WMRASE2M9bd-s22WFw;->f$0:Lcom/rigol/scope/adapters/DecodeFlexrayAdapter;

    check-cast p4, Lcom/rigol/scope/data/MappingObject;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/rigol/scope/adapters/DecodeFlexrayAdapter;->lambda$onClick$4$DecodeFlexrayAdapter(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILcom/rigol/scope/data/MappingObject;)V

    return-void
.end method
