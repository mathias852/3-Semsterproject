package org.example.BeerMachine.service;

import org.example.BeerMachine.BeerMachineCommunication.Read;
import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.models.MachineState;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TemperatureServiceImpl implements TemperatureService {
    private Read read = new Read();
    private final MachineState machineState = BeerMachineController.getBeerMachineController().getMachineState();

    @Autowired
    TemperatureRepository temperatureRepository;

    @Autowired
    BatchReportRepository batchReportRepository;

    @Override
    public void createTemperature() {
        try {
            TemperatureRequest temperatureRequest = new TemperatureRequest();
            temperatureRequest.setBatchReportId((int)read.getBatchId());
            Temperature newTemperature = new Temperature();
            newTemperature.setBatchReport(temperatureRequest.getBatchReport(batchReportRepository));
            newTemperature.setTemperature(machineState.getTemperatureSub().getTemperature());
            newTemperature.setTimestamp(temperatureRequest.getTimestampFormat().format(new Date()));
            temperatureRepository.save(newTemperature);
        } catch (NullPointerException e){
            System.out.println("BatchReportRepository NullPointerException");
        }
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
