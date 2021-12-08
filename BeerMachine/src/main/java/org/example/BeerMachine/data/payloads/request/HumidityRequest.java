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
public class HumidityRequest {
    @NotNull
    private Integer batchReportId;

    @NotNull
    private Double humidity;

    @NotNull
    private String timestamp;

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

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public SimpleDateFormat getTimestampFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
