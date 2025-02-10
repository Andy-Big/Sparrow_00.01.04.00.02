# change added
# Inform: фрагмент с информацией о каналах и дискретизации в полноэкранном режиме

.class public Lcom/rigol/scope/myfragment/FullscreenBarFragment;
.super Landroidx/fragment/app/Fragment;
.implements Landroidx/lifecycle/Observer;

.field private static instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;

.field private fsb_a_value:Landroid/widget/TextView;
.field private fsb_h_value:Landroid/widget/TextView;
.field private fsb_v1_title:Landroid/widget/TextView;
.field private fsb_v1_value:Landroid/widget/TextView;
.field private fsb_v2_title:Landroid/widget/TextView;
.field private fsb_v2_value:Landroid/widget/TextView;
.field private fsb_v3_title:Landroid/widget/TextView;
.field private fsb_v3_value:Landroid/widget/TextView;
.field private fsb_v4_title:Landroid/widget/TextView;
.field private fsb_v4_value:Landroid/widget/TextView;

.field private horizontalParam:Lcom/rigol/scope/data/HorizontalParam;
.field private horizontalViewModel:Lcom/rigol/scope/viewmodels/HorizontalViewModel;

.field private chanNum:I

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

    # Количество каналов
    const/16 v0, 0xf
    iput v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanNum:I

    # Добавляем лог для проверки
    const-string v0, "== FullScreenBarFragment onCreate == : ViewModel initialized"
    const-string v1, ""
    invoke-static {v0, v1}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    

    return-void
.end method


.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    
    const-string v1, "== FullScreenBarFragment onCreateView == "
    invoke-static {v1}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;)V

   # Inflate layout
    sget v0, Lcom/rigol/scope/R$layout;->fragment_fullscreen_bar:I
    const/4 v1, 0x0
    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    move-result-object p1

    # Find TextView fsb_a_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_a_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_a_value:Landroid/widget/TextView;

    # Find TextView fsb_h_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_h_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_h_value:Landroid/widget/TextView;

    # Find TextView fsb_v1_title
    sget v0, Lcom/rigol/scope/R$id;->fsb_v1_title:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_title:Landroid/widget/TextView;

    # Find TextView fsb_v1_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_v1_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;

    # Find TextView fsb_v2_title
    sget v0, Lcom/rigol/scope/R$id;->fsb_v2_title:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v2_title:Landroid/widget/TextView;

    # Find TextView fsb_v2_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_v2_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v2_value:Landroid/widget/TextView;

    # Find TextView fsb_v3_title
    sget v0, Lcom/rigol/scope/R$id;->fsb_v3_title:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v3_title:Landroid/widget/TextView;

    # Find TextView fsb_v3_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_v3_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v3_value:Landroid/widget/TextView;

    # Find TextView fsb_v4_title
    sget v0, Lcom/rigol/scope/R$id;->fsb_v4_title:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v4_title:Landroid/widget/TextView;

    # Find TextView fsb_v4_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_v4_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v4_value:Landroid/widget/TextView;

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

    # Проверяем статус всех каналов и скрываем скрытые каналы


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


.method public static onChangedHP(J)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    const-string v2, "0.00"
    invoke-static {v2}, Lcom/rigol/scope/utilities/UnitFormat;->newBuilder(Ljava/lang/String;)Lcom/rigol/scope/utilities/UnitFormat;
    move-result-object v2
    sget-object v3, Lcom/rigol/scope/cil/ServiceEnum$Unit;->Unit_SaS:Lcom/rigol/scope/cil/ServiceEnum$Unit;
    invoke-virtual {v2, p0, p1, v3}, Lcom/rigol/scope/utilities/UnitFormat;->convert(JLcom/rigol/scope/cil/ServiceEnum$Unit;)Ljava/lang/String;
    move-result-object v2


    # Логируем значение
    const-string v1, "== FullScreenBarFragment onChangedHP1 == : "
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V

    # Устанавливаем строковое значение в TextView
    invoke-virtual {v0, v2}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setHValue(Ljava/lang/String;)V
    
    :cond_0
    return-void
.end method


