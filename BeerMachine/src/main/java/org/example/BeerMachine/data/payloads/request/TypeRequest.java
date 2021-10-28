package org.example.BeerMachine.data.payloads.request;

import org.example.BeerMachine.data.models.Type;

import javax.validation.constraints.NotNull;

public class TypeRequest {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
