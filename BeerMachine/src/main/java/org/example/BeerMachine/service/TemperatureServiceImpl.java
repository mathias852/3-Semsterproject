package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.models.Temperature;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.request.TemperatureRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.data.repository.TemperatureRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureServiceImpl implements TemperatureService {
    @Autowired
    TemperatureRepository temperatureRepository;

    @Autowired
    BatchReportRepository batchReportRepository;

    @Override
    public MessageResponse createTemperature(TemperatureRequest temperatureRequest) {
        Temperature newTemperature = new Temperature();
        newTemperature.setBatchReport(temperatureRequest.getBatchReport(batchReportRepository));
        newTemperature.setTemperature(temperatureRequest.getTemperature());
        newTemperature.setTimestamp(temperatureRequest.getTimestamp());
        temperatureRepository.save(newTemperature);
        return new MessageResponse("New temperature entry created successfully");
    }

    @Override
    public Temperature getTemperature(Integer temperatureId) {
        try {
            return temperatureRepository.findById(temperatureId).get();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Temperature> getAllTemperatures() {
        return temperatureRepository.findAll();
    }
}
