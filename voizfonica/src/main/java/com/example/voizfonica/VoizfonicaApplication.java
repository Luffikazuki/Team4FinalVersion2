package com.example.voizfonica;

import com.example.voizfonica.data.DongleRepository;
import com.example.voizfonica.data.PostPaidPlanRepository;
import com.example.voizfonica.model.DongleDomain;
import com.example.voizfonica.model.PostPaid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class VoizfonicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoizfonicaApplication.class, args);
    }

    @Bean
    public CommandLineRunner dongleLoader(DongleRepository dongleRepo) {
        dongleRepo.deleteAll();
        return args -> {
            dongleRepo.save(new DongleDomain("199INR","Monthly Plan","10 GB"));
            dongleRepo.save(new DongleDomain("250INR","Monthly Plan","25 GB"));
            dongleRepo.save(new DongleDomain("505INR","Monthly Plan","205 GB"));
            dongleRepo.save(new DongleDomain("1520INR","Monthly Plan","1000 GB"));

        };
    }
    }

