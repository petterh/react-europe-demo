#import "MSReactBridge.h"

#import <React/RCTBridge.h>
#import <React/RCTRootView.h>

@implementation MSReactBridge
{
    RCTBridge* _bridge;
    RCTRootView* _rootView;
}

- (instancetype)init
{
    if (self = [super init])
    {
        _bridge = [[RCTBridge alloc] initWithDelegate:self
                                        launchOptions:nil];
    }

    return self;
}

- (RCTRootView*)viewWithFrame:(CGRect)frame
{
    if (_rootView == nil)
    {
        _rootView = [[RCTRootView alloc] initWithBridge:_bridge
                                             moduleName:@"HelloWorld"
                                      initialProperties:nil];
    }

    _rootView.frame = frame;
    return _rootView;
}

#pragma mark - RCTBridgeDelegate details

- (NSURL*)sourceURLForBridge:(RCTBridge*)bridge
{
    return [NSURL URLWithString:@"http://localhost:8081/index.ios.bundle?platform=ios"];
}

@end
