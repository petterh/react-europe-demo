package com.contoso.hostapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.contoso.reactnativedemolibrary.ReactNativeDemoLibrary;

/**
 * Activity hosting react-native demo view.
 */
public class ReactActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = ReactNativeDemoLibrary.start(this, false);
        setContentView(view);
    }
}
