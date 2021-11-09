package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.payloads.request.BatchRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    BatchService batchService;

    @GetMapping("/all")
    public ResponseEntity<List<Batch>> getAllBatches () {
        List<Batch> batches = batchService.getAllBatches();
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Batch> getBatchById (@PathVariable("id") Integer id) {
        Batch batch = batchService.getBatch(id);
        return new ResponseEntity<>(batch, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addBatch(@RequestBody BatchRequest batch) {
        MessageResponse newBatch = batchService.createBatch(batch);
        return new ResponseEntity<>(newBatch, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Batch>> updateBatch(@PathVariable Integer id, @RequestBody BatchRequest batch) {
        Optional<Batch> updateBatch = batchService.updateBatch(id, batch);
        return new ResponseEntity<>(updateBatch, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBatch(@PathVariable("id") Integer id) {
        batchService.deleteBatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
