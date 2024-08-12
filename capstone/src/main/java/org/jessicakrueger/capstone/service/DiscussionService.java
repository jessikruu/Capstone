package org.jessicakrueger.capstone.service;


import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.BookClubDAO;
import org.jessicakrueger.capstone.database.DAO.DiscussionDAO;
import org.jessicakrueger.capstone.database.entity.*;
import org.jessicakrueger.capstone.form.CreateDiscussionFormBean;
import org.jessicakrueger.capstone.security.AuthenticatedUserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DiscussionService {

    @Autowired
    DiscussionDAO discussionDAO;

    @Autowired
    BookClubDAO bookClubDAO;

    private final AuthenticatedUserUtilities authenticatedUserUtilities;

    public DiscussionService(AuthenticatedUserUtilities authenticatedUserUtilities) {
        this.authenticatedUserUtilities = authenticatedUserUtilities;
    }

    public Discussion createDiscussionPost(CreateDiscussionFormBean form) {

        log.debug(form.toString());

        Discussion discussion = discussionDAO.findById(form.getDiscussionId());
        if (discussion == null) {
            discussion = new Discussion();
        }

        discussion.setTitle(form.getTitle());
        discussion.setBody(form.getBody());
        discussion.setCreationDate(new Date());

        BookClub bookClub = bookClubDAO.findById(form.getClubId());
        discussion.setBookClub(bookClub);



        User currentUser = authenticatedUserUtilities.getCurrentUser(); // Implement this method to get the current user
        if (currentUser != null) {
            log.debug("Current user ID: " + currentUser.getId());

//            form.setCreatedBy(currentUser.getId());
            discussion.setDiscussionCreatorUser(currentUser);

        } else {
            log.warn("No current user found");
        }



        discussion = discussionDAO.save(discussion);

        return discussion;
    }
}
