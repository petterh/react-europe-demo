# Problems you might encounter

## Error calling AppRegistry.runApplication

* Ensure that the debug server is running (**react-native start**)
* Once it's running, **RELOAD** is sufficient

## Unable to resolve module `react/lib/ReactDebugCurrentFrame`

* Output from `npm install`: **npm WARN react-native@0.44.0 requires a peer of react@16.0.0-alpha.6 but none was installed.**
* Resolution: `npm install --save react@16.0.0-alpha.6`

## Could not connect to the development server when running on physical Android device

* `adb reverse tcp:8081 tcp:8081`


