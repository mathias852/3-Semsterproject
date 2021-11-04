package org.example.BeerMachine.data.payloads.request;

import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class BatchRequest {
    @NotNull
    private Integer amount;

    @NotNull
    private Integer type_id;

    public Integer getAmount() {
        return amount;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    //Missing the types from DB
    public Type getType(TypeRepository typeRepository) {
        List<Type> typeList = typeRepository.findAll();
        for (Type type : typeList) {
            if (type.getId().equals(getType_id()))
                    return type;
        }
        return null;
    }

    public void setType(int t) {
        this.type_id = t;
    }
}
