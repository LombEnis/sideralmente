// Copyright 2008 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.android.sideralmente.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.google.android.sideralmente.ApplicationConstants;
import com.google.android.sideralmente.R;
import com.google.android.sideralmente.StardroidApplication;
import com.google.android.sideralmente.activities.dialogs.WhatsNewDialogFragment;
import com.google.android.sideralmente.activities.util.ConstraintsChecker;
import com.google.android.sideralmente.inject.HasComponent;
import com.google.android.sideralmente.util.Analytics;
import com.google.android.sideralmente.util.MiscUtil;

import javax.inject.Inject;

/**
 * Shows a splash screen, then launch the next activity.
 */
public class SplashScreenActivity extends InjectableActivity
        implements WhatsNewDialogFragment.CloseListener,
        HasComponent<SplashScreenComponent> {
    private final static String TAG = MiscUtil.getTag(SplashScreenActivity.class);
    @Inject
    StardroidApplication app;
    @Inject
    Analytics analytics;
    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    Animation fadeAnimation;
    @Inject
    FragmentManager fragmentManager;
    @Inject
    WhatsNewDialogFragment whatsNewDialogFragment;
    @Inject
    ConstraintsChecker cc;
    private View graphic;
    private SplashScreenComponent daggerComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        daggerComponent = DaggerSplashScreenComponent.builder()
                .applicationComponent(getApplicationComponent())
                .splashScreenModule(new SplashScreenModule(this)).build();
        daggerComponent.inject(this);

        graphic = findViewById(R.id.splash);

        fadeAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation unused) {
                Log.d(TAG, "onAnimationEnd");
                graphic.setVisibility(View.INVISIBLE);
                maybeShowWhatsNewAndEnd();
            }

            public void onAnimationRepeat(Animation arg0) {
            }

            public void onAnimationStart(Animation arg0) {
                Log.d(TAG, "SplashScreen.Animation onAnimationStart");
            }
        });
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
        graphic.startAnimation(fadeAnimation);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    private void maybeShowWhatsNewAndEnd() {
        boolean whatsNewSeen = (sharedPreferences.getLong(
                ApplicationConstants.READ_WHATS_NEW_PREF_VERSION, -1) == app.getVersion());
        if (whatsNewSeen) {
            launchSkyMap();
        } else {
            whatsNewDialogFragment.show(fragmentManager, "Whats New Dialog");
        }
    }

    // What's new dialog closed.
    @Override
    public void dialogClosed() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(ApplicationConstants.READ_WHATS_NEW_PREF_VERSION, app.getVersion());
        editor.commit();
        launchSkyMap();
    }

    private void launchSkyMap() {
        Intent intent = new Intent(SplashScreenActivity.this, DynamicStarMapActivity.class);
        cc.check();
        startActivity(intent);
        finish();
    }

    @Override
    public SplashScreenComponent getComponent() {
        return daggerComponent;
    }
}
