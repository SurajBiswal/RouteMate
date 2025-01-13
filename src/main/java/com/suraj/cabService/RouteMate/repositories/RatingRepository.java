package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.Driver;
import com.suraj.cabService.RouteMate.entities.Rating;
import com.suraj.cabService.RouteMate.entities.Ride;
import com.suraj.cabService.RouteMate.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    List<Rating> findByRider(Rider rider);
    List<Rating> findByDriver(Driver driver);

    Optional<Rating> findByRide(Ride ride);
}
