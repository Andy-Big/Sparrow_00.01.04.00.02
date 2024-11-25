package com.rigol.scope.utilities;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
/* loaded from: classes2.dex */
public class ColorUtil {
    public static int getColor(Context context, ServiceEnum.Chan chan) {
        int identifier;
        if (chan == null || TextUtils.isEmpty(chan.value2) || (identifier = ContextUtil.getIdentifier(context, chan.value2, "color")) == 0) {
            return -1;
        }
        return ContextCompat.getColor(context, identifier);
    }

    public static int getColor(Context context, int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 11) {
                            if (i != 28) {
                                if (i != 50) {
                                    if (i != 60) {
                                        if (i != 63) {
                                            if (i != 71) {
                                                switch (i) {
                                                    case 17:
                                                        return ContextCompat.getColor(context, R.color.math1);
                                                    case 18:
                                                        return ContextCompat.getColor(context, R.color.math2);
                                                    case 19:
                                                        return ContextCompat.getColor(context, R.color.math3);
                                                    case 20:
                                                        return ContextCompat.getColor(context, R.color.math4);
                                                    default:
                                                        switch (i) {
                                                            case 42:
                                                                return ContextCompat.getColor(context, R.color.decode1);
                                                            case 43:
                                                                return ContextCompat.getColor(context, R.color.decode2);
                                                            case 44:
                                                                return ContextCompat.getColor(context, R.color.decode3);
                                                            case 45:
                                                                return ContextCompat.getColor(context, R.color.decode4);
                                                            default:
                                                                return -1;
                                                        }
                                                }
                                            }
                                            return ContextCompat.getColor(context, R.color.white);
                                        }
                                        return ContextCompat.getColor(context, R.color.orange_red);
                                    }
                                    return ContextCompat.getColor(context, R.color.dx);
                                }
                                return ContextCompat.getColor(context, R.color.rtsa);
                            }
                            return ContextCompat.getColor(context, R.color.histogram);
                        }
                        return ContextCompat.getColor(context, R.color.dx);
                    }
                    return ContextCompat.getColor(context, R.color.chan4);
                }
                return ContextCompat.getColor(context, R.color.chan3);
            }
            return ContextCompat.getColor(context, R.color.chan2);
        }
        return ContextCompat.getColor(context, R.color.chan1);
    }

    public static int getColorDoedCode(Context context, int i) {
        if (i != 0) {
            if (i == 1) {
                return ContextCompat.getColor(context, R.color.chan1);
            }
            if (i == 2) {
                return ContextCompat.getColor(context, R.color.chan2);
            }
            if (i == 3) {
                return ContextCompat.getColor(context, R.color.chan3);
            }
            if (i == 4) {
                return ContextCompat.getColor(context, R.color.chan4);
            }
            if (i != 33) {
                return ContextCompat.getColor(context, R.color.dx);
            }
        }
        return ContextCompat.getColor(context, R.color.white);
    }

    public static int getColor(Context context, ServiceEnum.enChanStatus enchanstatus) {
        if (enchanstatus == ServiceEnum.enChanStatus.CHAN_OFF) {
            return context.getColor(R.color.gray_regent);
        }
        return context.getColor(R.color.white);
    }

    public static void setChanColor(View view, ServiceEnum.Chan chan) {
        if (chan != null) {
            ((TextView) view).setTextColor(getColor(view.getContext(), chan));
        }
    }
}
