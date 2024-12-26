package com.suraj.cabService.RouteMate.utils;

import com.suraj.cabService.RouteMate.dto.PointDto;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

public class GeometryUtil {
    public static Point createPoint(PointDto pointDto) {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        Coordinate coordinate = new Coordinate(pointDto.getCoordinates()[0], pointDto.getCoordinates()[1]);
        return geometryFactory.createPoint(coordinate);
    }

}


//  Explanation of above code-

//    The GeometryUtil class provides a utility method createPoint to convert a PointDto into a Point object.
//    It uses a GeometryFactory with SRID 4326 (WGS84) to create a Point for geospatial operations.
//    The method extracts the first coordinate twice to form a Coordinate for the Point.