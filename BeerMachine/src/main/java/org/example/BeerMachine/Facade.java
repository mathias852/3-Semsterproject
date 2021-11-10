package org.example.BeerMachine;
import org.example.BeerMachine.data.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Facade {
    private static Facade facade;
    private MachineState machineState;

    public static Facade getFacade() {
        if (facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    public void initiateMachine() {
        HashMap<String, Integer> ingredients = new HashMap<>();
        ingredients.put("Barley", 100);
        ingredients.put("Hops", 98);
        ingredients.put("Malt", 88);
        ingredients.put("Wheat", 92);
        ingredients.put("Yeast", 94);

        machineState = new MachineState(1.5, 4.1, 4.2,
                ingredients,
                State.ACTIVATING);
    }

    public void setProductionBatch(int id, int amount, int speed, Type type) {

        BatchReport batchReport = new BatchReport(id, speed, type, amount);
        if (type.getMaxSpeed() < speed) {
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


}