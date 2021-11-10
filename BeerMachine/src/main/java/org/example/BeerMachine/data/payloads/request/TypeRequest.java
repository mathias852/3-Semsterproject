package org.example.BeerMachine.data.payloads.request;

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
