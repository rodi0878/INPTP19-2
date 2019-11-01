package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.Driver;
import cz.upce.fei.inptp.zz.entity.Vehicle;
import cz.upce.fei.inptp.zz.entity.VehicleType;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomas
 */
public class PlanTest {

    @Test
    public void testGetPlanEmpty() {
        Plan plan = new Plan();
        List<PlanItem> planItems = plan.getPlan();
        assertEquals(0, planItems.size());
    }

    @Test
    public void testAddNewVehiclePlan() {
        Vehicle vehicle = new Vehicle("id", 10, VehicleType.Large);
        Driver driver = new Driver("driver");
        
        Plan plan = new Plan();
        plan.addNewVehiclePlan(vehicle, driver);
        List<PlanItem> planItems = plan.getPlan();
        assertEquals(1, planItems.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNewVehiclePlanDuplicateDriver() {
        Vehicle vehicle = new Vehicle("id", 10, VehicleType.Large);
        Vehicle vehicle2 = new Vehicle("id2", 5, VehicleType.Medium);
        Driver driver = new Driver("driver");
        
        Plan plan = new Plan();
        plan.addNewVehiclePlan(vehicle, driver);
        plan.addNewVehiclePlan(vehicle2, driver);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNewVehiclePlanDuplicateVehicle() {
        Vehicle vehicle = new Vehicle("id", 10, VehicleType.Large);
        Driver driver = new Driver("driver");
        Driver driver2 = new Driver("driver2");
        
        Plan plan = new Plan();
        plan.addNewVehiclePlan(vehicle, driver);
        plan.addNewVehiclePlan(vehicle, driver2);
    }
    
}
