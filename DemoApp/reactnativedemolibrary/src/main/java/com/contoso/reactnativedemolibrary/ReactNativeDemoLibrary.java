package com.contoso.reactnativedemolibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.view.View;

import com.contoso.reactnativedemolibrary.internal.ActivityLifeCycleHandler;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

/**
 * Public interface to React Native.
 */
public final class ReactNativeDemoLibrary {

    @SuppressLint("StaticFieldLeak")
    private static ReactNativeHost reactNativeHost;

    private ReactNativeDemoLibrary() {
        throw new IllegalStateException("Static class; do not instantiate.");
    }

    public static View start(Activity activity) {
        Application application = activity.getApplication();
        ReactInstanceManagerBuilder builder = ReactInstanceManager.builder();
        ReactInstanceManager reactInstanceManager = builder
                .setApplication(application)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        ActivityLifeCycleHandler lifeCycleHandler = new ActivityLifeCycleHandler(activity, reactInstanceManager);
        application.registerActivityLifecycleCallbacks(lifeCycleHandler);

        ReactRootView reactRootView = new ReactRootView(activity);
        reactRootView.startReactApplication(
                reactInstanceManager,
                "HelloWorld");
        return reactRootView;
    }
}
