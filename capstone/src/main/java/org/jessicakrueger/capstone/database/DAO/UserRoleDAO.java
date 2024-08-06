package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Integer userId);


}
