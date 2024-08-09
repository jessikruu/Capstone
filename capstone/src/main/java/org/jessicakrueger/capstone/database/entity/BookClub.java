package org.jessicakrueger.capstone.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_clubs")
public class BookClub {

    @Id // this tells hibernate that this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this tells hibernate that the column is autoincremented
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "created_by", nullable = true)
    private User user;

    @Column(name = "created_by" ,insertable = false, updatable = false)
    private Integer createdBy;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "meeting_location_id", nullable = true)
    private MeetingLocations meetingLocation;

    @Column(name = "meeting_location_id", insertable=false, updatable=false)
    private Integer meetingLocationId;

    @Column(name = "club_name")
    private String clubName;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "genre_id", nullable = true)
    private Genres genre;

    @Column(name = "genre_id", insertable=false, updatable=false)
    private Integer genreId;

    @Column(name = "book_id")
    private Integer bookId;


    @Column(name = "description")
    private String description;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;


}
