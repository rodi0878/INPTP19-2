package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.Driver;
import cz.upce.fei.inptp.zz.entity.Order;
import cz.upce.fei.inptp.zz.entity.Vehicle;
import cz.upce.fei.inptp.zz.entity.VehicleType;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlanItemTest {
    
    public PlanItemTest() {
    }

    @Test(expected = RuntimeException.class)
    public void testAddOrderForNullValue() {
        Order order = null;
        PlanItem planItem = new PlanItem(new Vehicle("idVehicle", 4, VehicleType.Medium), new Driver("idDriver"));
        planItem.addOrder(order);
    }
    
    @Test
    public void testAddOrderForNonNullValue() {
        Order order = new Order("A", "B", 4);
        PlanItem planItem = new PlanItem(new Vehicle("idVehicle", 4, VehicleType.Medium), new Driver("idDriver"));
        planItem.addOrder(order);
    }

    
    
}
