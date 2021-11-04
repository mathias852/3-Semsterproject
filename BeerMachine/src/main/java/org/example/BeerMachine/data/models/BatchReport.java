package org.example.BeerMachine.data.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="batchReports")
public class BatchReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @OneToOne()
    @JoinColumn(name = "batchId", referencedColumnName = "id")
    private Batch batch;

    @OneToOne()
    @JoinColumn(name = "batchReportId", referencedColumnName = "id")
    private BatchReport batchReport;

    @NotNull
    private Integer speed;

    @NotNull
    private Integer totalCount;

    private Integer goodCount;

    private Integer rejectedCount;

    private Date startTime;

    private Date endTime;

    private Double OEE;

    @OneToMany(mappedBy="batchReport")
    private Set<Humidity> humidities;

    @OneToMany(mappedBy="batchReport")
    private Set<Temperature> temperatures;

    @OneToMany(mappedBy="batchReport")
    private Set<Vibration> vibrations;

    @OneToMany(mappedBy="batchReport")
    private Set<TimeState> timeStates;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public BatchReport getBatchReport() {
        return batchReport;
    }

    public void setBatchReport(BatchReport batchReport) {
        this.batchReport = batchReport;
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
}
