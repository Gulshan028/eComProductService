package com.ecommerce.ecomprodservicedec25.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class SampleController {
    @GetMapping("/hello/{number}")
    public String sayHello(@PathVariable("number") int number) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {
            sb.append("Hello folks!!");
        }
        return sb.toString();
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye All!!";
    }
}
