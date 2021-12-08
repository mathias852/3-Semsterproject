package org.example.BeerMachine.web;

import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.example.BeerMachine.BeerMachineController;
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

    @PostMapping("/reset")
    public ResponseEntity<MessageResponse> resetMachine() {
        MessageResponse resetMachine = machineService.resetMachine();
        return new ResponseEntity<>(resetMachine, HttpStatus.OK);
    }
    @PostMapping("/start/{batchId}")
    public ResponseEntity<MessageResponse> startMachine(@PathVariable Integer batchId) {
        MessageResponse startMachine = machineService.startMachine(batchId);
        if (startMachine.getMessage().equals("Machine didn't start...")){
            return new ResponseEntity<>(startMachine, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(startMachine, HttpStatus.OK);
    }
    @PostMapping("/queue/start")
    public ResponseEntity<MessageResponse> startQueue() {
        MessageResponse startQueue = machineService.startQueue();
        return new ResponseEntity<>(startQueue, HttpStatus.OK);
    }
    @PostMapping("/stop")
    public ResponseEntity<MessageResponse> stopMachine() {
        MessageResponse stopMachine = machineService.stopMachine();
        return new ResponseEntity<>(stopMachine, HttpStatus.OK);
    }
    @PostMapping("/abort")
    public ResponseEntity<MessageResponse> abortMachine() {
        MessageResponse abortMachine = machineService.abortMachine();
        return new ResponseEntity<>(abortMachine, HttpStatus.OK);
    }
    @PostMapping("/clear")
    public ResponseEntity<MessageResponse> clearMachine() {
        MessageResponse clearMachine = machineService.clearMachine();
        return new ResponseEntity<>(clearMachine, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getAmountToProduce")
    public ResponseEntity<Float> getAmountToProduce(){
        return new ResponseEntity<>(machineService.getAmountToProduce(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getBatchId")
    public ResponseEntity<Float> getBatchId(){
        return new ResponseEntity<>(machineService.getBatchId(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getSpeed")
    public ResponseEntity<Float> getSpeed(){
        return new ResponseEntity<>(machineService.getSpeed(), HttpStatus.OK);
    }


    //Live-data routes
    @CrossOrigin
    @GetMapping("/getBarley")
    public ResponseEntity<Float> getBarley (){return new ResponseEntity<>(machineService.getBarley(), HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("/getHops")
    public ResponseEntity<Float> getHops (){
        return new ResponseEntity<>(machineService.getHops(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/getMalt")
    public ResponseEntity<Float> getMalt (){
        return new ResponseEntity<>(machineService.getMalt(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/getWheat")
    public ResponseEntity<Float> getWheat () {
        return new ResponseEntity<>(machineService.getWheat(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/getYeast")
    public ResponseEntity<Float> getYeast (){
        return new ResponseEntity<>(machineService.getYeast(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/getHumidity")
    public ResponseEntity<Short> getHumidity (){return new ResponseEntity<>(machineService.getHumidity(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getTemperature")
    public ResponseEntity<Float> getTemperature (){return new ResponseEntity<>(machineService.getTemperature(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getVibrations")
    public ResponseEntity<Float> getVibrations (){return new ResponseEntity<>(machineService.getVibrations(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getStopReason")
    public ResponseEntity<Integer> getStopReason (){return new ResponseEntity<>(machineService.getStopReason(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getTotalCount")
    public ResponseEntity<UShort> getTotalCount (){return new ResponseEntity<>(machineService.getTotalCount(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getGoodCount")
    public ResponseEntity<UShort> getGoodCount (){return new ResponseEntity<>(machineService.getGoodCount(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getBadCount")
    public ResponseEntity<UShort> getBadCount (){return new ResponseEntity<>(machineService.getBadCount(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getMaintenanceCount")
    public ResponseEntity<UShort> getMaintenanceCount (){return new ResponseEntity<>(machineService.getMaintenanceCount(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getCurrentState")
    public ResponseEntity<Integer> getCurrentState (){return new ResponseEntity<>(machineService.getCurrentState(), HttpStatus.OK);}

    @CrossOrigin
    @GetMapping("/getState")
    public ResponseEntity<MessageResponse> getState () {
        MessageResponse resetMachine = machineService.getState();
        return new ResponseEntity<>(resetMachine, HttpStatus.OK);
    }
}
