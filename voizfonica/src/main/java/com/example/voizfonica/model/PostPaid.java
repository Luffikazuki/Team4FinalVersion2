package com.example.voizfonica.model;

import lombok.AccessLevel;
import java.lang.String;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE,force=true)
@Document(collection="Postpaid_plans")
public class PostPaid {
    @Id
    private final String id;
    private final String planMoney;
    private final String validity;
    private final String benefits;
}
