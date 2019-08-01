package com.example.voizfonica.data;

import com.example.voizfonica.model.DongleDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DongleRepository extends MongoRepository<DongleDomain,String> {

    List<DongleDomain> findByType(String type);
}
