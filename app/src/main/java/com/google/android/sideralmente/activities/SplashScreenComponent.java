package com.google.android.sideralmente.activities;

import com.google.android.sideralmente.ApplicationComponent;
import com.google.android.sideralmente.activities.dialogs.EulaDialogFragment;
import com.google.android.sideralmente.activities.dialogs.WhatsNewDialogFragment;
import com.google.android.sideralmente.inject.PerActivity;

import dagger.Component;

/**
 * Created by johntaylor on 4/2/16.
 */
@PerActivity
@Component(modules = SplashScreenModule.class, dependencies = ApplicationComponent.class)
public interface SplashScreenComponent extends EulaDialogFragment.ActivityComponent,
        WhatsNewDialogFragment.ActivityComponent {
    void inject(SplashScreenActivity activity);
}
