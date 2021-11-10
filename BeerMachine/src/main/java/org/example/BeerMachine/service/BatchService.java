package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BatchService {
    MessageResponse createBatch(BatchRequest batchRequest);

    Optional<Batch> updateBatch(Integer batchId, BatchRequest batchRequest);

    void deleteBatch(Integer batchId);

    Batch getBatch(Integer batchId);

    List<Batch> getAllBatches();
}
