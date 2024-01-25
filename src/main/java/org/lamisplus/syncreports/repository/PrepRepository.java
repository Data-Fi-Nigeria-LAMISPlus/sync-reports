package org.lamisplus.syncreports.repository;

import org.lamisplus.syncreports.domain.entity.Prep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface PrepRepository extends JpaRepository<Prep, Long>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM hts_prep_datamart.final_prepquery_datamart WHERE datimid IN (?1)", nativeQuery = true)
    List<Prep> findAllInDatimId(List<String> datimId);
}
