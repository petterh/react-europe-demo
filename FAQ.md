# Problems you might encounter

## Unable to resolve module `react/lib/ReactDebugCurrentFrame`

* Output from `npm install`: **npm WARN react-native@0.44.0 requires a peer of react@16.0.0-alpha.6 but none was installed.**
* Resolution: `npm install --save react@16.0.0-alpha.6`

## Problems connecting to the dev server when running on physical Android device

* `adb reverse tcp:8081 tcp:8081`


