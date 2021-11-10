package org.example.BeerMachine.data.payloads.request;

import org.example.BeerMachine.data.models.Batch;
import org.example.BeerMachine.data.models.Type;
import org.example.BeerMachine.data.repository.BatchRepository;
import org.example.BeerMachine.data.repository.TypeRepository;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class BatchReportRequest {
    @NotNull
    private Integer batchId;

    @NotNull
    private Integer speed;

    @NotNull
    private Integer totalCount;

    private Integer goodCount, rejectedCount;

    private String startTime, endTime;

    private Double OEE;

    public Integer getBatchId() {
        return batchId;
    }

    public Batch getBatch(BatchRepository batchRepository) {
        List<Batch> batchList = batchRepository.findAll();
        for (Batch batch : batchList) {
            if (batch.getId().equals(getBatchId())){
                return batch;
            }
        }
        return null;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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

    public Double getOEE() {
        return OEE;
    }

    public void setOEE(Double OEE) {
        this.OEE = OEE;
    }
}
