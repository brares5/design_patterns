package org.example.creational;

import org.example.creational.builder.Car;

public class CarConfiguration {

    public static void main(String[] args) {
        Car car1 = new Car.Builder("V6", "Automatic", "Leather", "Pink")
                .setSunroof(true)
                .setSafetyPackage(true)
                .build();
        System.out.println(car1);

        Car car2 = new Car.Builder("ABCDE", "Manual", "Plastic", "Black")
                .setGPS(true)
                .build();
        System.out.println(car2);

        Car car3 = new Car.Builder("XYZ", "Automatic", "Leather", "White")
                .setSunroof(true)
                .setGPS(true)
                .setSafetyPackage(true)
                .build();
        System.out.println(car3);
    }
}
