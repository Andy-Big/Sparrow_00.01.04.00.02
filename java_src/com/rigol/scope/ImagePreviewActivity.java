package com.rigol.scope;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.FileUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Key;
import com.rigol.scope.databinding.ActivityImagePreviewBinding;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class ImagePreviewActivity extends BaseActivity {
    public static final String IMAGE_FILE_PATH = "image_file_path";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityImagePreviewBinding inflate = ActivityImagePreviewBinding.inflate(getLayoutInflater());
        setContentView(inflate.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            final String stringExtra = intent.getStringExtra(IMAGE_FILE_PATH);
            Glide.with((FragmentActivity) this).load(stringExtra).signature(new Key() { // from class: com.rigol.scope.-$$Lambda$ImagePreviewActivity$chuMVav4Y1iyNPiT4fHOEFtTsNc
                @Override // com.bumptech.glide.load.Key
                public final void updateDiskCacheKey(MessageDigest messageDigest) {
                    messageDigest.update(String.valueOf(FileUtils.getFileLastModified(stringExtra)).getBytes());
                }
            }).into(inflate.image);
        }
    }

    @Override // com.rigol.scope.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            finish();
        }
        return true;
    }

    @Override // com.rigol.scope.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        finish();
        return true;
    }
}
