package org.example.BeerMachine.data.payloads.request;

import org.example.BeerMachine.data.models.BatchReport;
import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.repository.BatchReportRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class TimeStateRequest {
    @NotNull
    private Integer batchReportId;

    @NotNull
    private Integer stateId;

    @NotNull
    private String startTime, endTime;

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

    public String getStartTime(){
        return startTime;
    }

    public Date getStartTimeFormat(String startTime) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
    }

    public String getEndTime(){
        return startTime;
    }

    public Date getEndTimeFormat(String getEndTime) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getEndTime);
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStopReason() {
        return stopReason;
    }

    public void setStopReason(Integer stopReason) {
        this.stopReason = stopReason;
    }
}
