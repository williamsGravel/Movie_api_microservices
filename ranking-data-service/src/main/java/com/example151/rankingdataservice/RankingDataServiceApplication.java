package com.example151.rankingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RankingDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RankingDataServiceApplication.class, args);
    }

}
