package com.example.voizfonica.controller;

import com.example.voizfonica.data.UserCredentialRepository;
import com.example.voizfonica.model.Login;
import com.example.voizfonica.model.PassErrors;
import com.example.voizfonica.model.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/login")

public class LoginController {
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private LoginController(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    @GetMapping
    public String showLogin(Model model) {

        model.addAttribute("login", new Login());
        return "loginPage";
    }

    @PostMapping
    public String processLogin(@Valid Login login, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "loginPage";
        } else {
            List<UserCredential> user = userCredentialRepository.findByEmailIdAndPassword(login.getEmailId(), login.getPassword());
            if (user.isEmpty()) {
               return "redirect:/error101";
            } else {
                model.addAttribute("user", user);
                return "redirect:/dashboard";
            }
        }

    }
}
