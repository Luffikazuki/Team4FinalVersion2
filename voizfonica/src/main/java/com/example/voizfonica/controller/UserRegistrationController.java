package com.example.voizfonica.controller;

import com.example.voizfonica.data.UserCredentialRepository;
import com.example.voizfonica.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customerRegister")
public class UserRegistrationController {
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    public UserRegistrationController(UserCredentialRepository userCredentialRepository){
        this.userCredentialRepository = userCredentialRepository;
    }

    @ModelAttribute(name = "userCredentials")
    public UserCredential userCredential(){
        return new UserCredential();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        UserCredential userCredential = new UserCredential();
        model.addAttribute("userCredential",userCredential);
        return "customerRegister";
    }

    @PostMapping
    public String processRegistrationFrom(@Valid UserCredential userCredential, Errors errors, Model model){
        if(errors.hasErrors()){
            return "customerRegister";
        }else{
            userCredentialRepository.save(userCredential);
            model.addAttribute("showDetails",userCredential);
            return "redirect:/customerRegister";
        }
    }

}

