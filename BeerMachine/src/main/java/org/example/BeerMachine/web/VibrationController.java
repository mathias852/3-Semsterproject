package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.Vibration;
import org.example.BeerMachine.data.payloads.request.VibrationRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.service.VibrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/vibration")
public class VibrationController {
    @Autowired
    VibrationService vibrationService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Vibration>> getAllVibrations () {
        List<Vibration> vibrations = vibrationService.getAllVibrations();
        return new ResponseEntity<>(vibrations, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addVibration() {
        vibrationService.createVibration();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
