package cz.upce.fei.inptp.project.entity.vehicle;

import java.util.Objects;

public class Vehicle {

    private final String identifier;

    private final int capacity;

    private final VehicleType type;

    private final int pricePerKilometer;
    // TODO:initial position?

    /**
     * 
     * @param capacity has to be a positive number.
     * @param pricePerKilometer has to be a positive number.
     */
    public Vehicle(String identifier, int capacity, VehicleType type, int pricePerKilometer) {
        this.identifier = Objects.requireNonNull(identifier, "id should not be null!");
        if (capacity <= 0) {
            String errorMessage = "Capacity should be non-zero and positive number. Received " + capacity;
            throw new IllegalArgumentException(errorMessage);
        }
        this.capacity = capacity;
        this.type = Objects.requireNonNull(type, "type should not be null!");
        if (pricePerKilometer <= 0) {
            String errorMessage = "Price per kilometer should be non-zero and positive number. Received " + pricePerKilometer;
            throw new IllegalArgumentException(errorMessage);
        }
        this.pricePerKilometer = pricePerKilometer;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public VehicleType getType() {
        return type;
    }

    public int getPricePerKilometer() {
        return pricePerKilometer;
    }
}
