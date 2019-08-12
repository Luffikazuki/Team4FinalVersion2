package com.example.voizfonica.controller;

import com.example.voizfonica.data.PlanDetailRepository;
import com.example.voizfonica.data.SubscriptionDetailRepository;
import com.example.voizfonica.data.UserCredentialRepository;
import com.example.voizfonica.model.Login;
import com.example.voizfonica.model.PlanDetail;
import com.example.voizfonica.model.SubscriptionDetail;
import com.example.voizfonica.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("login")
@RequestMapping("/unsubscribe")
public class UnsubscribeController {
    private SubscriptionDetailRepository subscriptionDetailRepository;
    private UserCredentialRepository userCredentialRepository;
    private PlanDetailRepository planDetailRepository;


    @Autowired
    public UnsubscribeController(PlanDetailRepository planDetailRepository1,SubscriptionDetailRepository subscriptionDetailRepository1,UserCredentialRepository userCredentialRepository1){
        this.planDetailRepository = planDetailRepository1;
        this.subscriptionDetailRepository=subscriptionDetailRepository1;
        this.userCredentialRepository=userCredentialRepository1;
    }

    @ModelAttribute(name = "userCredential")
    public UserCredential userCredential() {
        return new UserCredential();
    }

    @ModelAttribute(name = "login")
    public Login login(){
        return new Login();
    }

    @ModelAttribute(name="subscriptionDetail")
    public SubscriptionDetail subscriptionDetail()
    {return new SubscriptionDetail();}

    @GetMapping
    public String showUnsubscirbe(Model model, @ModelAttribute Login login){
        Optional<UserCredential> userCredential = userCredentialRepository.findById(login.getId());
        UserCredential user = userCredential.get();
        model.addAttribute("user", user);

        List<SubscriptionDetail> subscriptionDetail=subscriptionDetailRepository.findSubscriptionDetailByUserId(user.getId());
        SubscriptionDetail plan=subscriptionDetail.get(0);
        model.addAttribute("plan",plan);
        return "/unsubscribe";
    }

    @PostMapping
    public String unsubscribePlan(SubscriptionDetail subscriptionDetail, Model model,
                             @ModelAttribute Login login){

        Optional<UserCredential> userCredential = userCredentialRepository.findById(login.getId());
        UserCredential user = userCredential.get();
        List<PlanDetail> planDetail=planDetailRepository.findByUserId(user.getId());
        PlanDetail plan=planDetail.get(0);
        planDetailRepository.delete(plan);
        List<SubscriptionDetail> subscriptionDetail1=subscriptionDetailRepository.findSubscriptionDetailByUserId(user.getId());
        SubscriptionDetail plan1=subscriptionDetail1.get(0);
        plan1.setPlandId("Not Available");
        plan1.setProductId("Not Plans selected");
       // user.setRequiredPlan("Not Plans Selected");
        subscriptionDetailRepository.save(plan1);
        userCredentialRepository.save(user);

        return "redirect:/dashboard";

    }

}
