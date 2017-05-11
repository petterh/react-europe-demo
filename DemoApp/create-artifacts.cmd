rem @echo off
rem TODO: Add android/ios parameter
rem Run this from the DemoApp directory

@setlocal

set platform=android

pushd reactnativedemolibrary

set artifacts=..\..\Artifacts
mkdir %artifacts%
mkdir %artifacts%\assets
mkdir %artifacts%\res

call ..\gradlew.bat publish copyReactNative
call react-native bundle --platform %platform% --dev false --entry-file index.%platform%.js --bundle-output %artifacts%/assets/index.%platform%.bundle --sourcemap-output %artifacts%/assets/index.%platform%.map --assets-dest %artifacts%/res/

popd
