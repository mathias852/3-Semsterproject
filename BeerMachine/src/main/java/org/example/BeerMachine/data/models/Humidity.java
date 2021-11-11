package org.example.BeerMachine.data.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "humidities")
public class Humidity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batchReportId", nullable = false)
    private BatchReport batchReport;

    @NotNull
    private Double humidity;

    @NotNull
    private Date timestamp;

    public Integer getId() {
        return id;
    }

    public BatchReport getBatchReport() {
        return batchReport;
    }

    public void setBatchReport(BatchReport batchReport) {
        this.batchReport = batchReport;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
