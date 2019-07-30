package com.example.usercredentials.controller;

import com.example.usercredentials.data.UserCredentialsRepository;
import com.example.usercredentials.model.UserCredentials;
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
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public UserRegistrationController(UserCredentialsRepository userCredentialsRepository){
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @ModelAttribute(name = "register")
    public UserCredentials register(){
        return new UserCredentials();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        UserCredentials userCredentials = new UserCredentials();
        model.addAttribute("userCredentials",userCredentials);
        return "customerRegister";
    }

    @PostMapping
    public String processRegistrationFrom(@Valid UserCredentials userCredentials, Errors errors, Model model){
        if(errors.hasErrors()){
            return "customerRegister";
        }else{
            userCredentialsRepository.save(userCredentials);
            model.addAttribute("showDetails",userCredentials);
            return "redirect:/customerRegister/Successful";
        }
    }

}
