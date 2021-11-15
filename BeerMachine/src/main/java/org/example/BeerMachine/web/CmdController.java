package org.example.BeerMachine.web;

import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cmd")
public class CmdController {

    @CrossOrigin
    @PostMapping("/reset")
    public ResponseEntity<MessageResponse> sendReset () {
        //TODO: Implement OPC UA connection
        return new ResponseEntity<>(new MessageResponse("Reset command sent."), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/start")
    public ResponseEntity<MessageResponse> sendStart () {
        //TODO: Implement OPC UA connection
        return new ResponseEntity<>(new MessageResponse("Start command sent."), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/stop")
    public ResponseEntity<MessageResponse> sendStop () {
        //TODO: Implement OPC UA connection
        return new ResponseEntity<>(new MessageResponse("Stop command sent."), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/abort")
    public ResponseEntity<MessageResponse> sendAbort () {
        //TODO: Implement OPC UA connection
        return new ResponseEntity<>(new MessageResponse("Abort command sent."), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/clear")
    public ResponseEntity<MessageResponse> sendClear () {
        //TODO: Implement OPC UA connection
        return new ResponseEntity<>(new MessageResponse("Clear command sent."), HttpStatus.OK);
    }

}
