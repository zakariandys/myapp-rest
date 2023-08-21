package id.zakariandys.restsample.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestAPI {

    @GetMapping
    public String printHelloWorld() {
        return "{\"message\":\"Hello, World!\"}";
    }
}
