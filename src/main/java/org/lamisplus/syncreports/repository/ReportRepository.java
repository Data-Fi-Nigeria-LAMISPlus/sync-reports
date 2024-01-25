package org.lamisplus.syncreports.repository;


import org.lamisplus.syncreports.domain.entity.FlatFile;
import org.lamisplus.syncreports.domain.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ReportRepository extends JpaRepository<Report, UUID> {
    Optional<Report> findByIdAndArchived(UUID id, int archived);

    List<Report> findAllByArchived(int archived);

    @Query(value = "SELECT agf.datim_id AS datimId, agf.period, agf.data_element AS dataElement, agf.data_element_name AS dataElementName, " +
            "agf.category_option_combo AS categoryOptionCombo, " +
            "agf.category_option_combo_name AS categoryOptionComboName, pat_combo.attribute_combo as attributeOptionCombo, agf.value, " +
            "cpm.facility_name AS facilityName, cpm.facility_state AS facilityState, cpm.facility_lga AS facilityLga, cpm.ip_name AS ipName " +
            "FROM aggregate_flatfile as agf " +
            "   INNER JOIN central_partner_mapping as cpm on agf.datim_id = cpm.datim_id " +
            "   INNER JOIN partner_attribute_combo as pat_combo on cast(cpm.ip_code as varchar(255)) = pat_combo.partner_code " +
            "WHERE agf.datim_id IN (?1) AND agf.period=?2", nativeQuery = true)
    List<FlatFile> getFlatFile(List<String> datimIds, String period);

}
