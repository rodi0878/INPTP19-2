package cz.upce.fei.inptp.project.entity;

import cz.upce.fei.inptp.project.entity.matrix.DistanceMatrix;
import org.junit.Test;
import static org.junit.Assert.*;

public class DistanceMatrixTest {

    public DistanceMatrixTest() {
    }

    private DistanceMatrix prepareDistanceMatrix() {
        String[] locations = {"A", "B", "C", "D"};
        double[][] distances = {
            {0, 1, 2, 3},
            {10, 0, 1, 2},
            {20, 10, 0, 1},
            {10, 10, 10, 1}
        };

        return new DistanceMatrix(locations, distances);
    }

    @Test
    public void testGetDistanceFromLocAToLocB() {
        DistanceMatrix dm = prepareDistanceMatrix();

        double actual = dm.getDistanceBetweenLocations("A", "B");

        assertEquals(1, actual, 0.01);
    }

    @Test(expected = RuntimeException.class)
    public void testGetDistanceFromUnknownToLocA() {
        DistanceMatrix dm = prepareDistanceMatrix();

        double actual = dm.getDistanceBetweenLocations("unkown", "B");

        fail();
    }
}
