package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.payloads.request.TypeRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TypeService {
    MessageResponse createType(TypeRequest typeRequest);

    Optional<Type> updateType(Integer typeId, TypeRequest typeRequest);

    void deleteType(Integer typeId);

    Type getType(Integer typeId);

    List<Type> getAllTypes();
}
