package com.rigol.scope;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.databinding.ActivityRigolKeyTest3Binding;
import com.rigol.scope.databinding.ActivityRigolKeyTest3BindingImpl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ActivityRigolKeyTest extends SelfTestActivity implements View.OnClickListener {
    private boolean HORIZONTAL_LEVEL_PRESSED;
    private boolean HORIZONTAL_POS_PRESSED;
    private boolean TRIG_PRESSED;
    private boolean VERITICAL_LEVEL_PRESSED;
    private boolean VERITICAL_POS_PRESSED;
    private boolean aLeftFlag;
    private boolean aRightFlag;
    private boolean acquireFlag;
    private ActivityRigolKeyTest3Binding activityRigolKeyTest3BindingImpl;
    private boolean analyseFlag;
    private boolean autoFlag;
    private boolean bLeftFlag;
    private boolean bRightFlag;
    private boolean ch1Flag;
    private int ch1Open;
    private boolean ch2Flag;
    private int ch2Open;
    private boolean ch3Flag;
    private int ch3Open;
    private boolean ch4Flag;
    private int ch4Open;
    private boolean clearFlag;
    private int count;
    private boolean cursorFlag;
    private boolean defaultFlag;
    private boolean forceFlag;
    private boolean g1Flag;
    private boolean g2Flag;
    private boolean horizontalOffsetFlag;
    private boolean horizontalOffsetLeftFlag;
    private boolean horizontalOffsetRightFlag;
    private boolean horizontalScaleFlag;
    private boolean horizontalScaleLeftFlag;
    private boolean horizontalScaleRightFlag;
    private TextView horizontal_Offset;
    private TextView horizontal_Scale;
    private JSONObject jsonObject;
    private boolean kf1pFlag;
    private boolean kf2pFlag;
    private boolean laFlag;
    private boolean mathFlag;
    private boolean measureFlag;
    private boolean quickFlag;
    private boolean recordBackFlag;
    private boolean recordFlag;
    private boolean recordForwardFlag;
    private boolean refFlag;
    private int runStopType;
    private boolean runstopFlag;
    private boolean searchFlag;
    private boolean singleFlag;
    private boolean slopeFlag;
    private int slpoeType;
    private boolean touchlockFlag;
    private boolean triLeftFlag;
    private boolean triRightFlag;
    private boolean triggerFlag;
    private boolean verticalOffsetFlag;
    private boolean verticalOffsetLeftFlag;
    private boolean verticalOffsetRightFlag;
    private boolean verticalScaleFlag;
    private boolean verticalScaleLeftFlag;
    private boolean verticalScaleRightFlag;
    private TextView vertical_Offset;
    private TextView vertical_Scale;
    private boolean zoomFlag;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityRigolKeyTest3Binding inflate = ActivityRigolKeyTest3BindingImpl.inflate(LayoutInflater.from(this));
        this.activityRigolKeyTest3BindingImpl = inflate;
        setContentView(inflate.getRoot());
        this.activityRigolKeyTest3BindingImpl.setOnClickListener(this);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH1_YELLOW.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH2_BLUE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH3_PINK.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH4_DBLU2.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_UP_AND_DOWN_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_UP_AND_DOWN_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G1_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G2_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SINGLE_ORANG.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SINGLE_RED.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.LA_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.INTEN_LED_WHITE.value1, 0);
        this.ch1Open = API.getInstance().UI_QueryBool(1, MessageID.MSG_CHAN_ON_OFF) ? 1 : 0;
        this.ch2Open = API.getInstance().UI_QueryBool(2, MessageID.MSG_CHAN_ON_OFF) ? 1 : 0;
        this.ch3Open = API.getInstance().UI_QueryBool(3, MessageID.MSG_CHAN_ON_OFF) ? 1 : 0;
        this.ch4Open = API.getInstance().UI_QueryBool(4, MessageID.MSG_CHAN_ON_OFF) ? 1 : 0;
        this.runStopType = API.getInstance().UI_QueryInt32(10, MessageID.MSG_HOR_RUN);
        if (API.getInstance().UI_QueryInt32(11, MessageID.MSG_PRODUCT_SERIES) == 800) {
            this.activityRigolKeyTest3BindingImpl.laText.setVisibility(8);
            this.activityRigolKeyTest3BindingImpl.giText.setVisibility(8);
        }
        initJson();
    }

    @Override // com.rigol.scope.SelfTestActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int i2 = i - 1073741824;
        Log.e("szl", "key=" + i2);
        if (i2 == 32) {
            addKeyType("btn_zoom", this.zoomFlag);
        } else {
            switch (i2) {
                case 1:
                    boolean controlForButton = setControlForButton(this.refFlag, this.activityRigolKeyTest3BindingImpl.refText, i2);
                    this.refFlag = controlForButton;
                    addKeyType("btn_ref", controlForButton);
                    break;
                case 2:
                    boolean controlForButton2 = setControlForButton(this.laFlag, this.activityRigolKeyTest3BindingImpl.laText, i2);
                    this.laFlag = controlForButton2;
                    addKeyType("btn_la", controlForButton2);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.LA_LED_WHITE.value1, this.kf1pFlag ? 1 : 0);
                    break;
                case 3:
                    boolean controlForButton3 = setControlForButton(this.g1Flag, this.activityRigolKeyTest3BindingImpl.giText, i2);
                    this.g1Flag = controlForButton3;
                    addKeyType("btn_GI", controlForButton3);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G1_LED_WHITE.value1, this.kf1pFlag ? 1 : 0);
                    break;
                case 4:
                    boolean controlForButton4 = setControlForButton(this.acquireFlag, this.activityRigolKeyTest3BindingImpl.acquireText, i2);
                    this.acquireFlag = controlForButton4;
                    addKeyType("btn_acquire", controlForButton4);
                    break;
                case 5:
                    boolean controlForButton5 = setControlForButton(this.searchFlag, this.activityRigolKeyTest3BindingImpl.searchText, i2);
                    this.searchFlag = controlForButton5;
                    addKeyType("btn_navigate", controlForButton5);
                    break;
                case 6:
                    boolean playStartButton = setPlayStartButton(this.recordForwardFlag, this.activityRigolKeyTest3BindingImpl.playOffsetLeft, i2);
                    this.recordForwardFlag = playStartButton;
                    addKeyType("btn_next", playStartButton);
                    break;
                case 7:
                    boolean playButton = setPlayButton(this.recordFlag, this.activityRigolKeyTest3BindingImpl.playOffset, i2);
                    this.recordFlag = playButton;
                    addKeyType("btn_pause", playButton);
                    break;
                case 8:
                    boolean playEndButton = setPlayEndButton(this.recordBackFlag, this.activityRigolKeyTest3BindingImpl.playOffsetLeft2, i2);
                    this.recordBackFlag = playEndButton;
                    addKeyType("btn_last", playEndButton);
                    break;
                case 9:
                    this.slopeFlag = setControlForButton(this.slopeFlag, this.activityRigolKeyTest3BindingImpl.slopeText, i2);
                    int i3 = this.slpoeType;
                    if (i3 == 0) {
                        this.slpoeType = 1;
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
                    } else if (1 == i3) {
                        this.slpoeType = 2;
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
                    } else {
                        this.slpoeType = 0;
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
                    }
                    addKeyType("btn_slope", this.slopeFlag);
                    break;
                case 10:
                    boolean controlForButton6 = setControlForButton(this.forceFlag, this.activityRigolKeyTest3BindingImpl.forceText, i2);
                    this.forceFlag = controlForButton6;
                    addKeyType("btn_force", controlForButton6);
                    break;
                case 11:
                    boolean controlForButton7 = setControlForButton(this.clearFlag, this.activityRigolKeyTest3BindingImpl.RUN7, i2);
                    this.clearFlag = controlForButton7;
                    addKeyType("btn_clear", controlForButton7);
                    break;
                case 12:
                    this.runstopFlag = setControlForButton(this.runstopFlag, this.activityRigolKeyTest3BindingImpl.RUN6, i2);
                    int i4 = this.runStopType;
                    if (i4 == 0) {
                        this.runStopType = 1;
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.STOP_RED.value1, 1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.RUN_GREEN.value1, 0);
                    } else if (i4 == 1) {
                        this.runStopType = 0;
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.RUN_GREEN.value1, 1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.STOP_RED.value1, 0);
                    }
                    addKeyType("btn_runstop", this.runstopFlag);
                    break;
                case 13:
                    boolean controlForButton8 = setControlForButton(this.autoFlag, this.activityRigolKeyTest3BindingImpl.RUN5, i2);
                    this.autoFlag = controlForButton8;
                    addKeyType("btn_auto", controlForButton8);
                    break;
                case 14:
                    boolean controlForButton9 = setControlForButton(this.singleFlag, this.activityRigolKeyTest3BindingImpl.RUN3, i2);
                    this.singleFlag = controlForButton9;
                    if (controlForButton9) {
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SINGLE_RED.value1, 1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SINGLE_ORANG.value1, 0);
                    } else {
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SINGLE_ORANG.value1, 1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SINGLE_RED.value1, 0);
                    }
                    addKeyType("btn_single", this.singleFlag);
                    break;
                case 15:
                    boolean controlForButton10 = setControlForButton(this.measureFlag, this.activityRigolKeyTest3BindingImpl.RUN, i2);
                    this.measureFlag = controlForButton10;
                    addKeyType("btn_measure", controlForButton10);
                    break;
                case 16:
                    boolean controlForButton11 = setControlForButton(this.cursorFlag, this.activityRigolKeyTest3BindingImpl.RUN1, i2);
                    this.cursorFlag = controlForButton11;
                    addKeyType("btn_cursor", controlForButton11);
                    break;
                case 17:
                    boolean controlForButton12 = setControlForButton(this.defaultFlag, this.activityRigolKeyTest3BindingImpl.RUN4, i2);
                    this.defaultFlag = controlForButton12;
                    addKeyType("btn_default", controlForButton12);
                    break;
                case 18:
                    boolean controlForButton13 = setControlForButton(this.analyseFlag, this.activityRigolKeyTest3BindingImpl.RUN2, i2);
                    this.analyseFlag = controlForButton13;
                    addKeyType("btn_analyse", controlForButton13);
                    break;
                case 19:
                    boolean controlForButton14 = setControlForButton(this.touchlockFlag, this.activityRigolKeyTest3BindingImpl.touchLockText, i2);
                    this.touchlockFlag = controlForButton14;
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, controlForButton14 ? 1 : 0);
                    addKeyType("btn_touchlock", this.touchlockFlag);
                    break;
                case 20:
                    boolean controlForButton15 = setControlForButton(this.quickFlag, this.activityRigolKeyTest3BindingImpl.quickText, i2);
                    this.quickFlag = controlForButton15;
                    addKeyType("btn_quick", controlForButton15);
                    break;
                case 21:
                    boolean controlForButton16 = setControlForButton(this.ch1Flag, this.activityRigolKeyTest3BindingImpl.ch1Text, i2);
                    this.ch1Flag = controlForButton16;
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH1_YELLOW.value1, controlForButton16 ? 1 : 0);
                    addKeyType("btn_ch1", this.ch1Flag);
                    break;
                case 22:
                    boolean controlForButton17 = setControlForButton(this.ch2Flag, this.activityRigolKeyTest3BindingImpl.ch2Text, i2);
                    this.ch2Flag = controlForButton17;
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH2_BLUE.value1, controlForButton17 ? 1 : 0);
                    addKeyType("btn_ch2", this.ch2Flag);
                    break;
                case 23:
                    boolean controlForButton18 = setControlForButton(this.ch3Flag, this.activityRigolKeyTest3BindingImpl.ch3Text, i2);
                    this.ch3Flag = controlForButton18;
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH3_PINK.value1, controlForButton18 ? 1 : 0);
                    addKeyType("btn_ch3", this.ch3Flag);
                    break;
                case 24:
                    boolean controlForButton19 = setControlForButton(this.ch4Flag, this.activityRigolKeyTest3BindingImpl.ch4Text, i2);
                    this.ch4Flag = controlForButton19;
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH4_DBLU2.value1, controlForButton19 ? 1 : 0);
                    addKeyType("btn_ch4", this.ch4Flag);
                    break;
                case 25:
                    boolean controlForButton20 = setControlForButton(this.mathFlag, this.activityRigolKeyTest3BindingImpl.mathText, i2);
                    this.mathFlag = controlForButton20;
                    addKeyType("btn_math", controlForButton20);
                    break;
                case 26:
                    boolean controlForButton21 = setControlForButton(this.triggerFlag, this.activityRigolKeyTest3BindingImpl.triggerText, i2);
                    this.triggerFlag = controlForButton21;
                    addKeyType("btn_trigger", controlForButton21);
                    break;
                default:
                    switch (i2) {
                        case 138:
                            this.horizontalOffsetRightFlag = setRightControl(this.horizontalOffsetRightFlag, this.activityRigolKeyTest3BindingImpl.postionOffsetLeft2, this.activityRigolKeyTest3BindingImpl.postionOffset);
                            addKeyType("knob6", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.postionOffset.getText().toString()));
                            break;
                        case 139:
                            this.horizontalOffsetLeftFlag = setLeftControl(this.horizontalOffsetLeftFlag, this.activityRigolKeyTest3BindingImpl.postionOffsetLeft, this.activityRigolKeyTest3BindingImpl.postionOffset);
                            addKeyType("knob6", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.postionOffset.getText().toString()));
                            break;
                        case 140:
                            boolean controlForButton22 = setControlForButton(this.HORIZONTAL_POS_PRESSED, this.activityRigolKeyTest3BindingImpl.postionOffset, i2);
                            this.HORIZONTAL_POS_PRESSED = controlForButton22;
                            addKeyType("btn_knob6", controlForButton22);
                            break;
                        default:
                            switch (i2) {
                                case 154:
                                    this.verticalOffsetRightFlag = setRightControl(this.verticalOffsetRightFlag, this.activityRigolKeyTest3BindingImpl.ch1OffsetLeft7Text, this.activityRigolKeyTest3BindingImpl.ch3OffsetText);
                                    addKeyType("knob3", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.ch3OffsetText.getText().toString()));
                                    break;
                                case 155:
                                    this.verticalOffsetLeftFlag = setLeftControl(this.verticalOffsetLeftFlag, this.activityRigolKeyTest3BindingImpl.ch1OffsetLeft3Text, this.activityRigolKeyTest3BindingImpl.ch3OffsetText);
                                    addKeyType("knob3", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.ch3OffsetText.getText().toString()));
                                    break;
                                case 156:
                                    boolean controlForButton23 = setControlForButton(this.VERITICAL_POS_PRESSED, this.activityRigolKeyTest3BindingImpl.ch3OffsetText, i2);
                                    this.VERITICAL_POS_PRESSED = controlForButton23;
                                    addKeyType("btn_knob3", controlForButton23);
                                    break;
                                default:
                                    switch (i2) {
                                        case 170:
                                            boolean rightControl = setRightControl(this.bRightFlag, this.activityRigolKeyTest3BindingImpl.ch1OffsetLeft7, this.activityRigolKeyTest3BindingImpl.ch3Offset2);
                                            this.bRightFlag = rightControl;
                                            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_LEFT_AND_RIGHT_LED_WHITE.value1, rightControl ? 1 : 0);
                                            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_UP_AND_DOWN_LED_WHITE.value1, 0);
                                            addKeyType("knob2", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.ch3Offset2.getText().toString()));
                                            break;
                                        case 171:
                                            boolean leftControl = setLeftControl(this.bLeftFlag, this.activityRigolKeyTest3BindingImpl.ch1OffsetLeft3, this.activityRigolKeyTest3BindingImpl.ch3Offset2);
                                            this.bLeftFlag = leftControl;
                                            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_UP_AND_DOWN_LED_WHITE.value1, leftControl ? 1 : 0);
                                            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
                                            addKeyType("knob2", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.ch3Offset2.getText().toString()));
                                            break;
                                        case 172:
                                            boolean controlForButton24 = setControlForButton(this.kf2pFlag, this.activityRigolKeyTest3BindingImpl.ch3Offset2, i2);
                                            this.kf2pFlag = controlForButton24;
                                            addKeyType("btn_knob2", controlForButton24);
                                            break;
                                        default:
                                            switch (i2) {
                                                case 186:
                                                    boolean rightControl2 = setRightControl(this.aRightFlag, this.activityRigolKeyTest3BindingImpl.ch1OffsetLeft2, this.activityRigolKeyTest3BindingImpl.ch3Offset);
                                                    this.aRightFlag = rightControl2;
                                                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_LEFT_AND_RIGHT_LED_WHITE.value1, rightControl2 ? 1 : 0);
                                                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_UP_AND_DOWN_LED_WHITE.value1, 0);
                                                    addKeyType("knob1", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.ch3Offset.getText().toString()));
                                                    break;
                                                case 187:
                                                    boolean leftControl2 = setLeftControl(this.aLeftFlag, this.activityRigolKeyTest3BindingImpl.ch1OffsetLeft, this.activityRigolKeyTest3BindingImpl.ch3Offset);
                                                    this.aLeftFlag = leftControl2;
                                                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_UP_AND_DOWN_LED_WHITE.value1, leftControl2 ? 1 : 0);
                                                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
                                                    addKeyType("knob1", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.ch3Offset.getText().toString()));
                                                    break;
                                                case 188:
                                                    boolean controlForButton25 = setControlForButton(this.kf1pFlag, this.activityRigolKeyTest3BindingImpl.ch3Offset, i2);
                                                    this.kf1pFlag = controlForButton25;
                                                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.INTEN_LED_WHITE.value1, controlForButton25 ? 1 : 0);
                                                    addKeyType("btn_knob1", this.kf1pFlag);
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case 202:
                                                            this.horizontalScaleRightFlag = setRightControl(this.horizontalScaleRightFlag, this.activityRigolKeyTest3BindingImpl.hScaleOffsetLeft2, this.activityRigolKeyTest3BindingImpl.hScaleOffset);
                                                            addKeyType("knob7", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.hScaleOffset.getText().toString()));
                                                            break;
                                                        case 203:
                                                            this.horizontalScaleLeftFlag = setLeftControl(this.horizontalScaleLeftFlag, this.activityRigolKeyTest3BindingImpl.hScaleOffsetLeft, this.activityRigolKeyTest3BindingImpl.hScaleOffset);
                                                            addKeyType("knob7", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.hScaleOffset.getText().toString()));
                                                            break;
                                                        case 204:
                                                            boolean controlForButton26 = setControlForButton(this.HORIZONTAL_LEVEL_PRESSED, this.activityRigolKeyTest3BindingImpl.hScaleOffset, i2);
                                                            this.HORIZONTAL_LEVEL_PRESSED = controlForButton26;
                                                            addKeyType("btn_knob7", controlForButton26);
                                                            break;
                                                        default:
                                                            switch (i2) {
                                                                case 218:
                                                                    this.verticalScaleRightFlag = setRightControl(this.verticalScaleRightFlag, this.activityRigolKeyTest3BindingImpl.ch1ScaleLeft7Text, this.activityRigolKeyTest3BindingImpl.ch3ScaleText);
                                                                    addKeyType("knob4", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.ch3ScaleText.getText().toString()));
                                                                    break;
                                                                case 219:
                                                                    this.verticalScaleLeftFlag = setLeftControl(this.verticalScaleLeftFlag, this.activityRigolKeyTest3BindingImpl.ch1ScaleLeft3Text, this.activityRigolKeyTest3BindingImpl.ch3ScaleText);
                                                                    addKeyType("knob4", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.ch3ScaleText.getText().toString()));
                                                                    break;
                                                                case 220:
                                                                    boolean controlForButton27 = setControlForButton(this.VERITICAL_LEVEL_PRESSED, this.activityRigolKeyTest3BindingImpl.ch3ScaleText, i2);
                                                                    this.VERITICAL_LEVEL_PRESSED = controlForButton27;
                                                                    addKeyType("btn_knob4", controlForButton27);
                                                                    break;
                                                                default:
                                                                    switch (i2) {
                                                                        case 234:
                                                                            this.triRightFlag = setRightControl(this.triRightFlag, this.activityRigolKeyTest3BindingImpl.triggeOffsetLeft2, this.activityRigolKeyTest3BindingImpl.triggerOffset);
                                                                            addKeyType("knob5", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.triggerOffset.getText().toString()));
                                                                            break;
                                                                        case 235:
                                                                            this.triLeftFlag = setLeftControl(this.triLeftFlag, this.activityRigolKeyTest3BindingImpl.triggeOffsetLeft, this.activityRigolKeyTest3BindingImpl.triggerOffset);
                                                                            addKeyType("knob5", Integer.parseInt(this.activityRigolKeyTest3BindingImpl.triggerOffset.getText().toString()));
                                                                            break;
                                                                        case 236:
                                                                            boolean controlForButton28 = setControlForButton(this.TRIG_PRESSED, this.activityRigolKeyTest3BindingImpl.triggerOffset, i2);
                                                                            this.TRIG_PRESSED = controlForButton28;
                                                                            addKeyType("btn_knob5", controlForButton28);
                                                                            break;
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    private boolean ClockwiseOrCounterclockwise(int i) {
        int i2 = i - 1073741824;
        int i3 = i & 255;
        boolean z = false;
        if (i2 == (i3 | 2048)) {
            z = true;
        } else {
            int i4 = i3 | 4096;
        }
        Log.e("szl", "顺时针还是逆时针：" + z);
        return z;
    }

    private boolean setLeftControl(boolean z, ImageButton imageButton, TextView textView) {
        boolean z2 = false;
        this.count = 0;
        if (z) {
            imageButton.setImageResource(R.drawable.unselect_left);
        } else {
            imageButton.setImageResource(R.drawable.select_left);
            z2 = true;
        }
        textView.setText(String.valueOf(Integer.parseInt(textView.getText().toString()) - 1));
        return z2;
    }

    private boolean setRightControl(boolean z, ImageButton imageButton, TextView textView) {
        boolean z2 = false;
        this.count = 0;
        if (z) {
            imageButton.setImageResource(R.drawable.unselect_right);
        } else {
            imageButton.setImageResource(R.drawable.select_right);
            z2 = true;
        }
        textView.setText(String.valueOf(Integer.parseInt(textView.getText().toString()) + 1));
        return z2;
    }

    private boolean setControlForButtonValue(boolean z, TextView textView) {
        this.count = 0;
        textView.setText("0");
        if (z) {
            textView.setBackgroundResource(R.drawable.unselect_circle);
            return false;
        }
        textView.setBackgroundResource(R.drawable.select_circle);
        return true;
    }

    private boolean setControlForButton(boolean z, TextView textView, int i) {
        if (z) {
            textView.setBackgroundResource(R.drawable.unselect);
            return false;
        }
        textView.setBackgroundResource(R.drawable.select);
        return true;
    }

    private boolean setPlayStartButton(boolean z, TextView textView, int i) {
        if (z) {
            textView.setBackgroundResource(R.drawable.record_left_grey);
            return false;
        }
        textView.setBackgroundResource(R.drawable.record_last);
        return true;
    }

    private boolean setPlayEndButton(boolean z, TextView textView, int i) {
        if (z) {
            textView.setBackgroundResource(R.drawable.record_right_grey);
            return false;
        }
        textView.setBackgroundResource(R.drawable.record_next);
        return true;
    }

    private boolean setPlayButton(boolean z, TextView textView, int i) {
        if (z) {
            textView.setBackgroundResource(R.drawable.record_play_grey);
            return false;
        }
        textView.setBackgroundResource(R.drawable.record_play1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH1_YELLOW.value1, this.ch1Open);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH2_BLUE.value1, this.ch2Open);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH3_PINK.value1, this.ch3Open);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH4_DBLU2.value1, this.ch4Open);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.exitText) {
            return;
        }
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH1_YELLOW.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH2_BLUE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH3_PINK.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.CH4_DBLU2.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_UP_AND_DOWN_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_UP_AND_DOWN_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G1_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G2_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SINGLE_ORANG.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SINGLE_RED.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.LA_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.INTEN_LED_WHITE.value1, 0);
        finish();
    }

    private void addKeyType(String str, int i) {
        try {
            this.jsonObject.put(str, i);
            API.getInstance().UI_PostStr(11, MessageID.MSG_APP_UTILITY_KEYBOARD_STATUS, this.jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void addKeyType(String str, boolean z) {
        try {
            this.jsonObject.put(str, z);
            API.getInstance().UI_PostStr(11, MessageID.MSG_APP_UTILITY_KEYBOARD_STATUS, this.jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initJson() {
        JSONObject jSONObject = new JSONObject();
        this.jsonObject = jSONObject;
        try {
            jSONObject.put("btn_measure", false);
            this.jsonObject.put("btn_cursor", false);
            this.jsonObject.put("btn_analyse", false);
            this.jsonObject.put("btn_single", false);
            this.jsonObject.put("btn_auto", false);
            this.jsonObject.put("btn_runstop", false);
            this.jsonObject.put("btn_default", false);
            this.jsonObject.put("btn_clear", false);
            this.jsonObject.put("btn_touchlock", false);
            this.jsonObject.put("btn_quick", false);
            this.jsonObject.put("btn_trigger", false);
            this.jsonObject.put("btn_slope", false);
            this.jsonObject.put("btn_force", false);
            this.jsonObject.put("btn_ch1", false);
            this.jsonObject.put("btn_ch2", false);
            this.jsonObject.put("btn_ch3", false);
            this.jsonObject.put("btn_ch4", false);
            this.jsonObject.put("btn_la", false);
            this.jsonObject.put("btn_g1", false);
            this.jsonObject.put("btn_g2", false);
            this.jsonObject.put("btn_math", false);
            this.jsonObject.put("btn_ref", false);
            this.jsonObject.put("btn_acquire", false);
            this.jsonObject.put("btn_zoom", false);
            this.jsonObject.put("btn_navigate", false);
            this.jsonObject.put("btn_search", false);
            this.jsonObject.put("btn_last", false);
            this.jsonObject.put("btn_pause", false);
            this.jsonObject.put("btn_next", false);
            this.jsonObject.put("btn_knob1", false);
            this.jsonObject.put("btn_knob2", false);
            this.jsonObject.put("btn_knob3", false);
            this.jsonObject.put("btn_knob4", false);
            this.jsonObject.put("btn_knob5", false);
            this.jsonObject.put("btn_knob6", false);
            this.jsonObject.put("btn_knob7", false);
            this.jsonObject.put("knob1", 0);
            this.jsonObject.put("knob2", 0);
            this.jsonObject.put("knob3", 0);
            this.jsonObject.put("knob4", 0);
            this.jsonObject.put("knob5", 0);
            this.jsonObject.put("knob6", 0);
            this.jsonObject.put("knob7", 0);
            API.getInstance().UI_PostStr(11, MessageID.MSG_APP_UTILITY_KEYBOARD_STATUS, this.jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
