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
    private Integer typeId;

    //@NotNull
    //private Integer Speed;

    public Integer getAmount() {
        return amount;
    }

    public Integer getTypeId() {
        return typeId;
    }

    //Not yet implemented functionality to set a speed when creating a new batch
    //public Integer getSpeed(){
    //    return speed;
    //}

    //public Integer setSpeed(Integer speed){
    // this.speed = speed;
    // }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Type getType(TypeRepository typeRepository) {
        List<Type> typeList = typeRepository.findAll();
        for (Type type : typeList) {
            if (type.getId().equals(getTypeId()))
                    return type;
        }
        return null;
    }

    public void setType(int t) {
        this.typeId = t;
    }
}
