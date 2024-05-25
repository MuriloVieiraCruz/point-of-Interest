package com.challenge.point_of_interest.controller;

import com.challenge.point_of_interest.dto.PointOfInterestDto;
import com.challenge.point_of_interest.entity.PointOfInterest;
import com.challenge.point_of_interest.repository.PointOfInterestRepository;
import com.challenge.point_of_interest.service.PointOfInterestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/point-of-interest")
public class PointOfInterestController {

    private final PointOfInterestService pointOfInterestService;

    public PointOfInterestController(PointOfInterestService pointOfInterestService) {
        this.pointOfInterestService = pointOfInterestService;
    }


    @PostMapping("/create")
    public ResponseEntity<Void> createPointOfInterest(@RequestBody PointOfInterestDto pointOfInterestDto) {
        pointOfInterestService.createPointOfInterest(new PointOfInterest(pointOfInterestDto.name(), pointOfInterestDto.x(), pointOfInterestDto.y()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<Page<PointOfInterest>> listPointOfInterest(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<PointOfInterest> pointOfInterests = pointOfInterestService.listAllPointsOfInterest(PageRequest.of(page, pageSize));
        return ResponseEntity.ok(pointOfInterests);
    }

    @GetMapping("/find/locations/near-me")
    public ResponseEntity<List<PointOfInterest>> findLocationsNearMe(@RequestParam(name = "x") Long x,
                                                                     @RequestParam(name = "y") Long y,
                                                                     @RequestParam(name = "max-distance") Long maxDistance) {

        List<PointOfInterest> body = pointOfInterestService.listPointsOfInterestNearMe(x, y, maxDistance);
        return ResponseEntity.ok(body);
    }


}
