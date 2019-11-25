package cz.upce.fei.inptp.project.planner;

import cz.upce.fei.inptp.project.entity.Driver;
import cz.upce.fei.inptp.project.entity.Order;
import cz.upce.fei.inptp.project.entity.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;

class PlanItem {

    private Vehicle vehicle;
    private Driver driver;

    private List<Order> orders;

    public PlanItem(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.orders = new ArrayList<>();
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
        orders.add(order);
    }
    
    
}
