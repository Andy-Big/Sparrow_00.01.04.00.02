# change added
# Inform: обработчик нажатий для кнопки открытия/закрытия информационной панели в заголовке окна сигналов
.class Lcom/rigol/scope/databinding/WindowWaveformBindingImpl$1;
.super Ljava/lang/Object;
.implements Landroid/view/View$OnClickListener;

.field final synthetic this$0:Lcom/rigol/scope/databinding/WindowWaveformBindingImpl;

.method constructor <init>(Lcom/rigol/scope/databinding/WindowWaveformBindingImpl;)V
    .locals 0
    
    iput-object p1, p0, Lcom/rigol/scope/databinding/WindowWaveformBindingImpl$1;->this$0:Lcom/rigol/scope/databinding/WindowWaveformBindingImpl;
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    
    # Получаем MainActivity через контекст view
    .line 1500
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    check-cast v0, Lcom/rigol/scope/MainActivity;

    # получаем флаг полного экрана из mainActivity
    .line 1501
    iget-object v1, v0, Lcom/rigol/scope/MainActivity;->axxxUtils:Lcom/rigol/axxx/axxxUtils;
    invoke-virtual {v1}, Lcom/rigol/axxx/axxxUtils;->getFullScreen()Z
    move-result v2

    # если флаг полного экрана равен false, то выходим из метода
    if-eqz v2, :cond_exit

    # иначе получаем флаг отображения информационной панели из mainActivity
    .line 1502
    invoke-virtual {v1}, Lcom/rigol/axxx/axxxUtils;->getShowInfoPanel()Z
    move-result v2

    # если флаг отображения информационной панели равен false, то вызываем метод showInfoPanel()
    if-nez v2, :cond_1
    invoke-virtual {v0}, Lcom/rigol/scope/MainActivity;->showInfoPanel()V
    goto :goto_0
    
    # иначе вызываем метод hideInfoPanel()
    :cond_1
    invoke-virtual {v0}, Lcom/rigol/scope/MainActivity;->hideInfoPanel()V

    :goto_0
    :cond_exit
    return-void
.end method
# /change added