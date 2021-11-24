package org.example.BeerMachine.service;

import org.example.BeerMachine.BeerMachineCommunication.Read;
import org.example.BeerMachine.BeerMachineCommunication.Subscription;
import org.example.BeerMachine.BeerMachineCommunication.Write;
import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.BatchReport;
import org.example.BeerMachine.data.models.State;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MachineServiceImpl implements MachineService {
    private Write write = new Write();
    private Read read = new Read();
    private Subscription subscription = new Subscription();

    @Autowired
    BatchReportRepository batchReportRepository;
    @Autowired
    BatchRepository batchRepository;

    @Override
    public MessageResponse resetMachine() {
        write.reset();
        return new MessageResponse("Machine reset...");
    }
    @Override
    public MessageResponse startMachine(Integer batchId) {
        try {
            BatchReport batchReport = batchReportRepository.findById(batchId).get();
            //The subtraction of 1 from the type_id is used because of different indexing methods (0index!=1index)
            write.startBatch(batchReport.getSpeed(), batchReport.getType().getId()-1, batchReport.getAmount());
        } catch (Exception e) {
            System.out.println(e);
            return new MessageResponse("Machine didn't start...");
        }
        return new MessageResponse("Machine started...");
    }
    @Override
    public MessageResponse startQueue() {
        MessageResponse response = new MessageResponse("Queue didn't start...");
        try {
            ArrayList<Batch> batchQueue = new ArrayList<>(batchRepository.findOrderByQueueSpotAndQueueSpotNotNull());
            if (BeerMachineController.getBeerMachineController().getMachineState().getState() == State.IDLE) {
                while (batchQueue.size() > 0) {
                    Integer firstQueue = batchQueue.get(0).getId();
                    response = startMachine(firstQueue);
                    batchQueue.remove(0);
                }
            } else {
                response = new MessageResponse("Machine not in idle...");
            }
        } catch (Exception e) {
            System.out.println(e);
            response = new MessageResponse("Queue failed...");
        }
        return response;
    }

    @Override
    public MessageResponse stopMachine() {
        write.stop();
        return new MessageResponse("Machine stopped...");
    }
    @Override
    public MessageResponse abortMachine() {
        write.abort();
        return new MessageResponse("Machine aborted...");
    }
    @Override
    public MessageResponse clearMachine() {
        write.clear();
        return new MessageResponse("Machine cleared...");
    }
    @Override
    public MessageResponse setHost(String host) {
        write.setHost(host);
        read.setHost(host);
        subscription.setHost(host);
        return new MessageResponse("Host set...");
    }
}
