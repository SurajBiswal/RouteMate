package com.suraj.cabService.RouteMate.repositories;

import com.suraj.cabService.RouteMate.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//ST_Distance(point1, point2)            // distance from current location to destination of rider
//ST_DWithin(point1, 10000)               // find driver within distance of 10km from rider

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance " +
            "FROM driver d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) "+
            "ORDER BY distance "+
            "LIMIT 10" , nativeQuery = true
    )
    List<Driver> findTenNearestDrivers(Point pickupLocation);

    @Query(value = "SELECT d.* "+
            "FROM driver d "+
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 15000) "+
            "ORDER BY d.rating DESC "+
            "LIMIT 10" , nativeQuery = true)
    List<Driver> findTenNearbyTopRatedDrivers(Point pickupLocation);
}


//    This repository fetches the 10 nearest available drivers to a rider's pickup location using geospatial functions from PostGIS.
//    The query calculates the distance between the rider's pickup point and each driver's current location (ST_Distance),
//    filters drivers within a 10 km radius (ST_DWithin),
//    and sorts them by proximity.
//    Only available drivers (available = true) are considered, and the results are limited to 10 drivers for efficiency.
//    The current_location column in the drivers table stores geospatial data, optimized using spatial indexing.
//    This method ensures accurate, performant matching of drivers for ride-hailing applications.