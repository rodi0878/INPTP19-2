/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

/**
 *
 * @author Roman
 */
public class Vehicle {
    private String identifier; // id should not be null
    private int capacity; // capacity should be nonzero and positive number
    private VehicleType type;
    // TODO:initial position?

    public Vehicle(String identifier, int capacity, VehicleType type) {
        this.identifier = identifier;
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
