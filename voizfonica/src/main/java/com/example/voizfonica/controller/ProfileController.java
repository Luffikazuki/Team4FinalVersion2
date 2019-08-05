package com.example.voizfonica.controller;

import com.example.voizfonica.data.UserCredentialRepository;
import com.example.voizfonica.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfileController {

    private UserCredentialRepository userCredentialRepository;
    @Autowired
    private ProfileController(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    @GetMapping("/profile")
    public String getEdit(Model model) {
        List<UserCredential> user = userCredentialRepository.findByEmailIdAndPassword("saravanan@gmail.com", "abcdefgh");
        model.addAttribute("user", user);
        return "profile";
    }
}