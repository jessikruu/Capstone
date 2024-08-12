package org.jessicakrueger.capstone;

import org.jessicakrueger.capstone.database.DAO.BookClubDAO;
import org.jessicakrueger.capstone.database.entity.BookClub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class BookClubDAOTest {

    @Autowired
    BookClubDAO bookClubDAO;


    @Test
    public void findByIdTest() {

        Integer id = 31;

        BookClub bookClub = bookClubDAO.findById(id);

        Assertions.assertNotNull(bookClub);
        Assertions.assertEquals(id, bookClub.getId());




    }
}
