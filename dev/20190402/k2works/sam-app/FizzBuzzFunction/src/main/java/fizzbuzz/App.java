package fizzbuzz;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import fizzbuzz.application.FizzBuzzValueCommand;
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
            fizzBuzzValueCommand.execute(number);
            final String value = fizzBuzzValueCommand.getValue();
            String output = String.format("{ \"number\": \"%s\", \"value\": \"%s\" }", number,value);
            return new GatewayResponse(output, headers, 200);
        } catch (Exception e) {
            return new GatewayResponse("{}", headers, 500);
        }
    }
}
