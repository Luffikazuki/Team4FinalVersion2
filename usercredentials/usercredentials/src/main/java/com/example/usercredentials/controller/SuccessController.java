package com.example.usercredentials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customerRegister/Successful")
public class SuccessController {
    @GetMapping
    public String showSuccess(){
        return "Successful";
    }
}
