package com.challenge.point_of_interest.service;

import com.challenge.point_of_interest.entity.PointOfInterest;
import com.challenge.point_of_interest.repository.PointOfInterestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointOfInterestService {

    private final PointOfInterestRepository pointOfInterestRepository;

    public PointOfInterestService(PointOfInterestRepository pointOfInterestRepository) {
        this.pointOfInterestRepository = pointOfInterestRepository;
    }


    public void createPointOfInterest(PointOfInterest pointOfInterest) {
        pointOfInterestRepository.save(pointOfInterest);
    }


    public Page<PointOfInterest> listAllPointsOfInterest(PageRequest pageRequest) {
        return pointOfInterestRepository.findAll(pageRequest);
    }


    public List<PointOfInterest> listPointsOfInterestNearMe(Long x, Long y, Long maxDistance) {
        Long MaxXDistance = x + maxDistance;
        Long MinXDistance = x - maxDistance;
        Long MaxYDistance = y + maxDistance;
        Long MinYDistance = y - maxDistance;

        return pointOfInterestRepository.findNearMe(MinXDistance, MaxXDistance, MinYDistance, MaxYDistance)
                .stream()
                .filter(pointOfInterest -> distanceBetweenTwoPoints(pointOfInterest.getX(), pointOfInterest.getY(), x, y) <= maxDistance)
                .toList();
    }

    private Double distanceBetweenTwoPoints(Long xA, Long yA, Long xB, Long yB) {
        return Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2));
    }
}
