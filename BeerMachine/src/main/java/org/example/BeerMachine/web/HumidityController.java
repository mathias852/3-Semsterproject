package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.Humidity;
import org.example.BeerMachine.data.payloads.request.HumidityRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.service.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/humidity")
public class HumidityController {
    @Autowired
    HumidityService humidityService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Humidity>> getAllHumidities () {
        List<Humidity> humidities = humidityService.getAllHumidities();
        return new ResponseEntity<>(humidities, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addHumidity() {
        humidityService.createHumidity();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
