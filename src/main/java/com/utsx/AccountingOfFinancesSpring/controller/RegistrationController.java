package com.utsx.AccountingOfFinancesSpring.controller;

import com.utsx.AccountingOfFinancesSpring.entities.User;
import com.utsx.AccountingOfFinancesSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "reg";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "reg";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "reg";
        }

        return "redirect:/";
    }

}
