package com.challenge.point_of_interest.controller;

import com.challenge.point_of_interest.dto.PointOfInterestDto;
import com.challenge.point_of_interest.entity.PointOfInterest;
import com.challenge.point_of_interest.repository.PointOfInterestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point-of-interest")
public class PointOfInterestController {

    private final PointOfInterestRepository pointOfInterestRepository;

    public PointOfInterestController(PointOfInterestRepository pointOfInterestRepository) {
        this.pointOfInterestRepository = pointOfInterestRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createPointOfInterest(@RequestBody PointOfInterestDto pointOfInterestDto) {
        pointOfInterestRepository.save(new PointOfInterest(pointOfInterestDto.name(), pointOfInterestDto.x(), pointOfInterestDto.y()));
        return ResponseEntity.ok().build();
    }
}
