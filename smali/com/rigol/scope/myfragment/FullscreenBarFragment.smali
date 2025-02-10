# change added
# Inform: фрагмент с информацией о каналах и дискретизации в полноэкранном режиме

.class public Lcom/rigol/scope/myfragment/FullscreenBarFragment;
.super Landroidx/fragment/app/Fragment;
.implements Landroidx/lifecycle/Observer;

.field private static instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;

.field private fsb_h_value:Landroid/widget/TextView;
.field private fsb_v1_value:Landroid/widget/TextView;

.field private horizontalParam:Lcom/rigol/scope/data/HorizontalParam;
.field private horizontalViewModel:Lcom/rigol/scope/viewmodels/HorizontalViewModel;


.method public constructor <init>()V
    .locals 0
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V
    return-void
.end method


# В методе onCreate инициализируем ViewModel
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onCreate(Landroid/os/Bundle;)V
    
    # Сохраняем ссылку на экземпляр
    sput-object p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;

    # Получаем ViewModelProvider для активити
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object p1
    new-instance v0, Landroidx/lifecycle/ViewModelProvider;
    invoke-direct {v0, p1}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    
    # Получаем HorizontalViewModel
    const-class p1, Lcom/rigol/scope/viewmodels/HorizontalViewModel;
    invoke-virtual {v0, p1}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object p1
    check-cast p1, Lcom/rigol/scope/viewmodels/HorizontalViewModel;
    iput-object p1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->horizontalViewModel:Lcom/rigol/scope/viewmodels/HorizontalViewModel;

    # Добавляем лог для проверки
    const-string v0, "== FullScreenBarFragment onCreate == : ViewModel initialized"
    const-string v1, ""
    invoke-static {v0, v1}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    
    return-void
.end method


.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    
    # Inflate layout
    sget v0, Lcom/rigol/scope/R$layout;->fragment_fullscreen_bar:I
    const/4 v1, 0x0
    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    move-result-object p1

    # Find TextView fsb_h_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_h_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_h_value:Landroid/widget/TextView;

    # Find TextView fsb_v1_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_v1_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;

    # Подписываемся на обновления HorizontalParam через ViewModel
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->horizontalViewModel:Lcom/rigol/scope/viewmodels/HorizontalViewModel;
    invoke-virtual {v0}, Lcom/rigol/scope/viewmodels/HorizontalViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    invoke-virtual {v0, v1, p0}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-object p1
.end method


.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2
    
    # Вызываем родительский метод
    invoke-super {p0, p1, p2}, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    # Получаем LiveData из HorizontalViewModel
    iget-object p1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->horizontalViewModel:Lcom/rigol/scope/viewmodels/HorizontalViewModel;
    invoke-virtual {p1}, Lcom/rigol/scope/viewmodels/HorizontalViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    move-result-object p1

    # Получаем LifecycleOwner
    invoke-virtual {p0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object p2

    # Создаем Observer (this как Observer)
    move-object v0, p0
    check-cast v0, Landroidx/lifecycle/Observer;

    # Подписываемся на изменения
    invoke-virtual {p1, p2, v0}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method


.method public onChanged(Ljava/lang/Object;)V
    .locals 2

    # Проверяем тип и приводим к HorizontalParam
    instance-of v0, p1, Lcom/rigol/scope/data/HorizontalParam;
    if-eqz v0, :cond_0
    
    check-cast p1, Lcom/rigol/scope/data/HorizontalParam;

    # Получаем значение sample как long
    invoke-virtual {p1}, Lcom/rigol/scope/data/HorizontalParam;->getSample()J
    move-result-wide v0

    # Конвертируем long в String и добавляем "Sa/s"
    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v0, " Sa/s"
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0

    # Логируем значение
    const-string v1, "== FullScreenBarFragment onChanged == : "
    invoke-static {v1, v0}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V

    # Устанавливаем строковое значение в TextView
    invoke-virtual {p0, v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setHValue(Ljava/lang/String;)V
    
    :cond_0
    return-void
.end method


.method public static onChangedHP(Lcom/rigol/scope/data/HorizontalParam;)V
    .locals 3


    # Получаем сохраненный экземпляр
    sget-object v2, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v2, :cond_0

    # Проверяем тип и приводим к HorizontalParam
    instance-of v0, p0, Lcom/rigol/scope/data/HorizontalParam;
    if-eqz v0, :cond_0
    
    check-cast p0, Lcom/rigol/scope/data/HorizontalParam;

    # Получаем значение sample как long
    invoke-virtual {p0}, Lcom/rigol/scope/data/HorizontalParam;->getSample()J
    move-result-wide v0

    # Конвертируем long в String и добавляем "Sa/s"
    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v0, " Sa/s"
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0

    # Логируем значение
    const-string v1, "== FullScreenBarFragment onChanged == : "
    invoke-static {v1, v0}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V

    # Устанавливаем строковое значение в TextView

    invoke-virtual {v2, v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setHValue(Ljava/lang/String;)V
    
    :cond_0
    return-void
.end method


.method public setHValue(Ljava/lang/String;)V
    .locals 1
    
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_h_value:Landroid/widget/TextView;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_0
    return-void
.end method


.method public setV1Value(Ljava/lang/String;)V
    .locals 1
    
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    
    :cond_0
    return-void
.end method

# /change