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
public class Order {
    private String from;
    private String to;
    private int capacity; // see vehicle capacity
    //TODO: add ability to custom filter allowed vehicles - by type, by specific number

    public Order(String from, String to, int capacity) {
        this.from = from;
        this.to = to;
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be non-zero and positive number. Received " + capacity);
        }
        this.capacity = capacity;
    }
            
}
