package org.lamisplus.syncreports.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.syncreports.domain.entity.FlatFileRequest;
import org.lamisplus.syncreports.domain.entity.Prep;
import org.lamisplus.syncreports.repository.PrepRepository;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrepService {
    private final PrepRepository prepRepository;

    public List<Prep> generatingPrepFile(FlatFileRequest flatFileRequest) {
        log.info("PREP request {}", flatFileRequest);
        return prepRepository.findAllInDatimId(flatFileRequest.getFacilityIds());
    }
}
