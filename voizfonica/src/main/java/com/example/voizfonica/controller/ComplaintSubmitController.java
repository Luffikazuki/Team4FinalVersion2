package com.example.voizfonica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ComplaintSubmitController {
    @GetMapping("/ComplaintSubmit")
    public String complaintsubmitfunc() {
        return "ComplaintSubmit";
    }
}
