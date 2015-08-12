package com.andyaylward;

import com.andyaylward.data.Wocket;
import com.hubspot.horizon.HttpClient;
import com.hubspot.horizon.HttpRequest;
import com.hubspot.horizon.HttpRequest.ContentType;
import com.hubspot.horizon.HttpRequest.Method;
import com.hubspot.horizon.HttpResponse;
import com.hubspot.horizon.apache.ApacheHttpClient;
import ninja.freethrow.jerseystarter.Service;
import ninja.freethrow.jerseystarter.config.StartupConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
  private static final String APP_ROOT = "/test-service";
  private static final int TEST_PORT = 8080;
  private static final HttpClient HTTP = new ApacheHttpClient();

  private static Service SERVICE;

  @BeforeClass
  public static void setup() {
    System.setProperty(StartupConfiguration.PORT_PROPERTY_NAME, String.valueOf(TEST_PORT));
    System.setProperty(StartupConfiguration.CONTEXT_PATH_PROPERTY_NAME, APP_ROOT);

    SERVICE = App.buildService();
    SERVICE.run(false);
  }

  @AfterClass
  public static void cleanup() {
    SERVICE.stop();
  }

  @Test
  public void itCanServeRequests() {
    String uri = String.format("http://localhost:%d%s/hello", TEST_PORT, APP_ROOT);
    HttpRequest request = HttpRequest.newBuilder()
        .setUrl(uri)
        .setMethod(Method.GET)
        .setAccept(ContentType.TEXT)
        .setQueryParam("name").to("friend")
        .build();
    HttpResponse response = HTTP.execute(request);
    assertThat(response.getStatusCode()).isEqualTo(200);
    assertThat(response.getAsString()).isEqualTo("Hello friend");
  }

  @Test
  public void itCanServeJSON() {
    Wocket expectedWocket = new Wocket("bop");
    String uri = String.format("http://localhost:%d%s/gimme-json", TEST_PORT, APP_ROOT);
    HttpRequest request = HttpRequest.newBuilder()
        .setUrl(uri)
        .setQueryParam("name").to("bop")
        .setMethod(Method.GET)
        .setAccept(ContentType.JSON)
        .build();
    HttpResponse response = HTTP.execute(request);
    assertThat(response.getStatusCode()).isEqualTo(200);
    assertThat(response.getAs(Wocket.class)).isEqualTo(expectedWocket);
  }
}
