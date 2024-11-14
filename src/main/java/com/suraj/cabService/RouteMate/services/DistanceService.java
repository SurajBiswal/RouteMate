package com.suraj.cabService.RouteMate.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    Double calculateDistance(Point src, Point dest);
}
