package cz.upce.fei.inptp.project.planner;

import cz.upce.fei.inptp.project.entity.Driver;
import cz.upce.fei.inptp.project.entity.Order;
import cz.upce.fei.inptp.project.entity.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlanItem {

    private Vehicle vehicle;
    private Driver driver;

    private List<Order> orders;
    private String vehicleStartingLocation;

    public PlanItem(Vehicle vehicle, Driver driver, String vehicleStartingLocation) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.orders = new ArrayList<>();
        this.vehicleStartingLocation = vehicleStartingLocation;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        Objects.requireNonNull(order, "Order cannot be null");
        orders.add(order);
    }

    public String getVehicleStartingLocation() {
        return vehicleStartingLocation;
    }

}
