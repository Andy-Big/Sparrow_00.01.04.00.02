# change added
# Inform: обработка кликов для фрагмента с информацией о каналах и дискретизации в полноэкранном режиме
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
    # Отображаем окно настроек 1 канала
    invoke-static {}, Lcom/rigol/scope/utilities/PopupViewManager;->getInstance()Lcom/rigol/scope/utilities/PopupViewManager;
    move-result-object v0
    const-class v1, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    invoke-virtual {v0, v1}, Lcom/rigol/scope/utilities/PopupViewManager;->get(Ljava/lang/Class;)Lcom/rigol/scope/views/baseview/BasePopupView;
    move-result-object v0
    instance-of v1, v0, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    if-eqz v1, :cond_0_0
    move-object v1, v0
    check-cast v1, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    const/4 v2, 0x0
    invoke-virtual {v1, v2}, Lcom/rigol/scope/views/vertical/VerticalPopupView;->setCurrentItem(I)V
    :cond_0_0
    invoke-virtual {v0}, Lcom/rigol/scope/views/baseview/BasePopupView;->show()V
    goto :goto_0

    :cond_1
    sget v1, Lcom/rigol/scope/R$id;->fsb_v2_value:I
    if-ne v0, v1, :cond_2
    # Отображаем окно настроек 2 канала
    invoke-static {}, Lcom/rigol/scope/utilities/PopupViewManager;->getInstance()Lcom/rigol/scope/utilities/PopupViewManager;
    move-result-object v0
    const-class v1, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    invoke-virtual {v0, v1}, Lcom/rigol/scope/utilities/PopupViewManager;->get(Ljava/lang/Class;)Lcom/rigol/scope/views/baseview/BasePopupView;
    move-result-object v0
    instance-of v1, v0, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    if-eqz v1, :cond_1_0
    move-object v1, v0
    check-cast v1, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    const/4 v2, 0x1
    invoke-virtual {v1, v2}, Lcom/rigol/scope/views/vertical/VerticalPopupView;->setCurrentItem(I)V
    :cond_1_0
    invoke-virtual {v0}, Lcom/rigol/scope/views/baseview/BasePopupView;->show()V
    goto :goto_0

    :cond_2
    sget v1, Lcom/rigol/scope/R$id;->fsb_v3_value:I
    if-ne v0, v1, :cond_3
    # Отображаем окно настроек 3 канала
    invoke-static {}, Lcom/rigol/scope/utilities/PopupViewManager;->getInstance()Lcom/rigol/scope/utilities/PopupViewManager;
    move-result-object v0
    const-class v1, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    invoke-virtual {v0, v1}, Lcom/rigol/scope/utilities/PopupViewManager;->get(Ljava/lang/Class;)Lcom/rigol/scope/views/baseview/BasePopupView;
    move-result-object v0
    instance-of v1, v0, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    if-eqz v1, :cond_2_0
    move-object v1, v0
    check-cast v1, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    const/4 v2, 0x2
    invoke-virtual {v1, v2}, Lcom/rigol/scope/views/vertical/VerticalPopupView;->setCurrentItem(I)V
    :cond_2_0
    invoke-virtual {v0}, Lcom/rigol/scope/views/baseview/BasePopupView;->show()V
    goto :goto_0

    :cond_3
    sget v1, Lcom/rigol/scope/R$id;->fsb_v4_value:I
    if-ne v0, v1, :cond_4
    # Отображаем окно настроек 4 канала
    invoke-static {}, Lcom/rigol/scope/utilities/PopupViewManager;->getInstance()Lcom/rigol/scope/utilities/PopupViewManager;
    move-result-object v0
    const-class v1, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    invoke-virtual {v0, v1}, Lcom/rigol/scope/utilities/PopupViewManager;->get(Ljava/lang/Class;)Lcom/rigol/scope/views/baseview/BasePopupView;
    move-result-object v0
    instance-of v1, v0, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    if-eqz v1, :cond_3_0
    move-object v1, v0
    check-cast v1, Lcom/rigol/scope/views/vertical/VerticalPopupView;
    const/4 v2, 0x3
    invoke-virtual {v1, v2}, Lcom/rigol/scope/views/vertical/VerticalPopupView;->setCurrentItem(I)V
    :cond_3_0
    invoke-virtual {v0}, Lcom/rigol/scope/views/baseview/BasePopupView;->show()V
    goto :goto_0

    :cond_4
    # ... обработка других TextView ...

    :goto_0
    return-void
.end method

# /change added
