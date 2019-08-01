//PrePaidController.java

package com.example.voizfonica.controller;

import com.example.voizfonica.data.PrePaidRepository;
import com.example.voizfonica.model.PrePaid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/prePaid")
public class PrePaidController {

    private PrePaidRepository preRepo;
    @Autowired
    public PrePaidController(PrePaidRepository preRepo) {
        this.preRepo=preRepo;
    }

    @GetMapping
    public String postPlanFunc(Model model) {
        List<PrePaid> THREE=preRepo.findByType("THREE");
        List<PrePaid> FOUR=preRepo.findByType("FOUR");
        model.addAttribute("THREE",THREE);
        model.addAttribute("FOUR",FOUR);
        return  "prePaid";

    }

    @PostMapping
    public String processPlanFrom(@Valid PrePaidController prepaidcontroller, Model model){
        model.addAttribute("payment",prepaidcontroller);
        return "redirect:/payment";
    }

}
