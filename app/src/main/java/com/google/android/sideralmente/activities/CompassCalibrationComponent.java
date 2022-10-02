package com.google.android.sideralmente.activities;

import com.google.android.sideralmente.ApplicationComponent;
import com.google.android.sideralmente.inject.PerActivity;

import dagger.Component;

/**
 * Created by johntaylor on 4/24/16.
 */
@PerActivity
@Component(modules = CompassCalibrationModule.class, dependencies = ApplicationComponent.class)
public interface CompassCalibrationComponent {
    void inject(CompassCalibrationActivity activity);
}

