#import <UIKit/UIKit.h>

//! Project version number for ReactFramework.
FOUNDATION_EXPORT const double ReactFrameworkVersionNumber;

//! Project version string for ReactFramework.
FOUNDATION_EXPORT const unsigned char ReactFrameworkVersionString[];

@interface ReactFramework : NSObject

+ (void)presentWithViewController:(UIViewController*)viewController;

@end
