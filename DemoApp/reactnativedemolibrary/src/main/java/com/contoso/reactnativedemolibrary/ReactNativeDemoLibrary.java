package com.contoso.reactnativedemolibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.contoso.reactnativedemolibrary.internal.ActivityLifeCycleHandler;
import com.contoso.reactnativedemolibrary.internal.DemoReactPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

/**
 * Public interface to React Native Demo Library.
 */
public final class ReactNativeDemoLibrary {

    /**
     * Make sure we don't change "useDeveloperSupport" during the app's lifetime; the results
     * will be unpredictable.
     */
    private enum DeveloperSupport {
        Uninitialized,
        UseDeveloperSupport,
        DontUseDeveloperSupport;

        static DeveloperSupport fromBoolean(boolean value) {
            return value ? UseDeveloperSupport : DontUseDeveloperSupport;
        }

        boolean equals(boolean value) {
            return value ? this == UseDeveloperSupport : this == DontUseDeveloperSupport;
        }
    }

    /**
     * Holds the singleton {@link ReactInstanceManager}.
     *
     * The "context leak" warning can be ignored; the {@link Context} in question is in fact the
     * application context -- the only one guaranteed to live for the lifetime of the application.
     * It cannot leak.
     *
     * https://nfrolov.wordpress.com/2014/07/12/android-using-context-statically-and-in-singletons/
     */
    @SuppressLint("StaticFieldLeak")
    private static ReactInstanceManager reactInstanceManager;

    private static DeveloperSupport developerSupport = DeveloperSupport.Uninitialized;

    /**
     * Prohibit instantiation of the {@link ReactNativeDemoLibrary} static class.
     */
    private ReactNativeDemoLibrary() {
        throw new IllegalStateException("Static class; do not instantiate.");
    }

    /**
     * Create a react-native "HelloWorld" {@link ReactRootView}.
     *
     * @param activity The {@link Activity} that will host the {@code View}.
     * @param useDeveloperSupport Pass {@code true} to load JS from development server. This requires
     *                            overlay permission. Host applications should generally pass {@code false}.
     *                            Pass the same value every time.
     * @return a new react-native "HelloWorld" {@link ReactRootView}.
     * @exception IllegalArgumentException if {@code activity == null} or this method has previously
     * been called with a different value for {@code useDeveloperSupport}.
     */
    public static View createHelloWorldView(@NonNull Activity activity, boolean useDeveloperSupport) {
        //noinspection ConstantConditions
        if (activity == null) {
            throw new IllegalArgumentException("Null activity passed to ReactNativeDemoLibrary.start");
        }

        if (developerSupport == DeveloperSupport.Uninitialized) {
            assert reactInstanceManager == null;
            developerSupport = DeveloperSupport.fromBoolean(useDeveloperSupport);
        } else if (!developerSupport.equals(useDeveloperSupport)) {
            assert reactInstanceManager != null;
            throw new IllegalArgumentException("The value of useDeveloperSupport may not be changed during the app's lifetime.");
        }

        if (reactInstanceManager == null) {
            reactInstanceManager = ReactInstanceManager.builder()
                    .setApplication(activity.getApplication())
                    .setBundleAssetName("index.android.bundle")
                    .setJSMainModuleName("index.android")
                    .addPackage(new MainReactPackage())
                    .addPackage(new DemoReactPackage())
                    .setUseDeveloperSupport(useDeveloperSupport)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    .build();
        }

        ActivityLifeCycleHandler lifeCycleHandler = new ActivityLifeCycleHandler(activity, reactInstanceManager);
        activity.getApplication().registerActivityLifecycleCallbacks(lifeCycleHandler);

        ReactRootView reactRootView = new ReactRootView(activity);
        reactRootView.startReactApplication(reactInstanceManager, "HelloWorld");
        return reactRootView;
    }
}
