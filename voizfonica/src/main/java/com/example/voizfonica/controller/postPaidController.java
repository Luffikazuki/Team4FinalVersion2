package com.example.voizfonica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/postPaid")
public class postPaidController {

    @GetMapping
    public String postPlanFunc() {
        return "postpaid";
    }

}
