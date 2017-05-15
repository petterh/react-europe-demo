# Artifacts directory

Generated artifacts end up here. Artifacts include:

* The JavaScript bundle;
* any other assets, such as images (of which there are currently none);
* a Maven POM holding the **reactnativedemolibrary** code;
* a Maven POM holding the **react-native** code, copied from `DemoApp/reactnativedemolibrary/node_modules/react-native/android` (and thus always in synch with the demo app and library).

Existing apps (e.g., `HostApp1`, `HostApp2`) consume these artifacts. In Real Life&trade;, use any distribution mechanism you like.
