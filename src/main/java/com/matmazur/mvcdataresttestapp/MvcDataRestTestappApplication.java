package com.matmazur.mvcdataresttestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcDataRestTestappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcDataRestTestappApplication.class, args);


        StringBuilder jobFinder = new StringBuilder()
                .append("Junior Java developer")
                .append("looking for a job")
                .append("GDANSK");

        System.out.println(jobFinder);
    }
}

