package com.karu3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloPageController {
    @GetMapping("/hello")
    public String hello() {
        return "hello2"; // src/main/resources/templates/hello2.htmlを返す
    }
}
