package org.example.BeerMachine.data.payloads.request;

import org.example.BeerMachine.data.models.Type;

import javax.validation.constraints.NotNull;

public class BatchRequest {
    @NotNull
    private Integer amount;

    @NotNull
    private int type_id;

    private Type ale = new Type(1, "Ale");
    private Type ipa = new Type(2, "IPA");
    private Type alcfree = new Type(3, "Alcohol Free");

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Type getType() {

        if(type_id == 1){
            return ale;
        } else {
            return alcfree;
        }
    }

    public void setType(int t) {
        this.type_id = t;
    }
}
