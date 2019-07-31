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
        return args -> {
            repo.save(new PostPaid("3G/4G[1.5GB/DAY]","199INR","Monthly Plan","25 GB"));

        };
    }
}
