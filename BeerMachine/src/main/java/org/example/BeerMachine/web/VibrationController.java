package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.*;
import org.example.BeerMachine.data.payloads.request.BatchReportRequest;
import org.example.BeerMachine.data.payloads.request.VibrationRequest;
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
@RequestMapping("/vibration")
public class VibrationController {
    @Autowired
    VibrationService vibrationService;

    @GetMapping("/all")
    public ResponseEntity<List<Vibration>> getAllVibrations () {
        List<Vibration> vibrations = vibrationService.getAllVibrations();
        return new ResponseEntity<>(vibrations, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addVibration(@RequestBody VibrationRequest vibration) throws ParseException {
        MessageResponse newVibration = vibrationService.createVibration(vibration);
        return new ResponseEntity<>(newVibration, HttpStatus.CREATED);
    }
}
