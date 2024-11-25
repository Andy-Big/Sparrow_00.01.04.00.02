package kotlinx.android.parcel;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Repeatable;
import kotlinx.android.parcel.Parceler;
/* compiled from: TypeParceler.kt */
@Target({ElementType.TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0010\b\u0001\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u00032\u00020\u0004B\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/android/parcel/TypeParceler;", ExifInterface.GPS_DIRECTION_TRUE, "P", "Lkotlinx/android/parcel/Parceler;", "", "kotlin-android-extensions-runtime"}, k = 1, mv = {1, 1, 16})
@Repeatable
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface TypeParceler<T, P extends Parceler<? super T>> {
}
