package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long> {
}
