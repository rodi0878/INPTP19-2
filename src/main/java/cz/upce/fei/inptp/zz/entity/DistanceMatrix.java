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
public class DistanceMatrix {

    private String[] locations;
    private double[][] distances;

    public DistanceMatrix(String[] locations, double[][] distances) {
        this.locations = locations;
        this.distances = distances;
    }
    
    public double get(String from, String to) {
        int f, t;

        f = getLocationIndex(from);
        t = getLocationIndex(to);
        
        return distances[f][t];
    }

    private int getLocationIndex(String value){
        for (int i = 0; i < locations.length; i++) {
            String location = locations[i];

            if (location.equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    
    
}
