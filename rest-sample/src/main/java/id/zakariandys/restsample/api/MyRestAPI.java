package id.zakariandys.restsample.api;

import id.zakariandys.restsample.api.response.HelloWorldResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestAPI {

    @GetMapping("/hello")
    public HelloWorldResponse printHelloWorld() {
        HelloWorldResponse response = new HelloWorldResponse();
        response.setSuccess(true);
        response.setMessage("Hello World!");
        return response;
    }
}
