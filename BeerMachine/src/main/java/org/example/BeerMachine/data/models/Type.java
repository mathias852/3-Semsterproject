package org.example.BeerMachine.data.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Double idealCycleTime;

    @NotNull
    private Integer maxSpeed;

    @OneToMany(mappedBy="type")
    private Set<Batch> batches;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setIdealCycleTime(Double idealCycleTime) {
        this.idealCycleTime = idealCycleTime;
    }

    public Double getIdealCycleTime() {
        return idealCycleTime;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id.equals(type.id) &&
                name.equals(type.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
