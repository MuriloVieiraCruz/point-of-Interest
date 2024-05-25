package com.challenge.point_of_interest.conf;

import com.challenge.point_of_interest.entity.PointOfInterest;
import com.challenge.point_of_interest.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertPointsOfInterest implements CommandLineRunner {

    @Autowired
    private PointOfInterestRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.save(new PointOfInterest("Lanchonete", 27L, 12L));
        repository.save(new PointOfInterest("Posto", 31L, 18L));
        repository.save(new PointOfInterest("Joalheria", 15L, 12L));
        repository.save(new PointOfInterest("Floricultura", 19L, 21L));
        repository.save(new PointOfInterest("Pub", 12L, 8L));
        repository.save(new PointOfInterest("Supermercado", 23L, 6L));
        repository.save(new PointOfInterest("Churrascaria", 28L, 2L));
    }
}
