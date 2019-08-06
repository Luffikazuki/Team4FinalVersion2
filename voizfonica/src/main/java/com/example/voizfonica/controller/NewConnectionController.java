package com.example.voizfonica.controller;

import com.example.voizfonica.data.UserCredentialRepository;
import com.example.voizfonica.model.Login;
import com.example.voizfonica.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@SessionAttributes("login")
public class NewConnectionController {

    private UserCredentialRepository userCredentialRepository;

    @ModelAttribute(name="login")
    public Login login(){return new Login();}
    @GetMapping("newConnection")
    public String showNewConnection(UserCredential userCredential){
        return"/newConnection";
    }

}
