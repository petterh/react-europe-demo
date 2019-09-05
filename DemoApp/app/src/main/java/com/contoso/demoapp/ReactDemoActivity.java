package com.contoso.demoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.contoso.reactnativedemolibrary.ReactNativeDemoLibrary;
import com.facebook.soloader.SoLoader;

/**
 * Activity hosting React Native demo.
 */
public class ReactDemoActivity extends AppCompatActivity {

    private static final int OVERLAY_PERMISSION_REQ_CODE = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            return;
        }

        try {
            SoLoader.init(getApplication(), 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        openReactView();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "Overlay permission denied", Toast.LENGTH_SHORT).show();
                return;
            }

            openReactView();
        }
    }

    private void openReactView() {
        View view = ReactNativeDemoLibrary.createHelloWorldView(this, true);
        setContentView(view);
    }
}
