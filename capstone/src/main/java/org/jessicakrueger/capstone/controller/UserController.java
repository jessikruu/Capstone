package org.jessicakrueger.capstone.controller;


import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.BookClubDAO;
import org.jessicakrueger.capstone.database.DAO.ClubMemberDAO;
import org.jessicakrueger.capstone.database.DAO.DiscussionDAO;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.entity.BookClub;
import org.jessicakrueger.capstone.database.entity.ClubMembers;
import org.jessicakrueger.capstone.database.entity.Discussion;
import org.jessicakrueger.capstone.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    BookClubDAO bookClubDAO;

    @Autowired
    ClubMemberDAO clubMemberDAO;

    @Autowired
    DiscussionDAO discussionDAO;

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

    @GetMapping("/bookClubsJoined")
    public ModelAndView bookClubsJoined(@RequestParam(required = true) Integer id) {

        ModelAndView response = new ModelAndView("user/bookClubsJoined");

        User userKey = userDAO.findById(id);
        response.addObject("userKey", userKey);

//        List<BookClub> bookClubInfo = clubMemberDAO.findBookClubsByMember(id);
//        for (BookClub bookClub : bookClubInfo) {
//            response.addObject("bookClubInfo", bookClub); // Note: Overwriting the existing object with each iteration
//        }
        List<ClubMembers> clubMembers = clubMemberDAO.findByUserId(id);
        // Extract BookClub IDs from the memberships
        List<Integer> bookClubIds = clubMembers.stream()
                .map(ClubMembers::getClubId)
                .collect(Collectors.toList());

        // Fetch the details for each book club
        List<BookClub> bookClubDetails = new ArrayList<>();
        for (Integer clubId : bookClubIds) {
            BookClub bookClub = bookClubDAO.findById(clubId);
            if (bookClub != null) {
                bookClubDetails.add(bookClub);
            }
        }

        // Add the book club details to the model
        response.addObject("bookClubDetails", bookClubDetails);

        return response;

    }

    @GetMapping("/discussionsPosted")
    public ModelAndView discussionsPosted(@RequestParam(required = true) Integer id) {

        ModelAndView response = new ModelAndView("user/discussionsPosted");

        User userKey = userDAO.findById(id);
        response.addObject("userKey", userKey);

        List<Discussion> posts = discussionDAO.findByUserId(id);
        response.addObject("posts", posts);

        return response;

    }
}
