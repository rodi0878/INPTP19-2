package cz.upce.fei.inptp.project.planner;

import cz.upce.fei.inptp.project.entity.Driver;
import cz.upce.fei.inptp.project.entity.Order;
import cz.upce.fei.inptp.project.entity.matrix.DistanceMatrix;
import cz.upce.fei.inptp.project.entity.vehicle.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlanItemPriceCalculatorTest {

    private static final double epsilon = 0.01;

    private PlanItemPriceCalculator preparePlanItemPriceCalculator() {
        String[] locations = {"A", "B", "C", "D"};
        double[][] distances = {
            {0, 1, 2, 3},
            {1, 0, 4, 5},
            {2, 4, 0, 6},
            {3, 5, 6, 0}
        };

        return new PlanItemPriceCalculator(new DistanceMatrix(locations, distances));
    }

    @Test
    public void testCalculatePriceEmptyOrders() {     
        PlanItemPriceCalculator planItemPriceCalculator = preparePlanItemPriceCalculator();
        Vehicle vehicle = new Vehicle("id", 4, VehicleType.Small,6);
        Driver driver = new Driver("driver");
        PlanItem planItem = new PlanItem(vehicle, driver, "B");

        double price = planItemPriceCalculator.calculatePrice(planItem);
        assertEquals(0, price, epsilon);
    }

    @Test
    public void testCalculatePrice() {     
        PlanItemPriceCalculator planItemPriceCalculator = preparePlanItemPriceCalculator();
        Vehicle vehicle = new Vehicle("id", 4, VehicleType.Small,6);
        Driver driver = new Driver("driver");
        PlanItem planItem = new PlanItem(vehicle, driver,"A");
        planItem.addOrder(new Order("A", "C", 2));

        double price = planItemPriceCalculator.calculatePrice(planItem);
        double distance = 2;
        double pricePerKilometer = 6;
        double expectedValue = distance * pricePerKilometer;
        assertEquals(expectedValue, price, epsilon);
    } 

    @Test
    public void testCalculatePrice1() {     
        PlanItemPriceCalculator planItemPriceCalculator = preparePlanItemPriceCalculator();
        Vehicle vehicle = new Vehicle("id", 4, VehicleType.Small,6);
        Driver driver = new Driver("driver");
        PlanItem planItem = new PlanItem(vehicle, driver,"B");
        planItem.addOrder(new Order("A", "C", 2));

        double price = planItemPriceCalculator.calculatePrice(planItem);
        double distanceFromBToA = 1;
        double distanceFromAToC = 2;
        double distance = distanceFromBToA + distanceFromAToC;
        double pricePerKilometer = 6;
        double expectedValue = distance * pricePerKilometer;
        assertEquals(expectedValue, price, epsilon);
    }
}
