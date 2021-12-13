package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.models.Vibration;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
import org.example.BeerMachine.data.payloads.request.VibrationRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Component
public interface VibrationService {
    void createVibration();

    Vibration getVibration(Integer vibrationId);

    List<Vibration> getAllVibrations();
}
