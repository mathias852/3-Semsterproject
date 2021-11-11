package org.example.BeerMachine.data.payloads.request;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueueRequest {
    private List<Integer> queue;

    public List<Integer> getQueue() {
        return queue;
    }

    public void setQueue(List<Integer> queue) {
        this.queue = queue;
    }
}
