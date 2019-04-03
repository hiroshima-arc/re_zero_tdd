package fizzbuzz;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fizzbuzz.application.FizzBuzzValueCommand;
import fizzbuzz.application.FizzBuzzValuesCommand;
import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.model.FizzBuzzValues;
import fizzbuzz.domain.type.FizzBuzzType;

import java.util.*;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<Object, Object> {

    public Object handleRequest(final Object input, final Context context) {
        String method = (String) ((LinkedHashMap) input).get("httpMethod");
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        try {
            switch (method) {
                case "POST":
                    ObjectMapper objectMapper = new ObjectMapper();
                    String body = (String) ((LinkedHashMap) input).get("body");
                    JsonNode jsonBody = objectMapper.readTree(body);
                    int number = jsonBody.get("number").asInt();
                    String type = "one";
                    if (Objects.nonNull(jsonBody.get("type"))) type = jsonBody.get("type").asText();
                    FizzBuzzValuesCommand fizzBuzzValuesCommand = new FizzBuzzValuesCommand(FizzBuzzType.valueOf(type));
                    FizzBuzzValues values = (FizzBuzzValues) fizzBuzzValuesCommand.execute(number);
                    ArrayList<String > jsonValues = new ArrayList<>();
                    for(FizzBuzzValue value :values.getFizzBuzzValues()) {
                        String json = objectMapper.writeValueAsString(value);
                        jsonValues.add(json);
                    }
                    String output = String.format("{ \"number\": \"%s\", \"values\": \"%s\" }", number, jsonValues);
                    return new GatewayResponse(output, headers, 200);
                default:
                    Map<Object,Object> params = (Map<Object, Object>) ((LinkedHashMap) input).get("queryStringParameters");
                    number = Integer.parseInt((String) params.get("number"));
                    type = (String) params.get("type");
                    if (Objects.isNull(type)) type = "one";
                    FizzBuzzValueCommand fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf(type));
                    FizzBuzzValue value = (FizzBuzzValue) fizzBuzzValueCommand.execute(number);
                    output = String.format("{ \"number\": \"%s\", \"value\": \"%s\" }", value.getNumber(),value.getValue());
                    return new GatewayResponse(output, headers, 200);
            }

        } catch (Exception e) {
            String output = String.format("{ \"message\": \"%s\"}", e.getMessage());
            return new GatewayResponse(output, headers, 500);
        }
    }
}
