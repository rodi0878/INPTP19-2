package cz.upce.fei.inptp.project.planner;

import cz.upce.fei.inptp.project.entity.Driver;
import cz.upce.fei.inptp.project.entity.Order;
import cz.upce.fei.inptp.project.entity.vehicle.Vehicle;
import cz.upce.fei.inptp.project.entity.vehicle.VehicleType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class PlanItemTest {
    
    public PlanItemTest() {
    }

    @Test(expected = RuntimeException.class)
    public void testAddOrderForNullValue() {
        Order order = null;
        PlanItem planItem = new PlanItem(new Vehicle("idVehicle", 4, VehicleType.Medium, 125), new Driver("idDriver"), "unknownLocation");
        planItem.addOrder(order);
    }
    
    @Test
    public void testAddOrderForNonNullValue() {
        Order order = new Order("A", "B", 4);
        PlanItem planItem = new PlanItem(new Vehicle("idVehicle", 4, VehicleType.Medium, 298), new Driver("idDriver"), "unknownLocation");
        planItem.addOrder(order);
        List<Order> list = planItem.getOrders();
        assertEquals(order, list.get(0));
    }

    @Test
    public void testAddOrderPossibleCapacity() {
        Order order = new Order("A", "B", 100);
        Vehicle vehicle = new Vehicle("idVehicle", 100, VehicleType.Medium, 100);
        Driver driver = new Driver("idDriver");
        PlanItem planItem = new PlanItem(vehicle, driver, "unknownLocation");
        planItem.addOrder(order);
        List<Order> list = planItem.getOrders();
        assertEquals(order, list.get(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddOrderImpossibleCapacity() {
        Order order = new Order("A", "B", 101);
        Vehicle vehicle = new Vehicle("idVehicle", 100, VehicleType.Medium, 100);
        Driver driver = new Driver("idDriver");
        PlanItem planItem = new PlanItem(vehicle, driver, "unknownLocation");
        planItem.addOrder(order);

        fail();
    }



    
    
}
