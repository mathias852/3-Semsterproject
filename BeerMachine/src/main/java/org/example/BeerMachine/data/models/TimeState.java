package org.example.BeerMachine.data.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "timestates")
public class TimeState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
