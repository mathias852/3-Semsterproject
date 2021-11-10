package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.models.TimeState;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
import org.example.BeerMachine.data.payloads.request.TimeStateRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class TimeStateServiceImpl implements TimeStateService {
    @Autowired
    TimeStateRepository timeStateRepository;

    @Autowired
    BatchReportRepository batchReportRepository;


    @Override
    public MessageResponse createTimeState(TimeStateRequest timeStateRequest) throws ParseException {
        TimeState newTimeState = new TimeState();
        newTimeState.setBatchReport(timeStateRequest.getBatchReport(batchReportRepository));
        newTimeState.setStateId(timeStateRequest.getStateId());
        newTimeState.setStartTime(timeStateRequest.getStartTimeFormat(timeStateRequest.getStartTime()));
        newTimeState.setEndTime(timeStateRequest.getEndTimeFormat(timeStateRequest.getEndTime()));
        newTimeState.setStopReason(timeStateRequest.getStopReason());
        timeStateRepository.save(newTimeState);
        return new MessageResponse("New time state entry created successfully");
    }

    @Override
    public TimeState getTimeState(Integer timeStateId) {
        try {
            return timeStateRepository.findById(timeStateId).get();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<TimeState> getAllTimeStates() {
        return timeStateRepository.findAll();
    }
}
