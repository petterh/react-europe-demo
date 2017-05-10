package com.contoso.reactnativedemolibrary.internal;

import android.content.Intent;
import android.net.Uri;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import javax.annotation.Nonnull;

/**
 * Expose a simple {@code Dialer.dial(} method to JavaScript.
 */
class DialerNativeModule extends ReactContextBaseJavaModule {

    public DialerNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /**
     * @return the name of this module as seen by JavaScript.
     */
    @Override
    public String getName() {
        return "Dialer";
    }

    @ReactMethod
    void dial(@Nonnull String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
        getReactApplicationContext().startActivity(intent);
    }
}
