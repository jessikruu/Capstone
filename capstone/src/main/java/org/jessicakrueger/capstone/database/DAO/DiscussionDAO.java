package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.ClubMembers;
import org.jessicakrueger.capstone.database.entity.Discussions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionDAO extends JpaRepository<ClubMembers, Long> {

    Discussions findById(Integer Id);


}
