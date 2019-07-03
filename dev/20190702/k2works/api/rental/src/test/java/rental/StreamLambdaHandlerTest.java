package rental;

import com.amazonaws.serverless.proxy.internal.LambdaContainerHandler;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.*;

public class StreamLambdaHandlerTest {
  private static StreamLambdaHandler handler;
  private static Context lambdaContext;

  @BeforeClass
  public static void setUp() {
    handler = new StreamLambdaHandler();
    lambdaContext = new MockLambdaContext();
  }

  @Test
  public void textStatement() {
    InputStream requestStream = new AwsProxyRequestBuilder(
      "/textStatement",
      HttpMethod.GET
    )
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .buildStream();
    ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

    handle(requestStream, responseStream);

    AwsProxyResponse response = readResponse(responseStream);
    assertNotNull(response);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatusCode());

    assertFalse(response.isBase64Encoded());

    assertTrue(response.getBody().contains("statement"));
    assertTrue(
      response.getBody()
        .contains(
          "{\"statement\":\"山田様のレンタル明細\\n\\t新作\\t900円\\n\\t子供\\t150円\\n\\t一般\\t200円\\n合計金額 1250円\\n獲得ポイント 4ポイント\"}"
        )
    );

    assertTrue(
      response.getMultiValueHeaders().containsKey(HttpHeaders.CONTENT_TYPE)
    );
    assertTrue(
      response.getMultiValueHeaders()
        .getFirst(HttpHeaders.CONTENT_TYPE)
        .startsWith(MediaType.APPLICATION_JSON)
    );
  }

  @Test
  public void htmlStatement() {
    InputStream requestStream = new AwsProxyRequestBuilder(
      "/htmlStatement",
      HttpMethod.GET
    )
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .buildStream();
    ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

    handle(requestStream, responseStream);

    AwsProxyResponse response = readResponse(responseStream);
    assertTrue(response.getBody().contains("statement"));

    assertTrue(
      response.getMultiValueHeaders().containsKey(HttpHeaders.CONTENT_TYPE)
    );
    assertTrue(
      response.getMultiValueHeaders()
        .getFirst(HttpHeaders.CONTENT_TYPE)
        .startsWith(MediaType.APPLICATION_JSON)
    );
  }

  @Test
  public void invalidResource_streamRequest_responds404() {
    InputStream requestStream = new AwsProxyRequestBuilder(
      "/pong",
      HttpMethod.GET
    )
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .buildStream();
    ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

    handle(requestStream, responseStream);

    AwsProxyResponse response = readResponse(responseStream);
    assertNotNull(response);
    assertEquals(
      Response.Status.NOT_FOUND.getStatusCode(),
      response.getStatusCode()
    );
  }

  private void handle(InputStream is, ByteArrayOutputStream os) {
    try {
      handler.handleRequest(is, os, lambdaContext);
    } catch (IOException e) {
      e.printStackTrace();
      fail(e.getMessage());
    }
  }

  private AwsProxyResponse readResponse(ByteArrayOutputStream responseStream) {
    try {
      return LambdaContainerHandler.getObjectMapper()
        .readValue(responseStream.toByteArray(), AwsProxyResponse.class);
    } catch (IOException e) {
      e.printStackTrace();
      fail("Error while parsing response: " + e.getMessage());
    }
    return null;
  }
}
