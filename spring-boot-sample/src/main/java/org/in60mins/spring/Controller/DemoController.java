package org.in60mins.spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping
    public String sauHello(){
        return "Hello Raj ...!";
    }
}
