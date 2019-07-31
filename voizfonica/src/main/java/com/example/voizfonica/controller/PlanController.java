package com.example.voizfonica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PlanController {

    @GetMapping("/plans")
    public String plansfunc() {
        return "plans";
    }

}
