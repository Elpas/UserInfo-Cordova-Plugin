getInfo = function(action,callback,args){
	cordova.exec(callback,error,"UserInfo",action,[args]);
}
