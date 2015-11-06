package hu.zalatnai.native_notification;

import android.os.Bundle;
import com.google.android.gms.gcm.GcmListenerService;


public class GCMIntentService extends GcmListenerService {
    private static final String TAG = "GCMIntentService";

    @Override
    public void onMessageReceived(String from, Bundle data) {
    }
}