package org.lamisplus.syncreports.repository;

import org.lamisplus.syncreports.domain.entity.AggregateData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AggregateDataRepository extends JpaRepository<AggregateData, String>{
    Optional<AggregateData> findAggregateDataByFacilityId(String facilityId);
}
