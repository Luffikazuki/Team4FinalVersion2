package com.example.voizfonica.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@NoArgsConstructor(access= AccessLevel.PRIVATE,force=true)
@Document(collection="Orders Received")
public class Order {
    @Id
    private String id;
    



}