package com.lipian.polishparliament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping
    private String index() {
        return "index";
    }
}
