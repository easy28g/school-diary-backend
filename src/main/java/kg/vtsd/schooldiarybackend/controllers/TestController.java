package kg.vtsd.schooldiarybackend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {

    @GetMapping("/admins-test")
    public String getHello() {
        return "Hello, World!";
    }
    
}
