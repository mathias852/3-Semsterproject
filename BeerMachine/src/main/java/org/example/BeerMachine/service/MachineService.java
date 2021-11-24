package org.example.BeerMachine.service;

import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

@Component
public interface MachineService {
    MessageResponse resetMachine();
    MessageResponse startMachine(Integer batchId);
    MessageResponse startQueue();
    MessageResponse stopMachine();
    MessageResponse abortMachine();
    MessageResponse clearMachine();
    MessageResponse getState();
    MessageResponse setHost(String host);
    MessageResponse getHost();
}
