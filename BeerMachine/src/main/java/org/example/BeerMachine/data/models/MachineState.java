package org.example.BeerMachine.data.models;

import javax.persistence.*;
import java.util.Map;
import java.util.Objects;

public class MachineState {
    private Batch currentBatch;

    private double currentHumidity;
    private double currentTemperature;
    private double currentVibration;

    private Map<String, Integer> ingredients;

    private StopReason stopreason;

    private State state;

    public MachineState(double currentHumidity, double currentTemperature, double currentVibration, Map<String, Integer> ingredients, State state) {
        this.currentHumidity = currentHumidity;
        this.currentTemperature = currentTemperature;
        this.currentVibration = currentVibration;
        this.ingredients = ingredients;
        this.state = state;
    }

    public Batch getCurrentBatch() {
        return currentBatch;
    }

    public void setCurrentBatch(Batch currentBatch) {
        this.currentBatch = currentBatch;
    }

    public double getCurrentHumidity() {
        return currentHumidity;
    }

    public void setCurrentHumidity(double currentHumidity) {
        this.currentHumidity = currentHumidity;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getCurrentVibration() {
        return currentVibration;
    }

    public void setCurrentVibration(double currentVibration) {
        this.currentVibration = currentVibration;
    }

    public StopReason getStopreason() {
        return stopreason;
    }

    public void setStopreason(StopReason stopreason) {
        this.stopreason = stopreason;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
