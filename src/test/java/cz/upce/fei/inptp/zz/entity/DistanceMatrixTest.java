/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roman
 */
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
