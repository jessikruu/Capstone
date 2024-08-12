package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.BookClub;
import org.jessicakrueger.capstone.database.entity.ClubMembers;
import org.jessicakrueger.capstone.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ClubMemberDAO extends JpaRepository<ClubMembers, Long> {

    ClubMembers findById(Integer Id);

    @Query(value = "select * from club_members where user_id = :userId and club_id = :clubId", nativeQuery = true)
    ClubMembers findIfAMember(Integer userId, Integer clubId);


    @Query(value = "select * from club_members where user_id = :userId and club_id = :clubId", nativeQuery = true)
    public List<Map<String, Object>> getCurrentClubs(Integer userId, Integer clubId);

    List<ClubMembers> findByUserId(Integer userId);


}
