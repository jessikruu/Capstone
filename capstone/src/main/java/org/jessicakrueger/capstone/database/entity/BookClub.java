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
@Table(name = "book_clubs")
public class BookClub {

    @Id // this tells hibernate that this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this tells hibernate that the column is autoincremented
    @Column(name = "id")
    private Integer id;

//    @ToString.Exclude
//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Customer> customers;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "created_by", nullable = true)
    private User user;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "meeting_location_id", nullable = true)
    private MeetingLocations MeetingLocation;

//    @Column(name = "office_id",insertable = false, updatable = false)
//    private Integer officeId;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "genre")
    private String genre;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "created_by" ,insertable = false, updatable = false)
    private Integer createdBy;

    @Column(name = "meeting_location_id", insertable=false, updatable=false)
    private Integer meetingLocationId;

//    @Column(name = "")
//    private Integer ;



}
