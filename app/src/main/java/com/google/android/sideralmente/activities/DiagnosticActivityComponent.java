package com.google.android.sideralmente.activities;

import com.google.android.sideralmente.ApplicationComponent;
import com.google.android.sideralmente.inject.PerActivity;

import dagger.Component;

/**
 * Created by johntaylor on 4/15/16.
 */
@PerActivity
@Component(modules = DiagnosticActivityModule.class, dependencies = ApplicationComponent.class)
public interface DiagnosticActivityComponent {
    void inject(DiagnosticActivity activity);
}
