package cz.upce.fei.inptp.project.planner;

import cz.upce.fei.inptp.project.entity.Driver;
import cz.upce.fei.inptp.project.entity.vehicle.Vehicle;
import cz.upce.fei.inptp.project.entity.vehicle.VehicleType;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlanTest {

    @Test
    public void testGetPlanEmpty() {
        Plan plan = new Plan();
        List<PlanItem> planItems = plan.getPlanItems();
        assertEquals(0, planItems.size());
    }

    @Test
    public void testAddNewVehiclePlan() {
        Vehicle vehicle = new Vehicle("id", 10, VehicleType.Large,5);
        Driver driver = new Driver("driver");
        
        Plan plan = new Plan();
        plan.addNewVehiclePlan(vehicle, driver, "unknownLocation");
        List<PlanItem> planItems = plan.getPlanItems();
        assertEquals(1, planItems.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNewVehiclePlanDuplicateDriver() {
        Vehicle vehicle = new Vehicle("id", 10, VehicleType.Large,5);
        Vehicle vehicle2 = new Vehicle("id2", 5, VehicleType.Medium,5);
        Driver driver = new Driver("driver");
        
        Plan plan = new Plan();
        plan.addNewVehiclePlan(vehicle, driver, "unknownLocation");
        plan.addNewVehiclePlan(vehicle2, driver, "unknownLocation");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNewVehiclePlanDuplicateVehicle() {
        Vehicle vehicle = new Vehicle("id", 10, VehicleType.Large,5);
        Driver driver = new Driver("driver");
        Driver driver2 = new Driver("driver2");
        
        Plan plan = new Plan();
        plan.addNewVehiclePlan(vehicle, driver, "unknownLocation");
        plan.addNewVehiclePlan(vehicle, driver2, "unknownLocation");
    }
    
}
