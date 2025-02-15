# change added
# Inform: фрагмент с информацией о каналах и дискретизации в полноэкранном режиме

.class public Lcom/rigol/scope/myfragment/FullscreenBarFragment;
.super Landroidx/fragment/app/Fragment;

.field private static instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;

.field private triggerParam:Lcom/rigol/scope/data/TriggerParam;
.field private triggerViewModel:Lcom/rigol/scope/viewmodels/TriggerViewModel;

.field private fsb_t_icon:Landroid/widget/ImageView;
.field private fsb_tc_name:Landroid/widget/TextView;
.field private fsb_a_value:Landroid/widget/TextView;
.field private fsb_h_value:Landroid/widget/TextView;
.field private fsb_hs_value:Landroid/widget/TextView;
.field private fsb_v1_title:Landroid/widget/TextView;
.field private fsb_v1_value:Landroid/widget/TextView;
.field private fsb_v2_title:Landroid/widget/TextView;
.field private fsb_v2_value:Landroid/widget/TextView;
.field private fsb_v3_title:Landroid/widget/TextView;
.field private fsb_v3_value:Landroid/widget/TextView;
.field private fsb_v4_title:Landroid/widget/TextView;
.field private fsb_v4_value:Landroid/widget/TextView;

.field private chanNum:I
.field private sample:J
.field private horizontalScale:J
.field private trigStatus:I
.field private chanStatus:[I
.field private chanScale:[J

.field private triggerMode:Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;
.field private triggerVideoPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
.field private triggerRuntPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
.field private triggerSHEvent:Lcom/rigol/scope/cil/ServiceEnum$SHEvent;
.field private triggerEdgeSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
.field private triggerSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
.field private triggerTimeoutSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
.field private triggerOverSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
.field private triggerOverEvent:Lcom/rigol/scope/cil/ServiceEnum$OverEvent;
.field private triggerSetupHoldSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
.field private triggerEdgeSlopeA:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
.field private triggerPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
.field private triggerNthSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
.field private triggerEdgeSlopeB:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
.field private triggerChannel:I



.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V
    return-void
.end method


# В методе onCreate инициализируем ViewModel
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onCreate(Landroid/os/Bundle;)V
    
    # Сохраняем ссылку на экземпляр
    sput-object p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;

    # Получаем TriggerParam через TriggerViewModel
    const-class v0, Lcom/rigol/scope/viewmodels/TriggerViewModel;
    invoke-static {v0}, Lcom/rigol/scope/utilities/ContextUtil;->getAppViewModel(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v0
    check-cast v0, Lcom/rigol/scope/viewmodels/TriggerViewModel;

    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerViewModel:Lcom/rigol/scope/viewmodels/TriggerViewModel;
    if-nez v0, :cond_1
    const-string v0, "== FullscreenBarFragment onCreate == triggerViewModel: null"
    invoke-static {v0}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;)V
    goto :cond_0

    :cond_1
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerParam:Lcom/rigol/scope/data/TriggerParam;
    if-eqz v1, :cond_2
    const-string v1, "== FullscreenBarFragment onCreate == triggerParam: not null"
    invoke-static {v1}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;)V
    goto :cond_0

    :cond_2
    invoke-virtual {v0}, Lcom/rigol/scope/viewmodels/TriggerViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerViewModel:Lcom/rigol/scope/viewmodels/TriggerViewModel;
    invoke-virtual {v0}, Lcom/rigol/scope/viewmodels/TriggerViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual {v0}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-nez v0, :cond_3
    const-string v0, "== FullscreenBarFragment onCreate == LiveData->getValue(): null"
    invoke-static {v0}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;)V
    goto :cond_0

    :cond_3
    check-cast v0, Lcom/rigol/scope/data/TriggerParam;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerParam:Lcom/rigol/scope/data/TriggerParam;

    :cond_0
    # Количество каналов
    const/16 v0, 0xf
    iput v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanNum:I

    # Сэмплрейт
    const-wide v0, 0x2710    # Значение 10000 в формате long
    iput-wide v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->sample:J

    # Масштаб горизонтальной шкалы
    const-wide v0, 0x2710    # Значение 10000 в формате long
    iput-wide v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->horizontalScale:J

    # Статус триггера
    const/4 v0, 0x0      # 0 - Status_Stoped
    iput v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->trigStatus:I

    # Инициализируем массивы
    # Статус каналов
    const/16 v0, 0x5
    new-array v0, v0, [I
    const/16 v1, 0x0    # 0 - CHAN_OFF
    const/16 v2, 0x0    # Индекс для установки значения
    aput v1, v0, v2    # Устанавливаем значение v1 в массив v0 по индексу v2
    const/16 v2, 0x1
    aput v1, v0, v2    # Устанавливаем значение v1 в массив v0 по индексу v2
    const/16 v2, 0x2
    aput v1, v0, v2    # Устанавливаем значение v1 в массив v0 по индексу v2
    const/16 v2, 0x3
    aput v1, v0, v2    # Устанавливаем значение v1 в массив v0 по индексу v2
    const/16 v2, 0x4
    aput v1, v0, v2    # Устанавливаем значение v1 в массив v0 по индексу v2
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanStatus:[I


    # Масштаб каналов
    const/16 v0, 0x5
    new-array v0, v0, [J
    const-wide v1, 0x2710    # Значение 10000 в формате long
    const/16 v3, 0x0    # Индекс для установки значения
    aput-wide v1, v0, v3    # Устанавливаем значение v1 в массив v0 по индексу v3
    const/16 v3, 0x1    # Индекс для установки значения
    aput-wide v1, v0, v3    # Устанавливаем значение v1 в массив v0 по индексу v3
    const/16 v3, 0x2    # Индекс для установки значения
    aput-wide v1, v0, v3    # Устанавливаем значение v1 в массив v0 по индексу v3
    const/16 v3, 0x3    # Индекс для установки значения
    aput-wide v1, v0, v3    # Устанавливаем значение v1 в массив v0 по индексу v3
    const/16 v3, 0x4    # Индекс для установки значения
    aput-wide v1, v0, v3    # Устанавливаем значение v1 в массив v0 по индексу v3
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanScale:[J

    # Инициализируем параметры триггера
    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;->Trigger_Edge:Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerMode:Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;
    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->Trigger_pulse_positive:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerVideoPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerRuntPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$SHEvent;->Trigger_SH_hold:Lcom/rigol/scope/cil/ServiceEnum$SHEvent;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSHEvent:Lcom/rigol/scope/cil/ServiceEnum$SHEvent;
    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->Trigger_Edge_Rising:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerTimeoutSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerOverSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSetupHoldSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlopeA:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerNthSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlopeB:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$OverEvent;->Trigger_over_enter:Lcom/rigol/scope/cil/ServiceEnum$OverEvent;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerOverEvent:Lcom/rigol/scope/cil/ServiceEnum$OverEvent;

    # Инициализируем канал триггера
    const/4 v0, 0x1
    iput v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerChannel:I

    return-void
.end method


.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    
    # Inflate layout
    sget v0, Lcom/rigol/scope/R$layout;->fragment_fullscreen_bar:I
    const/4 v1, 0x0
    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    move-result-object p1

    # Find TextView fsb_t_icon
    sget v0, Lcom/rigol/scope/R$id;->fsb_t_icon:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_t_icon:Landroid/widget/ImageView;

    # Find TextView fsb_tc_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_tc_name:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_tc_name:Landroid/widget/TextView;

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

    # Find TextView fsb_hs_value
    sget v0, Lcom/rigol/scope/R$id;->fsb_hs_value:I
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_hs_value:Landroid/widget/TextView;

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
    # Добавляем слушатель кликов
    new-instance v1, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;
    invoke-direct {v1, p0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;-><init>(Lcom/rigol/scope/myfragment/FullscreenBarFragment;)V
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    # Расширяем область клика
    invoke-direct {p0, v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setupTextViewTouchDelegate(Landroid/widget/TextView;)V

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
    # Добавляем слушатель кликов
    new-instance v1, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;
    invoke-direct {v1, p0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;-><init>(Lcom/rigol/scope/myfragment/FullscreenBarFragment;)V
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    # Расширяем область клика
    invoke-direct {p0, v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setupTextViewTouchDelegate(Landroid/widget/TextView;)V

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
    # Добавляем слушатель кликов
    new-instance v1, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;
    invoke-direct {v1, p0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;-><init>(Lcom/rigol/scope/myfragment/FullscreenBarFragment;)V
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    # Расширяем область клика
    invoke-direct {p0, v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setupTextViewTouchDelegate(Landroid/widget/TextView;)V

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
    # Добавляем слушатель кликов
    new-instance v1, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;
    invoke-direct {v1, p0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment$CommonClickListener;-><init>(Lcom/rigol/scope/myfragment/FullscreenBarFragment;)V
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    # Расширяем область клика
    invoke-direct {p0, v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setupTextViewTouchDelegate(Landroid/widget/TextView;)V

    return-object p1
.end method


# Добавляем приватный метод для настройки TouchDelegate
.method private setupTextViewTouchDelegate(Landroid/widget/TextView;)V
    .locals 2
    
    if-eqz p1, :cond_0
    
    # Создаем и устанавливаем TouchDelegate
    new-instance v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment$TouchDelegateHelper;
    invoke-direct {v0, p0, p1}, Lcom/rigol/scope/myfragment/FullscreenBarFragment$TouchDelegateHelper;-><init>(Lcom/rigol/scope/myfragment/FullscreenBarFragment;Landroid/widget/TextView;)V
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    
    :cond_0
    return-void
.end method


.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2
    
    # Вызываем родительский метод
    invoke-super {p0, p1, p2}, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    return-void
.end method


.method public static onChangedSample(J)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Сравниваем сэмплрейт с сохраненным и если он не изменился, то выходим
    iget-wide v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->sample:J
    cmp-long v2, p0, v1
    if-eqz v2, :cond_0

    # Сохраняем сэмплрейт в локальном поле
    iput-wide p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->sample:J

    const-string v2, "0.00"
    invoke-static {v2}, Lcom/rigol/scope/utilities/UnitFormat;->newBuilder(Ljava/lang/String;)Lcom/rigol/scope/utilities/UnitFormat;
    move-result-object v2
    sget-object v3, Lcom/rigol/scope/cil/ServiceEnum$Unit;->Unit_SaS:Lcom/rigol/scope/cil/ServiceEnum$Unit;
    invoke-virtual {v2, p0, p1, v3}, Lcom/rigol/scope/utilities/UnitFormat;->convert(JLcom/rigol/scope/cil/ServiceEnum$Unit;)Ljava/lang/String;
    move-result-object v2

    # Устанавливаем строковое значение в TextView
    invoke-virtual {v0, v2}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setHValue(Ljava/lang/String;)V
    
    :cond_0
    return-void
.end method


.method public static onChangedHScale(J)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Сравниваем сэмплрейт с сохраненным и если он не изменился, то выходим
    iget-wide v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->horizontalScale:J
    cmp-long v2, p0, v1
    if-eqz v2, :cond_0

    # Сохраняем масштаб горизонтальной шкалы в локальном поле
    iput-wide p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->horizontalScale:J

    sget-object v2, Lcom/rigol/scope/utilities/UnitFormat$SI;->FEMTO:Lcom/rigol/scope/utilities/UnitFormat$SI;
    invoke-static {v2}, Lcom/rigol/scope/utilities/UnitFormat;->newBuilder(Lcom/rigol/scope/utilities/UnitFormat$SI;)Lcom/rigol/scope/utilities/UnitFormat;
    move-result-object v2
    sget-object v3, Lcom/rigol/scope/cil/ServiceEnum$Unit;->Unit_s:Lcom/rigol/scope/cil/ServiceEnum$Unit;
    invoke-virtual {v2, p0, p1, v3}, Lcom/rigol/scope/utilities/UnitFormat;->convert(JLcom/rigol/scope/cil/ServiceEnum$Unit;)Ljava/lang/String;
    move-result-object v2

    #sget-object v3, Lcom/rigol/scope/cil/ServiceEnum$Unit;->Unit_SaS:Lcom/rigol/scope/cil/ServiceEnum$Unit;
    #invoke-static {v2}, Lcom/rigol/scope/utilities/UnitFormat;->newBuilder(Ljava/lang/String;)Lcom/rigol/scope/utilities/UnitFormat;
    #move-result-object v2
    #sget-object v3, Lcom/rigol/scope/cil/ServiceEnum$Unit;->Unit_SaS:Lcom/rigol/scope/cil/ServiceEnum$Unit;
    #invoke-virtual {v2, p0, p1, v3}, Lcom/rigol/scope/utilities/UnitFormat;->convert(JLcom/rigol/scope/cil/ServiceEnum$Unit;)Ljava/lang/String;
    #move-result-object v2

    # Устанавливаем строковое значение в TextView
    invoke-virtual {v0, v2}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setHScale(Ljava/lang/String;)V
    
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

    # Получаем код статуса из ControlStatus
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;->value1:I

    # Сравниваем статус триггера с сохраненным и если он не изменился, то выходим
    iget v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->trigStatus:I
    if-eq v2, v1, :cond_0

    # Сохраняем его в локальном поле
    iput v2, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->trigStatus:I

    # Получаем текст статуса из ControlStatus
    iget-object v3, p0, Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;->value2:Ljava/lang/String;

    # Устанавливаем текст и цвет
    invoke-virtual {v0, v3, v2}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setAValue(Ljava/lang/String;I)V
    
    :cond_0
    return-void
.end method


.method public static onChangedChanStatus(Lcom/rigol/scope/cil/ServiceEnum$Chan;Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;)V
    .locals 5

    # Получаем сохраненный экземпляр
    .line 1000
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    .line 1010
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    .line 1020
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Проверяем что мы еще не получили количество каналов
    .line 1030
    const/16 v2, 0xf
    iget v3, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanNum:I
    .line 1040
    if-ne v3, v2, :cond_1

    # Получаем количество каналов
    .line 1050
    const-class v2, Lcom/rigol/scope/viewmodels/UtilityViewModel;
    invoke-static {v2}, Lcom/rigol/scope/utilities/ContextUtil;->getAppViewModel(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v2
    .line 1060
    check-cast v2, Lcom/rigol/scope/viewmodels/UtilityViewModel;
    .line 1070
    if-eqz v2, :cond_1
    .line 1080
    invoke-virtual {v2}, Lcom/rigol/scope/viewmodels/UtilityViewModel;->getLiveData()Landroidx/lifecycle/LiveData;
    move-result-object v2
    .line 1090
    invoke-virtual {v2}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    .line 1100
    check-cast v2, Lcom/rigol/scope/data/UtilityParam;
    .line 1110
    if-eqz v2, :cond_1
    .line 1120
    invoke-virtual {v2}, Lcom/rigol/scope/data/UtilityParam;->getChNum()I
    move-result v2
    iput v2, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanNum:I
    .line 1130
    # Если каналов только 2, то гасим 3 и 4 каналы
    const/4 v3, 0x2
    if-ne v2, v3, :cond_1
    .line 1140
    const/4 v2, 0x3
    const/4 v3, 0x3
    invoke-virtual {v0, v2, v3}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setVxStatus(II)V
    .line 1150
    const/4 v2, 0x4
    invoke-virtual {v0, v2, v3}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setVxStatus(II)V
    .line 1160

    :cond_1
    # Получаем номер канала
    .line 1170
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$Chan;->value1:I
    # Получаем статус канала
    .line 1180
    iget v3, p1, Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;->value1:I

    # Сравниваем статус канала с сохраненным и если он не изменился, то выходим
    .line 1190
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanStatus:[I
    .line 1200
    aget v4, v1, v2     # Получаем статус канала из массива chanStatus v1 по индексу v2 в v4
    .line 1210
    if-eq v3, v4, :cond_0

    # Сохраняем статус канала в локальном поле
    .line 1220
    aput v3, v1, v2    # Сохраняем статус канала v3 в массив chanStatus v1 по индексу v2

    # Устанавливаем статус канала
    .line 1230
    invoke-virtual {v0, v2, v3}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setVxStatus(II)V

    :cond_0
    return-void
.end method

.method public static onChangedChanScale(Lcom/rigol/scope/cil/ServiceEnum$Chan;Ljava/lang/String;J)V
    .locals 6


    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем номер канала
    iget v1, p0, Lcom/rigol/scope/cil/ServiceEnum$Chan;->value1:I

    # Сравниваем масштаб канала с сохраненным и если он не изменился, то выходим
    iget-object v2, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->chanScale:[J
    aget-wide v4, v2, v1
    cmp-long v4, p2, v4
    if-eqz v4, :cond_0

    # Сохраняем масштаб канала в локальном поле
    aput-wide p2, v2, v1    # Сохраняем масштаб канала p2 в массив chanScale v2 по индексу v1

    # Устанавливаем строковое значение в TextView
    invoke-virtual {v0, v1, p1}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setVxValue(ILjava/lang/String;)V

    :cond_0
    return-void
.end method


.method public static onChangedTriggerMode(Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerMode
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerMode:Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerMode == triggerMode: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerMode
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerMode:Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerVideoPolarity(Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerVideoPolarity
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerVideoPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerVideoPolarity == triggerVideoPolarity: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerVideoPolarity
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerVideoPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerRuntPolarity(Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerPulsePolarity2
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerRuntPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerRuntPolarity == triggerRuntPolarity: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerPulsePolarity2
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerRuntPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerPolarity(Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerPolarity
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerPolarity == triggerPolarity: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerPolarity
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerSHEvent(Lcom/rigol/scope/cil/ServiceEnum$SHEvent;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerSHEvent
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSHEvent:Lcom/rigol/scope/cil/ServiceEnum$SHEvent;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$SHEvent;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$SHEvent;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerSHEvent == triggerSHEvent: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$SHEvent;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerSHEvent
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSHEvent:Lcom/rigol/scope/cil/ServiceEnum$SHEvent;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerEdgeSlope(Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerEdgeSlope
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerEdgeSlope == triggerEdgeSlope: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerEdgeSlope
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerSlope(Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerSlope
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerSlope == triggerSlope: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerSlope
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerTimeoutSlope(Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerTimeoutSlope
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerTimeoutSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerTimeoutSlope == triggerTimeoutSlope: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerTimeoutSlope
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerTimeoutSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerOverSlope(Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerOverSlope
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerOverSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerOverSlope == triggerOverSlope: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerOverSlope
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerOverSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerSetupHoldSlope(Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerSetupHoldSlope
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSetupHoldSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerSetupHoldSlope == triggerSetupHoldSlope: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerSetupHoldSlope
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSetupHoldSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerEdgeSlopeA(Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerEdgeSlopeA
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlopeA:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerEdgeSlopeA == triggerEdgeSlopeA: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerEdgeSlopeA
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlopeA:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerNthSlope(Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerNthSlope
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerNthSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerNthSlope == triggerNthSlope: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerNthSlope
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerNthSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerEdgeSlopeB(Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerEdgeSlopeB
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlopeB:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerEdgeSlopeB == triggerEdgeSlopeB: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerEdgeSlopeB
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlopeB:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerOverEvent(Lcom/rigol/scope/cil/ServiceEnum$OverEvent;)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение value1 из поля triggerOverEvent
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerOverEvent:Lcom/rigol/scope/cil/ServiceEnum$OverEvent;
    iget v2, v1, Lcom/rigol/scope/cil/ServiceEnum$OverEvent;->value1:I
    # Сравниваем значение value1 с новым значением p0.value1
    iget v3, p0, Lcom/rigol/scope/cil/ServiceEnum$OverEvent;->value1:I
    if-eq v2, v3, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerOverEvent == triggerOverEvent: "
    iget v2, p0, Lcom/rigol/scope/cil/ServiceEnum$OverEvent;->value1:I
    invoke-static {v1, v2}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerOverEvent
    iput-object p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerOverEvent:Lcom/rigol/scope/cil/ServiceEnum$OverEvent;

    # Устанавливаем иконку триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerIcon()V

    :cond_0
    return-void
.end method

.method public static onChangedTriggerChannel(I)V
    .locals 4

    # Получаем сохраненный экземпляр
    sget-object v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->instance:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    
    # Проверяем что экземпляр существует
    if-eqz v0, :cond_0

    # Проверяем, что элементы уже созданы
    iget-object v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_tc_name:Landroid/widget/TextView;
    if-eqz v1, :cond_0

    # Получаем значение номера канала из поля triggerChannel
    iget v1, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerChannel:I
    # Сравниваем значение номера канала с новым значением p0
    if-eq v1, p0, :cond_0

    const-string v1, "== FullscreenBarFragment setTriggerChannel == triggerChannel: "
    invoke-static {v1, p0}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Устанавливаем новое значение полю triggerChannel
    iput p0, v0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerChannel:I

    # Устанавливаем канал триггера
    invoke-virtual {v0}, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->setTriggerChannelName()V

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

.method public setHScale(Ljava/lang/String;)V
    .locals 1
    
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_hs_value:Landroid/widget/TextView;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_0
    return-void
.end method

.method public setVxStatus(II)V
    .locals 4
    # p1 - номер канала, p2 - статус канала

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

.method public setVxValue(ILjava/lang/String;)V
    .locals 4
    
    # p1 - номер канала, p2 - масштаб канала

    const v0, 0x0
    # Проверяем номер канала
    # Проверяем p1 == 1 - chan1
    const/4 v1, 0x1
    if-ne p1, v1, :cond_1
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v1_value:Landroid/widget/TextView;
    goto :goto_4

    :cond_1
    # Проверяем p1 == 2 - chan2
    const/4 v1, 0x2
    if-ne p1, v1, :cond_2
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v2_value:Landroid/widget/TextView;
    goto :goto_4

    :cond_2
    # Проверяем p1 == 3 - chan3
    const/4 v1, 0x3
    if-ne p1, v1, :cond_3
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v3_value:Landroid/widget/TextView;
    goto :goto_4

    :cond_3
    # Проверяем p1 == 4 - chan4
    const/4 v1, 0x4
    if-ne p1, v1, :cond_0
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_v4_value:Landroid/widget/TextView;

    :goto_4
    if-eqz v0, :cond_0

    # Устанавливаем текст
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_0
    return-void
.end method

.method public setTriggerIcon()V
    .locals 15
    
    # Получаем ссылку на TriggerParam
    iget-object v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerParam:Lcom/rigol/scope/data/TriggerParam;
    if-eqz v0, :cond_0

    # Получаем сохраненные параметры триггера
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerMode:Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;
    iget-object v2, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerVideoPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iget-object v3, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerRuntPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iget-object v4, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSHEvent:Lcom/rigol/scope/cil/ServiceEnum$SHEvent;
    iget-object v5, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget-object v6, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget-object v7, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerTimeoutSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget-object v8, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerOverSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget-object v9, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerOverEvent:Lcom/rigol/scope/cil/ServiceEnum$OverEvent;
    iget-object v10, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerSetupHoldSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget-object v11, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlopeA:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget-object v12, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerPolarity:Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;
    iget-object v13, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerNthSlope:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    iget-object v14, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerEdgeSlopeB:Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;
    
    # Получаем id изображения
    invoke-virtual/range {v0 .. v14}, Lcom/rigol/scope/data/TriggerParam;->getTriggerViewDisplay(Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;Lcom/rigol/scope/cil/ServiceEnum$SHEvent;Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;Lcom/rigol/scope/cil/ServiceEnum$OverEvent;Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;Lcom/rigol/scope/cil/ServiceEnum$TriggerPulsePolarity;Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;Lcom/rigol/scope/cil/ServiceEnum$EdgeSlope;)I
    move-result v0

# change changed
    const-string v2, "== TriggerParam setTriggerIcon == id: "
    invoke-static {v2, v0}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V
# /change changed

    # Устанавливаем иконку
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_t_icon:Landroid/widget/ImageView;
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    :cond_0
    return-void
.end method

.method public setTriggerChannelName()V 
    .locals 5
    
    # Получаем значение номера канала из поля triggerChannel
    .line 2000
    iget v0, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->triggerChannel:I

    # Получаем контекст
    .line 2020
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_tc_name:Landroid/widget/TextView;
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v3

    # Проверяем номер канала
    # Проверяем v0 == 1 - chan1
    .line 2030
    const/4 v1, 0x1
    if-ne v0, v1, :cond_1
    .line 2040
    const-string v0, "C1"
    # Получаем цвет для канала 1
    .line 2050
    sget-object v1, Lcom/rigol/scope/cil/ServiceEnum$Chan;->chan1:Lcom/rigol/scope/cil/ServiceEnum$Chan;
    .line 2060
    invoke-static {v3, v1}, Lcom/rigol/scope/utilities/ColorUtil;->getColor(Landroid/content/Context;Lcom/rigol/scope/cil/ServiceEnum$Chan;)I
    move-result v1
    .line 2070
    goto :goto_4

    :cond_1
    # Проверяем v0 == 2 - chan2
    .line 2080
    const/4 v1, 0x2
    if-ne v0, v1, :cond_2
    .line 2090
    const-string v0, "C2"
    # Получаем цвет для канала 2
    .line 2100
    sget-object v1, Lcom/rigol/scope/cil/ServiceEnum$Chan;->chan2:Lcom/rigol/scope/cil/ServiceEnum$Chan;
    .line 2110
    invoke-static {v3, v1}, Lcom/rigol/scope/utilities/ColorUtil;->getColor(Landroid/content/Context;Lcom/rigol/scope/cil/ServiceEnum$Chan;)I
    move-result v1
    .line 2120
    goto :goto_4

    :cond_2
    # Проверяем v0 == 3 - chan3
    .line 2130
    const/4 v1, 0x3
    if-ne v0, v1, :cond_3
    .line 2140
    const-string v0, "C3"
    # Получаем цвет для канала 3
    .line 2150
    sget-object v1, Lcom/rigol/scope/cil/ServiceEnum$Chan;->chan3:Lcom/rigol/scope/cil/ServiceEnum$Chan;
    .line 2160
    invoke-static {v3, v1}, Lcom/rigol/scope/utilities/ColorUtil;->getColor(Landroid/content/Context;Lcom/rigol/scope/cil/ServiceEnum$Chan;)I
    move-result v1
    .line 2170
    goto :goto_4

    :cond_3
    # Проверяем v0 == 4 - chan4
    .line 2180
    const/4 v1, 0x4
    if-ne v0, v1, :cond_0
    .line 2190
    const-string v0, "C4"
    # Получаем цвет для канала 4
    .line 2200
    sget-object v1, Lcom/rigol/scope/cil/ServiceEnum$Chan;->chan4:Lcom/rigol/scope/cil/ServiceEnum$Chan;
    .line 2210
    invoke-static {v3, v1}, Lcom/rigol/scope/utilities/ColorUtil;->getColor(Landroid/content/Context;Lcom/rigol/scope/cil/ServiceEnum$Chan;)I
    move-result v1

    :goto_4
    # Логируем имя канала
    .line 2220
    const-string v4, "== FullscreenBarFragment setTriggerChannelName == name: "
    invoke-static {v4, v0}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;Ljava/lang/String;)V
    # Логируем цвет
    .line 2230
    const-string v4, "== FullscreenBarFragment setTriggerChannelName == color: "
    invoke-static {v4, v1}, Lcom/rigol/scope/App;->axxxLogOut(Ljava/lang/String;I)V

    # Получаем ссылку на TextView
    .line 2240
    iget-object v2, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment;->fsb_tc_name:Landroid/widget/TextView;

    # Устанавливаем текст
    .line 2250
    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    # Устанавливаем цвет
    .line 2260
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setTextColor(I)V

    :cond_0
    return-void
.end method


# /change added
