.class Lcom/rigol/scope/adapters/UpaQualityAdapter$4;
.super Ljava/lang/Object;
.source "UpaQualityAdapter.java"

# interfaces
.implements Lcom/rigol/scope/views/keyboard/KeyboardListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/rigol/scope/adapters/UpaQualityAdapter;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/rigol/scope/adapters/UpaQualityAdapter;


# direct methods
.method constructor <init>(Lcom/rigol/scope/adapters/UpaQualityAdapter;)V
    .locals 0

    .line 280
    iput-object p1, p0, Lcom/rigol/scope/adapters/UpaQualityAdapter$4;->this$0:Lcom/rigol/scope/adapters/UpaQualityAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCall(Lcom/rigol/scope/views/keyboard/KeyboardPopupView;)V
    .locals 1

    .line 288
    iget-object v0, p0, Lcom/rigol/scope/adapters/UpaQualityAdapter$4;->this$0:Lcom/rigol/scope/adapters/UpaQualityAdapter;

    invoke-static {v0, p1}, Lcom/rigol/scope/adapters/UpaQualityAdapter;->access$102(Lcom/rigol/scope/adapters/UpaQualityAdapter;Lcom/rigol/scope/views/keyboard/KeyboardPopupView;)Lcom/rigol/scope/views/keyboard/KeyboardPopupView;

    return-void
.end method

.method public resultMinUnitValueListener(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)V"
        }
    .end annotation

    .line 283
    iget-object v0, p0, Lcom/rigol/scope/adapters/UpaQualityAdapter$4;->this$0:Lcom/rigol/scope/adapters/UpaQualityAdapter;

    iget-object v0, v0, Lcom/rigol/scope/adapters/UpaQualityAdapter;->param:Lcom/rigol/scope/data/UpaParam;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    invoke-virtual {v0, p1}, Lcom/rigol/scope/data/UpaParam;->saveRefPctMidLow(I)V

    return-void
.end method
