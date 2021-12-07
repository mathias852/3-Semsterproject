package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.Temperature;
import org.example.BeerMachine.data.payloads.request.TemperatureRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {
    @Autowired
    TemperatureService temperatureService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Temperature>> getAllTemperatures() {
        List<Temperature> temperatures = temperatureService.getAllTemperatures();
        return new ResponseEntity<>(temperatures, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addTemperature() {
        temperatureService.createTemperature();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}