package org.lamisplus.syncreports.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.syncreports.domain.entity.FlatFileRequest;
import org.lamisplus.syncreports.domain.entity.Hts;
import org.lamisplus.syncreports.repository.HtsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HtsService {
    private final HtsRepository htsRepository;

    public List<Hts> generatingHtsFile(FlatFileRequest flatFileRequest) {
        log.info("Hts request {}", flatFileRequest);
        return htsRepository.findAllInDatimId(flatFileRequest.getFacilityIds());
    }
}
