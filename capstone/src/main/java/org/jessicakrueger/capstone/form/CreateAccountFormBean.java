package org.jessicakrueger.capstone.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAccountFormBean {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @AssertTrue(message="sorry, you gotta be human to ride this ride")
    private boolean human;

    @AssertTrue(message = "SKINWALKER!!!!!!")
    private boolean sure;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private Integer zipCode;

    @NotEmpty
    private String username;


}


