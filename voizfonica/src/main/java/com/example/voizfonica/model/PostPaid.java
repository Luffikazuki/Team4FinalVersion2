package com.example.voizfonica.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import java.lang.String;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@NoArgsConstructor(access= AccessLevel.PRIVATE,force=true)
@Document(collection="Postpaid_plans")
public class PostPaid {
    @Id
    private String id;
    private final String postMoney;
    private final String validity;
    private final String benefits;

    @JsonCreator

    @PersistenceConstructor
    public PostPaid(@JsonProperty("postMoney") final String postMoney, @JsonProperty("validity") final String validity, @JsonProperty("benefits") final String benefits) {
        this.postMoney = postMoney;
        this.validity = validity;
        this.benefits=benefits;
    }
}
