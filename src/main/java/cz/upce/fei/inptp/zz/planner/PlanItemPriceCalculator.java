package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.DistanceMatrix;
import cz.upce.fei.inptp.zz.entity.Order;
import java.util.HashSet;
import java.util.List;

public class PlanItemPriceCalculator {
    
    DistanceMatrix dm;

    public PlanItemPriceCalculator(DistanceMatrix dm) {
        this.dm = dm;
    }
 
    public double calculatePrice(PlanItem planItem) {
        List<Order> orders = planItem.getOrders();
        // TODO: tests
        String currentLocation = orders.get(0).getFrom();
        HashSet<Order> loadedOrders = new HashSet<>();
        int price = 0;
        for (int i = 0; i < orders.size(); i++) {
            Order currentOrder = orders.get(i);
        
            boolean loading = true;
            if (loadedOrders.contains(currentOrder)) {
                loading = false;
            }
            
            String currentOrderLocation = loading ? currentOrder.getFrom() : currentOrder.getTo();
            
            if (!currentLocation.equals(currentOrderLocation)) {
                price += dm.getDistanceBetweenLocations(currentLocation, currentOrderLocation);
                price *= planItem.getVehicle().getPricePerKilometer();
            }
            
            
            // ... loading/unloading of order ...
            // TODO: add coefficient for order price per capacity unit

        }
        
        return price;
    }
}
