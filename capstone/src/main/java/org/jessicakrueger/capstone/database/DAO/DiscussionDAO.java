package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.ClubMembers;
import org.jessicakrueger.capstone.database.entity.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiscussionDAO extends JpaRepository<Discussion, Long> {

    Discussion findById(Integer Id);

    @Query("select d from Discussion d join BookClub bc on d.clubId = bc.id where bc.id = :id")
    List<Discussion> findByBookClubId(Integer id);

    @Query("select d.clubId from Discussion d where d.clubId = :id")
    Discussion getClubId(Integer id);
}
