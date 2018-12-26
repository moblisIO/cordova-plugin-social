#import <Cordova/CDVPlugin.h>

@interface SocialCordovaPlugin : CDVPlugin <UIPopoverControllerDelegate>

// The hooks for our plugin commands
- (void)share:(CDVInvokedUrlCommand *)command;


@end
