package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
