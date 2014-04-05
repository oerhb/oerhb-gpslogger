package com.mendhak.gpslogger.views;

import android.app.Activity;
import android.app.Fragment;

/**
 * Common class for communicating with the parent for the
 * GpsViewCallbacks
 *
 * Created by oceanebelle on 04/04/14.
 */
public abstract class GenericViewFragment extends Fragment {
    // Mechanism to talk back to parent
    protected IGpsViewCallback gpsCallback;

    protected void requestStartLogging() {
        if (gpsCallback != null) {
            gpsCallback.onRequestStartLogging();
        }
    }

    protected void requestStopLogging() {
        if (gpsCallback != null) {
            gpsCallback.onRequestStopLogging();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof IGpsViewCallback) {
            gpsCallback = (IGpsViewCallback) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (gpsCallback != null) {
            gpsCallback = null;
        }
    }

    /**
     * Interface used by the different fragments to communicate with the parent activity
     * which should implement this interface.
     * Created by oceanebelle on 04/04/14.
     */
    public static interface IGpsViewCallback {
        public void onRequestStartLogging();
        public void onRequestStopLogging();
    }
}