package org.lamisplus.syncdashboard.repository;

import org.lamisplus.syncdashboard.domain.entity.Radet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RadetRepository extends JpaRepository<Radet, Long> {
    List<Radet> findAllByDatimidIn(Collection<String> datimid);

    List<Radet> findAllByDatimidInAndPeriod(Collection<String> datimid, String period);
}