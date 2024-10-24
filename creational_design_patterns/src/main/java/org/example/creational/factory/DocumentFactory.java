package org.example.creational.factory;


import org.example.creational.builder.Car;

class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("PDF Document opened.");
    }

    @Override
    public void createDocWithCarDetails(Car car) {
        System.out.println("Creating PDF Document: " + car.toString());
    }
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Word Document opened.");
    }

    @Override
    public void createDocWithCarDetails(Car car) {
        System.out.println("Creating Word Document: " + car.toString());
    }
}

class HTMLDocument implements Document {
    @Override
    public void open() {
        System.out.println("HTML Document opened.");
    }

    @Override
    public void createDocWithCarDetails(Car car) {
        System.out.println("Creating HTML Document: " + car.toString());
    }
}

public class DocumentFactory {

    public static Document createDocument(String type) {
        switch (type) {
            case "PDF":
                return new PDFDocument();
            case "Word":
                return new WordDocument();
            case "HTML":
                return new HTMLDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}
