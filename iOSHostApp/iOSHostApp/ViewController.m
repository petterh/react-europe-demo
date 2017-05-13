#import "ViewController.h"

#import <ReactFramework/ReactFramework.h>

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    [ReactFramework presentWithViewController:self];
}

@end
