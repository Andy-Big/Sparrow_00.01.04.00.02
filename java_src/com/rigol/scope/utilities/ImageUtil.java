package com.rigol.scope.utilities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.IDisplayManager;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.DisplayInfo;
import android.view.IWindowManager;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.util.ToastUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class ImageUtil {
    private static final int BMP_WIDTH_OF_TIMES = 4;
    private static final int BYTE_PER_PIXEL = 3;

    private static byte[] writeInt(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & ViewCompat.MEASURED_STATE_MASK) >> 24)};
    }

    private static byte[] writeShort(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s & 65280) >> 8)};
    }

    public static Bitmap screenshot(IWindowManager iWindowManager, IDisplayManager iDisplayManager) throws Exception {
        Point currentDisplaySize = getCurrentDisplaySize(iWindowManager, iDisplayManager, false);
        Class<?> cls = Class.forName(Build.VERSION.SDK_INT <= 17 ? "android.view.Surface" : "android.view.SurfaceControl");
        Bitmap bitmap = Build.VERSION.SDK_INT >= 28 ? (Bitmap) cls.getDeclaredMethod("screenshot", Rect.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, new Rect(), Integer.valueOf(currentDisplaySize.x), Integer.valueOf(currentDisplaySize.y), 0) : (Bitmap) cls.getDeclaredMethod("screenshot", Integer.TYPE, Integer.TYPE).invoke(null, Integer.valueOf(currentDisplaySize.x), Integer.valueOf(currentDisplaySize.y));
        int rotation = getRotation(iWindowManager, iDisplayManager);
        if (rotation == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        if (rotation == 1) {
            matrix.postRotate(-90.0f);
        } else if (rotation == 2) {
            matrix.postRotate(-180.0f);
        } else if (rotation == 3) {
            matrix.postRotate(-270.0f);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, currentDisplaySize.x, currentDisplaySize.y, matrix, false);
    }

    public static Point getCurrentDisplaySize(IWindowManager iWindowManager, IDisplayManager iDisplayManager, boolean z) {
        int rotation;
        try {
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 18) {
                iWindowManager.getBaseDisplaySize(0, point);
                try {
                    rotation = iWindowManager.getRotation();
                } catch (Error unused) {
                    rotation = ((Integer) DisplayInfo.class.getDeclaredField(Key.ROTATION).get(iDisplayManager.getDisplayInfo(0))).intValue();
                }
            } else if (Build.VERSION.SDK_INT == 17) {
                DisplayInfo displayInfo = iDisplayManager.getDisplayInfo(0);
                point.x = ((Integer) DisplayInfo.class.getDeclaredField("logicalWidth").get(displayInfo)).intValue();
                point.y = ((Integer) DisplayInfo.class.getDeclaredField("logicalHeight").get(displayInfo)).intValue();
                rotation = ((Integer) DisplayInfo.class.getDeclaredField(Key.ROTATION).get(displayInfo)).intValue();
            } else {
                iWindowManager.getRealDisplaySize(point);
                rotation = iWindowManager.getRotation();
            }
            if (z && (rotation == 1 || rotation == 3)) {
                int i = point.x;
                point.x = point.y;
                point.y = i;
            }
            return point;
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static int getRotation(IWindowManager iWindowManager, IDisplayManager iDisplayManager) throws RemoteException, NoSuchFieldException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                return iWindowManager.getRotation();
            } catch (Error unused) {
                return ((Integer) DisplayInfo.class.getDeclaredField(Key.ROTATION).get(iDisplayManager.getDisplayInfo(0))).intValue();
            }
        } else if (Build.VERSION.SDK_INT != 17) {
            return iWindowManager.getRotation();
        } else {
            return ((Integer) DisplayInfo.class.getDeclaredField(Key.ROTATION).get(iDisplayManager.getDisplayInfo(0))).intValue();
        }
    }

    public static boolean save(Bitmap bitmap, String str) {
        String upperCase = str.toUpperCase();
        if (upperCase.endsWith(Bitmap.CompressFormat.PNG.name())) {
            return saveImg(bitmap, str, Bitmap.CompressFormat.PNG);
        }
        if (upperCase.endsWith(Bitmap.CompressFormat.JPEG.name()) || upperCase.endsWith("JPG")) {
            return saveImg(bitmap, str, Bitmap.CompressFormat.JPEG);
        }
        if (upperCase.endsWith("BMP")) {
            try {
                return saveBMP(bitmap, str);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private static boolean saveImg(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (bitmap == 0 || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            Log.e("YYY", "bitmap is empty.");
            return false;
        } else if (bitmap.isRecycled()) {
            Log.e("YYY", "bitmap is recycled.");
            return false;
        } else {
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                Log.e("YYY", "create or delete file <" + file + "> failed.");
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        fileOutputStream2 = 100;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                z = bitmap.compress(compressFormat, 100, fileOutputStream);
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
            } catch (IOException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                    fileOutputStream2 = fileOutputStream2;
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            return z;
        }
    }

    private static boolean saveBMP(Bitmap bitmap, String str) throws IOException {
        boolean z;
        byte[] bArr;
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null || str == null) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * 3;
        int i2 = i % 4;
        if (i2 > 0) {
            byte[] bArr2 = new byte[4 - i2];
            Arrays.fill(bArr2, (byte) -1);
            bArr = bArr2;
            z = true;
        } else {
            z = false;
            bArr = null;
        }
        int i3 = width * height;
        int[] iArr = new int[i3];
        int length = (i + (z ? bArr.length : 0)) * height;
        int i4 = length + 54;
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        ByteBuffer allocate = ByteBuffer.allocate(i4);
        allocate.put((byte) 66);
        allocate.put((byte) 77);
        allocate.put(writeInt(i4));
        allocate.put(writeShort((short) 0));
        allocate.put(writeShort((short) 0));
        allocate.put(writeInt(54));
        allocate.put(writeInt(40));
        allocate.put(writeInt(((z && bArr.length == 3) ? 1 : 0) + width));
        allocate.put(writeInt(height));
        allocate.put(writeShort((short) 1));
        allocate.put(writeShort((short) 24));
        allocate.put(writeInt(0));
        allocate.put(writeInt(length));
        allocate.put(writeInt(0));
        allocate.put(writeInt(0));
        allocate.put(writeInt(0));
        allocate.put(writeInt(0));
        int i5 = (height - 1) * width;
        int i6 = i3;
        while (height > 0) {
            for (int i7 = i5; i7 < i6; i7++) {
                allocate.put((byte) (iArr[i7] & 255));
                allocate.put((byte) ((iArr[i7] & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8));
                allocate.put((byte) ((iArr[i7] & 16711680) >> 16));
            }
            if (z) {
                allocate.put(bArr);
            }
            height--;
            int i8 = i5;
            i5 -= width;
            i6 = i8;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        fileOutputStream.write(allocate.array());
        fileOutputStream.getFD().sync();
        fileOutputStream.close();
        Log.v("AndroidBmpUtil", (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return true;
    }

    public static Bitmap createInvertedBitmap(Bitmap bitmap) {
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static void save(final StorageSaveParam storageSaveParam) {
        if (storageSaveParam == null) {
            return;
        }
        ToastUtils.INSTANCE.cancel();
        final ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(storageSaveParam.getFileType());
        final String fileName = storageSaveParam.getFileName();
        final String pathName = storageSaveParam.getPathName();
        ThreadUtils.getIoPool().submit(new Runnable() { // from class: com.rigol.scope.utilities.-$$Lambda$ImageUtil$8Wko3v_zXWPEDxPu8nMO4ZDWVKc
            @Override // java.lang.Runnable
            public final void run() {
                ImageUtil.lambda$save$0(StorageSaveParam.this, enfiletype, fileName, pathName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$save$0(StorageSaveParam storageSaveParam, ServiceEnum.enFileType enfiletype, String str, String str2) {
        UtilityViewModel utilityViewModel;
        UtilityParam value;
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Bitmap screenshot = screenshot(SystemUtil.getWindowManager(), SystemUtil.getDisplayManager());
            if (storageSaveParam.isImageColor()) {
                screenshot = ImageUtils.toGray(screenshot);
            }
            if (storageSaveParam.isImageInvert()) {
                screenshot = createInvertedBitmap(screenshot);
            }
            if (storageSaveParam.isImageHeader() && (utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)) != null && (value = utilityViewModel.getLiveData().getValue()) != null) {
                screenshot = ImageUtils.addTextWatermark(screenshot, value.getModel() + " ", 30, -1, 10.0f, 42.0f);
            }
            if (screenshot != null) {
                if (enfiletype != null && !TextUtils.isEmpty(str)) {
                    String str3 = str2 + File.separator + str;
                    Log.i("YYY", "start ImageUtil.save " + str3);
                    boolean save = save(screenshot, str3);
                    Log.i("YYY", "end ImageUtil.save " + str3);
                    if (save) {
                        ToastUtils.showLong(ActivityUtils.getTopActivity().getString(R.string.msg_storage_toast_save_success) + ViewUtil.getDiskUIPathName(str3));
                    }
                }
                screenshot.recycle();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void masksave(final StorageSaveParam storageSaveParam) {
        if (storageSaveParam == null) {
            return;
        }
        PopupViewManager.getInstance().dismissAll(new Class[0]);
        final ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(storageSaveParam.getFileType());
        final String fileName = storageSaveParam.getFileName();
        final String pathName = storageSaveParam.getPathName();
        ThreadUtils.getIoPool().submit(new Runnable() { // from class: com.rigol.scope.utilities.-$$Lambda$ImageUtil$RQSNWtFOwQWJpKLeAgGYpb0CU9c
            @Override // java.lang.Runnable
            public final void run() {
                ImageUtil.lambda$masksave$1(StorageSaveParam.this, enfiletype, fileName, pathName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$masksave$1(StorageSaveParam storageSaveParam, ServiceEnum.enFileType enfiletype, String str, String str2) {
        UtilityViewModel utilityViewModel;
        UtilityParam value;
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Bitmap screenshot = screenshot(SystemUtil.getWindowManager(), SystemUtil.getDisplayManager());
            if (storageSaveParam.isImageColor()) {
                screenshot = ImageUtils.toGray(screenshot);
            }
            if (storageSaveParam.isImageInvert()) {
                screenshot = createInvertedBitmap(screenshot);
            }
            if (storageSaveParam.isImageHeader() && (utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)) != null && (value = utilityViewModel.getLiveData().getValue()) != null) {
                screenshot = ImageUtils.addTextWatermark(screenshot, value.getModel() + " ", 30, -1, 10.0f, 42.0f);
            }
            if (screenshot == null || enfiletype == null || TextUtils.isEmpty(str)) {
                return;
            }
            save(screenshot, str2 + File.separator + str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
