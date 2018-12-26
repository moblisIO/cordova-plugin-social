package io.cordova.moblis.social;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;

import android.util.Log;

public class SocialCordovaPlugin extends CordovaPlugin {
  private static final String TAG = "SocialCordovaPlugin";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    //Log.d(TAG, "Initializing SocialCordovaPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("share")) {
      String subject = args.getString(0);
      String message = args.getString(1);
      String url = args.getString(2);
      shareIt(subject, message, url);
      Log.d(TAG, message);
    }
    return true;
  }

  private void shareIt(String subject, String message, String url) {

    final CordovaInterface mycordova = cordova;
    final CordovaPlugin plugin = this;
    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
    sharingIntent.setType("text/plain");
    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, message + System.getProperty("line.separator") + url);
    mycordova.startActivityForResult(plugin, sharingIntent, 1);
  }
}
