package com.andyaylward;

import ninja.freethrow.jerseystarter.StartupConfiguration;
import ninja.freethrow.jerseystarter.JerseyStarter;

public class App {
  private JerseyStarter jersey;

  public static void main(String... args) throws Exception {
    App app = new App();
    app.run(true);
  }

  protected App() {
    StartupConfiguration configuration = new StartupConfiguration(8080, App.class.getPackage(), "/test-service");
    jersey = JerseyStarter.newStarterApp(configuration);
  }

  protected void run(boolean join) throws Exception {
    jersey.run(join);
  }

  protected void stop() throws Exception {
    jersey.stop();
  }
}
