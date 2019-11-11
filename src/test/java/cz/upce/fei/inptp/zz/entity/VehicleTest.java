package cz.upce.fei.inptp.zz.entity;

import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTest {

    @Test(expected = NullPointerException.class)
    public void testInvalidIdentifier() {
        Vehicle vehicle = new Vehicle(null, 5, VehicleType.Small,7);
        
        assertNotNull(vehicle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCapacity() {
        Vehicle vehicle = new Vehicle("id", -5, VehicleType.Small,7);
        
        assertNotNull(vehicle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroCapacity() {
        Vehicle vehicle = new Vehicle("id", 0, VehicleType.Large,7);
        
        assertNotNull(vehicle);
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidType() {
        Vehicle vehicle = new Vehicle("id", 5, null,7);
        
        assertNotNull(vehicle);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativePricePerKilometer() {
        Vehicle vehicle = new Vehicle("id", -5, VehicleType.Small,-7);
        
        assertNotNull(vehicle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroPricePerKilometer() {
        Vehicle vehicle = new Vehicle("id", 0, VehicleType.Large,0);
        
        assertNotNull(vehicle);
    }

    @Test
    public void testVehicleCreation() {
        Vehicle vehicle = new Vehicle("id", 5, VehicleType.Medium,7);
        
        assertEquals("id", vehicle.getIdentifier());
        assertEquals(5, vehicle.getCapacity());
        assertEquals(VehicleType.Medium, vehicle.getType());
        assertEquals(7, vehicle.getPricePerKilometer());
    }
}
