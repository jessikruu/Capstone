package org.jessicakrueger.capstone.database.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meeting_locations")
public class MeetingLocations {

    @Id // this tells hibernate that this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this tells hibernate that the column is autoincremented
    @Column(name = "id")
    private Integer id;

    @Column(name = "meeting_location")
    private String meetingLocation;

    @Column(name = "description")
    private String description;
}
