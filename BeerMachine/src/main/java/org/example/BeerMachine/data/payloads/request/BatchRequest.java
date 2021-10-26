package org.example.BeerMachine.data.payloads.request;

import org.example.BeerMachine.data.models.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BatchRequest {
    @NotNull
    private Integer amount;

    @NotNull
    private Type type;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Type getType() {

        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
