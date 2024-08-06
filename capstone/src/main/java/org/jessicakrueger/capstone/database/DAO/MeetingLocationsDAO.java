package org.jessicakrueger.capstone.database.DAO;

import org.jessicakrueger.capstone.database.entity.MeetingLocations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingLocationsDAO extends JpaRepository<MeetingLocations, Long> {

    MeetingLocations findById(Integer Id);

}
