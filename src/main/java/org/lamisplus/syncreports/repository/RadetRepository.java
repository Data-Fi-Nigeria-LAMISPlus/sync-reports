package org.lamisplus.syncreports.repository;

import org.lamisplus.syncreports.domain.entity.Radet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RadetRepository extends JpaRepository<Radet, Long> {
    List<Radet> findAllByDatimIdIn(Collection<String> datimid);

    List<Radet> findAllByDatimIdInAndPeriod(List<String> datimid, String period);
}