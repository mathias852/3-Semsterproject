package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.models.Vibration;
import org.example.BeerMachine.data.payloads.request.TypeRequest;
import org.example.BeerMachine.data.payloads.request.VibrationRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.example.BeerMachine.data.repository.VibrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class VibrationServiceImpl implements VibrationService {
    @Autowired
    VibrationRepository vibrationRepository;

    @Autowired
    BatchReportRepository batchReportRepository;

    @Override
    public MessageResponse createVibration(VibrationRequest vibrationRequest) throws ParseException {
        Vibration newVibration = new Vibration();
        newVibration.setBatchReport(vibrationRequest.getBatchReport(batchReportRepository));
        newVibration.setVibration(vibrationRequest.getVibration());
        newVibration.setTimestamp(vibrationRequest.getTimestampFormat(vibrationRequest.getTimestamp()));
        vibrationRepository.save(newVibration);
        return new MessageResponse("New vibration entry created successfully");
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
