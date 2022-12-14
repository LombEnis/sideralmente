package com.google.android.sideralmente.activities.dialogs;

import android.app.Dialog;
import android.os.Bundle;

import com.google.android.sideralmente.activities.DynamicStarMapActivity;
import com.google.android.sideralmente.inject.HasComponent;
import com.google.android.sideralmente.util.MiscUtil;

import javax.inject.Inject;

/**
 * Time travel dialog fragment.
 * Created by johntaylor on 4/3/16.
 */
// TODO(jontayler): see if this crashes when backgrounded on older devices and use
// the fragment in this package if so.
public class TimeTravelDialogFragment extends android.app.DialogFragment {
    private static final String TAG = MiscUtil.getTag(TimeTravelDialogFragment.class);
    @Inject
    DynamicStarMapActivity parentActivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Activities using this dialog MUST implement this interface.  Obviously.
        ((HasComponent<ActivityComponent>) getActivity()).getComponent().inject(this);

        return new TimeTravelDialog(parentActivity,
                parentActivity.getModel());
    }

    public interface ActivityComponent {
        void inject(TimeTravelDialogFragment fragment);
    }
}
