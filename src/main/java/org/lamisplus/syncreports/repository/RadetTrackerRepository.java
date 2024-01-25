package org.lamisplus.syncreports.repository;

import org.lamisplus.syncreports.domain.entity.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RadetTrackerRepository extends JpaRepository<Tracker, Long> {
    @Query(value = "SELECT * From central_radet_tracker where report_id=?1 order by id DESC", nativeQuery = true)
    List<Tracker> allTrackers(UUID reportId);
    @Query(value = "SELECT *From public.central_radet_tracker where ip_code =?1 order by id DESC", nativeQuery = true)
    List<Tracker> ipTrackers(Long ipCode);
}
