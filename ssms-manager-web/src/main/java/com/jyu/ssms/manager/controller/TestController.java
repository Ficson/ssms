package com.jyu.ssms.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    private static final String TEST = "test";
    @RequestMapping("/test")
    public String test() {
        return TEST;
    }
}
