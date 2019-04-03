package fizzbuzz;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import fizzbuzz.application.FizzBuzzValueCommand;
import fizzbuzz.domain.model.FizzBuzzValue;
import fizzbuzz.domain.type.FizzBuzzType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<Object, Object> {

    public Object handleRequest(final Object input, final Context context) {
        Map<Object,Object> params = (Map<Object, Object>) ((LinkedHashMap) input).get("queryStringParameters");
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        try {
            int number = Integer.parseInt((String) params.get("number"));
            FizzBuzzValueCommand fizzBuzzValueCommand = new FizzBuzzValueCommand(FizzBuzzType.valueOf("one"));
            FizzBuzzValue value = (FizzBuzzValue) fizzBuzzValueCommand.execute(number);
            String output = String.format("{ \"number\": \"%s\", \"value\": \"%s\" }", value.getNumber(),value.getValue());
            return new GatewayResponse(output, headers, 200);
        } catch (Exception e) {
            String output = String.format("{ \"message\": \"%s\"}", e.getMessage());
            return new GatewayResponse(output, headers, 500);
        }
    }
}
