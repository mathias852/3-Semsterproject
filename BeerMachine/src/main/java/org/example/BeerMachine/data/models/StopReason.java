package org.example.BeerMachine.data.models;

public enum StopReason {
    EMPTY_INVENTORY(10),
    MAINTENANCE(11),
    MANUAL_STOP(12),
    MOTOR_POWER_LOSS(13),
    MANUAL_ABORT(14);

    private final int id;

    StopReason(int id) {
        this.id = id;
    }
}