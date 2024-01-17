package org.lamisplus.syncdashboard.repository;

import org.lamisplus.syncdashboard.domain.entity.RadetTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RadetTrackerRepository extends JpaRepository<RadetTracker, Long> {
    @Query(value = "SELECT *From public.central_radet_tracker order by id DESC", nativeQuery = true)
    List<RadetTracker> allTrackers();
    @Query(value = "SELECT *From public.central_radet_tracker where ip_code =?1 order by id DESC", nativeQuery = true)
    List<RadetTracker> ipTrackers(Long ipCode);
}
