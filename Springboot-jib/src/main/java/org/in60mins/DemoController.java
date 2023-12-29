package org.in60mins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("hello")
    public String sayHello(){
        return "Hello Google Jib...!";
    }
}
