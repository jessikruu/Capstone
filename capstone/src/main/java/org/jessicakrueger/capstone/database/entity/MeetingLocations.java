package org.jessicakrueger.capstone.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ToString.Exclude
    @OneToMany(mappedBy = "meetingLocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookClub> bookClubs;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "description")
    private String description;
}
