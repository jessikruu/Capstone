package org.jessicakrueger.capstone.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discussions")
public class Discussion {

    @Id // this tells hibernate that this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this tells hibernate that the column is autoincremented
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private BookClub bookClub;

    @Column(name = "club_id", insertable = false, updatable = false)
    private Integer clubId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussion_creator")
    private User discussionCreatorUser;

    @Column(name = "discussion_creator", insertable = false, updatable = false)
    private Integer discussionCreatorId;

    @Column(name = "body")
    private String body;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "title")
    private String title;
}
