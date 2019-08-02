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
import java.util.List;

@Controller
@RequestMapping("/profileEdit")
public class ProfileEditController {
    

private UserCredentialRepository userCredentialRepository;
private String userId;
    @Autowired
    private ProfileEditController(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;

    }

    @ModelAttribute(name = "userCredential")
    public UserCredential userCredential() {
        return new UserCredential();
    }
    @GetMapping
    public String getEdit(Model model) {

        List<UserCredential> user = userCredentialRepository.findByEmailIdAndPassword("nandhinivishwanathanbe@gmail.com", "nandhini1");
        userId=user.get(0).getId();
        model.addAttribute("user", user);
        return "profileEdit";
    }
    @PostMapping
    public String setChanges(@Valid UserCredential userCredential, Errors errors, Model model){
        if(errors.hasErrors()){
            return "redirect:/profileEdit";
        }else{
           // userCredentialRepository.save(userCredential);
            userCredentialRepository.save(userCredential);
            userCredentialRepository.
           return "redirect:/profile";
        }
    }
}

