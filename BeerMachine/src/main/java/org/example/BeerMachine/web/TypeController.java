package org.example.BeerMachine.web;

import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.payloads.request.TypeRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    TypeService typeService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Type>> getAllTypes () {
        List<Type> types = typeService.getAllTypes();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/find/{id}")
    public ResponseEntity<Type> getTypeById (@PathVariable("id") Integer id) {
        Type type = typeService.getType(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addType(@RequestBody TypeRequest type) {
        MessageResponse newType = typeService.createType(type);
        return new ResponseEntity<>(newType, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Type>> updateType(@PathVariable Integer id, @RequestBody TypeRequest type) {
        Optional<Type> updateType = typeService.updateType(id, type);
        return new ResponseEntity<>(updateType, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteType(@PathVariable("id") Integer id) {
        typeService.deleteType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
