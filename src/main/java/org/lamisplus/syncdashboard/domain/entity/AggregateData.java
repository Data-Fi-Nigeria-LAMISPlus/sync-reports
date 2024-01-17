package org.lamisplus.syncdashboard.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

@Entity
@Table(name = "aggregate_data",  schema = "public")
@Data
@NoArgsConstructor
public class AggregateData implements Serializable, Persistable<Long>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String facilityId;
    private String facilityName;
    private String facilityState;
    private String facilityLga;
    private String ipCode;
    private String ipName;
    private Long patient;
    private Long biometric;
    private Long hiv;
    private Long hts;
    private Long prep;
    private Long pmtct;
    private Long male;
    private Long female;
    private Long triage;
    private Long lab;
    private Long radet;
    private Long prepReport;
    private Long htsTst;
    private Long htsPos;
    private Long txNew;
    private Long txCurr;
    private Long txPvlsd;
    private Long txPvlsn;


    @Override
    public boolean isNew() {
        return false;
    }

}
