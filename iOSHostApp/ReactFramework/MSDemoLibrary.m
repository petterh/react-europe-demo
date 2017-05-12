#import <Foundation/Foundation.h>

#import <React/RCTBridgeModule.h>

@interface MSDemoLibrary : NSObject <RCTBridgeModule>

@end

@implementation MSDemoLibrary

RCT_EXPORT_MODULE(DemoLibrary)

RCT_REMAP_METHOD(getName,
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
    resolve(@"React Native Demo Library");
}

@end
