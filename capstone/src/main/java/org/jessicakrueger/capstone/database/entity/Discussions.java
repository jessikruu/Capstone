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
public class Discussions {

    @Id // this tells hibernate that this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this tells hibernate that the column is autoincremented
    @Column(name = "id")
    private Integer id;

    @Column(name = "club_id")
    private Integer clubId;

    @Column(name = "discussion_creator")
    private Integer discussionCreator;

    @Column(name = "body")
    private String body;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "title")
    private String title;
}
