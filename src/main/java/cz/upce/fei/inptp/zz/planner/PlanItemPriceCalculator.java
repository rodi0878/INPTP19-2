package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.DistanceMatrix;
import cz.upce.fei.inptp.zz.entity.Order;
import java.util.HashSet;
import java.util.List;

public class PlanItemPriceCalculator {
    
    private final DistanceMatrix distanceMatrix;

    public PlanItemPriceCalculator(DistanceMatrix distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }
 
    public double calculatePrice(PlanItem planItem) {
        List<Order> orders = planItem.getOrders();
        // TODO: tests
        double price = 0;
        if(orders.isEmpty()){
            return price;
        }
        String currentLocation = orders.get(0).getFrom();
        HashSet<Order> loadedOrders = new HashSet<>();
        for (Order currentOrder : orders){
            
            boolean loading = !loadedOrders.contains(currentOrder);
            
            String currentOrderLocation = loading ? currentOrder.getFrom() : currentOrder.getTo();
            
            if (!currentLocation.equals(currentOrderLocation)) {
                price += distanceMatrix.getDistanceBetweenLocations(currentLocation, currentOrderLocation);
                price *= planItem.getVehicle().getPricePerKilometer();
            }
            
            
            // ... loading/unloading of order ...
            // TODO: add coefficient for order price per capacity unit

        }
        
        return price;
    }
}
