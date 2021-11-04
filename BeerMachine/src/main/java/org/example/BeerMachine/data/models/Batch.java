package org.example.BeerMachine.data.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="batches")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @OneToOne()
    @JoinColumn(name = "batchReportId", referencedColumnName = "id")
    private BatchReport batchReport;


    public Batch() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return id.equals(batch.id) &&
                amount.equals(batch.amount) &&
                type == batch.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, type);
    }
}
