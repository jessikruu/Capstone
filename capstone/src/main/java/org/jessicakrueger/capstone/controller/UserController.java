package org.jessicakrueger.capstone.controller;


import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.BookClubDAO;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.entity.BookClub;
import org.jessicakrueger.capstone.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    BookClubDAO bookClubDAO;

    @GetMapping("/profile")
    public ModelAndView bookClubInfo(@RequestParam(required = false) Integer id) {

        //by default the @requestparam is required, meaning it has to be in the url or else you get error
        // if the id param isn't present on the url, the incoming id will be null

        //this function is for the home page of the website which is expressed as just the plain /

        ModelAndView response = new ModelAndView("user/profile");

        User userKey = userDAO.findById(id);
        response.addObject("userKey", userKey);

        List<Map<String,Object>> bookClubsCreated = bookClubDAO.getCreatedBy(id);
        response.addObject("bookClubsCreated", bookClubsCreated);

        List<BookClub> bookClubs = bookClubDAO.findByCreatedBy(id);
        response.addObject("bookClubs", bookClubs);


        return response;
    }
}
