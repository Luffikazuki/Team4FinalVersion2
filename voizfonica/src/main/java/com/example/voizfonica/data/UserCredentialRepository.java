package com.example.voizfonica.data;

import com.example.voizfonica.model.UserCredential;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCredentialRepository extends MongoRepository<UserCredential,String> {

}
