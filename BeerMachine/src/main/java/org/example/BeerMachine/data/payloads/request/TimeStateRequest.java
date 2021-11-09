package org.example.BeerMachine.data.payloads.request;

import org.example.BeerMachine.data.models.BatchReport;
import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Component
public class TimeStateRequest {
    @NotNull
    private Integer batchReportId;

    @NotNull
    private Integer stateId;

    @NotNull
    private Date startTime, endTime;

    private Integer stopReason;

    public Integer getBatchReportId() {
        return batchReportId;
    }

    public void setBatchReportId(Integer batchReportId) {
        this.batchReportId = batchReportId;
    }

    public BatchReport getBatchReport(BatchReportRepository batchReportRepository){
        List<BatchReport> batchReportList = batchReportRepository.findAll();
        for (BatchReport batchReport : batchReportList) {
            if (batchReport.getId().equals(getBatchReportId())){
                return batchReport;
            }
        }
        return null;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
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

    public Integer getStopReason() {
        return stopReason;
    }

    public void setStopReason(Integer stopReason) {
        this.stopReason = stopReason;
    }
}
