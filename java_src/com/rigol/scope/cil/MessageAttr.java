package com.rigol.scope.cil;

import android.util.Log;
/* loaded from: classes2.dex */
public class MessageAttr {
    private Object m_CurValue;
    private Object m_DefValue;
    private Object m_MaxValue;
    private Object m_MinValue;
    private long m_StepValue;
    private int m_s32ParamType;

    public MessageAttr() {
        this(1000, 1, 500);
    }

    public MessageAttr(int i, int i2, int i3) {
        this.m_MaxValue = Integer.valueOf(i);
        this.m_MinValue = Integer.valueOf(i2);
        this.m_DefValue = Integer.valueOf(i3);
    }

    public MessageAttr(long j, long j2, long j3) {
        this.m_MaxValue = Long.valueOf(j);
        this.m_MinValue = Long.valueOf(j2);
        this.m_DefValue = Long.valueOf(j3);
    }

    public int getMaxIntValue() {
        return Integer.parseInt(String.valueOf(this.m_MaxValue));
    }

    public long getMaxLongValue() {
        return Long.parseLong(String.valueOf(this.m_MaxValue));
    }

    public double getMaxDoubleValue() {
        return Double.parseDouble(String.valueOf(this.m_MaxValue));
    }

    public int getMinIntValue() {
        return Integer.parseInt(String.valueOf(this.m_MinValue));
    }

    public long getMinLongValue() {
        return Long.parseLong(String.valueOf(this.m_MinValue));
    }

    public double getMinDoubleValue() {
        return Double.parseDouble(String.valueOf(this.m_MinValue));
    }

    public int getDefIntValue() {
        return Integer.parseInt(String.valueOf(this.m_DefValue));
    }

    public long getDefLongValue() {
        Log.d("m_DefValue", "m_DefValue: " + this.m_DefValue);
        return Long.parseLong(String.valueOf(this.m_DefValue));
    }

    public long getDefHighLongValue() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(28, MessageID.MSG_APP_MEAS_TH_DEFAULT_HIGH);
        Log.d("s64DefaultValueHigh", "getDefHighLongValue: " + UI_QueryInt64);
        return Long.parseLong(String.valueOf(UI_QueryInt64));
    }

    public long getDefMidLongValue() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(28, MessageID.MSG_APP_MEAS_TH_DEFAULT_MID);
        Log.d("s64DefaultValueMid", "getDefHighMidValue: " + UI_QueryInt64);
        return Long.parseLong(String.valueOf(UI_QueryInt64));
    }

    public long getDefLowLongValue() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(28, MessageID.MSG_APP_MEAS_TH_DEFAULT_LOW);
        Log.d("s64DefaultValueLow", "getDefLowLongValue: " + UI_QueryInt64);
        return Long.parseLong(String.valueOf(UI_QueryInt64));
    }

    public double getDefDoubleValue() {
        return Double.parseDouble(String.valueOf(this.m_DefValue));
    }

    public void setStepValue(long j) {
        this.m_StepValue = j;
    }

    public long getStepValue() {
        return this.m_StepValue;
    }

    public void setMaxValue(int i) {
        this.m_MaxValue = Integer.valueOf(i);
    }

    public void setMaxValue(long j) {
        this.m_MaxValue = Long.valueOf(j);
    }

    public void setMaxValue(double d) {
        this.m_MaxValue = Double.valueOf(d);
    }

    public void setMinValue(int i) {
        this.m_MinValue = Integer.valueOf(i);
    }

    public void setMinValue(long j) {
        this.m_MinValue = Long.valueOf(j);
    }

    public void setMinValue(double d) {
        this.m_MinValue = Double.valueOf(d);
    }

    public void setDefValue(int i) {
        this.m_DefValue = Integer.valueOf(i);
    }

    public void setDefValue(long j) {
        this.m_DefValue = Long.valueOf(j);
    }

    public void setDefValue(double d) {
        this.m_DefValue = Double.valueOf(d);
    }

    public Object getM_MaxValue() {
        return this.m_MaxValue;
    }

    public Object getM_MinValue() {
        return this.m_MinValue;
    }

    public Object getM_DefValue() {
        return this.m_DefValue;
    }

    public Object getM_CurValue() {
        return this.m_CurValue;
    }

    public String toString() {
        return "MessageAttr{m_MaxValue=" + this.m_MaxValue + ", m_MinValue=" + this.m_MinValue + ", m_DefValue=" + this.m_DefValue + '}';
    }
}
