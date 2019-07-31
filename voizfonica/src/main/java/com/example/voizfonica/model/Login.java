package com.example.voizfonica.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Data
public class Login {

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\.\\-]+)\\.([a-zA-Z]{2,5})$")
    private String emailId;

    @NotEmpty(message = "Provide password")
    @Size(min=8,max=25)
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
}
