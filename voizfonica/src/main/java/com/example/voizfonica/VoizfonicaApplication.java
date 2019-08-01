package com.example.voizfonica;


import com.example.voizfonica.data.PostPaidPlanRepository;
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
    }

