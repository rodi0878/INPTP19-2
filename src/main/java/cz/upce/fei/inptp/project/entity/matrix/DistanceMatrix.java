package cz.upce.fei.inptp.project.entity.matrix;

import java.util.HashMap;
import java.util.Map;

public class DistanceMatrix {

    private Map<String, Integer> locations;
    private double[][] distances;

    public DistanceMatrix(String[] locations, double[][] distances) {
        this.locations = new HashMap<>();
        for (int i = 0; i < locations.length; i++) {
            this.locations.put(locations[i], i);
        }
        this.distances = distances;
    }
    
    public double getDistanceBetweenLocations(String from, String to) {
        int fromIndex = getLocationIndex(from);
        int toIndex = getLocationIndex(to);
        
        return distances[fromIndex][toIndex];
    }

    private int getLocationIndex(String value) {
        Integer index = locations.get(value);
        return index == null ? -1 : index;
    }
    
}
