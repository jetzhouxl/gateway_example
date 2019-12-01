package com.example.firstserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/test")
    public String test(@RequestHeader("X-first-Header") String headerValue){
        return headerValue;
    }

}
