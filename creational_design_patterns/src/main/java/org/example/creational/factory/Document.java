package org.example.creational.factory;

import org.example.creational.builder.Car;

public interface Document {
    void open();
    void createDocWithCarDetails(Car car);
}
