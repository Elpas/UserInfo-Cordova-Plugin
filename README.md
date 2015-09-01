# UserInfo-Cordova-Plugin
A plugin to get user details such as email. Currently only providing support for User Email.

##Usage: 
1)from CLI inside your cordova project call
```
cordova plugins add https://github.com/xarv/UserInfo-Cordova-Plugin.git
```
2) Add Permission to your AndroidManifestfile.xml file
```xml
<uses-permission android:name="android.permission.GET_ACCOUNTS"/>
```
3) After Cordova has been loaded, you can use it the following way to get the email.
```Javascript
  var success = function(string){
    alert(string);
  };
  var error = function(string){
    alert("error");
  };
  getInfo("email",success,error,"email",[]);
```



