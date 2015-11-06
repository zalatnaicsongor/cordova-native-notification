var exec = cordova.require('cordova/exec');

var NativeNotification = function() {};

NativeNotification.prototype.getToken = function (senderId, onSuccess, onFailed) {
    exec(onSuccess, onFailed, 'NativeNotification', 'getToken', [{senderId: senderId}]);
};

module.exports = new NativeNotification();

