var exec = cordova.require('cordova/exec');

var NativeNotification = function() {};

NativeNotification.prototype.getToken = function (senderId, onSuccess, onFailed) {
    exec(onSuccess, onFailed, 'NotificationPlugin', 'getToken', [{senderId: senderId}]);
};

module.exports = new NativeNotification();

