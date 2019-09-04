package com.contoso.reactnativedemolibrary.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

/**
 * Forwards life-cycle events to {@link ReactInstanceManager}. This saves the host
 * {@link Activity} from having to implement a fair bit of boilerplate code.
 *
 * The life cycle handler is automatically unregistered when the activity is destroyed.
 *
 * TODO: Back-button handling needs forwarding to JS.
 */
public final class ActivityLifeCycleHandler implements Application.ActivityLifecycleCallbacks, DefaultHardwareBackBtnHandler {

    private final Activity activity;
    private final ReactInstanceManager reactInstanceManager;

    /**
     * Create a new instance of th e{@link ActivityLifeCycleHandler} class. It forwards life-cycle
     * activities to to the provided {@link ReactInstanceManager react instance manager}.
     *
     * @param activity The activity hosting a {@link ReactRootView react native view}.
     * @param reactInstanceManager The {@link ReactInstanceManager} to forward life-cycle events to.
     *
     * @exception IllegalArgumentException if either argument is {@code null}.
     */
    public ActivityLifeCycleHandler(@NonNull Activity activity, @NonNull ReactInstanceManager reactInstanceManager) {
        this.activity = activity;
        this.reactInstanceManager = reactInstanceManager;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (activity == this.activity) {
            reactInstanceManager.onHostResume(activity, this);
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        if (activity == this.activity) {
            reactInstanceManager.onHostPause(activity);
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activity == this.activity) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            reactInstanceManager.onHostDestroy(activity);
        }
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        activity.onBackPressed();
    }
}
