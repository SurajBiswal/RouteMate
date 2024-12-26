package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {

}
