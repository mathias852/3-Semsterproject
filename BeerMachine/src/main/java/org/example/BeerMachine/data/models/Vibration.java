package org.example.BeerMachine.data.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vibrations")
public class Vibration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batchReportId", nullable = false)
    private BatchReport batchReport;

    @NotNull
    private float vibration;

    @NotNull
    private String timestamp;

    public Integer getId() {
        return id;
    }

    public BatchReport getBatchReport() {
        return batchReport;
    }

    public void setBatchReport(BatchReport batchReport) {
        this.batchReport = batchReport;
    }

    public float getVibration() {
        return vibration;
    }

    public void setVibration(float vibration) {
        this.vibration = vibration;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
