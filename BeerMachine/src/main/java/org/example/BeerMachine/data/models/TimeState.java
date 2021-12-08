package org.example.BeerMachine.data.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "timestates")
public class TimeState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batchReportId", nullable = false)
    private BatchReport batchReport;

    @NotNull
    private Integer stateId;

    private Integer stopReason;

    @NotNull
    private Date startTime;

    @NotNull
    private Date endTime;

    public TimeState() {
    }

    public TimeState(BatchReport batchReport, Integer stateId, Integer stopReason, Date startTime) {
        this.batchReport = batchReport;
        this.stateId = stateId;
        this.stopReason = stopReason;
        this.startTime = startTime;
    }

    public Integer getId() {
        return id;
    }

    public BatchReport getBatchReport() {
        return batchReport;
    }

    public void setBatchReport(BatchReport batchReport) {
        this.batchReport = batchReport;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStopReason() {
        return stopReason;
    }

    public void setStopReason(Integer stopReason) {
        this.stopReason = stopReason;
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
}
