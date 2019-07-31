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
    public CommandLineRunner planLoader(PostPaidPlanRepository repo) {
        repo.deleteAll();
        return args -> {
            repo.save(new PostPaid("199INR","Monthly Plan","25 GB"));
            repo.save(new PostPaid("500INR","Monthly Plan","205 GB"));
            repo.save(new PostPaid("1500INR","Monthly Plan","1000 GB"));

        };
    }
}
