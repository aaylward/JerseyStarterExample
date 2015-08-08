package com.andyaylward;

import ninja.freethrow.jerseystarter.JerseyStarter;
import ninja.freethrow.jerseystarter.JerseyStarterConfiguration;

public class App {
  public static void main(String... args) throws Exception {
    JerseyStarterConfiguration configuration = new JerseyStarterConfiguration(8080, App.class.getPackage());
    JerseyStarter.newJerseyStarter(configuration).run();
  }
}
