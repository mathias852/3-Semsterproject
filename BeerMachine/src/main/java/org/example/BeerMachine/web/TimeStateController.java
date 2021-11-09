package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.*;
import org.example.BeerMachine.data.payloads.request.BatchReportRequest;
import org.example.BeerMachine.data.payloads.request.TimeStateRequest;
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
@RequestMapping("/timeState")
public class TimeStateController {
    @Autowired
    TimeStateService timeStateService;

    @GetMapping("/all")
    public ResponseEntity<List<TimeState>> getAllTimeStates () {
        List<TimeState> timeStates = timeStateService.getAllTimeStates();
        return new ResponseEntity<>(timeStates, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addTimeState(@RequestBody TimeStateRequest timeState) throws ParseException {
        MessageResponse newTimeState = timeStateService.createTimeState(timeState);
        return new ResponseEntity<>(newTimeState, HttpStatus.CREATED);
    }
}
