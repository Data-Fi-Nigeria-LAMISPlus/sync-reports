package org.lamisplus.syncdashboard.repository;

import org.lamisplus.syncdashboard.domain.entity.AggregateData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AggregateDataRepository extends JpaRepository<AggregateData, String>{
    Optional<AggregateData> findAggregateDataByFacilityId(String facilityId);
}
