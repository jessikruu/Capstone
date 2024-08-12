package org.jessicakrueger.capstone;

import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @ParameterizedTest
    @CsvSource(
            {
                    "Username"


            }
    )
    public void findByUsernameTest(String username) {

        List<User> userList = userDAO.findByUsername(username);

        Assertions.assertNotNull(userList);
        Assertions.assertTrue(userList.size() > 0);

        for(User u : userList) {
            Assertions.assertEquals(username, u.getUsername());
        }

    }
}
