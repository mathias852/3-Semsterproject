package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.BatchReport;
import org.example.BeerMachine.data.payloads.request.QueueRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface QueueService {
    List<Batch> updateQueue(QueueRequest queueRequest);
}
