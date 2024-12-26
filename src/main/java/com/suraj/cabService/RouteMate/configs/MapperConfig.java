package com.suraj.cabService.RouteMate.configs;

import com.suraj.cabService.RouteMate.dto.PointDto;
import com.suraj.cabService.RouteMate.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();

        // here this will convert the PointDto to a Point
        mapper.typeMap(PointDto.class, Point.class).setConverter(context ->{
            PointDto pointDto = context.getSource();
            return GeometryUtil.createPoint(pointDto);
        });

        // Now here this will convert the Point to PointDto
        mapper.typeMap(Point.class, PointDto.class).setConverter(context->{
            Point point = context.getSource();
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };
            return new PointDto(coordinates);
        });

        return mapper;
    }
}

//explanation of above code-

// This code configures a ModelMapper to enable seamless conversions between PointDto and Point.
// PointDto is a lightweight Data Transfer Object used for API communication, containing latitude and longitude as a simple array.
// On the other hand, Point represents a geospatial object used for domain logic, such as geospatial computations or database storage.
// The PointDto is converted to Point for operations like distance calculation or routing, and then back to PointDto for client-friendly API responses.
// This separation of concerns ensures flexibility, simplifies client interactions, and abstracts internal geospatial logic, making the code maintainable and scalable.