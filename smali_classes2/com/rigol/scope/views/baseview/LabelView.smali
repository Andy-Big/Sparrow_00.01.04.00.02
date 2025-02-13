.class public Lcom/rigol/scope/views/baseview/LabelView;
.super Landroidx/appcompat/widget/AppCompatTextView;
.source "LabelView.kt"


# Inform: подготовка и отрисовка меток каналов



# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000c"
    }
    d2 = {
        "Lcom/rigol/scope/views/baseview/LabelView;",
        "Landroidx/appcompat/widget/AppCompatTextView;",
        "context",
        "Landroid/content/Context;",
        "attrs",
        "Landroid/util/AttributeSet;",
        "(Landroid/content/Context;Landroid/util/AttributeSet;)V",
        "setPosition",
        "",
        "x",
        "",
        "y",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x4,
        0x1
    }
.end annotation



# change added
.field private isDrawing:Z
# /change



# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 36
    invoke-direct {p0, p1, p2}, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V


# change added
    const/4 v0, 0x0
    iput-boolean v0, p0, Lcom/rigol/scope/views/baseview/LabelView;->isDrawing:Z
# /change


    .line 52
    invoke-static {}, Landroid/view/View;->generateViewId()I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/rigol/scope/views/baseview/LabelView;->setId(I)V

    const/high16 p1, 0x41900000    # 18.0f

    .line 55
    invoke-virtual {p0, p1}, Lcom/rigol/scope/views/baseview/LabelView;->setTextSize(F)V

    const/16 p1, 0x10

    .line 58
    invoke-virtual {p0, p1}, Lcom/rigol/scope/views/baseview/LabelView;->setGravity(I)V

    const/high16 p1, 0x3f800000    # 1.0f

    const/high16 p2, -0x1000000

    .line 61

# change removed
    #invoke-virtual {p0, p1, p1, p1, p2}, Lcom/rigol/scope/views/baseview/LabelView;->setShadowLayer(FFFI)V
# /change

    return-void
.end method


# virtual methods
.method public final setPosition(II)V
    .locals 2

    .line 40
    invoke-virtual {p0}, Lcom/rigol/scope/views/baseview/LabelView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 41
    instance-of v1, v0, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    if-eqz v1, :cond_0

    .line 43
    move-object v1, v0

    check-cast v1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    iput p2, v1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topMargin:I

    .line 44
    iput p1, v1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startMargin:I

    .line 45
    invoke-virtual {p0, v0}, Lcom/rigol/scope/views/baseview/LabelView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    :cond_0
    return-void
.end method



# change added
.method protected invalidate()V
    .locals 1

    iget-boolean v0, p0, Lcom/rigol/scope/views/baseview/LabelView;->isDrawing:Z
    if-eqz v0, :cond_0
    return-void
    :cond_0
    invoke-super {p0}, Landroid/view/View;->invalidate()V
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3

    const/4 v0, 0x1
    iput-boolean v0, p0, Lcom/rigol/scope/views/baseview/LabelView;->isDrawing:Z

    # save original color
    invoke-virtual {p0}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;
    move-result-object v0
    invoke-virtual {v0}, Landroid/content/res/ColorStateList;->getDefaultColor()I
    move-result v0
    # set black color
    const v1, 0xaf000000
    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    invoke-virtual {p0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;
    move-result-object v1

    # set stroke width
    const/high16 v2, 0x41000000    # 8.0f
    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V
    # set stroke style
    sget-object v2, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;
    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    # paint stroked text
    invoke-super {p0, p1}, Landroid/widget/TextView;->onDraw(Landroid/graphics/Canvas;)V
    # reset stroke width
    const/high16 v2, 0x0    # 0.0f
    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V
    # reset stroke style
    sget-object v2, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;
    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    # set original color
    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setTextColor(I)V

    const/4 v0, 0x0
    iput-boolean v0, p0, Lcom/rigol/scope/views/baseview/LabelView;->isDrawing:Z
    # paint normal text
    invoke-super {p0, p1}, Landroid/widget/TextView;->onDraw(Landroid/graphics/Canvas;)V

    return-void
.end method
# /change