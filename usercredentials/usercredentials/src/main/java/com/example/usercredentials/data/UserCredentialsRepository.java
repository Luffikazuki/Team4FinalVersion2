package com.example.usercredentials.data;

import com.example.usercredentials.model.UserCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCredentialsRepository extends MongoRepository<UserCredentials,String> {
}
