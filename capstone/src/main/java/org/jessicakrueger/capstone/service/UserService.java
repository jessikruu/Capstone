package org.jessicakrueger.capstone.service;

import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.DAO.UserRoleDAO;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.database.entity.UserRole;
import org.jessicakrueger.capstone.form.CreateAccountFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleDAO userRoleDAO;

    public User createUser(CreateAccountFormBean form) {

        //no errors, so we can add user to the db
        User user = new User();

        //encrypting pw before saving it to the db
        String encryptedPassword = passwordEncoder.encode(form.getPassword());

        user.setEmail(form.getEmail());
        user.setPassword(encryptedPassword);
        user.setCreateDate(new Date());



        userDAO.save(user);

//        UserRole userRole = new UserRole();
//        userRole.setRoleName("USER");
//        userRole.setUserId(user.getId());
//        userRole.setCreateDate(new Date());
//
//        userRoleDAO.save(userRole);

//        createUserRole(user.getId(), "USER");

        return user;


    }


//    private UserRole createUserRole(Integer userId, String roleName) {
//        UserRole userRole = new UserRole();
//        userRole.setUserId(userId);
//        userRole.setRoleName(roleName);
//        userRole.setCreateDate(new Date());
//
//        userRoleDAO.save(userRole);
//
//        return userRole;
//    }
}
