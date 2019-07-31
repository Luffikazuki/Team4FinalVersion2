package com.example.voizfonica.controller;

import com.example.voizfonica.data.PostPaidPlanRepository;
import com.example.voizfonica.model.PostPaid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping
    public String postPlanFunc(Model model) {
    List<PostPaid> postplans=new ArrayList<PostPaid>();
        postRepo.findAll().forEach(i -> postplans.add(i));
        model.addAttribute("postplans",postplans);
        return "postpaid";
    }

}
