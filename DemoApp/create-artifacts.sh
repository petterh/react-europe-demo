#!/bin/bash
# TODO: Add android/ios parameter
# Run this from the DemoApp directory (where it is located)

# make our output stand out

bold=`tput bold`
green=`tput setaf 2`
boldgreen=${bold}${green}
magenta=`tput setaf 5`
boldmagenta=${bold}${magenta}
end=`tput sgr0`

platform=android

pushd reactnativedemolibrary >/dev/null

artifacts=../../Artifacts

echo ${boldgreen}Creating ${boldmagenta}${artifacts}${boldgreen} folders${end}

mkdir -p "${artifacts}/assets"
mkdir -p "${artifacts}/res"

echo ${boldgreen}Publishing ${boldmagenta}reactnativedemolibry${boldgreen} and copying ${boldmagenta}node_modules/react-native/android${boldgreen} to maven${end}
/bin/bash ../gradlew clean build publish copyReactNative copyJdcAndroid

echo ${boldgreen}Creating JS bundle${end}

cliPath=node_modules/react-native/local-cli/cli.js
node $cliPath bundle --platform "$platform" --dev false --entry-file index."$platform".js --bundle-output ${artifacts}/assets/index."$platform".bundle --sourcemap-output ${artifacts}/assets/index."$platform".map --assets-dest ${artifacts}/res/

popd >/dev/null
