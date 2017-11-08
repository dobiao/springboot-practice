package com.souche.test;

import com.souche.db.mappers.CarMapper;
import com.souche.db.model.Car;
import com.souche.test.base.BaseTest;
import org.junit.Test;

/**
 * Created by dubiao on 2017/9/30.
 */
public class MappersTest extends BaseTest {


    @Test
    public void testMappers() {

        Car car = new Car();
        car.setMake("ion");
        car.setNumberOfSeats(4);
        car.setType("P");

        this.print(CarMapper.INSTANCE.carToCarDto(car));

    }
}
