var exec = require('cordova/exec');

var PLUGIN_NAME = 'SocialCordovaPlugin';

var SocialCordovaPlugin = {
  share: function(subject, message, url, cb) {
    exec(cb, null, PLUGIN_NAME, 'share', [subject, message, url]);
  }
};

module.exports = SocialCordovaPlugin;
