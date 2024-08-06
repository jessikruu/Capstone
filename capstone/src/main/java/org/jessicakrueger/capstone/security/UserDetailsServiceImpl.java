package org.jessicakrueger.capstone.security;

import lombok.extern.slf4j.Slf4j;
import org.jessicakrueger.capstone.database.DAO.UserDAO;
import org.jessicakrueger.capstone.database.DAO.UserRoleDAO;
import org.jessicakrueger.capstone.database.entity.User;
import org.jessicakrueger.capstone.database.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //this User -object is in the imports section
        User user = userDAO.findByEmailIgnoreCase(username);

        //if the user is null then whatever the person entered in the login form doesn't exist in the db
        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        // check the account status
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<UserRole> userRoles = userRoleDAO.findByUserId(user.getId());
        Collection<? extends GrantedAuthority> authorities = buildGrantAuthorities(userRoles);

        //this User object is part of spring security
        //bc both objects are named User, we have to use the full path to the object
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),  // this paramter is the username, in our case the user from the database
                user.getPassword(), // this is the users encrypted password from the database
                accountIsEnabled, // is this account enabled, if false, then spring security will deny access
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                authorities); //the list of security roles the user is authorized for

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }


}
