# change add
# Inform: класс обработки нажатия на кнопку полноэкранного режима
.class public final synthetic Lcom/rigol/scope/-$$Lambda$MainActivity$SetFullScreenOnClick;
.super Ljava/lang/Object;
.source "lambda"


# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic f$0:Lcom/rigol/scope/MainActivity;


# direct methods
.method public synthetic constructor <init>(Lcom/rigol/scope/MainActivity;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/rigol/scope/-$$Lambda$MainActivity$SetFullScreenOnClick;->f$0:Lcom/rigol/scope/MainActivity;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 12

    # экземпляр MainActivity
    iget-object v0, p0, Lcom/rigol/scope/-$$Lambda$MainActivity$SetFullScreenOnClick;->f$0:Lcom/rigol/scope/MainActivity;
    if-eqz v0, :cond_exit
    
    # биндинг
    invoke-virtual {v0}, Lcom/rigol/scope/MainActivity;->getBinding()Lcom/rigol/scope/databinding/ActivityMainBinding;
    move-result-object v1
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

    # логируем
    const-string v4, "=== SetFullScreenOnClick == isFullScreen: "
    invoke-static {v4, v0}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;Z)V
    
    if-nez v0, :cond_close
    
    # не развернуто, разворачиваем
    # логируем
    const-string v4, "=== SetFullScreenOnClick == разворачиваем"
    invoke-static {v4}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;)V
    
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
    # логируем
    const-string v4, "=== SetFullScreenOnClick == сворачиваем"
    invoke-static {v4}, Lcom/rigol/axxx/axxxUtils;->axxxLogOut(Ljava/lang/String;)V
    
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
# /change add