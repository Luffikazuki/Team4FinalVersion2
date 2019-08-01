package com.example.voizfonica;

import com.example.voizfonica.data.DongleRepository;
import com.example.voizfonica.model.DongleDomain;
import com.example.voizfonica.data.PostPaidPlanRepository;
import com.example.voizfonica.model.PostPaid;
import com.example.voizfonica.data.PrePaidRepository;
import com.example.voizfonica.model.PrePaid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class VoizfonicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoizfonicaApplication.class, args);
    }
        
    //Postpaid Database
    @Bean
    public CommandLineRunner postLoader(PostPaidPlanRepository postRepo) {
        postRepo.deleteAll();
        return args -> {
            postRepo.save(new PostPaid("199INR","Monthly Plan","100 GB", "THREEG"));
            postRepo.save(new PostPaid("599INR","Monthly Plan","250 GB","THREEG"));
            postRepo.save(new PostPaid("899INR","Yearly Plan","500 GB","THREEG"));
            postRepo.save(new PostPaid("1500INR","Monthly Plan","205 GB","FOURG"));
            postRepo.save(new PostPaid("3300INR","Monthly Plan","505 GB","FOURG"));
            postRepo.save(new PostPaid("5500INR","Yearly Plan","1001 GB","FOURG"));

        };
    }
    
    
    //Dongle Database
    @Bean
    public CommandLineRunner dongleLoader(DongleRepository dongleRepo) {
        dongleRepo.deleteAll();
        return args -> {
            dongleRepo.save(new DongleDomain("199INR", "28 Days", "10 GB", "3G"));
            dongleRepo.save(new DongleDomain("250INR", "28 Days", "25 GB", "3G"));
            dongleRepo.save(new DongleDomain("500INR", "48 Days", "100 GB", "3G"));
            dongleRepo.save(new DongleDomain("1250INR", "96 Days", "250 GB", "3G"));
            dongleRepo.save(new DongleDomain("99INR", "28 Days", "205 GB", "4G"));
            dongleRepo.save(new DongleDomain("299INR", "28 Days", "1000 GB", "4G"));
            dongleRepo.save(new DongleDomain("505INR", "48 Days", "205 GB", "4G"));
            dongleRepo.save(new DongleDomain("1520INR", "96 Days", "1000 GB", "4G"));

        };
    }
    
    
    //Prepaid Database
    @Bean
    public CommandLineRunner planLoader(PrePaidRepository repo) {
        repo.deleteAll();
        return args -> {
            repo.save(new PrePaid("1500 INR","365 Days","547.5 GB", "THREE"));
            repo.save(new PrePaid("400 INR","84 Days","126 GB", "THREE"));
            repo.save(new PrePaid("28 INR","28 Days","42 GB" , "THREE"));


            repo.save(new PrePaid("198 INR","28 Days","56 GB", "FOUR"));
            repo.save(new PrePaid("400 INR","78 Days","140 GB", "FOUR"));
            repo.save(new PrePaid("448 INR","84 Days","168 GB", "FOUR"));
        };
    }
    
    }

