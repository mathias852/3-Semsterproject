package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
import org.example.BeerMachine.data.payloads.request.QueueRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.data.repository.HumidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {
    @Autowired
    BatchRepository batchRepository;

    @Override
    public List<Batch> updateQueue(QueueRequest queueRequest) {
        return null;
    }
}
