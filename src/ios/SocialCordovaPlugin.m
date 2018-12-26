#import "SocialCordovaPlugin.h"

#import <Cordova/CDVAvailability.h>

@implementation SocialCordovaPlugin

- (void)pluginInitialize {
}

- (void)share:(CDVInvokedUrlCommand *)command {


        NSString* subject = [command.arguments objectAtIndex:0];
        NSString* message = [command.arguments objectAtIndex:1];
        NSString* url = [command.arguments objectAtIndex:2];

        //NSLog(@"%@", phrase);

        //NSString *textToShare = @"Look at this awesome website for aspiring iOS Developers!";
        //NSURL *myWebsite = [NSURL URLWithString:@"http://www.codingexplorer.com/"];

        NSArray *objectsToShare = @[message, url];

        UIActivityViewController *activityVC = [[UIActivityViewController alloc] initWithActivityItems:objectsToShare applicationActivities:nil];

        NSArray *excludeActivities = @[UIActivityTypeAirDrop,
                                       UIActivityTypePrint,
                                       UIActivityTypeAssignToContact,
                                       UIActivityTypeSaveToCameraRoll,
                                       UIActivityTypeAddToReadingList,
                                       UIActivityTypePostToFlickr,
                                       UIActivityTypePostToVimeo];

        activityVC.excludedActivityTypes = excludeActivities;
        activityVC.popoverPresentationController.sourceView = self.webViewEngine.engineWebView;
        [self.viewController presentViewController:activityVC animated:YES completion:nil];
}

@end
