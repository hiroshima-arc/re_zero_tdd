package fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
  @Test
  public void successfulGetResponse() {
    App app = new App();
    LinkedHashMap<Object,Object> request = new LinkedHashMap<>();
    request.put("httpMethod","GET");
    Map<String,String> params = new HashMap<>();
    params.put("number","3");
    params.put("type","one");
    request.put("queryStringParameters",params);
    GatewayResponse result = (GatewayResponse) app.handleRequest(request, null);
    assertEquals(result.getStatusCode(), 200);
    assertEquals(result.getHeaders().get("Content-Type"), "application/json");
    String content = result.getBody();
    assertNotNull(content);
    assertTrue(content.contains("\"number\""));
    assertTrue(content.contains("\"3\""));
    assertTrue(content.contains("\"value\""));
    assertTrue(content.contains("\"Fizz\""));
  }

  @Test
  public void successfulPostResponse() {
    App app = new App();
    LinkedHashMap<Object,Object> request = new LinkedHashMap<>();
    request.put("httpMethod","POST");
    request.put("body","{\"number\":\"5\",\"type\":\"one\"}");
    GatewayResponse result = (GatewayResponse) app.handleRequest(request, null);
    assertEquals(result.getStatusCode(), 200);
    assertEquals(result.getHeaders().get("Content-Type"), "application/json");
    String content = result.getBody();
    assertNotNull(content);
    assertTrue(content.contains("\"number\""));
    assertTrue(content.contains("\"5\""));
    assertTrue(content.contains("{\"value\":\"Fizz\",\"number\":3}"));
  }
}
