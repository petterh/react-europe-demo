package com.contoso.hostapp1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.contoso.reactnativedemolibrary.ReactNativeDemoLibrary;
import com.facebook.soloader.SoLoader;

/**
 * Activity hosting react-native demo view.
 */
public class ReactActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            SoLoader.init(getApplication(), 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        View view = ReactNativeDemoLibrary.createHelloWorldView(this, false);
        setContentView(view);
    }
}
