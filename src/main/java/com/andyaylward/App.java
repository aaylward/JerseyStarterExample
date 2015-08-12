package com.andyaylward;

import ninja.freethrow.jerseystarter.Service;

public class App {
  public static void main(String... args) {
    buildService().run();
  }

  public static Service buildService() {
    return Service.buildService(App.class.getPackage());
  }
}
