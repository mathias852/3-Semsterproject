package org.example.BeerMachine.data.models;

public enum State {
    DEACTIVATED(0),
    CLEARING(1),
    STOPPED(2),
    STARTING(3),
    IDLE(4),
    SUSPENDED(5),
    EXECUTE(6),
    STOPPING(7),
    ABORTING(8),
    ABORTED(9),
    HOLDING(10),
    HELD(11),
    RESETTING(15),
    COMPLETING(16),
    COMPLETE(17),
    DEACTIVATING(18),
    ACTIVATING(19);

    private final int id;

    State(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}