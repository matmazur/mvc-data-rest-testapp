package com.matmazur.mvcdataresttestapp;

import com.matmazur.mvcdataresttestapp.model.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcDataRestTestappApplication {

    public static void main(String[] args) {

        SpringApplication.run(MvcDataRestTestappApplication.class, args);


        City city = City.builder().withName("Sochaczew").withPopulation(432432L).build();
        System.out.println(city);

    }

}

