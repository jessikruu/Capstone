package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(String email);

    User findById(Integer id);



}
