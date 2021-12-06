package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.*;
import org.example.BeerMachine.data.payloads.request.BatchReportRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/batchReport")
public class BatchReportController {
    @Autowired
    BatchReportService batchReportService;

    @Autowired
    HumidityService humidityService;

    @Autowired
    TemperatureService temperatureService;

    @Autowired
    VibrationService vibrationService;

    @Autowired
    TimeStateService timeStateService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<BatchReport>> getAllBatchReports () {
        List<BatchReport> batchReports = batchReportService.getAllBatchReports();
        return new ResponseEntity<>(batchReports, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/all/{batchReportId}/humidities")
    public ResponseEntity<List<Humidity>> getAllHumidities (@PathVariable("batchReportId") Integer id) {
        List<Humidity> humidities = humidityService.getAllHumidities();
        List<Humidity> specificHumiditiesForBatchReport = new ArrayList<>();
        for (Humidity humidity : humidities) {
            if(humidity.getBatchReport().getId().equals(id)){
                specificHumiditiesForBatchReport.add(humidity);
            }
        }
        return new ResponseEntity<>(specificHumiditiesForBatchReport, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/all/{batchReportId}/temperatures")
    public ResponseEntity<List<Temperature>> getAllTemperatures (@PathVariable("batchReportId") Integer id) {
        List<Temperature> temperatures = temperatureService.getAllTemperatures();
        List<Temperature> specificTemperaturesForBatchReport = new ArrayList<>();
        for (Temperature temperature : temperatures) {
            if(temperature.getBatchReport().getId().equals(id)){
                specificTemperaturesForBatchReport.add(temperature);
            }
        }
        return new ResponseEntity<>(specificTemperaturesForBatchReport, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/all/{batchReportId}/vibrations")
    public ResponseEntity<List<Vibration>> getAllVibrations (@PathVariable("batchReportId") Integer id) {
        List<Vibration> vibrations = vibrationService.getAllVibrations();
        List<Vibration> specificVibrationsForBatchReport = new ArrayList<>();
        for (Vibration vibration : vibrations) {
            if(vibration.getBatchReport().getId().equals(id)){
                specificVibrationsForBatchReport.add(vibration);
            }
        }
        return new ResponseEntity<>(specificVibrationsForBatchReport, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/all/{batchReportId}/timeStates")
    public ResponseEntity<List<TimeState>> getAllTimeStates (@PathVariable("batchReportId") Integer id) {
        List<TimeState> timeStates = timeStateService.getAllTimeStates();
        List<TimeState> specificTimeStatesForBatchReport = new ArrayList<>();
        for (TimeState timeState : timeStates) {
            if(timeState.getBatchReport().getId().equals(id)){
                specificTimeStatesForBatchReport.add(timeState);
            }
        }
        return new ResponseEntity<>(specificTimeStatesForBatchReport, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/find/{batchReportId}")
    public ResponseEntity<BatchReport> getBatchReportById (@PathVariable("batchReportId") Integer id) {
        BatchReport batchReports = batchReportService.getBatchReport(id);
        return new ResponseEntity<>(batchReports, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/find/batchReport/{batchId}")
    public ResponseEntity<BatchReport> getBatchReportByBatchId (@PathVariable("batchId") Integer batchId) {
        List<BatchReport> batchReports = batchReportService.getAllBatchReports();
        for (BatchReport batchReport: batchReports) {
            if (batchReport.getBatchId().equals(batchId)){
                return new ResponseEntity<>(batchReport, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addBatch(@RequestBody BatchReportRequest batchReport) {
        MessageResponse newBatchReport = batchReportService.createBatchReport(batchReport);
        return new ResponseEntity<>(newBatchReport, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{batchReportId}")
    public ResponseEntity<?> deleteBatch(@PathVariable("batchReportId") Integer id) {
        batchReportService.deleteBatchReport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
