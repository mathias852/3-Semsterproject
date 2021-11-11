package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.*;
import org.example.BeerMachine.data.payloads.request.BatchReportRequest;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
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
@RequestMapping("/humidity")
public class HumidityController {
    @Autowired
    HumidityService humidityService;

    @GetMapping("/all")
    public ResponseEntity<List<Humidity>> getAllHumidities () {
        List<Humidity> humidities = humidityService.getAllHumidities();
        return new ResponseEntity<>(humidities, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addHumidity(@RequestBody HumidityRequest humidity) throws ParseException {
        MessageResponse newHumidity = humidityService.createHumidity(humidity);
        return new ResponseEntity<>(newHumidity, HttpStatus.CREATED);
    }
}
