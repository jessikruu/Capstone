package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(String email);

    User findById(Integer id);

}
