@echo off
rem TODO: Add android/ios parameter
rem Run this from the DemoApp directory

@setlocal

rem make our output stand out (only for Win10 with Threshold 2 update)
rem http://stackoverflow.com/a/38617204/3968276

set escape=
set boldgreen=%escape%[1m%escape%[32m
set boldmagenta=%escape%[1m%escape%[35m
set end=%escape%[0m

set platform=android

pushd reactnativedemolibrary

set artifacts=..\..\Artifacts

echo %boldgreen%Creating %boldmagenta%%artifacts%%boldgreen% folders%end%
if not exist %artifacts% mkdir %artifacts%
if not exist %artifacts%\assets mkdir %artifacts%\assets
if not exist %artifacts%\res mkdir %artifacts%\res

echo %boldgreen%Publishing %boldmagenta%reactnativedemolibry%boldgreen% and copying %boldmagenta%node_modules/react-native/android%boldgreen% to maven%end%
call ..\gradlew.bat build publish copyReactNative copyJdcAndroid

echo %boldgreen%Creating JS bundle%end%
call react-native bundle --platform %platform% --dev false --entry-file index.%platform%.js --bundle-output %artifacts%/assets/index.%platform%.bundle --sourcemap-output %artifacts%/assets/index.%platform%.map --assets-dest %artifacts%/res/

popd
