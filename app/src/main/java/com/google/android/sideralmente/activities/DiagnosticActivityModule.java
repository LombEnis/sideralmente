package com.google.android.sideralmente.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import com.google.android.sideralmente.inject.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by johntaylor on 4/15/16.
 */
@Module
public class DiagnosticActivityModule {
    private DiagnosticActivity activity;

    public DiagnosticActivityModule(DiagnosticActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    Context provideActivityContext() {
        return activity;
    }

    @Provides
    @PerActivity
    Handler provideHandler() {
        return new Handler();
    }
}
