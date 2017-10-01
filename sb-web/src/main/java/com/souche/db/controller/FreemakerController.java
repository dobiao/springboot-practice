package com.souche.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemaker")
public class FreemakerController {

    @RequestMapping("/hello")
    public String getModle(Model model){
        model.addAttribute("title", "Hello Freemaker");
        model.addAttribute("href", "https://www.bilibili.com");
        model.addAttribute("hrefName", "click me");
        return "helloFreemaker";
    }
}
