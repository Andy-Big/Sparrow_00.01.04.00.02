# Создаем внутренний класс для TouchDelegate (один для всех TextView)
.class Lcom/rigol/scope/myfragment/FullscreenBarFragment$TouchDelegateHelper;
.super Ljava/lang/Object;
.implements Ljava/lang/Runnable;

.field final synthetic this$0:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
.field private final view:Landroid/widget/TextView;

.method constructor <init>(Lcom/rigol/scope/myfragment/FullscreenBarFragment;Landroid/widget/TextView;)V
    .locals 1
    
    iput-object p1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment$TouchDelegateHelper;->this$0:Lcom/rigol/scope/myfragment/FullscreenBarFragment;
    iput-object p2, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment$TouchDelegateHelper;->view:Landroid/widget/TextView;
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public run()V
    .locals 5

    # Создаем Rect для расширенной области касания
    new-instance v0, Landroid/graphics/Rect;
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V
    
    # Получаем текущие границы view
    iget-object v1, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment$TouchDelegateHelper;->view:Landroid/widget/TextView;
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->getHitRect(Landroid/graphics/Rect;)V
    
    # Расширяем область касания на 100dp во все стороны
    const/16 v2, 0x64    # 100dp
    iget v3, v0, Landroid/graphics/Rect;->left:I
    sub-int/2addr v3, v2
    iput v3, v0, Landroid/graphics/Rect;->left:I
    
    iget v3, v0, Landroid/graphics/Rect;->top:I
    sub-int/2addr v3, v2
    iput v3, v0, Landroid/graphics/Rect;->top:I
    
    iget v3, v0, Landroid/graphics/Rect;->right:I
    add-int/2addr v3, v2
    iput v3, v0, Landroid/graphics/Rect;->right:I
    
    iget v3, v0, Landroid/graphics/Rect;->bottom:I
    add-int/2addr v3, v2
    iput v3, v0, Landroid/graphics/Rect;->bottom:I
    
    # Создаем TouchDelegate
    new-instance v3, Landroid/view/TouchDelegate;
    iget-object v4, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment$TouchDelegateHelper;->view:Landroid/widget/TextView;
    invoke-direct {v3, v0, v4}, Landroid/view/TouchDelegate;-><init>(Landroid/graphics/Rect;Landroid/view/View;)V
    
    # Устанавливаем TouchDelegate для родительского view
    iget-object v4, p0, Lcom/rigol/scope/myfragment/FullscreenBarFragment$TouchDelegateHelper;->view:Landroid/widget/TextView;
    invoke-virtual {v4}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;
    move-result-object v4
    check-cast v4, Landroid/view/View;
    invoke-virtual {v4, v3}, Landroid/view/View;->setTouchDelegate(Landroid/view/TouchDelegate;)V

    return-void
.end method