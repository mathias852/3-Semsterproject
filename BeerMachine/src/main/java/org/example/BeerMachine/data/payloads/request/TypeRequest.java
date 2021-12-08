package org.example.BeerMachine.data.payloads.request;

import javax.validation.constraints.NotNull;

public class TypeRequest {
    @NotNull
    private String name;

    @NotNull
    private Double idealCycleTime;

    @NotNull
    private Integer maxSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIdealCycleTime() {
        return idealCycleTime;
    }

    public void setIdealCycleTime(Double idealCycleTime) {
        this.idealCycleTime = idealCycleTime;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
