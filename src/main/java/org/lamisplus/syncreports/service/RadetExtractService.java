package org.lamisplus.syncreports.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.lamisplus.syncreports.domain.entity.*;
import org.lamisplus.syncreports.repository.AggregateDataRepository;
import org.lamisplus.syncreports.repository.RadetRepository;
import org.lamisplus.syncreports.repository.RadetTrackerRepository;
import org.lamisplus.syncreports.repository.ReportRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RadetExtractService {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String dateAnother;
    public static String dateName;
    public static final SimpleDateFormat DATE_FORMAT_ANOTHER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String ipName;
    private final RadetRepository radetExtractRepository;

    public List<Radet> generatingRadetFile(FlatFileRequest flatFileRequest) {
        log.info("radet request " + flatFileRequest);
        /*Date date1 = new Date();
        final String FILE_NAME_DATE = DATE_FORMAT.format(date1);
        dateAnother = DATE_FORMAT_ANOTHER.format(date1);*/
        String period = flatFileRequest.getFy() + flatFileRequest.getQuarter();
        log.info("period request " + period);
        /*dateName = FILE_NAME_DATE;

        ipName = flatFileRequest.getIPName();*/
        return radetExtractRepository.findAllByDatimIdInAndPeriod(flatFileRequest.getFacilityIds(), period);
    }
}
