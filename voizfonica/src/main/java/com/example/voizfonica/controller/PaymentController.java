package com.example.voizfonica.controller;



import com.example.voizfonica.data.*;
import com.example.voizfonica.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Optional;

@Controller
@RequestMapping("/payment")
@SessionAttributes({"subscriptionDetail","login"})
public class PaymentController {

    private PaymentRepository paymentRepository;
    private SubscriptionDetailRepository subscriptionDetailRepository;
    private PrePaidRepository prePaidRepository;
    private PostPaidRepository postPaidRepository;
    private PlanDetailRepository planDetailRepository;
    private DongleRepository dongleRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository,
                             SubscriptionDetailRepository subscriptionDetailRepository,
                             PrePaidRepository prePaidRepository,
                             PostPaidRepository postPaidRepository,
                             PlanDetailRepository planDetailRepository,
                             DongleRepository dongleRepository) {
        this.paymentRepository = paymentRepository;
        this.subscriptionDetailRepository = subscriptionDetailRepository;
        this.prePaidRepository = prePaidRepository;
        this.postPaidRepository = postPaidRepository;
        this.planDetailRepository = planDetailRepository;
        this.dongleRepository = dongleRepository;
    }

    @ModelAttribute(name = "payment")
    public Payment pay() {
        return new Payment();
    }

    @GetMapping
    public String showPaymentForm(Model model) {
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "payment";
    }

    @PostMapping
    public String processPaymentFrom(@Valid Payment payment, Errors errors,
                                     @ModelAttribute SubscriptionDetail subscriptionDetail, Model model) {
        if (errors.hasErrors()) {
            return "payment";
        } else {
            paymentRepository.save(payment);
            //model.addAttribute("hello", payment);
            subscriptionDetail.setPayment(payment);
            subscriptionDetailRepository.save(subscriptionDetail);
            PlanDetail planDetail = new PlanDetail();
            planDetail.setUserId(subscriptionDetail.getUserId());
            planDetail.setPlanId(subscriptionDetail.getPlandId());
            planDetail.setStartDate(subscriptionDetail.getPayment().getPaymentDate());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(subscriptionDetail.getPayment().getPaymentDate());
//            calendar.add(Calendar.DAY_OF_MONTH,28);
//            planDetail.setEndDate(calendar.getTime());
            String productId = subscriptionDetail.getProductId();
            String validity;
            String data;
            String amountPaid;
            ////Getting plan validity
            if(productId.equals("prePaid")){
                Optional<PrePaid> prePaid = prePaidRepository.findById(subscriptionDetail.getPlandId());
                validity = prePaid.get().getValidity();
                data = prePaid.get().getBenefits();
                amountPaid = prePaid.get().getPreMoney();
            }else if(productId.equals("postPaid")){
                Optional<PostPaid> postPaid = postPaidRepository.findById(subscriptionDetail.getPlandId());
                validity = postPaid.get().getValidity();
                data = postPaid.get().getBenefits();
                amountPaid = postPaid.get().getPostMoney();
            }else{
                Optional<Dongle> dongle = dongleRepository.findById(subscriptionDetail.getPlandId());
                validity = dongle.get().getValidity();
                data = dongle.get().getBenefits();
                amountPaid = dongle.get().getDongleMoney();
            }

            planDetail.setValidity(validity);
            planDetail.setAmountPaid(amountPaid);
            char[] validityChar = validity.toCharArray();
            int validityNumber = validityChar[0] - '0';
            for(int i=1;i<validityChar.length;i++){
                if(Character.isDigit(validityChar[i])){
                    validityNumber=validityNumber*10;
                    validityNumber=validityNumber+validityChar[i]-'0';
                }
            }

            calendar.add(Calendar.DAY_OF_MONTH,validityNumber);
            planDetail.setEndDate(calendar.getTime());
            planDetail.setData(data);
            planDetail.setRemainingData(data);
            planDetail.setGeneratedNumber("9874563215");
            planDetailRepository.save(planDetail);
            return "redirect:/success";
        }
    }
}
