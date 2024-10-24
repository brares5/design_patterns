package org.example.creational.builder;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestCar {
    @Test
    public void testCarWithAllFeatures() {
        Car car1 = new Car.Builder("V6", "Automatic", "Leather", "Pink")
                .setSunroof(true)
                .setSafetyPackage(true)
                .setGPS(true)
                .build();

        assertTrue(car1.toString().contains("Engine=V6"));
        assertTrue(car1.toString().contains("Transmission=Automatic"));
        assertTrue(car1.toString().contains("Sunroof=true"));
        assertTrue(car1.toString().contains("GPS=true"));
        assertTrue(car1.toString().contains("Safety Package=true"));
    }

    @Test
    public void testCarWithoutOptionalFeatures() {
        Car car = new Car.Builder("AAAAA", "Manual", "Plastic", "Black")
                .build();

        assertTrue(car.toString().contains("Engine=AAAAA"));
        assertTrue(car.toString().contains("Transmission=Manual"));
        assertTrue(car.toString().contains("Interior=Plastic"));
        assertTrue(car.toString().contains("Sunroof=false"));
        assertTrue(car.toString().contains("GPS=false"));
        assertTrue(car.toString().contains("Safety Package=false"));
    }

    @Test
    public void testCarWithPartialFeatures() {
        Car car = new Car.Builder("34534", "Manual", "Nice", "Blue")
                .setSunroof(true)
                .setSafetyPackage(true)
                .build();

        assertTrue(car.toString().contains("Engine=34534"));
        assertTrue(car.toString().contains("Transmission=Manual"));
        assertTrue(car.toString().contains("Sunroof=true"));
        assertTrue(car.toString().contains("GPS=false"));
        assertTrue(car.toString().contains("Safety Package=true"));
    }
}
