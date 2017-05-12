package com.contoso.reactnativedemolibrary.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

/**
 * Forwards life-cycle events to {@link ReactInstanceManager}. This saves the host
 * {@link Activity} from having to implement a fair bit of boilerplate code.
 *
 * TODO: Back-button handling needs forwarding to JS.
 */
public final class ActivityLifeCycleHandler implements Application.ActivityLifecycleCallbacks, DefaultHardwareBackBtnHandler {

    private final Activity activity;
    private final ReactInstanceManager reactInstanceManager;

    public ActivityLifeCycleHandler(Activity activity, ReactInstanceManager reactInstanceManager) {
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
