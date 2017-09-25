package com.souche.db.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }


    @RequestMapping(value = "/hello1")
    public String hello(@RequestParam(value = "name", required = false) String name) {
        String result = "hello  " + name;
        log.info("返回结果", result);
        return result;
    }

    @RequestMapping(value = "/world")
    public String world(@RequestParam(value = "arg", required = true) String arg) {
        String result = "world  " + arg;
        log.info("返回结果", result);
        return result;
    }

    @RequestMapping(value = "/annotation")
    public String annotation() {
        return "annotation";
    }

}
