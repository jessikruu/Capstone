package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.BookClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BookClubDAO extends JpaRepository<BookClub, Long> {

    @Query("select b from BookClub b where lower(b.clubName) like concat('%', :name, '%') ")
    List<BookClub> findBySearchTerm(String name);

    BookClub findById(Integer id);

    @Query(value = "select bc.created_by from book_clubs bc where bc.created_by = :id;", nativeQuery = true)
    public List<Map<String, Object>> getCreatedBy(Integer id);

    List<BookClub> findByCreatedBy(Integer id);

    BookClub findByMeetingLocationId(Integer id);

    @Query(value = "SELECT bc.club_name, bc.genre_id, bc.created_by, bc.creation_date, bc.meeting_location_id, bc.description FROM book_clubs bc INNER JOIN club_members cm ON bc.id = cm.club_id WHERE cm.user_id = :id", nativeQuery = true)
    ArrayList<BookClub> findBookClubDetails(@Param("id") Integer id);

//    @Query("select * from BookClub b, ClubMembers cm where cm.userId = id and b.id = cm.clubId")
//    List<BookClub> findBookClubsByUserId(Integer id);
}

