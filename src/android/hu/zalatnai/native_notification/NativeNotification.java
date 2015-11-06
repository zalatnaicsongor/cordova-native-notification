package hu.zalatnai.native_notification;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class NativeNotification extends CordovaPlugin {
    public static final String LOG_TAG = "NotificationPlugin";

    /**
     * Gets the application context from cordova's main activity.
     *
     * @return the application context
     */
    private Context getApplicationContext() {
        return this.cordova.getActivity().getApplicationContext();
    }

    @Override
    public boolean execute(final String action, final JSONArray data, final CallbackContext callbackContext) {
        Log.v(LOG_TAG, "execute: action=" + action);

        if (action.equals("getToken")) {
            try {
                callbackContext.success(InstanceID.getInstance(getApplicationContext())
                                                .getToken(
                                                        data.getJSONObject(0).getString("senderId"),
                                                        GoogleCloudMessaging.INSTANCE_ID_SCOPE
                                                ));
                return true;
            } catch (Exception e) {
                callbackContext.error(e.getMessage());
                return false;
            }
        }

        return false;
    }
}
