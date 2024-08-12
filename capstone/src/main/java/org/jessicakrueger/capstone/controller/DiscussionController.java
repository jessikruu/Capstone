package org.jessicakrueger.capstone.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.BookClubDAO;
import org.jessicakrueger.capstone.database.DAO.DiscussionDAO;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.entity.BookClub;
import org.jessicakrueger.capstone.database.entity.Discussion;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.form.CreateDiscussionFormBean;
import org.jessicakrueger.capstone.security.AuthenticatedUserUtilities;
import org.jessicakrueger.capstone.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/discussion")
public class DiscussionController {

    @Autowired
    DiscussionDAO discussionDAO;

    @Autowired
    BookClubDAO bookClubDAO;

    private final AuthenticatedUserUtilities authenticatedUserUtilities;
    @Autowired
    private DiscussionService discussionService;
    @Autowired
    private UserDAO userDAO;

    public DiscussionController(AuthenticatedUserUtilities authenticatedUserUtilities) {
        this.authenticatedUserUtilities = authenticatedUserUtilities;
    }


    @GetMapping("/info")
    public ModelAndView viewDiscussionPost(@RequestParam(required = false) Integer id) {

        //by default the @requestparam is required, meaning it has to be in the url or else you get error
        // if the id param isn't present on the url, the incoming id will be null

        //this function is for the home page of the website which is expressed as just the plain /

        ModelAndView response = new ModelAndView("discussion/viewDiscussionPost");

//        BookClub bookClub = bookClubDAO.findById(id);
//        response.addObject("bookClubKey", bookClub);

        Discussion discussions = discussionDAO.findById(id);
        response.addObject("discussions", discussions);

        User currentUser = authenticatedUserUtilities.getCurrentUser();

        User user = userDAO.findById(currentUser.getId());
        response.addObject("user", user);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("discussionForm");

        BookClub currentBookClub = bookClubDAO.findById(id);
        response.addObject("bookClub", currentBookClub);


        User currentUser = authenticatedUserUtilities.getCurrentUser();

        if (currentUser != null) {
            response.addObject("userId", currentUser.getId());
        }

        return response;
    }


    @RequestMapping(value = "/createSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView createSubmit(@Valid CreateDiscussionFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();


        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }


            response.addObject("bindingResult", bindingResult);


            response.setViewName("discussionForm");

            //now to add the form to the model so we can display the user entered data

            response.addObject("form", form);

            return response;


        } else {

            Discussion discussion = discussionService.createDiscussionPost(form);


            response.setViewName("redirect:/discussion/info?id=" + discussion.getId());


            return response;


        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("discussionForm");


        if (id != null) {

            Discussion discussion = discussionDAO.findById(id);
            if (discussion != null) {
                CreateDiscussionFormBean form = new CreateDiscussionFormBean();

                form.setTitle(discussion.getTitle());
                form.setBody(discussion.getBody());
                form.setDiscussionId(discussion.getId());
                form.setDiscussionCreatorId(discussion.getDiscussionCreatorId());
                form.setClubId(discussion.getClubId());

                response.addObject("form", form);
            }
            else {
                response.addObject("errorMessage", "The discussion post wasn't found in the database");
            }
        }

        return response;
    }
}
