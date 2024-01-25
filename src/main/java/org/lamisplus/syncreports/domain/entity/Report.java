package org.lamisplus.syncreports.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "report")
public class Report {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;
    private String name;
    private int archived;
    private String url;

    @PrePersist
    public void setUuid(){
        if(id == null) id = UUID.randomUUID();
    }
}
