package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.Driver;
import cz.upce.fei.inptp.zz.entity.Order;
import cz.upce.fei.inptp.zz.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        Objects.requireNonNull(order, "Order cannot be null");
        orders.add(order);
    }
    
    
}
