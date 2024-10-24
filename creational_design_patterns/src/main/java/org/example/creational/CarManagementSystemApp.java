package org.example.creational;

import org.example.creational.builder.Car;
import org.example.creational.factory.Document;
import org.example.creational.factory.DocumentFactory;

public class CarManagementSystemApp {

    public static void main(String[] args) {
        Car car1 = new Car.Builder("V6", "Automatic", "Leather", "Pink")
                .setSunroof(true)
                .setSafetyPackage(true)
                .build();
        try {
            Document document = DocumentFactory.createDocument("HTML");
            document.open();
            document.createDocWithCarDetails(car1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid document type selected.");
        }
    }
}
