package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.models.Temperature;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
import org.example.BeerMachine.data.payloads.request.TemperatureRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Component
public interface TemperatureService {
    void createTemperature();

    Temperature getTemperature(Integer temperatureId);

    List<Temperature> getAllTemperatures();
}
