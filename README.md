# react-europe-demo

Demo app for React Europe lightning talk (Paris, May 2017), showing how to create reusable react-native components that can be consumed by existing Android applications that don't want to take a dependency on **npm** and associated infrastructure.


## Getting started

### Windows

* [Install Git](https://git-scm.com/downloads)
* [Install Node.js](https://nodejs.org/en/download/)
* For all commands that follow, use a shell with Node and Git in the path
* `git clone https://github.com/petterh/react-europe-demo.git` in the folder where you want the repository
* `cd react-europe-demo\DemoApp\reactnativedemolibrary`
* `npm install` (creates a `node_modules` folder)
* Install [Android Studio](https://developer.android.com/studio/install.html), following instructions on the React Native [Getting Started](https://facebook.github.io/react-native/docs/getting-started.html) page.
* Open `react-europe-demo\DemoApp` in Android Studio
* Build and run the `app` module (debug, for now &ndash; emulator or device doesn't matter)
* From `react-europe-demo\DemoApp\reactnativedemo`, run `react-native start` 

### Mac

TODO

## The code

This repository is structured as follows:

```
react-europe-demo
  |
  +-- DemoApp
  |     |
  |     +-- app
  |     |
  |     +-- reactnativedemolibrary
  |
  +-- Artifacts
  |
  +-- HostApp1
  |
  +-- HostApp2
  |
  .
  |
  +-- HostApp_n
```

**DemoApp** is an Android Studio project with two modules:

* **app**: A testbed application that depends on the **reactnativedemolibrary** module. This module isn't strictly necessary, but is a great convenience.
* **reactnativedemolibrary**: A react-native library with some JavaScript and a Java native module. (TODO: Add a resource as well, such as an image.)

**Artifacts** is a "repository"-ish container for **reactnativedemolibrary** artifacts:

The various **HostApp**s represent any existing app that wants to use the functionality offered by **reactnativedemolibrary**. These consume the JavaScript in different ways.

* The JavaScript bundle;
* any other assets, such as images 
* a Maven POM holding the **reactnativedemolibrary** code;  
* a Maven POM holding the **react-native** code.

## Creating artifacts

The demo app links in react-native via reactnativedemolibrary, and in **Getting started** above, the JavaScript bundle isn't bundled with the apk; it's loaded from the dev server &ndash; we depend on it at runtime. For production, the JavaScript must be bundled into the apk, done via the `react-native bundle` command. We also need to pack up our code into something a host app can consume. For this we utilize a Gradle plugin called `maven-publish` to create a POM. [Source](http://stackoverflow.com/questions/34872382/manually-adding-aar-with-dependency-pom-iml-file)

From `react-europe-demo\DemoApp`, run `.\create-artifacts.cmd`. This will generate something like this:

```
react-europe-demo/Artifacts
  |
  +-- assets
  |     |
  |     +-- index.android.bundle
  |     +-- (additional non-essential files -- haven't gotten map to work (TODO))
  |
  +-- maven
  |     |
  |     +-- com
  |           +-- contoso
  |           |     |
  |           |     +-- react
  |           |           +-- reactnativedemolibrary
  |           |                 +-- 0.1
  |           |                 |     +-- reactnativedemolibrary-0.1.aar
  |           |                 |     +-- reactnativedemolibrary-0.1.pom
  |           |                 |     +-- (additional files)
  |           |                 +-- maven-metadata.xml
  |           |                 +-- (additional files)
  |           +-- facebook
  |           |     |
  |                 +-- react
  |                       +-- reactnativedemolibrary
  |                             +-- 0.44.0
  |                             |     +-- react-native-0.44.0.aar
  |                             |     +-- react-native-0.44.0.pom
  |                             |     +-- react-native-0.44.0-javadoc.jar
  |                             |     +-- react-native-0.44.0-sources.jar
  |                             |     +-- (additional files)
  |                             +-- maven-metadata.xml
  |                             +-- (additional files)
  +-- res (not yet used; intended for images)
```

## Notes

* 32-bit vs 64-bit: React Native doesn't currently support 64-bit native (C/C++) modules.
