package org.example.BeerMachine.data.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@SequenceGenerator(name = "seqBatchReport", allocationSize = 0)
@Table(name="batchReports")
public class BatchReport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBatchReport")
    private Integer id;

    @NotNull
    private Integer batchId;

    @NotNull
    private Integer speed;

    @NotNull
    @ManyToOne
    private Type type;

    @NotNull
    private Integer amount; //how many units was wanted

    private Integer totalCount; //how many units was actually produced

    private Integer goodCount; //how many was acceptable

    private Integer rejectedCount; //how many was rejected

    private Date startTime;

    private Date endTime;

    private Double OEE;

    private Double availability;

    private Double performance;

    private Double quality;

    private boolean updated = false;

    @OneToMany(mappedBy="batchReport")
    private Set<Humidity> humidities;

    @OneToMany(mappedBy="batchReport")
    private Set<Temperature> temperatures;

    @OneToMany(mappedBy="batchReport")
    private Set<Vibration> vibrations;

    @OneToMany(mappedBy="batchReport")
    private Set<TimeState> timeStates;

    public BatchReport(Integer batchId, Integer speed, Type type, Integer amount) {
        this.batchId = batchId;
        this.speed = speed;
        this.type = type;
        this.amount = amount;
    }

    public BatchReport() {}

    public Integer getId() {
        return id;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Integer getRejectedCount() {
        return rejectedCount;
    }

    public void setRejectedCount(Integer rejectedCount) {
        this.rejectedCount = rejectedCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getOEE() {
        return OEE;
    }

    public void setOEE(Double OEE) {
        this.OEE = OEE;
    }

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public Type getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
}
