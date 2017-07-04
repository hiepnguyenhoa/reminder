package com.walmart.reminder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HiepNguyen on 7/4/2017.
 */

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "resultPage";
    }
}