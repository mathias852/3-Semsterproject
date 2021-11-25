package org.example.BeerMachine.data.models;

import org.example.BeerMachine.BeerMachineCommunication.Subscription;

import java.util.List;
import java.util.Map;

public class MachineState {
    private Subscription barleySub;
    private Subscription wheatSub;
    private Subscription hopsSub;
    private Subscription maltSub;
    private Subscription yeastSub;
    private BatchReport batchReport;
    private Subscription humiditySub;
    private Subscription temperatureSub;
    private Subscription vibrationSub;
    private Subscription stopReasonSub;
    private Subscription stateSub;

    private Map<String, Subscription> ingredients;
    private List<Integer> queue;

    public MachineState(Subscription barleySub, Subscription wheatSub, Subscription hopsSub, Subscription maltSub, Subscription yeastSub,
                        Subscription humiditySub, Subscription temperatureSub, Subscription vibrationSub, Subscription stopReasonSub,
                        Subscription stateSub) {

        this.barleySub = barleySub;
        this.wheatSub = wheatSub;
        this.hopsSub = hopsSub;
        this.maltSub = maltSub;
        this.yeastSub = yeastSub;
        this.humiditySub = humiditySub;
        this.temperatureSub = temperatureSub;
        this.vibrationSub = vibrationSub;
        this.stopReasonSub = stopReasonSub;
        this.stateSub = stateSub;

        this.barleySub.start();
        this.hopsSub.start();
/*        this.maltSub.start();
        this.wheatSub.start();
        this.yeastSub.start();*/

        /*this.humiditySub.start();
        temperatureSub.start();
        vibrationSub.start();
        stopReasonSub.start();
        stateSub.start();*/
    }

    public Subscription getBarleySub() {
        return barleySub;
    }
    public void setBarleySub(Subscription barleySub) {
        this.barleySub = barleySub;
    }
    public Subscription getWheatSub() {
        return wheatSub;
    }
    public void setWheatSub(Subscription wheatSub) {
        this.wheatSub = wheatSub;
    }
    public Subscription getHopsSub() {
        return hopsSub;
    }
    public void setHopsSub(Subscription hopsSub) {
        this.hopsSub = hopsSub;
    }
    public Subscription getMaltSub() {
        return maltSub;
    }
    public void setMaltSub(Subscription maltSub) {
        this.maltSub = maltSub;
    }
    public Subscription getYeastSub() {
        return yeastSub;
    }
    public void setYeastSub(Subscription yeastSub) {
        this.yeastSub = yeastSub;
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
    public List<Integer> getQueue() {
        return queue;
    }
    public void setQueue(List<Integer> queue) {
        this.queue = queue;
    }
}
