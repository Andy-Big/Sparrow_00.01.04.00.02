.class public final synthetic Lcom/rigol/scope/adapters/-$$Lambda$VerticalViewPagerAdapter$CXvMBRDbLADG4NOHFxoG3I6Yox4;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Landroidx/lifecycle/Observer;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/adapters/VerticalViewPagerAdapter;

.field public final synthetic f$1:Lcom/rigol/scope/viewmodels/PanelKeyViewModel;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/adapters/VerticalViewPagerAdapter;Lcom/rigol/scope/viewmodels/PanelKeyViewModel;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/adapters/-$$Lambda$VerticalViewPagerAdapter$CXvMBRDbLADG4NOHFxoG3I6Yox4;->f$0:Lcom/rigol/scope/adapters/VerticalViewPagerAdapter;

    iput-object p2, p0, Lcom/rigol/scope/adapters/-$$Lambda$VerticalViewPagerAdapter$CXvMBRDbLADG4NOHFxoG3I6Yox4;->f$1:Lcom/rigol/scope/viewmodels/PanelKeyViewModel;

    return-void
.end method


# virtual methods
.method public final onChanged(Ljava/lang/Object;)V
    .locals 2

    iget-object v0, p0, Lcom/rigol/scope/adapters/-$$Lambda$VerticalViewPagerAdapter$CXvMBRDbLADG4NOHFxoG3I6Yox4;->f$0:Lcom/rigol/scope/adapters/VerticalViewPagerAdapter;

    iget-object v1, p0, Lcom/rigol/scope/adapters/-$$Lambda$VerticalViewPagerAdapter$CXvMBRDbLADG4NOHFxoG3I6Yox4;->f$1:Lcom/rigol/scope/viewmodels/PanelKeyViewModel;

    check-cast p1, Landroid/view/KeyEvent;

    invoke-virtual {v0, v1, p1}, Lcom/rigol/scope/adapters/VerticalViewPagerAdapter;->lambda$setPanelKeyViewModel$3$VerticalViewPagerAdapter(Lcom/rigol/scope/viewmodels/PanelKeyViewModel;Landroid/view/KeyEvent;)V

    return-void
.end method
