package org.example.BeerMachine.service;

import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.payloads.request.TypeRequest;
import org.example.BeerMachine.data.payloads.response.MessageResponse;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    @Override
    public MessageResponse createType(TypeRequest typeRequest) {
        Type newType = new Type();
        newType.setName(typeRequest.getName());
        newType.setIdealCycleTime(typeRequest.getIdealCycleTime());
        newType.setMaxSpeed(typeRequest.getMaxSpeed());
        typeRepository.save(newType);
        return new MessageResponse("New type created successfully");
    }

    @Override
    public Optional<Type> updateType(Integer typeId, TypeRequest typeRequest) {
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isEmpty()){
            return null;
        }
        else {
            type.get().setName(typeRequest.getName());
            typeRepository.save(type.get());
        }
        return type;
    }

    @Override
    public void deleteType(Integer typeId) {
        if (typeRepository.getById(typeId).getId().equals(typeId)){
            typeRepository.deleteById(typeId);
        }
    }

    @Override
    public Type getType(Integer typeId) {
        try {
            return typeRepository.findById(typeId).get();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Type> getAllTypes() {

        return typeRepository.findAll();
    }

}
