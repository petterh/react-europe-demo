#import "MSReactBridge.h"

#import <React/RCTBridge.h>
#import <React/RCTRootView.h>
#import <ReactFramework/ReactFramework.h>

@implementation ReactFramework

static MSReactBridge *_sharedInstance;

+ (void)presentWithViewController:(UIViewController *)viewController
{
    _sharedInstance = [MSReactBridge new];
    RCTRootView* rootView = [_sharedInstance viewWithFrame:viewController.view.frame];

    [NSNotificationCenter.defaultCenter
        addObserverForName:RCTJavaScriptDidLoadNotification
                    object:nil
                     queue:NSOperationQueue.mainQueue
                usingBlock:^(NSNotification* notification) {
                    viewController.view = rootView;
                }];
}

@end
