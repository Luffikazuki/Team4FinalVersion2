package com.payment.validcheck.Data;

import com.payment.validcheck.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment,String>{

}
