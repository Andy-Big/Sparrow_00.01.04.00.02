# change added
# Inform: мои утилиты для помощи в коде

.class public Lcom/rigol/axxx/axxxUtils;
.super Ljava/lang/Object;
.source "axxxUtils.java"


# флаг отображения информационной панели
.field private isShowInfoPanel:Z
# флаг полноэкранного режима
.field private isFullScreen:Z

# массив с флагами сокрытия каналов
.field private isHideChannels:[Z



.method public constructor <init>()V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    # логируем
    const-string v2, "== axxxUtils -> <init> == "
    invoke-static {v2}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;)V

    const/4 v0, 0x1
    iput-boolean v0, p0, Lcom/rigol/axxx/axxxUtils;->isShowInfoPanel:Z
    const/4 v0, 0x0
    iput-boolean v0, p0, Lcom/rigol/axxx/axxxUtils;->isFullScreen:Z

    # создаем и инициализируем массив с флагами сокрытия каналов
    const/4 v1, 0x5
    new-array v0, v1, [Z
    iput-object v0, p0, Lcom/rigol/axxx/axxxUtils;->isHideChannels:[Z

    const/4 v1, 0x0
    const/4 v2, 0x4
    :goto_0
    aput-boolean v1, v0, v2
    add-int/lit8 v2, v2, -0x1
    if-ltz v2, :cond_0
    goto :goto_0

    :cond_0

    return-void
.end method


.method public readAllSettings()V
    .locals 0

    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->readShowInfoPanel()Z
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->readFullScreen()Z
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->readHideChannels()V
    return-void
.end method

.method public saveAllSettings()V
    .locals 0

    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveShowInfoPanel()V
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveFullScreen()V
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveHideChannels()V

    return-void
.end method



.method public getShowInfoPanel()Z
    .locals 1
    iget-boolean v0, p0, Lcom/rigol/axxx/axxxUtils;->isShowInfoPanel:Z
    return v0
.end method
#===============================================================================

.method public setShowInfoPanel(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/rigol/axxx/axxxUtils;->isShowInfoPanel:Z
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveShowInfoPanel()V

    return-void
.end method
#===============================================================================

.method public readShowInfoPanel()Z
    .locals 2

    # загружаем флаг отображения информационной панели из preferences приложения
    invoke-static {}, Lcom/blankj/utilcode/util/SPUtils;->getInstance()Lcom/blankj/utilcode/util/SPUtils;
    move-result-object v0
    const-string v1, "show_info_panel"
    invoke-virtual {v0, v1}, Lcom/blankj/utilcode/util/SPUtils;->getBoolean(Ljava/lang/String;)Z
    move-result v0
    iput-boolean v0, p0, Lcom/rigol/axxx/axxxUtils;->isShowInfoPanel:Z

    return v0
.end method
#===============================================================================

.method public saveShowInfoPanel()V
    .locals 3

    # сохраняем флаг отображения информационной панели в preferences приложения
    invoke-static {}, Lcom/blankj/utilcode/util/SPUtils;->getInstance()Lcom/blankj/utilcode/util/SPUtils;
    move-result-object v0
    const-string v1, "show_info_panel"
    iget-boolean v2, p0, Lcom/rigol/axxx/axxxUtils;->isShowInfoPanel:Z
    invoke-virtual {v0, v1, v2}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Z)V

    return-void
.end method
#===============================================================================


.method public getFullScreen()Z
    .locals 1
    iget-boolean v0, p0, Lcom/rigol/axxx/axxxUtils;->isFullScreen:Z
    return v0
.end method
#===============================================================================

.method public setFullScreen(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/rigol/axxx/axxxUtils;->isFullScreen:Z
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveFullScreen()V

    return-void
.end method
#===============================================================================

.method public readFullScreen()Z
    .locals 2

    # загружаем флаг отображения информационной панели из preferences приложения
    invoke-static {}, Lcom/blankj/utilcode/util/SPUtils;->getInstance()Lcom/blankj/utilcode/util/SPUtils;
    move-result-object v0
    const-string v1, "is_full_screen"
    invoke-virtual {v0, v1}, Lcom/blankj/utilcode/util/SPUtils;->getBoolean(Ljava/lang/String;)Z
    move-result v0
    iput-boolean v0, p0, Lcom/rigol/axxx/axxxUtils;->isFullScreen:Z

    return v0
.end method
#===============================================================================

.method public saveFullScreen()V
    .locals 3

    # сохраняем флаг отображения информационной панели в preferences приложения
    invoke-static {}, Lcom/blankj/utilcode/util/SPUtils;->getInstance()Lcom/blankj/utilcode/util/SPUtils;
    move-result-object v0
    const-string v1, "is_full_screen"
    iget-boolean v2, p0, Lcom/rigol/axxx/axxxUtils;->isFullScreen:Z
    invoke-virtual {v0, v1, v2}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Z)V

    return-void
.end method
#===============================================================================


.method public getHideChannel(I)Z
    .locals 1

    iget-object v0, p0, Lcom/rigol/axxx/axxxUtils;->isHideChannels:[Z
    aget-boolean v0, v0, p1

    return v0
.end method
#===============================================================================

.method public setHideChannel(IZ)V
    .locals 1

    iget-object v0, p0, Lcom/rigol/axxx/axxxUtils;->isHideChannels:[Z
    aput-boolean p2, v0, p1
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveHideChannels()V

    return-void
.end method
#===============================================================================

.method public readHideChannels()V
    .locals 3

    # загружаем массив с флагами сокрытия каналов из preferences приложения
    invoke-static {}, Lcom/blankj/utilcode/util/SPUtils;->getInstance()Lcom/blankj/utilcode/util/SPUtils;
    move-result-object v0
    const-string v1, "hide_channels_array"
    invoke-virtual {v0, v1}, Lcom/blankj/utilcode/util/SPUtils;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    # Логируем
    const-string v1, "== axxxUtils -> readHideChannels == : "
    invoke-static {v1, v0}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    # десериализуем строку в массив
    new-instance v1, Lcom/google/gson/Gson;
    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V
    # класс массива
    const-class v2, [Z
    invoke-virtual {v1, v0, v2}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    if-eqz v0, :cond_exit
    check-cast v0, [Z
    iput-object v0, p0, Lcom/rigol/axxx/axxxUtils;->isHideChannels:[Z

    :cond_exit
    return-void
.end method
#===============================================================================

.method public saveHideChannels()V
    .locals 3

    # сохраняем массив с флагами сокрытия каналов в preferences приложения
    # сериализатор
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V
    # массив
    iget-object v1, p0, Lcom/rigol/axxx/axxxUtils;->isHideChannels:[Z
    # сериализуем массив в строку
    invoke-virtual {v0, v1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    # сохраняем сериализованный массив в preferences
    invoke-static {}, Lcom/blankj/utilcode/util/SPUtils;->getInstance()Lcom/blankj/utilcode/util/SPUtils;
    move-result-object v1
    const-string v2, "hide_channels_array"
    invoke-virtual {v1, v2, v0}, Lcom/blankj/utilcode/util/SPUtils;->put(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
#===============================================================================






.method public getFragmentSettingsBarBinding()Lcom/rigol/scope/databinding/FragmentSettingsBarBinding;
    .locals 2

    # Получаем FragmentManager
    sget-object v0, Lcom/rigol/scope/MainActivity;->sInstance:Lcom/rigol/scope/MainActivity;
    if-eqz v0, :cond_exit_null
    invoke-virtual {v0}, Lcom/rigol/scope/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    # Находим фрагмент по ID контейнера
    invoke-virtual {v0}, Lcom/rigol/scope/MainActivity;->getBinding()Lcom/rigol/scope/databinding/ActivityMainBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/rigol/scope/databinding/ActivityMainBindingImpl;->settingsBar:Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual {v0}, Landroid/view/View;->getId()I
    move-result v0
    invoke-virtual {v1, v0}, Landroidx/fragment/app/FragmentManager;->findFragmentById(I)Landroidx/fragment/app/Fragment;
    move-result-object v1
    if-eqz v1, :cond_exit_null
    # Приводим к SettingsBarFragment
    check-cast v1, Lcom/rigol/scope/SettingsBarFragment;

    # Получаем binding фрагмента
    invoke-virtual {v1}, Lcom/rigol/scope/SettingsBarFragment;->getBinding()Lcom/rigol/scope/databinding/FragmentSettingsBarBinding;
    move-result-object v0
    goto :goto_exit

    :cond_exit_null
    const/4 v0, 0x0

    :goto_exit
    return-object v0

.end method
#===============================================================================





# переключение видимости иконоки канала
.method public swithShowChanIcon(Lcom/rigol/scope/data/VerticalParam;Z)V
    .locals 6

    # получаем номер канала из объекта VerticalParam
    invoke-virtual {p1}, Lcom/rigol/scope/data/VerticalParam;->getChan()Lcom/rigol/scope/cil/ServiceEnum$Chan;
    move-result-object v3
    iget v3, v3, Lcom/rigol/scope/cil/ServiceEnum$Chan;->value1:I
    # вычитаем 1, так как номера каналов начинаются с 1
    add-int/lit8 v3, v3, -0x1

    # логируем
    const-string v0, "== axxxUtils -> swithShowChanIcon == chan number: "
    invoke-static {v0, v3}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;I)V

    
    # Получаем FragmentManager
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->getFragmentSettingsBarBinding()Lcom/rigol/scope/databinding/FragmentSettingsBarBinding;
    move-result-object v0
    if-eqz v0, :cond_exit_err
    # Получаем RecyclerView
    iget-object v4, v0, Lcom/rigol/scope/databinding/FragmentSettingsBarBinding;->verticalList:Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v4, :cond_exit_err
    # Получаем LayoutManager
    invoke-virtual {v4}, Landroidx/recyclerview/widget/RecyclerView;->getLayoutManager()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    move-result-object v0
    if-eqz v0, :cond_exit_err
    # Находим View по позиции
    invoke-virtual {v0, v3}, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;->findViewByPosition(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, :cond_exit_err
    add-int/lit8 v3, v3, 0x1

    # получаем массив с флагами сокрытия каналов
    iget-object v1, p0, Lcom/rigol/axxx/axxxUtils;->isHideChannels:[Z

    # если флаг сокрытия канала в параметре p2 равен false, то отображаем элемент
    if-nez p2, :cond_hide
    const/4 v2, 0x0
    aput-boolean v2, v1, v3

    # отображаем канал
    # логируем
    const-string v2, "== axxxUtils -> swithShowChanIcon == VISIBLE"
    invoke-static {v2}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;)V

    const/4 v1, 0x0    # VISIBLE
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V
    goto :goto_exit

    # если флаг сокрытия канала равен true, то скрываем элемент
    :cond_hide
    const/4 v2, 0x1
    aput-boolean v2, v1, v3
    # устанавливаем статус канала в OFF
    invoke-static {v3}, Lcom/rigol/axxx/axxxUtils;->axxxGetVerticalParamByNum(I)Lcom/rigol/scope/data/VerticalParam;
    move-result-object v1
    if-eqz v1, :cond_exit_err
    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;->CHAN_OFF:Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;
    invoke-virtual {v1, v2}, Lcom/rigol/scope/data/VerticalParam;->saveStatus(Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;)V
    # скрываем канал
    # логируем
    const-string v2, "== axxxUtils -> swithShowChanIcon == GONE"
    invoke-static {v2}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;)V

    const/16 v1, 0x8    # GONE
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :goto_exit
    # сохраняем массив с флагами сокрытия каналов
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveHideChannels()V
    return-void

    :cond_exit_err
    const-string v0, "== axxxUtils -> swithShowChanIcon == error"
    invoke-static {v0}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;)V
    return-void

.end method
#===============================================================================

# возвращает указатель на VerticalParam по номеру канала
.method public static axxxGetVerticalParamByNum(I)Lcom/rigol/scope/data/VerticalParam;
    .locals 4

    # проверяем, если номер канала меньше 1, то возвращаем null
    if-lez p0, :cond_exit_null

    # уменьшаем номер канала на 1, так как номера каналов начинаются с 1
    add-int/lit8 p0, p0, -0x1

    # создаем объект списка VerticalParam
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V
    if-eqz v1, :cond_exit_null

    # Получаем указатель на VerticalViewModel
    const-class v0, Lcom/rigol/scope/viewmodels/VerticalViewModel;
    invoke-static {v0}, Lcom/rigol/scope/utilities/ContextUtil;->getAppViewModel(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v0
    check-cast v0, Lcom/rigol/scope/viewmodels/VerticalViewModel;

    # Получаем список VerticalParam
    invoke-virtual {v0}, Lcom/rigol/scope/viewmodels/VerticalViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    invoke-virtual {v0}, Lcom/rigol/scope/viewmodels/VerticalViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0

    # присваиваем объект списка VerticalParam
    move-object v1, v0
    check-cast v1, Ljava/util/List;

    # сравниваем номер канала с количеством элементов в списке (с учетом того, что номера каналов начинаются с 1)
    invoke-interface {v1}, Ljava/util/List;->size()I
    move-result v0
    if-ge p0, v0, :cond_exit_null

    # получаем объект VerticalParam по номеру канала
    invoke-interface {v1, p0}, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/rigol/scope/data/VerticalParam;

    # возвращаем объект VerticalParam
    return-object v0

    :cond_exit_null
    const/4 v0, 0x0
    return-object v0
.end method
#===============================================================================

# возвращает указатель на ServiceEnum$Chan; по номеру канала
.method public static axxxGetChanByNum(I)Lcom/rigol/scope/cil/ServiceEnum$Chan;
    .locals 4

    # получаем объект VerticalParam по номеру канала
    invoke-static {p0}, Lcom/rigol/axxx/axxxUtils;->axxxGetVerticalParamByNum(I)Lcom/rigol/scope/data/VerticalParam;
    move-result-object v0

    # проверяем, если объект VerticalParam не равен null, то возвращаем указатель на ServiceEnum$Chan
    if-eqz v0, :cond_exit_null

    # возвращаем указатель на ServiceEnum$Chan
    invoke-virtual {v0}, Lcom/rigol/scope/data/VerticalParam;->getChan()Lcom/rigol/scope/cil/ServiceEnum$Chan;
    move-result-object v0
    return-object v0

    :cond_exit_null
    const/4 v0, 0x0
    return-object v0
.end method
#===============================================================================

# возвращает указатель на HorizontalParam
.method public static axxxGetHorizontalParam()Lcom/rigol/scope/data/HorizontalParam;
    .locals 4

    # получаем указатель на HorizontalViewModel
    const-class v0, Lcom/rigol/scope/viewmodels/HorizontalViewModel;
    invoke-static {v0}, Lcom/rigol/scope/utilities/ContextUtil;->getAppViewModel(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v0
    check-cast v0, Lcom/rigol/scope/viewmodels/HorizontalViewModel;

    # получаем указатель на HorizontalParam
    invoke-virtual {v0}, Lcom/rigol/scope/viewmodels/HorizontalViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    invoke-virtual {v0}, Lcom/rigol/scope/viewmodels/HorizontalViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/rigol/scope/data/HorizontalParam;

    # возвращаем указатель на HorizontalParam
    return-object v0
.end method
#===============================================================================





.method public static axxxPrintStackTraces()V
    .locals 7

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;
    move-result-object v2
    invoke-virtual {v2}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;
    move-result-object v1

    array-length v3, v1
    const/4 v2, 0x0
    const-string v4, "[RIGOL-Axxx-DEBUG]"

    :goto_0
    if-lt v2, v3, :cond_0
    return-void

    :cond_0
    aget-object v0, v1, v2
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "Class name :: " 
    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual {v0}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "  || method name :: " 
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual {v0}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    add-int/lit8 v2, v2, 0x1
    goto :goto_0

.end method
#===============================================================================

# вывод отладочной информации в logcat
.method public static axxxLogOut(Ljava/lang/String;)V
    .locals 1

    const-string v0, "[RIGOL-Axxx-DEBUG]"

    invoke-static {v0, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method
#===============================================================================

# вывод отладочной информации с числовым значением в logcat
.method public static axxxLogOut(Ljava/lang/String;I)V
    .locals 2

    const-string v0, "[RIGOL-Axxx-DEBUG]"

    # Создаем новый StringBuilder
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V
    
    # Добавляем исходную строку p0 в StringBuilder
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    
    # Преобразуем число p1 в строку и добавляем в StringBuilder
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object p0
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    
    # Получаем итоговую строку из StringBuilder
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object p0

    # Выводим отладочное сообщение в logcat
    invoke-static {v0, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method
#===============================================================================

# вывод отладочной информации с текстовым значением в logcat
.method public static axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    const-string v0, "[RIGOL-Axxx-DEBUG]"

    # Создаем новый StringBuilder
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V
    
    # Добавляем исходную строку p0 в StringBuilder
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    
    # Добавляем исходную строку p1 в StringBuilder
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    # Получаем итоговую строку из StringBuilder
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1

    # Выводим отладочное сообщение в logcat
    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method
#===============================================================================

# вывод отладочной информации с булевым значением в logcat
.method public static axxxLogOut(Ljava/lang/String;Z)V
    .locals 2

    const-string v0, "[RIGOL-Axxx-DEBUG]"

    # Создаем новый StringBuilder
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V
    
    # Добавляем исходную строку p0 в StringBuilder
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    
    # Если p1 равно true, то добавляем "true" в StringBuilder, иначе добавляем "false"
    if-eqz p1, :cond_false
    const-string p0, "true"
    goto :cond_execute

    :cond_false
    const-string p0, "false"

    :cond_execute
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    
    # Получаем итоговую строку из StringBuilder
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object p0

    # Выводим отладочное сообщение в logcat
    invoke-static {v0, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method
#===============================================================================




# /change added









