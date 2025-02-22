# change added
# Inform: мои утилиты для помощи в коде

.class public Lcom/rigol/axxx/axxxUtils;
.super Ljava/lang/Object;
.source "axxxUtils.java"


# Inform: флаг отображения информационной панели
.field private isShowInfoPanel:Z
# Inform: флаг полноэкранного режима
.field private isFullScreen:Z




.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1
    iput-boolean v0, p0, Lcom/rigol/axxx/axxxUtils;->isShowInfoPanel:Z
    const/4 v0, 0x0
    iput-boolean v0, p0, Lcom/rigol/axxx/axxxUtils;->isFullScreen:Z
    return-void
.end method


.method public readAllSettings()V
    .locals 0

    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->readShowInfoPanel()Z
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->readFullScreen()Z

    return-void
.end method

.method public saveAllSettings()V
    .locals 0

    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveShowInfoPanel()V
    invoke-virtual {p0}, Lcom/rigol/axxx/axxxUtils;->saveFullScreen()V

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






# обработка нажатия на кнопку полноэкранного режима
.method public clickFullScreen(Landroid/view/View;)V
    .locals 12

    # экземпляр MainActivity
    sget-object v0, Lcom/rigol/scope/MainActivity;->sInstance:Lcom/rigol/scope/MainActivity;
    if-eqz v0, :cond_exit

    # биндинг
    iget-object v1, v0, Lcom/rigol/scope/MainActivity;->binding:Lcom/rigol/scope/databinding/ActivityMainBinding;
    if-eqz v1, :cond_exit

    # экземпляр axxxUtils
    iget-object v2, v0, Lcom/rigol/scope/MainActivity;->axxxUtils:Lcom/rigol/axxx/axxxUtils;
    if-eqz v2, :cond_exit

    # контекст иконки разворота на весь экран
    iget-object v3, v1, Lcom/rigol/scope/databinding/ActivityMainBindingImpl;->fullscreenwave_icon:Landroid/widget/ImageView;
    invoke-virtual {v3}, Landroid/widget/ImageView;->getContext()Landroid/content/Context;
    move-result-object v3
    if-eqz v3, :cond_exit
   
    # проверка на включен ли режим разворота на весь экран
    invoke-virtual {v2}, Lcom/rigol/axxx/axxxUtils;->getFullScreen()Z
    move-result v0
    if-eqz v0, :cond_close
    
    # не развернуто, разворачиваем
    const/4 v0, 0x1
    invoke-virtual {v2, v0}, Lcom/rigol/axxx/axxxUtils;->setFullScreen(Z)V
    # скрываем верхнюю и нижнюю панели
    const/16 v4, 0x8   #   View.GONE
    # скрываем или отображаем панель с информацией о каналах и дискретизации в зависимости от флага isShowInfoPanel
    # если флаг сокрытия/показа панели с информацией о каналах и дискретизации равен true, то показываем панель
    invoke-virtual {v2}, Lcom/rigol/axxx/axxxUtils;->getShowInfoPanel()Z
    move-result v0
    if-eqz v0, :cond_0
    const/4 v10, 0x0   #   View.VISIBLE
    goto :cond_1
    # иначе скрываем панель
    :cond_0
    const/16 v10, 0x8   #   View.GONE
    :cond_1
    # отображаем кнопкуоткрытия/закрытия информационной панели в заголовке окна сигналов
    const/4 v11, 0x0   #   View.VISIBLE
    # картинка сворачивания
    const v7, 0x7f081002   #   R.drawable.fullscreen_close
    # поля слева и справа
    const/4 v8, 0x0
    # поля сверху и снизу
    const/4 v9, 0x0
    goto :cond_execute


    # развернуто, сворачиваем
    :cond_close
    const/4 v0, 0x0
    invoke-virtual {v2, v0}, Lcom/rigol/axxx/axxxUtils;->setFullScreen(Z)V
    # отображаем верхнюю и нижнюю панели
    const/4 v4, 0x0   #   View.VISIBLE
    # скрываем панель с информацией о каналах и дискретизации
    const/16 v10, 0x8   #   View.GONE
    # скрываем кнопку открытия/закрытия информационной панели в заголовке окна сигналов
    const/16 v11, 0x8   #   View.GONE
    # картинка разворачивания
    const v7, 0x7f081001   #   R.drawable.fullscreen_open
    # поля слева и справа
    const/4 v8, 0x2
    # поля сверху и снизу
    const/4 v9, 0x7

    :cond_execute
    # скрываем или отображаем панель с информацией о каналах и дискретизации
    iget-object v6, v1, Lcom/rigol/scope/databinding/ActivityMainBindingImpl;->fullscreen_bar:Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual {v6, v10}, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V

    # скрываем или отображаем нижнюю панель
    iget-object v6, v1, Lcom/rigol/scope/databinding/ActivityMainBindingImpl;->settingsBar:Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual {v6, v4}, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V

    # скрываем или отображаем верхнюю панель
    iget-object v6, v1, Lcom/rigol/scope/databinding/ActivityMainBindingImpl;->navigationBar:Landroidx/fragment/app/FragmentContainerView;
    invoke-virtual {v6, v4}, Landroidx/fragment/app/FragmentContainerView;->setVisibility(I)V

    # скрываем или отображаем кнопку открытия/закрытия информационной панели в заголовке окна сигналов
    # Получаем экземпляр WindowWaveformBindingImpl
    invoke-static {}, Lcom/rigol/scope/databinding/WindowWaveformBindingImpl;->getInstance()Lcom/rigol/scope/databinding/WindowWaveformBindingImpl;
    move-result-object v6
    # Получаем windowTitleInfo
    iget-object v6, v6, Lcom/rigol/scope/databinding/WindowWaveformBinding;->windowTitleInfo:Landroid/widget/ImageButton;
    # Устанавливаем видимость
    invoke-virtual {v6, v11}, Landroid/widget/ImageButton;->setVisibility(I)V

    # получаем в v7 картинку из ресурсов
    invoke-static {v3, v7}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    move-result-object v7
    # получаем в v6 объект иконки
    iget-object v6, v1, Lcom/rigol/scope/databinding/ActivityMainBindingImpl;->fullscreenwave_icon:Landroid/widget/ImageView;
    # присваиваем картинку к иконке
    invoke-static {v6, v7}, Landroidx/databinding/adapters/ImageViewBindingAdapter;->setImageDrawable(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)V


    :cond_exit
   return-void
.end method
#===============================================================================

# переключение видимости иконоки канала
.method public swithShowChanIcon(Lcom/rigol/scope/data/VerticalParam;)V
    .locals 2

    .line 100
    const/4 v1, 0x1
    invoke-virtual {p1, v1}, Lcom/rigol/scope/data/VerticalParam;->saveShowLabel(Z)V

    # логируем
    const-string v1, "swithShowChanIcon"
    invoke-static {v1}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;)V

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

# вывод отладочной информации в logcat
.method public static axxxLogOut(Ljava/lang/String;)V
    .locals 1

    const-string v0, "[RIGOL-Axxx-DEBUG]"

    invoke-static {v0, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

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





# /change added









