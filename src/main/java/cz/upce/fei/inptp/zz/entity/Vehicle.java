/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.Objects;

/**
 *
 * @author Roman
 */
public class Vehicle {
    private String identifier;
    private int capacity; // capacity should be nonzero and positive number
    private VehicleType type;
    // TODO:initial position?

    public Vehicle(String identifier, int capacity, VehicleType type) {
        this.identifier = Objects.requireNonNull(identifier, "id should not be null!");
        this.capacity = capacity;
        this.type = type;
    }
  
    public String getIdentifier() {
        return identifier;
    }

    public int getCapacity() {
        return capacity;
    }
    
    
    
}
