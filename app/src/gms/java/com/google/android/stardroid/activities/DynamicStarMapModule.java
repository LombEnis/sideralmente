package com.google.android.sideralmente.activities;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.sideralmente.inject.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module
 * Created by johntaylor on 3/29/16.
 */
@Module
public class DynamicStarMapModule extends AbstractDynamicStarMapModule {
    public DynamicStarMapModule(DynamicStarMapActivity activity) {
        super(activity);
    }

    @Provides
    @PerActivity
    GoogleApiAvailability providePlayServicesApiAvailability() {
        return GoogleApiAvailability.getInstance();
    }
}
