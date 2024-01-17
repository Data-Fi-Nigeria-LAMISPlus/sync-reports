package org.lamisplus.syncreports.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "central_radet_tracker")
public class RadetTracker {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ipCode;
    private String ipName;
    private Long fiscalYear;
    private String reportingQuarter;
    private String createdDate;
    private String status;
    private String links;
}
