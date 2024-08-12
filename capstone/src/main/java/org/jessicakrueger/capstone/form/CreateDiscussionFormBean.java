package org.jessicakrueger.capstone.form;


import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CreateDiscussionFormBean {


    private Integer clubId;

    private Integer discussionCreator;

    private String body;

    private Date creationDate;

    private String title;
}
