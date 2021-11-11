package org.example.BeerMachine.service;

import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.payloads.request.QueueRequest;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {
    @Autowired
    BatchRepository batchRepository;

    @Override
    public List<Integer> updateQueue(QueueRequest queueRequest) {
        BeerMachineController.getBeerMachineController().getMachineState().setQueue(queueRequest.getQueue());
        return BeerMachineController.getBeerMachineController().getMachineState().getQueue();
    }

    public List<Integer> getQueue() {
        return BeerMachineController.getBeerMachineController().getMachineState().getQueue();
    }
}
