package org.jessicakrueger.capstone.service;

import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.BookClubDAO;
import org.jessicakrueger.capstone.database.DAO.GenresDAO;
import org.jessicakrueger.capstone.database.DAO.MeetingLocationsDAO;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.entity.BookClub;
import org.jessicakrueger.capstone.database.entity.Genres;
import org.jessicakrueger.capstone.database.entity.MeetingLocations;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.form.CreateBookClubFormBean;
import org.jessicakrueger.capstone.security.AuthenticatedUserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class BookClubService {

    @Autowired
    BookClubDAO bookClubDAO;

    @Autowired
    MeetingLocationsDAO meetingLocationsDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    GenresDAO genresDAO;

    private final AuthenticatedUserUtilities authenticatedUserUtilities;

    public BookClubService(AuthenticatedUserUtilities authenticatedUserUtilities) {
        this.authenticatedUserUtilities = authenticatedUserUtilities;
    }

    public BookClub createBookClub(CreateBookClubFormBean form) {

        log.debug(form.toString());

        BookClub bookClub = bookClubDAO.findById(form.getBookClubId());
        if (bookClub == null) {
            bookClub = new BookClub();
        }

        bookClub.setClubName(form.getClubName());
//        bookClub.setGenre(form.getGenre());
        bookClub.setDescription(form.getDescription());
        bookClub.setCreationDate(new Date());

//        log.debug(form.getMeetingLocationId().toString());



        MeetingLocations meetingLocation = meetingLocationsDAO.findById(form.getMeetingLocationId());
        bookClub.setMeetingLocation(meetingLocation);

        Genres genres = genresDAO.findById(form.getGenreId());
        bookClub.setGenre(genres);

        User currentUser = authenticatedUserUtilities.getCurrentUser(); // Implement this method to get the current user
        if (currentUser != null) {
            log.debug("Current user ID: " + currentUser.getId());

//            form.setCreatedBy(currentUser.getId());
            bookClub.setUser(currentUser);

        } else {
            log.warn("No current user found");
        }



        bookClub = bookClubDAO.save(bookClub);

        return bookClub;
    }


}
