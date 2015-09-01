package com.xarv.android.Info;
import java.util.regex.Pattern;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Patterns;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;


public class UserInfo extends CordovaPlugin {

	Context context;


	@Override
	public boolean execute(String action,JSONArray args, CallbackContext callbackContext) throws JSONException
	{
		context=this.cordova.getActivity().getApplicationContext();

		if(action.equals("email")){
			String mEmail = null;
			Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
			Account[] accounts = AccountManager.get(context).getAccounts();
			for (Account account : accounts) {
			    if (emailPattern.matcher(account.name).matches()) {
				String possibleEmail = account.name;
				mEmail = possibleEmail;
			    }
			}
			if(mEmail != null){
				callbackContext.success(mEmail);
				return true;
			}
			else{
				callbackContext.error("error fetching email");
				return false;
			}
		}
		callbackContext.error("Invalid Request");
		return false;
	}

}
