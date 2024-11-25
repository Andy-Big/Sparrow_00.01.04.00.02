package com.rigol.scope.data;

import java.util.Objects;
/* loaded from: classes2.dex */
public class SelfTestParam {
    private String item;
    private String range;
    private int result;
    private String value;

    public String getItem() {
        return this.item;
    }

    public void setItem(String str) {
        this.item = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getRange() {
        return this.range;
    }

    public void setRange(String str) {
        this.range = str;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SelfTestParam selfTestParam = (SelfTestParam) obj;
        return this.result == selfTestParam.result && Objects.equals(this.item, selfTestParam.item) && Objects.equals(this.value, selfTestParam.value) && Objects.equals(this.range, selfTestParam.range);
    }

    public int hashCode() {
        return Objects.hash(this.item, this.value, this.range, Integer.valueOf(this.result));
    }

    public String toString() {
        return "SelfTestParam{item='" + this.item + "', value='" + this.value + "', range='" + this.range + "', result=" + this.result + '}';
    }
}
