package com.contoso.hostapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Activity hosting react-native demo.
 */
public class ReactActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openReactView();
    }

    private void openReactView() {
        Toast.makeText(this, "Open react native activity", Toast.LENGTH_SHORT).show();
//        View view = ReactNativeDemoLibrary.start(this, true);
//        setContentView(view);
    }
}
