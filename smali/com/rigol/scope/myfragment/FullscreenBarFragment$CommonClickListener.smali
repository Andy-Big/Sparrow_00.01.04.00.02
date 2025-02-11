# Общий класс для обработки кликов
.class Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;
.super Ljava/lang/Object;
.implements Landroid/view/View$OnClickListener;

.field final synthetic this$0:Lcom/rigol/scope/myfragment/FullscreenBarFragment;

.method constructor <init>(Lcom/rigol/scope/myfragment/FullscreenBarFragment;)V
    .locals 0
    
    iput-object p1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;->this$0:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    # Получаем ID нажатого view
    invoke-virtual {p1}, Landroid/view/View;->getId()I
    move-result v0

    # Проверяем какой именно TextView был нажат
    sget v1, Lcom/rigol/scope/R$id;->fsb_v1_value:I
    if-ne v0, v1, :cond_1
    const-string v1, "== FullScreenBarFragment CommonClickListener onClick == fsb_v1_value clicked"
    const-string v2, ""
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    goto :goto_0

    :cond_1
    sget v1, Lcom/rigol/scope/R$id;->fsb_v2_value:I
    if-ne v0, v1, :cond_2
    const-string v1, "== FullScreenBarFragment CommonClickListener onClick == fsb_v2_value clicked"
    const-string v2, ""
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    goto :goto_0

    :cond_2
    sget v1, Lcom/rigol/scope/R$id;->fsb_v3_value:I
    if-ne v0, v1, :cond_3
    const-string v1, "== FullScreenBarFragment CommonClickListener onClick == fsb_v3_value clicked"
    const-string v2, ""
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    goto :goto_0

    :cond_3
    sget v1, Lcom/rigol/scope/R$id;->fsb_v4_value:I
    if-ne v0, v1, :cond_4
    const-string v1, "== FullScreenBarFragment CommonClickListener onClick == fsb_v4_value clicked"
    const-string v2, ""
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    goto :goto_0

    :cond_4
    # ... обработка других TextView ...

    :goto_0
    return-void
.end method