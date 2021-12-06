package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.BatchReport;
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
        newBatch.setAmount(batchRequest.getAmount());
        newBatch.setType(batchRequest.getType(typeRepository));
        if (queueService.getQueue() != null & queueService.getQueue().size() > 0) {
            Integer lastQueueIndex = queueService.getQueue().size();
            Integer lastQueueSpot = queueService.getQueue().get(lastQueueIndex-1).getQueueSpot();
            newBatch.setQueueSpot(lastQueueSpot + 1);
        } else {
            newBatch.setQueueSpot(1);
        }
        batchRepository.save(newBatch);
        BatchReport newBatchReport = new BatchReport(newBatch.getId(), newBatch.getSpeed(),
                newBatch.getType(), newBatch.getAmount());
        batchReportRepository.save(newBatchReport);
        return new MessageResponse("New Batch created successfully with a corresponding batch report");
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
