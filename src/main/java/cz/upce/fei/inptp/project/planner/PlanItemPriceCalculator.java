package cz.upce.fei.inptp.project.planner;

import cz.upce.fei.inptp.project.entity.matrix.DistanceMatrix;
import cz.upce.fei.inptp.project.entity.Order;
import cz.upce.fei.inptp.project.entity.vehicle.Vehicle;

import java.util.HashSet;
import java.util.List;

public class PlanItemPriceCalculator {

    private final DistanceMatrix distanceMatrix;

    public PlanItemPriceCalculator(DistanceMatrix distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    private double calculatePricePerMovedKilometers(String from, String to, Vehicle vehicle) {
        double price = distanceMatrix.getDistanceBetweenLocations(from, to);
        price *= vehicle.getPricePerKilometer();
        return price;
    }


    public double calculatePrice(PlanItem planItem) {
        // TODO: tests

        List<Order> orders = planItem.getOrders();

        double price = 0;
        if (orders.isEmpty()) {
            return price;
        }

        String currentLocation = planItem.getVehicleStartingLocation();
        HashSet<Order> loadedOrders = new HashSet<>();
        
        // TODO: order processing
        // - process orders in planItem's list order 
        // - respect and test vehicle capacity
        // - if multiple orders can be fit into vehicle and are from same source location - merge loading and then go to destination unload them
        // - price is currently determined by:
        //     moved kilometers * price per kilometer + 
        //     loaded capacity * price per load per unit (vehicle parameter) + 
        //     unloaded capacity * price per load per unit (vehicle parameter)
        // - all changes must be supported by tests to determine that algorithm is correct!
        


        for (Order currentOrder : orders) {
            boolean loading = !loadedOrders.contains(currentOrder);
            String currentOrderLocation = loading ? currentOrder.getFrom() : currentOrder.getTo();
            
            if (!currentLocation.equals(currentOrderLocation)) {

                price += calculatePricePerMovedKilometers(currentLocation,
                        currentOrderLocation, planItem.getVehicle());
            }
            price += calculatePricePerMovedKilometers(currentOrder.getFrom(),
                    currentOrder.getTo(), planItem.getVehicle());


            // ... loading/unloading of order ...
            // TODO: add coefficient for order price per capacity unit
        }

        return price;
    }
}
