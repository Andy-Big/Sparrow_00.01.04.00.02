.class Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "BaseSurfaceView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/rigol/scope/views/baseview/BaseSurfaceView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;


# direct methods
.method constructor <init>(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)V
    .locals 0

    .line 246
    iput-object p1, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onContextClick(Landroid/view/MotionEvent;)Z
    .locals 1

    .line 503
    invoke-super {p0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onContextClick(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1
.end method

.method public onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 2

    .line 463
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v0, :cond_0

    .line 465
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onDoubleTap(Landroid/view/MotionEvent;)Z

    .line 467
    :cond_0
    invoke-super {p0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onDoubleTap(Landroid/view/MotionEvent;)Z

    move-result p1

# change added
# Inform: Обработка двойного нажатия в окне сигналов
    invoke-static {}, Lcom/rigol/scope/utilities/PopupViewManager;->getInstance()Lcom/rigol/scope/utilities/PopupViewManager;
    move-result-object v0
    const-class v1, Lcom/rigol/scope/views/startMenu/StartMenuPopupView;
    invoke-virtual {v0, v1}, Lcom/rigol/scope/utilities/PopupViewManager;->toggle(Ljava/lang/Class;)V
# /change added

    return p1
.end method

.method public onDoubleTapEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .line 483
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v0, :cond_0

    .line 485
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    .line 487
    :cond_0
    invoke-super {p0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1
.end method

.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 4

    .line 262
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v0}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$400(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)[F

    move-result-object v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/4 v2, 0x0

    aput v1, v0, v2

    .line 263
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v0}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$400(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)[F

    move-result-object v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/4 v3, 0x1

    aput v1, v0, v3

    .line 266
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v0, v2}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$502(Lcom/rigol/scope/views/baseview/BaseSurfaceView;I)I

    .line 269
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v0}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$600(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)[F

    move-result-object v0

    const/4 v1, 0x0

    aput v1, v0, v2

    .line 270
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v0}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$600(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)[F

    move-result-object v0

    aput v1, v0, v3

    .line 272
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v0, :cond_0

    .line 274
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onDown(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1

    .line 276
    :cond_0
    invoke-super {p0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onDown(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1

    .line 423
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v0, :cond_0

    .line 425
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result p1

    return p1

    .line 427
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result p1

    return p1
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 1

    .line 396
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-virtual {v0}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->isScaling()Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 400
    :cond_0
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v0, :cond_1

    .line 402
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onLongPress(Landroid/view/MotionEvent;)V

    :cond_1
    return-void
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 5

    .line 335
    invoke-static {p3}, Ljava/lang/Math;->abs(F)F

    move-result v0

    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result v1

    cmpl-float v0, v0, v1

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-lez v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    move v0, v2

    :goto_0
    if-eqz v0, :cond_1

    .line 338
    iget-object v3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v3}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$600(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)[F

    move-result-object v3

    aget v4, v3, v2

    add-float/2addr v4, p3

    aput v4, v3, v2

    goto :goto_1

    .line 343
    :cond_1
    iget-object v3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v3}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$600(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)[F

    move-result-object v3

    aget v4, v3, v1

    add-float/2addr v4, p4

    aput v4, v3, v1

    .line 347
    :goto_1
    iget-object v3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v3}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$508(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)I

    .line 357
    iget-object v3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v3}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$700(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)I

    move-result v3

    if-lez v3, :cond_2

    iget-object v3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v3}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$500(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)I

    move-result v3

    iget-object v4, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {v4}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$700(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)I

    move-result v4

    rem-int/2addr v3, v4

    if-eqz v3, :cond_2

    return v1

    .line 363
    :cond_2
    iget-object v3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v3, v3, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v3, :cond_3

    .line 365
    iget-object v3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v3, v3, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v3, p1, p2, p3, p4}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result p1

    goto :goto_2

    :cond_3
    move p1, v2

    :goto_2
    const/4 p2, 0x0

    if-eqz v0, :cond_4

    .line 372
    iget-object p3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {p3}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$600(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)[F

    move-result-object p3

    aput p2, p3, v2

    goto :goto_3

    .line 377
    :cond_4
    iget-object p3, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    invoke-static {p3}, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->access$600(Lcom/rigol/scope/views/baseview/BaseSurfaceView;)[F

    move-result-object p3

    aput p2, p3, v1

    :goto_3
    return p1
.end method

.method public onShowPress(Landroid/view/MotionEvent;)V
    .locals 1

    .line 291
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v0, :cond_0

    .line 293
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onShowPress(Landroid/view/MotionEvent;)V

    :cond_0
    return-void
.end method

.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 1

    .line 443
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v0, :cond_0

    .line 445
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onSingleTapConfirmed(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1

    .line 447
    :cond_0
    invoke-super {p0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onSingleTapConfirmed(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1
.end method

.method public onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 1

    .line 310
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    if-eqz v0, :cond_0

    .line 312
    iget-object v0, p0, Lcom/rigol/scope/views/baseview/BaseSurfaceView$2;->this$0:Lcom/rigol/scope/views/baseview/BaseSurfaceView;

    iget-object v0, v0, Lcom/rigol/scope/views/baseview/BaseSurfaceView;->gestureListener:Landroid/view/GestureDetector$SimpleOnGestureListener;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onSingleTapUp(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1

    .line 314
    :cond_0
    invoke-super {p0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onSingleTapUp(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1
.end method
