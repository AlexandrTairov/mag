package com.mag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping(value = "/")
    public String startPage() {
        return "redirect:startPage.html";
    }
}
