package org.lamisplus.syncreports.repository;

import org.lamisplus.syncreports.domain.entity.Hts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HtsRepository extends JpaRepository<Hts, Long>, JpaSpecificationExecutor {
    @Query(value = "SELECT * FROM hts_prep_datamart.final_htsquery_datamart WHERE datim_id IN (?1)", nativeQuery = true)
    List<Hts> findAllInDatimId(List<String> datimId);
}
