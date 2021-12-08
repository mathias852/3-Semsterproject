package org.example.BeerMachine.data.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seqBatch", allocationSize = 0)
@Table(name="batches")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBatch")
    private Integer id;

    @NotNull
    private Integer amount;

    @NotNull
    private Integer speed;

    private Integer queueSpot;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    public Batch() {}

    public Batch(Integer id, Integer speed, Type type, Integer amount) {
        this.id = id;
        this.speed = speed;
        this.type = type;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

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

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getQueueSpot() {
        return queueSpot;
    }

    public void setQueueSpot(Integer queueSpot) {
        this.queueSpot = queueSpot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, type);
    }
}
