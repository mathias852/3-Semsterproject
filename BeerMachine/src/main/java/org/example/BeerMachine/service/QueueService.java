package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface QueueService {

    List<Batch> getQueue();

    List<Batch> moveUp(Integer id);

    List<Batch> moveDown(Integer id);
}
