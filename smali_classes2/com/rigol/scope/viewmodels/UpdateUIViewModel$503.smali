.class Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;
.super Ljava/lang/Object;
.source "UpdateUIViewModel.java"

# interfaces
.implements Landroidx/lifecycle/Observer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/rigol/scope/viewmodels/UpdateUIViewModel;->bind(Landroidx/lifecycle/LifecycleOwner;Lcom/rigol/scope/data/DecodeParam;)V
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

.field final synthetic val$param:Lcom/rigol/scope/data/DecodeParam;


# direct methods
.method constructor <init>(Lcom/rigol/scope/viewmodels/UpdateUIViewModel;Lcom/rigol/scope/data/DecodeParam;)V
    .locals 0

    .line 5917
    iput-object p1, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;->this$0:Lcom/rigol/scope/viewmodels/UpdateUIViewModel;

    iput-object p2, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;->val$param:Lcom/rigol/scope/data/DecodeParam;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(Ljava/lang/Boolean;)V
    .locals 5

    .line 5920
    iget-object p1, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;->val$param:Lcom/rigol/scope/data/DecodeParam;

    invoke-virtual {p1}, Lcom/rigol/scope/data/DecodeParam;->getType()Lcom/rigol/scope/cil/ServiceEnum$DecodeBusType;

    move-result-object p1

    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$DecodeBusType;->Decode_LIN:Lcom/rigol/scope/cil/ServiceEnum$DecodeBusType;

    if-ne p1, v0, :cond_0

    iget-object p1, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;->val$param:Lcom/rigol/scope/data/DecodeParam;

    .line 5921
    invoke-virtual {p1}, Lcom/rigol/scope/data/DecodeParam;->getLin_thres()J

    move-result-wide v0

    iget-object p1, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;->val$param:Lcom/rigol/scope/data/DecodeParam;

    const/16 v2, 0x594a

    invoke-virtual {p1, v2}, Lcom/rigol/scope/data/DecodeParam;->readLong(I)J

    move-result-wide v3

    cmp-long p1, v0, v3

    if-eqz p1, :cond_0

    .line 5922
    iget-object p1, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;->val$param:Lcom/rigol/scope/data/DecodeParam;

    invoke-virtual {p1}, Lcom/rigol/scope/data/DecodeParam;->readLin_thres()V

    .line 5923
    iget-object p1, p0, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;->val$param:Lcom/rigol/scope/data/DecodeParam;

    invoke-virtual {p1}, Lcom/rigol/scope/data/DecodeParam;->getLin_thres()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p1, v2, v0}, Lcom/rigol/scope/data/DecodeParam;->syncData(ILjava/lang/Object;)V

    :cond_0
    return-void
.end method

.method public bridge synthetic onChanged(Ljava/lang/Object;)V
    .locals 0

    .line 5917
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Lcom/rigol/scope/viewmodels/UpdateUIViewModel$503;->onChanged(Ljava/lang/Boolean;)V

    return-void
.end method
