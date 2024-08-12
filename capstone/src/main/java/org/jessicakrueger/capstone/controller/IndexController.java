package org.jessicakrueger.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.security.AuthenticatedUserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    UserDAO userDAO;

    private final AuthenticatedUserUtilities authenticatedUserUtilities;

    public IndexController(AuthenticatedUserUtilities authenticatedUserUtilities) {
        this.authenticatedUserUtilities = authenticatedUserUtilities;
    }


    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");


        if (authenticatedUserUtilities.isAuthenticated()) {
            User currentUser = authenticatedUserUtilities.getCurrentUser();
            User userKey = userDAO.findById(currentUser.getId());
            response.addObject("userKey", userKey);
            response.addObject("isLoggedIn", true); // Add this line to indicate the user is logged in
        } else {
            response.addObject("isLoggedIn", false); // Indicate the user is not logged in
        }

        return response;
    }

}
