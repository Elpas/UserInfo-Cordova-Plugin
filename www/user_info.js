getInfo = function(action,success,error,args){
	cordova.exec(success,error,"UserInfo",action,[args]);
}
