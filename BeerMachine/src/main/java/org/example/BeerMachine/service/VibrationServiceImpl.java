package org.example.BeerMachine.service;

import org.example.BeerMachine.BeerMachineCommunication.Read;
import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.models.MachineState;
import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.models.Vibration;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
import org.example.BeerMachine.data.payloads.request.TypeRequest;
import org.example.BeerMachine.data.payloads.request.VibrationRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.example.BeerMachine.data.repository.VibrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VibrationServiceImpl implements VibrationService {
    private Read read = new Read();
    private final MachineState machineState = BeerMachineController.getBeerMachineController().getMachineState();

    @Autowired
    VibrationRepository vibrationRepository;

    @Autowired
    BatchReportRepository batchReportRepository;

    @Override
    public void createVibration() {
        try {
            VibrationRequest vibrationRequest = new VibrationRequest();
            vibrationRequest.setBatchReportId((int)read.getBatchId());
            Vibration vibration = new Vibration();
            vibration.setBatchReport(vibrationRequest.getBatchReport(batchReportRepository));
            vibration.setVibration(machineState.getVibrationSub().getVibrations());
            vibration.setTimestamp(vibrationRequest.getTimestampFormat().format(new Date()));
            vibrationRepository.save(vibration);
        } catch (NullPointerException e){
            System.out.println("BatchReportRepository NullPointerException");
        }
    }

    @Override
    public Vibration getVibration(Integer vibrationId) {
        try {
            return vibrationRepository.findById(vibrationId).get();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Vibration> getAllVibrations() {
        return vibrationRepository.findAll();
    }
}
