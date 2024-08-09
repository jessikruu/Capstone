package org.jessicakrueger.capstone.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.form.CreateAccountFormBean;
import org.jessicakrueger.capstone.security.AuthenticatedUserUtilities;
import org.jessicakrueger.capstone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/account")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/create-account")
    //localhost:8080/account/create-account
    public ModelAndView createAccount() {

        ModelAndView response = new ModelAndView("auth/create-account");

        return response;
    }

    @GetMapping("/login")
    //localhost:8080/account/login
    public ModelAndView login() {

        ModelAndView response = new ModelAndView("auth/login");

        return response;
    }

    @PostMapping("/create-account")
    public ModelAndView createAccountSubmit(@Valid CreateAccountFormBean form, BindingResult bindingResult, HttpSession session) {

        ModelAndView response = new ModelAndView("auth/create-account");

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            response.addObject("form", form);

        } else {

            User user = userService.createUser(form);
            authenticatedUserUtilities.manualAuthentication(session, form.getEmail(), form.getPassword());
            response.setViewName("redirect:/user/profile?id=" + user.getId());


        }

        return response;

    }


}
