package org.example.creational.builder;

// TODO implement logic
public class Car {
    private String engine;
    private String transmission;
    private String interior;
    private String color;
    private boolean hasSunroof;
    private boolean hasGPS;
    private boolean hasSafetyPackage;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.interior = builder.interior;
        this.color = builder.color;
        this.hasSunroof = builder.hasSunroof;
        this.hasGPS = builder.hasGPS;
        this.hasSafetyPackage = builder.hasSafetyPackage;
    }

    @Override
    public String toString() {
        return "Car [Engine=" + engine +
                ", Transmission=" + transmission +
                ", Interior=" + interior +
                ", Color=" + color +
                ", Sunroof=" + hasSunroof +
                ", GPS=" + hasGPS +
                ", Safety Package=" + hasSafetyPackage +
                "]";
    }

    public static class Builder {
        private String engine;
        private String transmission;
        private String interior;
        private String color;
        private boolean hasSunroof;
        private boolean hasGPS;
        private boolean hasSafetyPackage;

        public Builder(String engine, String transmission, String interior, String color) {
            this.engine = engine;
            this.transmission = transmission;
            this.interior = interior;
            this.color = color;
        }

        public Builder setSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public Builder setGPS(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        public Builder setSafetyPackage(boolean hasSafetyPackage) {
            this.hasSafetyPackage = hasSafetyPackage;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
