package com.example.voizfonica.model;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Dongle Plans")
public class DongleDomain {

    @Id
    private  String id;

    private final  String dongleMoney;
    private final  String dongleValidity;
    private final  String dongleBenefits;
    private final String type;

    public String getId() {
        return id;
    }

    public String getDongleMoney() {
        return dongleMoney;
    }

    public String getDongleValidity() {
        return dongleValidity;
    }

    public String getDongleBenefits() {
        return dongleBenefits;
    }

    public String getType() {
        return type;
    }
}
