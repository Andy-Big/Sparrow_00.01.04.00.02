.class public final synthetic Lcom/rigol/scope/-$$Lambda$SettingsBarFragment$C-ZDbOo-lBUhdguqNe2NklL5qvk;
.super Ljava/lang/Object;
.source "lambda"

# interfaces
.implements Landroidx/lifecycle/Observer;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/SettingsBarFragment;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/SettingsBarFragment;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/-$$Lambda$SettingsBarFragment$C-ZDbOo-lBUhdguqNe2NklL5qvk;->f$0:Lcom/rigol/scope/SettingsBarFragment;

    return-void
.end method


# virtual methods
.method public final onChanged(Ljava/lang/Object;)V
    .locals 1

    iget-object v0, p0, Lcom/rigol/scope/-$$Lambda$SettingsBarFragment$C-ZDbOo-lBUhdguqNe2NklL5qvk;->f$0:Lcom/rigol/scope/SettingsBarFragment;

    check-cast p1, Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Lcom/rigol/scope/SettingsBarFragment;->lambda$loadVerticalInfo$15$SettingsBarFragment(Ljava/util/ArrayList;)V

    return-void
.end method
