package org.example.BeerMachine.service;

import org.example.BeerMachine.BatchQueueComparator;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {
    @Autowired
    BatchRepository batchRepository;

    @Override
    public ArrayList<Batch> getQueue() {
        if (batchRepository == null) {
            System.out.println("get queue returning null");
            return null;
        }
        else {
            ArrayList<Batch> batchQueue = new ArrayList<>(batchRepository.findAll());
            BatchQueueComparator myBatchQueueComparator = new BatchQueueComparator();
            batchQueue.sort(myBatchQueueComparator);
            return batchQueue;
        }
    }

    @Override
    public List<Batch> moveUp(Integer id) {
        ArrayList<Batch> batchQueue = getQueue();

        //find queue spot of batch to move
        Batch batchToMove = new Batch();
        Batch batchAbove = new Batch();
        for (int i = 0; i<batchQueue.size();i++) {
            if (batchQueue.get(i).getId() == id) {
                batchToMove = batchQueue.get(i);
                if(i-1 >= 0) {
                    batchAbove = batchQueue.get(i-1);
                } else {
                    return null;
                }
            }
        }

        Batch batch1 = batchRepository.findById(batchToMove.getId()).get();
        Batch batch2 = batchRepository.findById(batchAbove.getId()).get();
        int savedQueueSpot = batch1.getQueueSpot();
        batch1.setQueueSpot(batchAbove.getQueueSpot());
        batch2.setQueueSpot(savedQueueSpot);
        batchRepository.save(batch1);
        batchRepository.save(batch2);

        ArrayList<Batch> newBatchQueue = getQueue();

        return newBatchQueue;
    }

    @Override
    public List<Batch> moveDown(Integer id) {
        ArrayList<Batch> batchQueue = getQueue();

        //find queue spot of batch to move
        Batch batchToMove = new Batch();
        Batch batchBelow = new Batch();
        for (int i = 0; i<batchQueue.size();i++) {
            if (batchQueue.get(i).getId() == id) {
                batchToMove = batchQueue.get(i);
                if(i+1 < batchQueue.size()) {
                    batchBelow = batchQueue.get(i+1);
                } else {
                    return null;
                }
            }
        }

        Batch batch1 = batchRepository.findById(batchToMove.getId()).get();
        Batch batch2 = batchRepository.findById(batchBelow.getId()).get();
        int savedQueueSpot = batch1.getQueueSpot();
        batch1.setQueueSpot(batchBelow.getQueueSpot());
        batch2.setQueueSpot(savedQueueSpot);
        batchRepository.save(batch1);
        batchRepository.save(batch2);

        ArrayList<Batch> newBatchQueue = getQueue();

        return newBatchQueue;
    }
}
