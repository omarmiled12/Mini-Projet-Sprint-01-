package com.omar.tvs;

import com.omar.tvs.entities.Tv;
import com.omar.tvs.service.TvService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TvsApplication implements CommandLineRunner {

    @Autowired
    private TvService tvService;

    public static void main(String[] args) {
        SpringApplication.run(TvsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        tvService.saveTv(new Tv("55 inch", 499.99, "4K UHD", "Samsung OLED TV",  new Date()));
        tvService.saveTv(new Tv("65 inch", 799.99, "8K", "LG QLED TV", new Date()));
        tvService.saveTv(new Tv("43 inch", 299.99, "Full HD", "Sony LED TV", new Date()));
    }
}
