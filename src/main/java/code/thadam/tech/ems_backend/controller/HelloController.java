package code.thadam.tech.ems_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping("")
    public String get() {
        return "welcome to my world";
    }
}
