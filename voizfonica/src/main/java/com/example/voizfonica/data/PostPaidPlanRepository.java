package com.example.voizfonica.data;

import com.example.voizfonica.model.PostPaid;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostPaidPlanRepository extends MongoRepository<PostPaid,String> {
}
