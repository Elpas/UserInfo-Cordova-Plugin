getInfo = function(action,callback,error,args){
	cordova.exec(callback,error,"UserInfo",action,[args]);
}
