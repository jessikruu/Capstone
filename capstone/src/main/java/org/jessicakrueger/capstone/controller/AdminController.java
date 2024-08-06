package org.jessicakrueger.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.security.AuthenticatedUserUtilities;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {


    private final AuthenticatedUserUtilities authenticatedUserUtilities;

    public AdminController(AuthenticatedUserUtilities authenticatedUserUtilities) {
        this.authenticatedUserUtilities = authenticatedUserUtilities;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView response = new ModelAndView("admin/dashboard");

        User user = authenticatedUserUtilities.getCurrentUser();
        log.debug(user.toString());

        return response;
    }

}

