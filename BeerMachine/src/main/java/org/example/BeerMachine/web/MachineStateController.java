package org.example.BeerMachine.web;

import org.example.BeerMachine.BeerMachineController;
import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.State;
import org.example.BeerMachine.data.models.StopReason;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machineState")
public class MachineStateController {

    @CrossOrigin
    @GetMapping("/getTemperature")
    public ResponseEntity<Double> getTemperature () {
        return new ResponseEntity<>(BeerMachineController.getBeerMachineController().getMachineState().getCurrentTemperature(),
                HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getHumidity")
    public ResponseEntity<Double> getHumidity () {
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
    public ResponseEntity<State> getState () {
        return new ResponseEntity<>(BeerMachineController.getBeerMachineController().getMachineState().getState(),
                HttpStatus.OK);
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
