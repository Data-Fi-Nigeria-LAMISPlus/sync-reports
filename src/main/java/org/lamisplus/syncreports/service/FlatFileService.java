package org.lamisplus.syncreports.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.syncreports.domain.entity.FlatFile;
import org.lamisplus.syncreports.domain.entity.FlatFileRequest;
import org.lamisplus.syncreports.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlatFileService {
    private final ReportRepository reportRepository;

    public List<FlatFile> generatingFlatFile(FlatFileRequest flatFileRequest) {
        log.info("Flat File request {}", flatFileRequest);
        String period = flatFileRequest.getFy() + flatFileRequest.getQuarter();
        return reportRepository.getFlatFile(flatFileRequest.getFacilityIds(), period);
    }
}
