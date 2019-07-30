package com.example.voizfonica.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Data
@Document
public class UserCredential {

    @Id
    private String id;

    @NotNull
    @Size(min=5, message = "Name must of atleast of length 5")
    private String userName;

    @NotEmpty(message = "Provide password")
    @Size(min=8,max=25)
    private String password;

    @Email
    private String emailId;

    @Size(max=12)
    private String aadharNumber;

    @NotNull
    @Size(max=10)
    @Pattern(regexp = "^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$", message = "Example AAAAA1234A")
    private String panNumber;

    @NotNull
    private String requiredPlan;

    @NotEmpty(message = "Provide your address")
    @Length(max = 100,min = 20)
    private String address;


    @Digits(integer = 10,fraction = 0, message = "Must of size 10 numbers")
    private long contactNumber;
}

