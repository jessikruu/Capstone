package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.BookClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookClubDAO extends JpaRepository<BookClub, Long> {

    @Query("select b from BookClub b where lower(b.clubName) like concat('%', :name, '%') ")
    List<BookClub> findBySearchTerm(String name);

    BookClub findById(Integer id);
}
