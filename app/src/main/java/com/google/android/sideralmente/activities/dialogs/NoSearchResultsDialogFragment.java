package com.google.android.sideralmente.activities.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.google.android.sideralmente.R;
import com.google.android.sideralmente.inject.HasComponent;
import com.google.android.sideralmente.util.MiscUtil;

import javax.inject.Inject;

/**
 * End User License agreement dialog.
 * Created by johntaylor on 4/3/16.
 */
public class NoSearchResultsDialogFragment extends DialogFragment {
    private static final String TAG = MiscUtil.getTag(NoSearchResultsDialogFragment.class);
    @Inject
    Activity parentActivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Activities using this dialog MUST implement this interface.  Obviously.
        ((HasComponent<ActivityComponent>) getActivity()).getComponent().inject(this);

        return new AlertDialog.Builder(parentActivity)
                .setTitle(R.string.no_search_title).setMessage(R.string.no_search_results_text2)
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog1, int whichButton) {
                        Log.d(TAG, "No search results Dialog closed");
                        dialog1.dismiss();
                    }
                }).create();
    }

    public interface ActivityComponent {
        void inject(NoSearchResultsDialogFragment fragment);
    }
}
