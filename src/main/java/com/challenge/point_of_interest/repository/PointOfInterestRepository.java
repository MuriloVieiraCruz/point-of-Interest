package com.challenge.point_of_interest.repository;

import com.challenge.point_of_interest.entity.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

    @Query("SELECT p FROM PointOfInterest p "
            + "WHERE p.x >= :minXDistance AND p.x <= :maxXDistance AND p.y >= :minYDistance AND p.y <= :maxYDistance")
    List<PointOfInterest> findNearMe(Long minXDistance, Long maxXDistance, Long minYDistance, Long maxYDistance);
}
