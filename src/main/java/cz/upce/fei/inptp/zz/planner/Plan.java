package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.Driver;
import cz.upce.fei.inptp.zz.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    
    private List<PlanItem> plan;

    public Plan() {
        plan = new ArrayList<>();
    }

    public List<PlanItem> getPlan() {
        return plan;
    }
    
    /**
     * @param vehicle needs to be unique for the whole plan otherwise throws {@link IllegalArgumentException}
     * @param driver needs to be unique for the whole plan otherwise throws {@link IllegalArgumentException}
     */
    public PlanItem addNewVehiclePlan(Vehicle vehicle, Driver driver, String vehicleStartingLocation) {
        if (containsVehicle(vehicle)) {
            throw new IllegalArgumentException("Vehicle already used for this plan.");
        }
        if (containsDriver(driver)) {
            throw new IllegalArgumentException("Driver already used for this plan.");
        }
        
        PlanItem planItem = new PlanItem(vehicle, driver, vehicleStartingLocation);
        
        plan.add(planItem);
        
        return planItem;
    }
    
    private boolean containsVehicle(Vehicle vehicle) {
        for (PlanItem item : plan) {
            if (item.getVehicle().equals(vehicle)) {
                return true;
            }
        }

        return false;
    }
    
    private boolean containsDriver(Driver driver) {
        for (PlanItem item : plan) {
            if (item.getDriver().equals(driver)) {
                return true;
            }
        }

        return false;
    }
    
}
