package org.example.BeerMachine;
import org.example.BeerMachine.BeerMachineCommunication.Subscription;
import org.example.BeerMachine.data.models.*;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public class BeerMachineController {
    private static BeerMachineController beerMachineController;
    private MachineState machineState;
    private BatchReport batchReport;

    public static BeerMachineController getBeerMachineController() {
        if (beerMachineController == null) {
            beerMachineController = new BeerMachineController();
        }
        return beerMachineController;
    }

    public BeerMachineController() {
        HashMap<String, Subscription> ingredients = new HashMap<>();
        ingredients.put("Barley", new Subscription("Program:Inventory.Barley"));
        ingredients.put("Wheat", new Subscription("Program:Inventory.Wheat"));
        ingredients.put("Hops", new Subscription("Program:Inventory.Hops"));
        ingredients.put("Malt", new Subscription("Program:Inventory.Malt"));
        ingredients.put("Yeast", new Subscription("Program:Inventory.Yeast"));

        this.machineState = new MachineState(ingredients, new Subscription("Program:Data.Value.RelHumidity"),
                new Subscription("Program:Data.Value.Temperature"), new Subscription("Program:Data.Value.Vibration"),
                new Subscription("Program:Cube.Admin.StopReason.Value"), new Subscription("Program:Cube.Status.StateCurrent"),
                new Subscription("Program:product.produced"), new Subscription("Program:product.good"),
                new Subscription("Program:product.bad"), new Subscription("Program:Maintenance.Counter"));
    }

    public MachineState getMachineState() {
        return this.machineState;
    }

    public void setMachineState(MachineState machineState) {
        this.machineState = machineState;
    }

    public void setProductionBatch(int id, int amount, int speed, Type type) {
         this.batchReport = new BatchReport(id, speed, type, amount);

        if (type.getMaxSpeed() <= speed) {
            try {
                throw new Exception("Speed greater than max speed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (0 > amount | amount > 32767) {
            try {
                throw new Exception("Amount is out of bounds.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Batch batch = new Batch(id, speed, type, amount);
    }

    public double calculateOEE(double goodCount, double idealCycleTime, double plannedProductionTime){
        //Everything will be measured in minutes
        //OEE can be calculated based on the following: OEE = (GoodCount * IdealCycleTime) / plannedProductionTime
        //Where plannedProductionTime is the time between a batch start to a batch end
        return (goodCount * idealCycleTime) / plannedProductionTime;
    }

    public double getAvailability(double downTime, double plannedProductionTime){
        //Planned Production Time - downTime = run Time
        return (plannedProductionTime - downTime)/plannedProductionTime;
    }

    public double getPerformance(double idealCycleTime, double totalCount, double speed, double amount){
        //Speed * amount = run Time
        return (idealCycleTime * totalCount)/(speed * amount);
    }

    public double getQuality(double goodCount, double totalCount){
        return goodCount/totalCount;
    }


    public BatchReport getBatchReport() {
        return batchReport;
    }
}