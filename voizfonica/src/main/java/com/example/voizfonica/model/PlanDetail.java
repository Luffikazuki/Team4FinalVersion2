package com.example.voizfonica.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document
public class PlanDetail {
    @Id
    private String id;

    @NotNull
    private String planName;

    @NotNull
    private String planData;

    @NotNull
    private String planValidity;

    @NotNull
    private String type;

    public String getPlanData(){
        return planData;
    }
    public String getId() {
        return id;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanValidity() {
        return planValidity;
    }

    public String getType() {
        return type;
    }
}
