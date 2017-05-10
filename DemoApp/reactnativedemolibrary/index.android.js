'use strict';

import React from 'react';
import {
  AppRegistry,
  Button,
  NativeModules,
  StyleSheet,
  Text,
  View
} from 'react-native';

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello, World</Text>
        <Button
          onPress={() => NativeModules.Dialer.dial('+1 (234) 567-8910')}
          title='Dial +1 (234) 567-8910'
        />
      </View>
    )
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);
