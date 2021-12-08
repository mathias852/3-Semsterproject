package org.example.BeerMachine.service;

import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.example.BeerMachine.data.models.BatchReport;
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
    float getBarley();
    float getHops();
    float getMalt();
    float getWheat();
    float getYeast();
    Short getHumidity();
    float getTemperature();
    float getVibrations();
    int getStopReason();
    int getCurrentState();
    float getSpeed();
    float getAmountToProduce();
    float getBatchId();
    UShort getTotalCount();
    UShort getGoodCount();
    UShort getBadCount();
    UShort getMaintenanceCount();
    void updateBatchReport(BatchReport batchReport);
}
