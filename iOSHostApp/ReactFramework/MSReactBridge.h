#import <Foundation/Foundation.h>
#import <React/RCTBridgeDelegate.h>

@class RCTRootView;

@interface MSReactBridge : NSObject <RCTBridgeDelegate>

- (RCTRootView*)viewWithFrame:(CGRect)frame;

@end