.method public static onChangedTrig(Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значения из ControlStatus
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;->value1:I
    iget-object v3, p0, Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;->value2:Ljava/lang/String;

    # Логируем значение
    const-string v1, "== FullScreenBarFragment onChangedTrig == : "
    invoke-static {v1, v3}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V

    # Устанавливаем текст и цвет
    invoke-virtual {v0, v3, v2}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setAValue(Ljava/lang/String;I)V
    
    :cond_0
    return-void
.end method


.method public static onChangedChanStatus(Lcom/rigol/scope/cil/ServiceEnum$Chan;Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Проверяем что мы еще не получили количество каналов
    const/16 v2, 0xf
    iget v3, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanNum:I

    if-ne v3, v2, :cond_1

    # Получаем количество каналов
    const-class v2, Lcom/rigol/scope/viewmodels/UtilityViewModel;
    invoke-static {v2}, Lcom/rigol/scope/utilities/ContextUtil;->getAppViewModel(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v2
    check-cast v2, Lcom/rigol/scope/viewmodels/UtilityViewModel;
    if-eqz v2, :cond_1
    invoke-virtual {v2}, Lcom/rigol/scope/viewmodels/UtilityViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    move-result-object v2
    invoke-virtual {v2}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/rigol/scope/data/UtilityParam;
    if-eqz v2, :cond_1
    invoke-virtual {v2}, Lcom/rigol/scope/data/UtilityParam;->getChNum()I
    move-result v2
    iput v2, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanNum:I

    const-string v1, "== FullScreenBarFragment onChangedChanStatus == chanNum: "
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Если каналов только 2, то гасим 3 и 4 каналы
    const/4 v3, 0x2
    if-ne v2, v3, :cond_1
    const-string v1, "== FullScreenBarFragment onChangedChanStatus == Hide 3 and 4"
    invoke-static {v1}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;)V
    const/4 v2, 0x3
    const/4 v3, 0x3
    invoke-virtual {v0, v2, v3}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setVxStatus(II)V
    const/4 v2, 0x4
    invoke-virtual {v0, v2, v3}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setVxStatus(II)V


    :cond_1
    # Получаем номер канала
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$Chan;->value1:I
    # Получаем статус канала
    iget v3, p1, Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;->value1:I


    # Логируем значение
    const-string v1, "== FullScreenBarFragment onChangedChanStatus == chan: "
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V
    const-string v1, "== FullScreenBarFragment onChangedChanStatus == status: "
    invoke-static {v1, v3}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V


    # Устанавливаем статус канала
    invoke-virtual {v0, v2, v3}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setVxStatus(II)V

    :cond_0
    return-void
.end method


.method public setAValue(Ljava/lang/String;I)V
    .locals 2
    
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_a_value:Landroid/widget/TextView;
    if-eqz v0, :cond_0

    # Устанавливаем текст
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    # Проверяем p2 == 0 - Status_Stoped
    const/4 v1, 0x0
    if-eq p2, v1, :cond_1
    
    # Проверяем p2 == 7 - Status_Force_Stoped
    const/4 v1, 0x7
    if-eq p2, v1, :cond_1
    
    # Проверяем p2 == 9 - Status_Record_Play
    const/16 v1, 0x9
    if-eq p2, v1, :cond_1
    
    # Если ни одно условие не выполнилось - зеленый цвет
    const v1, -0xff0100    # FF00FF00 (зеленый)
    goto :cond_2

    # Если хотя бы одно условие выполнилось - красный цвет
    :cond_1
    const/high16 v1, -0x10000    # FFFF0000 (красный)
    
    :cond_2
    # Устанавливаем выбранный цвет
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

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


.method public setVxStatus(II)V
    .locals 4
    # p1 - номер канала, p2 - статус канала

    const-string v3, "== FullScreenBarFragment setVxStatus == p1: "
    invoke-static {v3, p1}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V
    const-string v3, "== FullScreenBarFragment setVxStatus == p2: "
    invoke-static {v3, p2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Проверяем номер канала
    # Проверяем p1 == 1 - chan1
    const/4 v1, 0x1
    if-ne p1, v1, :cond_1
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_title:Landroid/widget/TextView;
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    goto :goto_4
    :cond_1

    # Проверяем p1 == 2 - chan2
    const/4 v1, 0x2
    if-ne p1, v1, :cond_2
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v2_title:Landroid/widget/TextView;
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v2_value:Landroid/widget/TextView;
    goto :goto_4


    :cond_2
    # Проверяем p1 == 3 - chan3
    const/4 v1, 0x3
    if-ne p1, v1, :cond_3
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v3_title:Landroid/widget/TextView;
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v3_value:Landroid/widget/TextView;
    goto :goto_4


    :cond_3
    # Проверяем p1 == 4 - chan4
    const/4 v1, 0x4
    if-ne p1, v1, :cond_0
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v4_title:Landroid/widget/TextView;
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v4_value:Landroid/widget/TextView;
    

    :goto_4
    if-eqz v0, :cond_0
    if-eqz v1, :cond_0

    const-string v3, "== FullScreenBarFragment setVxStatus == chan: "
    invoke-static {v3, p1}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V
    const-string v3, "== FullScreenBarFragment setVxStatus == status: "
    invoke-static {v3, p2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Проверяем статус канала
    # Проверяем p2 == 0 - CHAN_OFF
    const/4 v2, 0x0
    if-ne p2, v2, :cond_5
    const v2, -0x808080    # FF808080 (серый)
    goto :goto_5

    :cond_5
    # Проверяем p2 == 1 - CHAN_ON
    const/4 v2, 0x1
    if-ne p2, v2, :cond_6
    const v2, 0xffffffff    # FFFFFFFF (белый)
    goto :goto_5

    :cond_6
    # Проверяем p2 == 2 - CHAN_ACTIVE
    const/4 v2, 0x2
    if-ne p2, v2, :cond_7
    const v2, 0xffffffff    # FFFFFFFF (белый)
    goto :goto_5

    :cond_7
    # Проверяем p2 == 3 - CHAN_HIDE
    const/4 v2, 0x3
    if-ne p2, v2, :cond_0
    # Этот канал скрыт, скрываем его
    const/4 v2, 0x4     # GONE
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V
    goto :cond_0

    :goto_5
    # Устанавливаем цвет
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    :cond_0
    return-void
.end method


.method public setVxValue(Ljava/lang/String;)V
    .locals 1
    
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    
    :cond_0
    return-void
.end method

# /change