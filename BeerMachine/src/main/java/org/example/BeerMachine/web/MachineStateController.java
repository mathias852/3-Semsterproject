package org.example.BeerMachine.web;

import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.State;
import org.example.BeerMachine.data.models.StopReason;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/machine")
public class MachineStateController {

    @Autowired
    MachineService machineService;

    @GetMapping("/reset")
    public ResponseEntity<MessageResponse> resetMachine() {
        MessageResponse resetMachine = machineService.resetMachine();
        return new ResponseEntity<>(resetMachine, HttpStatus.OK);
    }

    @PostMapping("/start/{batchId}")
    public ResponseEntity<MessageResponse> startMachine(@PathVariable Integer batchId) {
        MessageResponse startMachine = machineService.startMachine(batchId);
        return new ResponseEntity<>(startMachine, HttpStatus.OK);
    }
    @PostMapping("/queue/start")
    public ResponseEntity<MessageResponse> startQueue() {
        MessageResponse startQueue = machineService.startQueue();
        return new ResponseEntity<>(startQueue, HttpStatus.OK);
    }

    @GetMapping("/stop")
    public ResponseEntity<MessageResponse> stopMachine() {
        MessageResponse stopMachine = machineService.stopMachine();
        return new ResponseEntity<>(stopMachine, HttpStatus.OK);
    }


    @GetMapping("/abort")
    public ResponseEntity<MessageResponse> abortMachine() {
        MessageResponse abortMachine = machineService.abortMachine();
        return new ResponseEntity<>(abortMachine, HttpStatus.OK);
    }


    @GetMapping("/clear")
    public ResponseEntity<MessageResponse> clearMachine() {
        MessageResponse clearMachine = machineService.clearMachine();
        return new ResponseEntity<>(clearMachine, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/setHost/{host}")
    public ResponseEntity<MessageResponse> setHost(@PathVariable String host){
        MessageResponse setHost = machineService.setHost(host);
        return new ResponseEntity<>(setHost, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getHost/")
    public ResponseEntity<MessageResponse> getHost(){
        MessageResponse getHost = machineService.getHost();
        return new ResponseEntity<>(getHost, HttpStatus.OK);
    }


    @CrossOrigin
    @GetMapping("/getTemperature")
    public ResponseEntity<Double> getTemperature () {
        return new ResponseEntity<>(BeerMachineController.getBeerMachineController().getMachineState().getCurrentTemperature(),
                HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getHumidity")
    public ResponseEntity<Double> getHumidity () {
        BeerMachineController.getBeerMachineController().getMachineState().setCurrentHumidity(BeerMachineController.getBeerMachineController().getMachineState().getCurrentHumidity() + 1);
        return new ResponseEntity<>(BeerMachineController.getBeerMachineController().getMachineState().getCurrentHumidity(),
                HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getVibration")
    public ResponseEntity<Double> getVibration () {
        return new ResponseEntity<>(BeerMachineController.getBeerMachineController().getMachineState().getCurrentVibration(),
                HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getBatch")
    public ResponseEntity<Batch> getBatch () {
        return new ResponseEntity<>(BeerMachineController.getBeerMachineController().getMachineState().getCurrentBatch(),
                HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getState")
    public ResponseEntity<MessageResponse> getState () {
        MessageResponse resetMachine = machineService.getState();
        return new ResponseEntity<>(resetMachine, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getStopreason")
    public ResponseEntity<StopReason> getStopreason () {
        StopReason stopReason = BeerMachineController.getBeerMachineController().getMachineState().getStopreason();
        if (stopReason != null)
        return new ResponseEntity<>(stopReason, HttpStatus.OK);
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
