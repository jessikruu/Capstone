package org.jessicakrueger.capstone.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.BookClubDAO;
import org.jessicakrueger.capstone.database.DAO.GenresDAO;
import org.jessicakrueger.capstone.database.DAO.MeetingLocationsDAO;
import org.jessicakrueger.capstone.database.entity.BookClub;
import org.jessicakrueger.capstone.database.entity.Genres;
import org.jessicakrueger.capstone.database.entity.MeetingLocations;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.form.CreateBookClubFormBean;
import org.jessicakrueger.capstone.security.AuthenticatedUserUtilities;
import org.jessicakrueger.capstone.service.BookClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bookClub")
public class BookClubController {

    @Autowired
    BookClubDAO bookClubDAO;

    @Autowired
    MeetingLocationsDAO meetingLocationsDAO;

    @Autowired
    BookClubService bookClubService;

    @Autowired
    GenresDAO genresDAO;

    private final AuthenticatedUserUtilities authenticatedUserUtilities;

    public BookClubController(AuthenticatedUserUtilities authenticatedUserUtilities) {
        this.authenticatedUserUtilities = authenticatedUserUtilities;
    }





    @GetMapping("/info")
    public ModelAndView bookClubInfo(@RequestParam(required = false) Integer id) {

        //by default the @requestparam is required, meaning it has to be in the url or else you get error
        // if the id param isn't present on the url, the incoming id will be null

        //this function is for the home page of the website which is expressed as just the plain /

        ModelAndView response = new ModelAndView("bookClub/bookClubInfo");

        BookClub bookClub = bookClubDAO.findById(id);
        response.addObject("bookClubKey", bookClub);


        return response;
    }

    @GetMapping("/search")
    //the get mapping ^^^ is the url that you use in the bar
    public ModelAndView searchBookClubs(@RequestParam(required = false) String search) {

        //this page is for another page of the website which is expressed by / and words after, such as http://localhost:8080/another-page

        ModelAndView response = new ModelAndView("bookClub/bookClubSearchResults");
        //the view name is the jsp, and that references the page for the view

        log.debug("The user searched for the term: " + search);


        //i am going to add the user input back into the model so that we can display the search term in the input field
        response.addObject("search", search);

        List<BookClub> bookClubs = bookClubDAO.findBySearchTerm(search);
        response.addObject("bookClubs", bookClubs);
        //the attribute name assigns a name for the jsp to use, the second term needs to match the list name, bc that is what references it
        log.debug(bookClubs.toString());

        bookClubs.stream().forEach(bookClub -> {
            log.debug(bookClub.toString());
            log.debug("Bookclub: " + bookClub.getClubName());
        });


        return response;
    }

    private void loadDropdowns(ModelAndView response) {
        List<MeetingLocations> possibleLocations = meetingLocationsDAO.findAll();

        response.addObject("possibleLocations", possibleLocations);

        List<Genres> possibleGenres = genresDAO.findAll();

        response.addObject("possibleGenres", possibleGenres);

    }


    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("bookClub/bookClubCreate");

        loadDropdowns(response);

        User currentUser = authenticatedUserUtilities.getCurrentUser();

        if (currentUser != null) {
            response.addObject("userId", currentUser.getId());
        }

        return response;
    }


    @RequestMapping(value = "/createSubmit", method = {RequestMethod.POST, RequestMethod.GET})
//    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(@Valid CreateBookClubFormBean form, BindingResult bindingResult) {
        //@RequestParam String **email** the email needs to match the name that was assigned in the form (if used, code above updated to shortcut)
        ModelAndView response = new ModelAndView();


        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            //if we're in this part of the if statement, then we know an error has occurred
            //we add the binding result to the model so we can use it on the JSP page to show the user the errors
            response.addObject("bindingResult", bindingResult);

//            //the page needs the list of employees, so we need to add the list of employees to the model
//            List<Employee> reportsToEmployees = employeeDAO.findAll();
//            response.addObject("reportsToEmployees", reportsToEmployees);
//
//            //also need the list of offices
//            List<Offices> reportingToOffice = officesDAO.findAll();
//            response.addObject("reportingToOffice", reportingToOffice);

            response.setViewName("bookClub/bookClubCreate");

            //now to add the form to the model so we can display the user entered data

            response.addObject("form", form);

            return response;


        } else {

            //call the employee service to create the employee
            BookClub bookClub = bookClubService.createBookClub(form);

            //when we save to the database, it will autoincrement to give us a new id
            //the new id is available in the return from the save method
            //returns the same object after the info has been inserted into the db

            response.setViewName("redirect:/bookClub/info?id=" + bookClub.getId());
            //the redirect:/employee/info?id= is referring to the mapping of the employee info page
            //after the redirect, it will input the data and create the new page


            //below are used for post mapping
//            loadDropdowns(response);
//            response.setViewName("employee/createEmployee");

            return response;


        }
    }

}
