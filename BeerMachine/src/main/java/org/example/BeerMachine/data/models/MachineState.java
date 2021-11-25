package org.example.BeerMachine.data.models;

import org.example.BeerMachine.BeerMachineCommunication.Subscription;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class MachineState {
    private Subscription barley;
    private Subscription wheat;
    private Subscription hops;
    private Subscription malt;
    private Subscription yeast;
    private BatchReport batchReport;
    private Subscription humidity;
    private Subscription temperature;
    private Subscription vibration;

    private Map<String, Subscription> ingredients;

    private StopReason stopreason;

    private Subscription state;

    private List<Integer> queue;

    public MachineState(Subscription barley, Subscription wheat) {
        this.barley = barley;
        this.wheat = wheat;

        barley.start();
        wheat.start();
    }

    public Subscription getBarley() {
        return barley;
    }

    public void setBarley(Subscription barley) {
        this.barley = barley;
    }

    public Subscription getWheat() {
        return wheat;
    }

    public void setWheat(Subscription wheat) {
        this.wheat = wheat;
    }

    public Map<String, Subscription> getIngredients() {
        return ingredients;
    }

    public List<Integer> getQueue() {
        return queue;
    }

    public void setQueue(List<Integer> queue) {
        this.queue = queue;
    }

    public void setIngredients(Map<String, Subscription> ingredients) {
        this.ingredients = ingredients;
    }

    public BatchReport getCurrentBatch() {
        return batchReport;
    }

    public void setCurrentBatch(BatchReport batchReport) {
        this.batchReport = batchReport;
    }

    public Subscription getCurrentHumidity() {
        return humidity;
    }

    public void setCurrentHumidity(Subscription humidity) {
        this.humidity = humidity;
    }

    public Subscription getCurrentTemperature() {
        return temperature;
    }

    public void setCurrentTemperature(Subscription temperature) {
        this.temperature = temperature;
    }

    public Subscription getCurrentVibration() {
        return vibration;
    }

    public void setCurrentVibration(Subscription vibration) {
        this.vibration = vibration;
    }

    public StopReason getStopreason() {
        return stopreason;
    }

    public void setStopreason(StopReason stopreason) {
        this.stopreason = stopreason;
    }

    public Subscription getState() {
        return state;
    }

    public void setState(Subscription state) {
        this.state = state;
    }
}
