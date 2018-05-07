package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageDemoController {

    @RequestMapping("/testPage")
    public String hello() {
        return "testPage";
    }

}
