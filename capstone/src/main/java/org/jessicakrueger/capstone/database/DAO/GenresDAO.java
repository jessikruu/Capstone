package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.Genres;
import org.jessicakrueger.capstone.database.entity.MeetingLocations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresDAO extends JpaRepository<Genres, Long> {

    Genres findById(Integer id);
}
