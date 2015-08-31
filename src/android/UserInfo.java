package com.xarv.android.Email;
import java.util.regex.Pattern;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.Account;
import android.accounts.AccountManager;


public class UserInfo extends CordovaPlugin {

	@Override
	public boolean execute(String action,JSONArray args, CallbackContext callbackContext) throws JSONException
	{
		if(action.equals("getEmail")){
			String mEmail = null;
			Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
			Account[] accounts = AccountManager.get(getBaseContext()).getAccounts();
			for (Account account : accounts) {
			    if (emailPattern.matcher(account.name).matches()) {
				String possibleEmail = account.name;
				mEmail = possibleEmail;
			    }
			}
			if(mEmail != null)
				callbackContext.success(mEmail);
			else
				callbackContext.error("error fetching email");
		}
	
	}

}