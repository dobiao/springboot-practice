package com.souche.db.mappers;

import com.souche.db.dto.CarDto;
import com.souche.db.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by dubiao on 2017/9/30.
 */
@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    @Mapping(source = "type", target = "carType")
    CarDto carToCarDto(Car car);

}
