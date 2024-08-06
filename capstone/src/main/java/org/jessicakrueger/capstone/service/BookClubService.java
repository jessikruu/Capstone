package org.jessicakrueger.capstone.service;

import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.BookClubDAO;
import org.jessicakrueger.capstone.database.DAO.MeetingLocationsDAO;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.entity.BookClub;
import org.jessicakrueger.capstone.database.entity.MeetingLocations;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.form.CreateBookClubFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BookClubService {

    @Autowired
    BookClubDAO bookClubDAO;

    @Autowired
    MeetingLocationsDAO meetingLocationsDAO;

    @Autowired
    UserDAO userDAO;

    public BookClub createBookClub(CreateBookClubFormBean form) {

        log.debug(form.toString());

        BookClub bookClub = bookClubDAO.findById(form.getBookClubId());
        if (bookClub == null) {
            bookClub = new BookClub();
        }

        bookClub.setClubName(form.getClubName());
        bookClub.setGenre(form.getGenre());

        log.debug(form.getMeetingLocationId().toString());

        MeetingLocations meetingLocations = meetingLocationsDAO.findById(form.getMeetingLocationId());
        bookClub.setMeetingLocation(meetingLocations);

        User user = userDAO.findById(form.getCreatedBy());
        bookClub.setCreatedBy(user.getId());


        bookClub = bookClubDAO.save(bookClub);

        return bookClub;
    }


}
