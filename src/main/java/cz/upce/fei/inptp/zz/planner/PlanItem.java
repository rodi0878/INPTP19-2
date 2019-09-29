/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.Driver;
import cz.upce.fei.inptp.zz.entity.Order;
import cz.upce.fei.inptp.zz.entity.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author Roman
 */
class PlanItem {

    private Vehicle vehicle;
    private Driver driver;

    private ArrayList<Order> orders;
}
