.class public final synthetic Lcom/rigol/scope/adapters/-$$Lambda$TriggerRuntAdapter$0TtTTDvua8MGa-1vHUDU5Ac_Jc0;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Landroidx/lifecycle/Observer;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/adapters/-$$Lambda$TriggerRuntAdapter$0TtTTDvua8MGa-1vHUDU5Ac_Jc0;->f$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    return-void
.end method


# virtual methods
.method public final onChanged(Ljava/lang/Object;)V
    .locals 1

    iget-object v0, p0, Lcom/rigol/scope/adapters/-$$Lambda$TriggerRuntAdapter$0TtTTDvua8MGa-1vHUDU5Ac_Jc0;->f$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    check-cast p1, Landroid/view/KeyEvent;

    invoke-virtual {v0, p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->lambda$onCreateViewHolder$2$TriggerRuntAdapter(Landroid/view/KeyEvent;)V

    return-void
.end method
