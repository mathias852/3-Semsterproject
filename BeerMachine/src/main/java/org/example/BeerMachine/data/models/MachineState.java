package org.example.BeerMachine.data.models;

import org.example.BeerMachine.BeerMachineCommunication.Subscription;

import java.util.Map;

public class MachineState {
    private BatchReport batchReport;
    private Subscription humiditySub;
    private Subscription temperatureSub;
    private Subscription vibrationSub;
    private Subscription stopReasonSub;
    private Subscription stateSub;
    private Subscription totalCountSub;
    private Subscription goodCountSub;
    private Subscription badCountSub;
    private Subscription maintenanceSub;

    private Map<String, Subscription> ingredients;

    public MachineState(Map<String, Subscription> ingredients, Subscription humiditySub, Subscription temperatureSub,
                        Subscription vibrationSub, Subscription stopReasonSub, Subscription stateSub,
                        Subscription totalCountSub, Subscription goodCountSub, Subscription badCountSub, Subscription maintenanceSub) {
        this.ingredients = ingredients;
        this.humiditySub = humiditySub;
        this.temperatureSub = temperatureSub;
        this.vibrationSub = vibrationSub;
        this.stopReasonSub = stopReasonSub;
        this.stateSub = stateSub;
        this.totalCountSub = totalCountSub;
        this.goodCountSub = goodCountSub;
        this.badCountSub = badCountSub;
        this.maintenanceSub = maintenanceSub;

        this.stateSub.start();
    }
    public BatchReport getBatchReport() {
        return batchReport;
    }
    public void setBatchReport(BatchReport batchReport) {
        this.batchReport = batchReport;
    }
    public Subscription getHumiditySub() {
        return humiditySub;
    }
    public void setHumiditySub(Subscription humiditySub) {
        this.humiditySub = humiditySub;
    }
    public Subscription getTemperatureSub() {
        return temperatureSub;
    }
    public void setTemperatureSub(Subscription temperatureSub) {
        this.temperatureSub = temperatureSub;
    }
    public Subscription getVibrationSub() {
        return vibrationSub;
    }
    public void setVibrationSub(Subscription vibrationSub) {
        this.vibrationSub = vibrationSub;
    }
    public Map<String, Subscription> getIngredients() {
        return ingredients;
    }
    public void setIngredients(Map<String, Subscription> ingredients) {
        this.ingredients = ingredients;
    }
    public Subscription getStopReasonSub() {
        return stopReasonSub;
    }
    public void setStopReasonSub(Subscription stopreason) {
        this.stopReasonSub = stopreason;
    }
    public Subscription getStateSub() {
        return stateSub;
    }
    public void setStateSub(Subscription stateSub) {
        this.stateSub = stateSub;
    }
    public Subscription getTotalCountSub() {
        return totalCountSub;
    }
    public void setTotalCountSub(Subscription totalCountSub) {
        this.totalCountSub = totalCountSub;
    }
    public Subscription getGoodCountSub() {
        return goodCountSub;
    }
    public void setGoodCountSub(Subscription goodCountSub) {
        this.goodCountSub = goodCountSub;
    }
    public Subscription getBadCountSub() {
        return badCountSub;
    }
    public void setBadCountSub(Subscription badCountSub) {
        this.badCountSub = badCountSub;
    }

    public Subscription getMaintenanceSub() {
        return maintenanceSub;
    }

    public void setMaintenanceSub(Subscription maintenanceSub) {
        this.maintenanceSub = maintenanceSub;
    }
}
