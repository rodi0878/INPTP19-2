package cz.upce.fei.inptp.project.planner;

import cz.upce.fei.inptp.project.entity.Driver;
import cz.upce.fei.inptp.project.entity.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    
    private List<PlanItem> planItems;

    public Plan() {
        planItems = new ArrayList<>();
    }

    public List<PlanItem> getPlanItems() {
        return planItems;
    }
    
    /**
     * @param vehicle needs to be unique for the whole planItems otherwise throws {@link IllegalArgumentException}
     * @param driver needs to be unique for the whole planItems otherwise throws {@link IllegalArgumentException}
     */
    public PlanItem addNewVehiclePlan(Vehicle vehicle, Driver driver, String vehicleStartingLocation) {
        if (containsVehicle(vehicle)) {
            throw new IllegalArgumentException("Vehicle already used for this planItems.");
        }
        if (containsDriver(driver)) {
            throw new IllegalArgumentException("Driver already used for this planItems.");
        }
        
        PlanItem planItem = new PlanItem(vehicle, driver, vehicleStartingLocation);
        
        planItems.add(planItem);
        
        return planItem;
    }
    
    private boolean containsVehicle(Vehicle vehicle) {
        for (PlanItem item : planItems) {
            if (item.getVehicle().equals(vehicle)) {
                return true;
            }
        }

        return false;
    }
    
    private boolean containsDriver(Driver driver) {
        for (PlanItem item : planItems) {
            if (item.getDriver().equals(driver)) {
                return true;
            }
        }

        return false;
    }
    
}
