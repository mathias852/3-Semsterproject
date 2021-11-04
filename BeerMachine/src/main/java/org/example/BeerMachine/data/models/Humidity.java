package org.example.BeerMachine.data.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "humidities")
public class Humidity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batchReportId", nullable = false)
    private BatchReport batchReport;

    @NotNull
    private Double humidity;

    @NotNull
    private Date timestamp;


}
