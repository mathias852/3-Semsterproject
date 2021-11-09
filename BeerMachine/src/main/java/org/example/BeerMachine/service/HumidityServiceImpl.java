package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.data.repository.HumidityRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HumidityServiceImpl implements HumidityService {
    @Autowired
    HumidityRepository humidityRepository;

    @Autowired
    BatchReportRepository batchReportRepository;


    @Override
    public MessageResponse createHumidity(HumidityRequest humidityRequest) {
        Humidity newHumidity = new Humidity();
        newHumidity.setBatchReport(humidityRequest.getBatchReport(batchReportRepository));
        newHumidity.setHumidity(humidityRequest.getHumidity());
        newHumidity.setTimestamp(humidityRequest.getTimestamp());
        humidityRepository.save(newHumidity);
        return new MessageResponse("New humidity entry created successfully");
    }

    @Override
    public Humidity getHumidity(Integer humidityId) {
        try {
            return humidityRepository.findById(humidityId).get();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Humidity> getAllHumidities() {
        return humidityRepository.findAll();
    }
}
