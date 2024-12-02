package com.rigol.scope.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseProperty.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0002\u0010\u000fJ\u001c\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0,2\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\fH\u0016J\u001d\u00101\u001a\u00020*2\u0006\u00102\u001a\u00028\u00002\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J\b\u00105\u001a\u00020*H\u0016J\b\u00106\u001a\u00020*H\u0016J\u0006\u00107\u001a\u00020*J\u0013\u00108\u001a\u00020*2\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010(J\u001f\u00108\u001a\u00020*2\u0006\u0010%\u001a\u00028\u00002\n\u00109\u001a\u0006\u0012\u0002\b\u00030:¢\u0006\u0002\u0010;J\u0014\u0010<\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0,R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R(\u0010%\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u00008G@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010(¨\u0006="}, d2 = {"Lcom/rigol/scope/data/BaseProperty;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/databinding/BaseObservable;", "serviceID", "", "messageID", "default", "attr", "Lcom/rigol/scope/cil/MessageAttr;", "logPrefix", "", "readable", "", "resetable", "syncable", "(IILjava/lang/Object;Lcom/rigol/scope/cil/MessageAttr;Ljava/lang/String;ZZZ)V", "getAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "setAttr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "getDefault", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLogPrefix", "()Ljava/lang/String;", "getMessageID", "()I", "observer", "Landroidx/lifecycle/Observer;", "getObserver", "()Landroidx/lifecycle/Observer;", "getReadable", "()Z", "getResetable", "getServiceID", "getSyncable", "origin", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "bind", "", "liveData", "Landroidx/lifecycle/LiveData;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onChanged", "state", "onSet", "old", "new", "(Ljava/lang/Object;Ljava/lang/Object;)V", "read", "readAttr", "reset", "save", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)V", "unbind", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class BaseProperty<T> extends BaseObservable {
    private MessageAttr attr;

    /* renamed from: default  reason: not valid java name */
    private final T f2default;
    private final String logPrefix;
    private final int messageID;
    private final Observer<Boolean> observer;
    private final boolean readable;
    private final boolean resetable;
    private final int serviceID;
    private final boolean syncable;
    private T value;

    public void onSet(T t, T t2) {
    }

    public final int getServiceID() {
        return this.serviceID;
    }

    public final int getMessageID() {
        return this.messageID;
    }

    public final T getDefault() {
        return this.f2default;
    }

    public /* synthetic */ BaseProperty(int i, int i2, Object obj, MessageAttr messageAttr, String str, boolean z, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, obj, (i3 & 8) != 0 ? null : messageAttr, (i3 & 16) != 0 ? "" : str, (i3 & 32) != 0 ? true : z, (i3 & 64) != 0 ? true : z2, (i3 & 128) != 0 ? false : z3);
    }

    public final MessageAttr getAttr() {
        return this.attr;
    }

    public final void setAttr(MessageAttr messageAttr) {
        this.attr = messageAttr;
    }

    public final String getLogPrefix() {
        return this.logPrefix;
    }

    public final boolean getReadable() {
        return this.readable;
    }

    public final boolean getResetable() {
        return this.resetable;
    }

    public final boolean getSyncable() {
        return this.syncable;
    }

    public BaseProperty(int i, int i2, T t, MessageAttr messageAttr, String logPrefix, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(logPrefix, "logPrefix");
        this.serviceID = i;
        this.messageID = i2;
        this.f2default = t;
        this.attr = messageAttr;
        this.logPrefix = logPrefix;
        this.readable = z;
        this.resetable = z2;
        this.syncable = z3;
        this.value = t;
        this.observer = new Observer<Boolean>() { // from class: com.rigol.scope.data.BaseProperty$observer$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean t2) {
                BaseProperty baseProperty = BaseProperty.this;
                Intrinsics.checkNotNullExpressionValue(t2, "t");
                baseProperty.onChanged(t2.booleanValue());
            }
        };
    }

    @Bindable
    public final T getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setValue(T t) {
        T t2;
        MessageAttr messageAttr = this.attr;
        if (messageAttr != null) {
            if (t instanceof Integer) {
                if (messageAttr.getM_MaxValue() != messageAttr.getM_MinValue()) {
                    Number number = (Number) t;
                    if (number.intValue() < messageAttr.getMinIntValue()) {
                        t2 = Integer.valueOf(messageAttr.getMinIntValue());
                    } else if (number.intValue() > messageAttr.getMaxIntValue()) {
                        t2 = Integer.valueOf(messageAttr.getMaxIntValue());
                    }
                    if (t2 != null) {
                        t = t2;
                    }
                }
                t2 = t;
                if (t2 != null) {
                }
            } else {
                if ((t instanceof Long) && messageAttr.getM_MaxValue() != messageAttr.getM_MinValue()) {
                    Number number2 = (Number) t;
                    if (number2.longValue() < messageAttr.getMinLongValue()) {
                        t2 = Long.valueOf(messageAttr.getMinLongValue());
                    } else if (number2.longValue() > messageAttr.getMaxLongValue()) {
                        t2 = Long.valueOf(messageAttr.getMaxLongValue());
                    }
                    if (t2 != null) {
                    }
                }
                t2 = t;
                if (t2 != null) {
                }
            }
        }
        T t3 = this.value;
        this.value = t;
        onSet(t3, t);
        notifyPropertyChanged(1015);
        if (this.syncable) {
            MessageBus.getInstance().onSyncData(MessageBus.getKey(this.serviceID, this.messageID), t);
        }
    }

    public final Observer<Boolean> getObserver() {
        return this.observer;
    }

    public final void save(T t) {
        setValue(t);
        if (t instanceof String) {
            API api = API.getInstance();
            int i = this.serviceID;
            int i2 = this.messageID;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            api.UI_PostStr(i, i2, (String) t);
        } else if (t instanceof Integer) {
            API api2 = API.getInstance();
            int i3 = this.serviceID;
            int i4 = this.messageID;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            api2.UI_PostInt32(i3, i4, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            API api3 = API.getInstance();
            int i5 = this.serviceID;
            int i6 = this.messageID;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            api3.UI_PostInt64(i5, i6, ((Long) t).longValue());
        } else if (t instanceof Boolean) {
            API api4 = API.getInstance();
            int i7 = this.serviceID;
            int i8 = this.messageID;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            api4.UI_PostBool(i7, i8, ((Boolean) t).booleanValue());
        }
    }

    public final void save(T t, Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        setValue(t);
        if (Intrinsics.areEqual(clazz, String.class)) {
            API api = API.getInstance();
            int i = this.serviceID;
            int i2 = this.messageID;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            api.UI_PostStr(i, i2, (String) t);
        } else if (Intrinsics.areEqual(clazz, Integer.TYPE)) {
            API api2 = API.getInstance();
            int i3 = this.serviceID;
            int i4 = this.messageID;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            api2.UI_PostInt32(i3, i4, ((Integer) t).intValue());
        } else if (Intrinsics.areEqual(clazz, Long.TYPE)) {
            API api3 = API.getInstance();
            int i5 = this.serviceID;
            int i6 = this.messageID;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            api3.UI_PostInt64(i5, i6, ((Long) t).longValue());
        } else if (Intrinsics.areEqual(clazz, Boolean.TYPE)) {
            API api4 = API.getInstance();
            int i7 = this.serviceID;
            int i8 = this.messageID;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            api4.UI_PostBool(i7, i8, ((Boolean) t).booleanValue());
        }
    }

    public void read() {
        T t = this.value;
        if (t instanceof String) {
            setValue(API.getInstance().UI_QueryStr(this.serviceID, this.messageID));
        } else if (t instanceof Integer) {
            setValue(Integer.valueOf(API.getInstance().UI_QueryInt32(this.serviceID, this.messageID)));
        } else if (t instanceof Long) {
            setValue(Long.valueOf(API.getInstance().UI_QueryInt64(this.serviceID, this.messageID)));
        } else if (t instanceof Boolean) {
            setValue(Boolean.valueOf(API.getInstance().UI_QueryBool(this.serviceID, this.messageID)));
        }
    }

    public void readAttr() {
        if (this.attr != null) {
            API.getInstance().UI_QueryAttr(this.serviceID, this.messageID, this.attr);
        }
    }

    public final void reset() {
        setValue(this.f2default);
    }

    public void onChanged(boolean z) {
        read();
    }

    public final void bind(LiveData<Boolean> liveData, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        liveData.observe(lifecycleOwner, this.observer);
    }

    public final void unbind(LiveData<Boolean> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        liveData.removeObserver(this.observer);
    }
}
