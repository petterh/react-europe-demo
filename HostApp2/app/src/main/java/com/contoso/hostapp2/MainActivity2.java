package com.contoso.hostapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.contoso.reactnativedemolibrary.ReactNativeDemoLibrary;
import com.facebook.soloader.SoLoader;

/**
 * Activity showing a normal Android layout that includes the react-native demo view.
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            SoLoader.init(getApplication(), 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        setContentView(R.layout.activity_main2);
        FrameLayout frame = findViewById(R.id.rn_view);
        View view = ReactNativeDemoLibrary.createHelloWorldView(this, false);
        frame.addView(view);
    }
}
