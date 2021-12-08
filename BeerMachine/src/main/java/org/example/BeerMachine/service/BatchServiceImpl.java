package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.BatchReport;
import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    BatchRepository batchRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    BatchReportRepository batchReportRepository;

    @Autowired
    QueueService queueService;

    @Override
    public MessageResponse createBatch(BatchRequest batchRequest) {
        Batch newBatch = new Batch();
        newBatch.setAmount((int) calculateAmountToProduce(batchRequest.getType(typeRepository), batchRequest.getAmount(), batchRequest.getSpeed()));
        newBatch.setType(batchRequest.getType(typeRepository));
        if (queueService.getQueue() != null & queueService.getQueue().size() > 0) {
            Integer lastQueueIndex = queueService.getQueue().size();
            Integer lastQueueSpot = queueService.getQueue().get(lastQueueIndex-1).getQueueSpot();
            newBatch.setQueueSpot(lastQueueSpot + 1);
        } else {
            newBatch.setQueueSpot(1);
        }

        newBatch.setSpeed(batchRequest.getSpeed());
        batchRepository.save(newBatch);
        BatchReport newBatchReport = new BatchReport(newBatch.getId(), newBatch.getSpeed(),
                newBatch.getType(), newBatch.getAmount());
        batchReportRepository.save(newBatchReport);
        return new MessageResponse("New Batch created successfully with a corresponding batch report");
    }

    //Method used to calculate the total amount that needs to be produced in order to
    //achieve the wished amount as good count
    public long calculateAmountToProduce(Type type, int amount, int speed){
        double goodCountPerMin = amount;
        switch (type.getId()){
            case(1):
                goodCountPerMin = (-5.65237 * Math.pow(10, -6) * Math.pow(speed, 3) + 0.0035 *
                        Math.pow(speed, 2) + 0.4 * speed + 25.16296);
                break;
            case(2):
                goodCountPerMin = (0.9703 * speed + 2.5295);
                break;
            case(3):
                goodCountPerMin = (0.9924 * speed + 0.3495);
                break;
            case(4):
                goodCountPerMin = (0.9963 * speed + 0.1832);
                break;
            case(5):
                goodCountPerMin = (0.9968 * speed + 0.0835);
                break;
        }
        //100 was picked randomly
        if(goodCountPerMin > speed){
            return amount + 100;
        }
        double totalAmountToProduce = (amount / goodCountPerMin) * speed;
        return Math.round(totalAmountToProduce);
    }


    @Override
    public Optional<Batch> updateBatch(Integer batchId, BatchRequest batchRequest) {
        Optional<Batch> batch = batchRepository.findById(batchId);
        if (batch.isEmpty()){
            return null;
        }
        else {
            batch.get().setType(batchRequest.getType(typeRepository));
            batch.get().setAmount(batchRequest.getAmount());
            batchRepository.save(batch.get());
        }
        return batch;
    }

    @Override
    public void deleteBatch(Integer batchId) {
        if (batchRepository.getById(batchId).getId().equals(batchId)){
            batchRepository.deleteById(batchId);
        }
    }

    @Override
    public Batch getBatch(Integer batchId) {
        try {
            return batchRepository.findById(batchId).get();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

}
