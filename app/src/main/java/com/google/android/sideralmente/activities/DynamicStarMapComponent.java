package com.google.android.sideralmente.activities;

import com.google.android.sideralmente.ApplicationComponent;
import com.google.android.sideralmente.activities.dialogs.EulaDialogFragment;
import com.google.android.sideralmente.activities.dialogs.HelpDialogFragment;
import com.google.android.sideralmente.activities.dialogs.MultipleSearchResultsDialogFragment;
import com.google.android.sideralmente.activities.dialogs.NoSearchResultsDialogFragment;
import com.google.android.sideralmente.activities.dialogs.NoSensorsDialogFragment;
import com.google.android.sideralmente.activities.dialogs.TimeTravelDialogFragment;
import com.google.android.sideralmente.inject.PerActivity;

import dagger.Component;

/**
 * Created by johntaylor on 3/29/16.
 */
@PerActivity
@Component(modules = DynamicStarMapModule.class, dependencies = ApplicationComponent.class)
public interface DynamicStarMapComponent extends EulaDialogFragment.ActivityComponent,
        TimeTravelDialogFragment.ActivityComponent, HelpDialogFragment.ActivityComponent,
        NoSearchResultsDialogFragment.ActivityComponent,
        MultipleSearchResultsDialogFragment.ActivityComponent,
        NoSensorsDialogFragment.ActivityComponent {
    void inject(DynamicStarMapActivity activity);
}

