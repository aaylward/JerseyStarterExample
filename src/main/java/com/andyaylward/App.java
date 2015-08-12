package com.andyaylward;

import ninja.freethrow.jerseystarter.JerseyStarter;
import ninja.freethrow.jerseystarter.config.StartupConfiguration;

public class App extends JerseyStarter {
  public static void main(String... args) throws Exception {
    StartupConfiguration configuration = StartupConfiguration
        .fromEnvWithBasePackage(App.class.getPackage());
    new App().configure(configuration).run();
  }
}
