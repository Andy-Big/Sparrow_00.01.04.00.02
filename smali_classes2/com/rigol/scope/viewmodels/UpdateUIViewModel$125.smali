.class Lcom/rigol/scope/viewmodels/UpdateUIViewModel$125;
.super Ljava/lang/Object;
.source "UpdateUIViewModel.java"

# interfaces
.implements Landroidx/lifecycle/Observer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/rigol/scope/viewmodels/UpdateUIViewModel;->bind(Landroidx/lifecycle/LifecycleOwner;Lcom/rigol/scope/data/RefParam;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroidx/lifecycle/Observer<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/rigol/scope/viewmodels/UpdateUIViewModel;

.field final synthetic val$finalI:I

.field final synthetic val$param:Lcom/rigol/scope/data/RefParam;


# direct methods
.method constructor <init>(Lcom/rigol/scope/viewmodels/UpdateUIViewModel;Lcom/rigol/scope/data/RefParam;I)V
    .locals 0

    .line 1904
    iput-object p1, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$125;->this$0:Lcom/rigol/scope/viewmodels/UpdateUIViewModel;

    iput-object p2, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$125;->val$param:Lcom/rigol/scope/data/RefParam;

    iput p3, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$125;->val$finalI:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(Ljava/lang/Boolean;)V
    .locals 1

    .line 1907
    iget-object p1, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$125;->val$param:Lcom/rigol/scope/data/RefParam;

    iget v0, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$125;->val$finalI:I

    invoke-virtual {p1, v0}, Lcom/rigol/scope/data/RefParam;->getParam(I)Lcom/rigol/scope/data/RefParam$Param;

    move-result-object p1

    invoke-virtual {p1}, Lcom/rigol/scope/data/RefParam$Param;->readLabel()Ljava/lang/String;

    return-void
.end method

.method public bridge synthetic onChanged(Ljava/lang/Object;)V
    .locals 0

    .line 1904
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$125;->onChanged(Ljava/lang/Boolean;)V

    return-void
.end method
