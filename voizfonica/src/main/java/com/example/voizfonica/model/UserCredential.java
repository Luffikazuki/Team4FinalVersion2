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

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\.\\-]+)\\.([a-zA-Z]{2,5})$")
    private String emailId;

    @Pattern(regexp = "^([0-9]){12}$")
    private String aadharNumber;

    @NotNull
    @Size(max=10)
    @Pattern(regexp = "^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$", message = "Example AAAAA1234A")
    private String panNumber;


    private String requiredPlan;

    @NotEmpty(message = "Provide your address")
    @Length(max = 100,min = 20)
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getRequiredPlan() {
        return requiredPlan;
    }

    public void setRequiredPlan(String requiredPlan) {
        this.requiredPlan = requiredPlan;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Pattern(regexp = "^([1-9]){1}([0-9]){9}$")
    private String contactNumber;

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
}

