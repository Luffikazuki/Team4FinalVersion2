package com.example.voizfonica.controller;

import com.example.voizfonica.data.UserCredentialRepository;
import com.example.voizfonica.model.Login;
import com.example.voizfonica.model.SubscriptionDetail;
import com.example.voizfonica.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customerRegister")
@SessionAttributes({"subscriptionDetail","login"})
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

    @ModelAttribute(name ="login")
    public Login login(){
        return new Login();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        UserCredential userCredential = new UserCredential();
        model.addAttribute("userCredential",userCredential);
        return "customerRegister";
    }

    @PostMapping
    public String processRegistrationFrom(@Valid UserCredential userCredential, Errors errors, Model model,
                                          @ModelAttribute Login login){
        if(errors.hasErrors()){
            return "customerRegister";
        }else{

            userCredentialRepository.save(userCredential);
            SubscriptionDetail subscriptionDetail = new SubscriptionDetail();
            List<UserCredential> user1 = userCredentialRepository.findByEmailIdAndPassword(userCredential.getEmailId(),
                    userCredential.getPassword());
            String userId = user1.get(0).getId();
            String productId = user1.get(0).getRequiredPlan();
            ///////Persisting the userId and productId in subscriptionDetail
            subscriptionDetail.setUserId(userId);
            subscriptionDetail.setProductId(productId);
            model.addAttribute("subscriptionDetail",subscriptionDetail);
            //Passing the login attributes
            login.setUserName(user1.get(0).getUserName());
            login.setId(userId);
            login.setPassword(null);
            login.setEmailId(null);
            return "redirect:/chooseplan/"+ productId;
        }
    }

}

