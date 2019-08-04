package com.example.voizfonica.controller;

import com.example.voizfonica.data.UserCredentialRepository;
import com.example.voizfonica.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

        List<UserCredential> user = userCredentialRepository.findByEmailIdAndPassword("nandhinivishwanathanbe@gmail.com", "nandhini12");
        model.addAttribute("user", user);
        return "profileEdit";
    }
    @PostMapping
    public String setChanges(@Valid UserCredential userCredential, Errors errors, Model model){
      List<UserCredential> user=userCredentialRepository.findUserCredentialByAadharNumberMatches("917703539337");
        userId=(String)user.get(0).getId();
        UserCredential user1=new UserCredential();
        user1.setId(userId);
        user1.setUserName(userCredential.getUserName());
        user1.setContactNumber(userCredential.getContactNumber());
        user1.setAadharNumber(user.get(0).getAadharNumber());
        user1.setAddress(userCredential.getAddress());
        user1.setEmailId(userCredential.getEmailId());
        user1.setPanNumber(user.get(0).getPanNumber());
        user1.setPassword(userCredential.getPassword());
        user1.setRequiredPlan(user.get(0).getRequiredPlan());
           return "redirect:/profile";

    }
    /*@PutMapping
    public String finalUpdate(UserCredential userCredential,Model model)
    {
        userCredentialRepository.save(userCredential);
        return "redirect:/customerComplaint";
    }*/
}

