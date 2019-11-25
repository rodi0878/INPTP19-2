package cz.upce.fei.inptp.project.planner;

import cz.upce.fei.inptp.project.entity.Driver;
import cz.upce.fei.inptp.project.entity.vehicle.Vehicle;
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
    
    public PlanItem addNewVehiclePlan(Vehicle vehicle, Driver driver) {
        PlanItem newplan = new PlanItem(vehicle, driver);
        
        plan.add(newplan);
        // TODO: check duplicity of vehicle/driver in plan
        
        return newplan;
    }
    
}
