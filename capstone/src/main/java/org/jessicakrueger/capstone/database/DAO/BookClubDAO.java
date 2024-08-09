package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.BookClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
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

}

