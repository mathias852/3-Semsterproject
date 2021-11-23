package org.example.BeerMachine.service;

import org.aspectj.bridge.Message;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MachineService {
    MessageResponse resetMachine();
    MessageResponse startMachine(Integer batchId);
    MessageResponse stopMachine();
    MessageResponse abortMachine();
    MessageResponse clearMachine();
    MessageResponse setHost(String host);
}
