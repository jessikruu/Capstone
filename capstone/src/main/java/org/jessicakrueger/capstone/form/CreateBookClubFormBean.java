package org.jessicakrueger.capstone.form;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jessicakrueger.capstone.database.entity.User;

@Getter
@Setter
@ToString
public class CreateBookClubFormBean {


    private Integer bookClubId;

    private String clubName;

    private String genre;

    private Integer bookId;

    private Integer createdBy;

    private Integer meetingLocationId;

}
