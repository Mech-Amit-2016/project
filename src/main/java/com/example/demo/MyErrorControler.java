package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class MyErrorControler implements ErrorController {
    @RequestMapping("/error")
    public @ResponseBody

    String handleError() {
        //do something like logging
        return "<h1>My Error</h1>";


    }
}
