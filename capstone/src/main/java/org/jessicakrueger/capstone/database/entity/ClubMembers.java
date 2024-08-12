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
@Table(name = "club_members")
public class ClubMembers {

    @Id // this tells hibernate that this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this tells hibernate that the column is autoincremented
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_id", insertable=false, updatable=false)
    private Integer userId;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "club_id")
    private BookClub bookClub;

    @Column(name = "club_id", insertable=false, updatable=false)
    private Integer clubId;

    @Column(name = "join_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }
}
