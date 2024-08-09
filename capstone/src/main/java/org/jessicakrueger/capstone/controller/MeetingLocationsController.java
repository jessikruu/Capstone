package org.jessicakrueger.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.MeetingLocationsDAO;
import org.jessicakrueger.capstone.database.entity.MeetingLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
@RequestMapping("/meetingLocation")
public class MeetingLocationsController {

    @Autowired
    MeetingLocationsDAO meetingLocationsDAO;

    @GetMapping("/info/{meetingLocationId}")
    public ModelAndView meetingLocationsPathVar(@PathVariable Integer meetingLocationId) {

        ModelAndView response = new ModelAndView("meetingLocations/meetingLocationInfo");

        MeetingLocations meetingLocations = meetingLocationsDAO.findById(meetingLocationId);
        response.addObject("meetingLocations", meetingLocations);

//        BookClub bookClubByMeetingLocation = bookClubDAO.findByMeetingLocationId(meetingLocationId);
//        response.addObject("bookClubByMeetingLocation", bookClubByMeetingLocation);

        return response;

    }
}
