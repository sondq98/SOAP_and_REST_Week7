package com.example.demo_calculator_soap_ws;

import com.baeldung.springsoap.gen.GetExpressionResultRequest;
import com.baeldung.springsoap.gen.GetExpressionResultResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static java.lang.Integer.parseInt;

@Endpoint
public class CalculatorEndpoint {
    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getExpressionResultRequest")
    public GetExpressionResultResponse getExpressionResult(@RequestPayload GetExpressionResultRequest request) {
        GetExpressionResultResponse response = new GetExpressionResultResponse();
        String[] paramsArray = request.getExpression().split(" ");
        if (paramsArray.length != 3 || (!paramsArray[1].equals("+") && !paramsArray[1].equals("-")
                && !paramsArray[1].equals("*") && !paramsArray[1].equals("/") && !paramsArray[1].equals("**"))) {
            response.setResult("Expression invalid.(Please type: a + b or a - b or a * b or a / b)");
        } else {
            switch (paramsArray[1]) {
                case "+":
                    response.setResult(String.valueOf(parseInt(paramsArray[0]) + parseInt(paramsArray[2])));
                    break;
                case "-":
                    response.setResult(String.valueOf(parseInt(paramsArray[0]) - parseInt(paramsArray[2])));
                    break;
                case "*":
                    response.setResult(String.valueOf(parseInt(paramsArray[0]) * parseInt(paramsArray[2])));
                    break;
                case "/":
                    response.setResult(String.valueOf(parseInt(paramsArray[0]) / parseInt(paramsArray[2])));
                    break;
                case "**":
                    response.setResult(String.valueOf(Math.pow(parseInt(paramsArray[0]), parseInt(paramsArray[2]))));
                    break;
                default:
                    break;
            }
        }

        return response;
    }

}
