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
    private String identifier;
    private int capacity; // capacity should be nonzero and positive number
    private VehicleType type;
    // TODO:initial position?

    public Vehicle(String identifier, int capacity, VehicleType type) {
        setIdentifier(identifier);
        this.capacity = capacity;
        this.type = type;
    }
  
    public String getIdentifier() {
        return identifier;
    }

    private void setIdentifier(String identifier) {
        if ((identifier == null) || (identifier.isEmpty())) {
            throw new NullPointerException("id should not be null!");
        }

        this.identifier = identifier;
    }

    public int getCapacity() {
        return capacity;
    }
    
    
    
}
