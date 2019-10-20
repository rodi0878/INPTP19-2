package cz.upce.fei.inptp.zz.entity;

public class DistanceMatrix {

    private String[] locations;
    private double[][] distances;

    public DistanceMatrix(String[] locations, double[][] distances) {
        this.locations = locations;
        this.distances = distances;
    }
    
    public double getDistanceBetweenLocations(String from, String to) {
        int fromIndex = getLocationIndex(from);
        int toIndex = getLocationIndex(to);
        
        return distances[fromIndex][toIndex];
    }

    private int getLocationIndex(String value) {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }
    
}
