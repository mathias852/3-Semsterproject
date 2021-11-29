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

    public double calculateOEE(double speed, int amount, TreeSet<TimeState> downTime, double goodCount, double totalCount, double idealCycleTime){
        //OEE is A * P * Q where A is availability, P is performance and Q is quality
        //Runtime = planedProductionTime - downTime
        //Quality = goodCount or totalCount-badCount
        //Performance = (idealCycleTime * totalCount) / runTime
        //Availability = runTime / PlanedProductionTime


        //Everything will be measured in seconds

        //Times 60 to get it in seconds due to the speed being in minutes
        double planedProductionTimeInSeconds = (amount / speed) * 60;
        double runTime;

        //Total downTime
        double totalDownTime = 0;
        for (TimeState timeState: downTime) {
            totalDownTime += timeState.getEndTime().getTime() - timeState.getStartTime().getTime();
        }

        if (totalDownTime != 0) {
            runTime = planedProductionTimeInSeconds - totalDownTime;
        } else {
            runTime = planedProductionTimeInSeconds;
        }

        double quality = goodCount;
        double performance = (idealCycleTime * totalCount) / runTime;
        double availability = runTime / planedProductionTimeInSeconds;
        return performance * quality * availability;
    }

    public BatchReport getBatchReport() {
        return batchReport;
    }
}