package org.example.BeerMachine.service;

import org.example.BeerMachine.BeerMachineCommunication.Read;
import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.models.MachineState;
import org.example.BeerMachine.data.models.Temperature;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
import org.example.BeerMachine.data.payloads.request.TemperatureRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.data.repository.HumidityRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HumidityServiceImpl implements HumidityService {
    private Read read = new Read();
    private final MachineState machineState = BeerMachineController.getBeerMachineController().getMachineState();

    @Autowired
    HumidityRepository humidityRepository;

    @Autowired
    BatchReportRepository batchReportRepository;


    @Override
    public void createHumidity() {
        try {
            HumidityRequest humidityRequest = new HumidityRequest();
            humidityRequest.setBatchReportId((int)read.getBatchId());
            Humidity newHumidity = new Humidity();
            newHumidity.setBatchReport(humidityRequest.getBatchReport(batchReportRepository));
            newHumidity.setHumidity(machineState.getHumiditySub().getHumidity());
            newHumidity.setTimestamp(humidityRequest.getTimestampFormat().format(new Date()));
            humidityRepository.save(newHumidity);
        } catch (NullPointerException e){
            System.out.println("BatchReportRepository NullPointerException");
        }
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
