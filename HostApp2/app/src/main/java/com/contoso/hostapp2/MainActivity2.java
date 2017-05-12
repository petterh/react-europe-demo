package com.contoso.hostapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.contoso.reactnativedemolibrary.ReactNativeDemoLibrary;

/**
 * Activity showing a normal Android layout that includes the react-native demo view.
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FrameLayout frame = (FrameLayout) findViewById(R.id.rn_view);
        View view = ReactNativeDemoLibrary.createHelloWorldView(this, false);
        frame.addView(view);
    }
}
