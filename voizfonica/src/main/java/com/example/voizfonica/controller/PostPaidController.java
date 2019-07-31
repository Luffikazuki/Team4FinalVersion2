package com.example.voizfonica.controller;

import com.example.voizfonica.data.PostPaidPlanRepository;
import com.example.voizfonica.model.Payment;
import com.example.voizfonica.model.PostPaid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/postPaid")
public class PostPaidController {

    private PostPaidPlanRepository postRepo;
    @Autowired
    public PostPaidController(
            PostPaidPlanRepository postRepo) {
        this.postRepo=postRepo;
    }

    @ModelAttribute(name = "payment")
    public Payment payment(){
        return new Payment();
    }
    @GetMapping
    public String postPlanFunc(Model model) {

        List<PostPaid> postPlans = new ArrayList<>();
        postRepo.findAll().forEach(i -> postPlans.add(i));
        model.addAttribute("postPlans",postPlans);
        return "postPaid";
    }

    @PostMapping
    public String processPlanFrom(@Valid PostPaidController postpaidcontroller, Model model){

        //postRepo.save(postpaidcontroller);
            model.addAttribute("payment",postpaidcontroller);
            return "redirect:/payment";

    }

}
