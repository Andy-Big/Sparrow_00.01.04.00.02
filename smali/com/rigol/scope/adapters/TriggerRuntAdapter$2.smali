.class Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;
.super Ljava/lang/Object;
.source "TriggerRuntAdapter.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/rigol/scope/adapters/TriggerRuntAdapter;->ShowTriggerRunt()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;


# direct methods
.method constructor <init>(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)V
    .locals 0

    .line 250
    iput-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 4

    if-nez p3, :cond_0

    return-void

    .line 257
    :cond_0
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result p1

    int-to-double p1, p1

    const-wide/high16 v0, 0x4059000000000000L    # 100.0

    div-double/2addr p1, v0

    iget-object p3, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p3}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p3

    invoke-virtual {p3}, Lcom/rigol/scope/data/TriggerParam;->getChanScale()J

    move-result-wide v0

    long-to-double v0, v0

    iget-object p3, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    .line 258
    invoke-static {p3}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p3

    invoke-virtual {p3}, Lcom/rigol/scope/data/TriggerParam;->getScaleNum()I

    move-result p3

    int-to-double v2, p3

    mul-double/2addr v0, v2

    mul-double/2addr p1, v0

    iget-object p3, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p3}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p3

    invoke-virtual {p3}, Lcom/rigol/scope/data/TriggerParam;->getChanOffset()J

    move-result-wide v0

    long-to-double v0, v0

    sub-double/2addr p1, v0

    iget-object p3, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p3}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p3

    invoke-virtual {p3}, Lcom/rigol/scope/data/TriggerParam;->getChanScale()J

    move-result-wide v0

    iget-object p3, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p3}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p3

    invoke-virtual {p3}, Lcom/rigol/scope/data/TriggerParam;->getScaleNum()I

    move-result p3

    int-to-long v2, p3

    mul-long/2addr v0, v2

    const-wide/16 v2, 0x2

    div-long/2addr v0, v2

    long-to-double v0, v0

    sub-double/2addr p1, v0

    double-to-long p1, p1

    .line 260
    iget-object p3, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p3}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p3

    invoke-virtual {p3}, Lcom/rigol/scope/data/TriggerParam;->getRuntTrigger_Level_ID()Lcom/rigol/scope/cil/ServiceEnum$Trigger_Level_ID;

    move-result-object p3

    sget-object v0, Lcom/rigol/scope/cil/ServiceEnum$Trigger_Level_ID;->Trigger_Level_Double:Lcom/rigol/scope/cil/ServiceEnum$Trigger_Level_ID;

    if-ne p3, v0, :cond_1

    .line 261
    iget-object p3, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p3}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p3

    invoke-virtual {p3, p1, p2}, Lcom/rigol/scope/data/TriggerParam;->saveRuntLevelASync(J)V

    goto :goto_0

    .line 263
    :cond_1
    iget-object p3, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p3}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p3

    invoke-virtual {p3, p1, p2}, Lcom/rigol/scope/data/TriggerParam;->saveRuntLevelASync(J)V

    .line 264
    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    const/16 p2, 0x29

    const/16 p3, 0x4fe7

    iget-object v0, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {v0}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object v0

    invoke-virtual {v0}, Lcom/rigol/scope/data/TriggerParam;->getRuntlevelB()J

    move-result-wide v0

    invoke-virtual {p1, p2, p3, v0, v1}, Lcom/rigol/scope/data/TriggerParam;->syncInterfaceData(IIJ)V

    :goto_0
    return-void
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0

    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 6

    .line 275
    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result p1

    int-to-double v0, p1

    const-wide/high16 v2, 0x4059000000000000L    # 100.0

    div-double/2addr v0, v2

    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    invoke-virtual {p1}, Lcom/rigol/scope/data/TriggerParam;->getChanScale()J

    move-result-wide v2

    long-to-double v2, v2

    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    .line 276
    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    invoke-virtual {p1}, Lcom/rigol/scope/data/TriggerParam;->getScaleNum()I

    move-result p1

    int-to-double v4, p1

    mul-double/2addr v2, v4

    mul-double/2addr v0, v2

    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    invoke-virtual {p1}, Lcom/rigol/scope/data/TriggerParam;->getChanOffset()J

    move-result-wide v2

    long-to-double v2, v2

    sub-double/2addr v0, v2

    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    invoke-virtual {p1}, Lcom/rigol/scope/data/TriggerParam;->getChanScale()J

    move-result-wide v2

    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    invoke-virtual {p1}, Lcom/rigol/scope/data/TriggerParam;->getScaleNum()I

    move-result p1

    int-to-long v4, p1

    mul-long/2addr v2, v4

    const-wide/16 v4, 0x2

    div-long/2addr v2, v4

    long-to-double v2, v2

    sub-double/2addr v0, v2

    double-to-long v0, v0

    .line 278
    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    invoke-virtual {p1}, Lcom/rigol/scope/data/TriggerParam;->getRuntTrigger_Level_ID()Lcom/rigol/scope/cil/ServiceEnum$Trigger_Level_ID;

    move-result-object p1

    sget-object v2, Lcom/rigol/scope/cil/ServiceEnum$Trigger_Level_ID;->Trigger_Level_Double:Lcom/rigol/scope/cil/ServiceEnum$Trigger_Level_ID;

    if-ne p1, v2, :cond_0

    .line 279
    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    invoke-virtual {p1, v0, v1}, Lcom/rigol/scope/data/TriggerParam;->saveRuntLevelASync(J)V

    goto :goto_0

    .line 281
    :cond_0
    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    invoke-virtual {p1, v0, v1}, Lcom/rigol/scope/data/TriggerParam;->saveRuntLevelASync(J)V

    .line 282
    iget-object p1, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {p1}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object p1

    const/16 v0, 0x29

    const/16 v1, 0x4fe7

    iget-object v2, p0, Lcom/rigol/scope/adapters/TriggerRuntAdapter$2;->this$0:Lcom/rigol/scope/adapters/TriggerRuntAdapter;

    invoke-static {v2}, Lcom/rigol/scope/adapters/TriggerRuntAdapter;->access$400(Lcom/rigol/scope/adapters/TriggerRuntAdapter;)Lcom/rigol/scope/data/TriggerParam;

    move-result-object v2

    invoke-virtual {v2}, Lcom/rigol/scope/data/TriggerParam;->getRuntlevelB()J

    move-result-wide v2

    invoke-virtual {p1, v0, v1, v2, v3}, Lcom/rigol/scope/data/TriggerParam;->syncInterfaceData(IIJ)V

    :goto_0
    return-void
.end method
