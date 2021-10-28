package org.example.BeerMachine.data.payloads.request;

import org.example.BeerMachine.BeerMachineApplication;
import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.example.BeerMachine.service.TypeServiceImpl;
import org.example.BeerMachine.web.TypeController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

public class BatchRequest {
    @NotNull
    private Integer amount;

    @NotNull
    private int type_id;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    //Missing the types from DB
    public Type getType() {
        return Type
    }

    public void setType(int t) {
        this.type_id = t;
    }
}
