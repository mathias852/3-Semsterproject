package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.*;
import org.example.BeerMachine.data.payloads.request.BatchReportRequest;
import org.example.BeerMachine.data.payloads.request.TemperatureRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {
    @Autowired
    TemperatureService temperatureService;


    @GetMapping("/all")
    public ResponseEntity<List<Temperature>> getAllTemperatures() {
        List<Temperature> temperatures = temperatureService.getAllTemperatures();
        return new ResponseEntity<>(temperatures, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addTemperature(@RequestBody TemperatureRequest temperature) throws ParseException {
        MessageResponse newTemperature = temperatureService.createTemperature(temperature);
        return new ResponseEntity<>(newTemperature, HttpStatus.CREATED);
    }
}
