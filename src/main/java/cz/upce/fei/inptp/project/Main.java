package cz.upce.fei.inptp.project;

import cz.upce.fei.inptp.project.entity.matrix.DistanceMatrix;
import cz.upce.fei.inptp.project.entity.matrix.DistanceMatrixLoader;

/**
 * VRP planner. Simple application to solve basic VRP. More will come later...
 * 
 */
public class Main {
    public static void main(String[] args) {
        DistanceMatrixLoader dml = new DistanceMatrixLoader("matrix1.csv");
        DistanceMatrix dm = dml.load();
        
        System.out.println("A-C " + dm.getDistanceBetweenLocations("A", "C"));
        System.out.println("B-E " + dm.getDistanceBetweenLocations("B", "E"));
        System.out.println("D-D " + dm.getDistanceBetweenLocations("D", "D"));
    }
}
