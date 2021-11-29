package org.example.BeerMachine;

import org.example.BeerMachine.data.models.Batch;

import java.util.Comparator;

public class BatchQueueComparator implements Comparator<Batch> {
    @Override
    public int compare(Batch o1, Batch o2) {
        return Integer.compare(o1.getQueueSpot(), o2.getQueueSpot());
    }
}
