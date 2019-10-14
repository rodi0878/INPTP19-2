package cz.upce.fei.inptp.zz.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author st52530
 */
public class VehicleTest {

    @Test(expected = NullPointerException.class)
    public void testInvalidIdentifier() {
        Vehicle vehicle = new Vehicle(null, 5, VehicleType.Small);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCapacity() {
        Vehicle vehicle = new Vehicle("id", -5, VehicleType.Small);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroCapacity() {
        Vehicle vehicle = new Vehicle("id", 0, VehicleType.Large);
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidType() {
        Vehicle vehicle = new Vehicle("id", 5, null);
    }

    @Test
    public void testVehicleCreation() {
        Vehicle vehicle = new Vehicle("id", 5, VehicleType.Medium);
        assertEquals("id", vehicle.getIdentifier());
        assertEquals(5, vehicle.getCapacity());
        assertEquals(VehicleType.Medium, vehicle.getType());
    }
    
}
