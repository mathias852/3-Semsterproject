package org.example.BeerMachine.service;

import org.example.BeerMachine.data.payloads.request.QueueRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface QueueService {
    List<Integer> updateQueue(QueueRequest queueRequest);

    List<Integer> getQueue();
}
