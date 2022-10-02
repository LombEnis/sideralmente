package com.google.android.sideralmente.activities;

import android.app.Activity;

import com.google.android.sideralmente.ApplicationComponent;
import com.google.android.sideralmente.StardroidApplication;

/**
 * Base class for all activities injected by Dagger.
 * <p>
 * Created by johntaylor on 4/9/16.
 */
public abstract class InjectableActivity extends Activity {
    protected ApplicationComponent getApplicationComponent() {
        return ((StardroidApplication) getApplication()).getApplicationComponent();
    }
}
