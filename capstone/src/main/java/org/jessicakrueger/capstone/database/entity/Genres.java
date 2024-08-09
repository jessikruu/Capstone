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
@Table(name = "genres")
public class Genres {

    @Id // this tells hibernate that this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this tells hibernate that the column is autoincremented
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookClub> bookClubsByGenre;

    @Column(name = "genre_name")
    private String genreName;

    @Column(name = "description")
    private String description;
}
