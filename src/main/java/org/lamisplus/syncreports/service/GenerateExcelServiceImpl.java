package org.lamisplus.syncreports.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.syncreports.domain.entity.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class GenerateExcelServiceImpl implements GenerateExcelService {
    private final RadetExtractService radetExtractService;
    private final PrepService prepService;
    private final ExcelService excelService;
    private final HtsService htsService;

    private final FlatFileService flatFileService;
    private final GenerateExcelDataHelper excelDataHelper;

    @Override
    public ByteArrayOutputStream generateRadet(FlatFileRequest flatFileRequest) {
        log.info("Start generating RADET...");
        try {
            List<Radet> radets = radetExtractService.generatingRadetFile(flatFileRequest);
            log.info("SIZE {}", radets.size());
            List<Map<Integer, Object>> data = excelDataHelper.fillRadetDataMapper(radets);
            return excelService.generate(Constants.RADET_SHEET, data, Constants.RADET_HEADER);
        } catch (Exception e) {
            log.error("Error Occurred when generating RADET !!!");
            e.printStackTrace();
        }
        log.info("End generate RADET");
        return null;
    }

    @Override
    public ByteArrayOutputStream generatePrep(FlatFileRequest flatFileRequest) {
        log.info("Start generating PREP");
        try {
            List<Prep> prepReport = prepService.generatingPrepFile(flatFileRequest);
            //LOG.error("Hts Size: {}", htsReport.size());
            List<Map<Integer, Object>> data = excelDataHelper.fillPrepDataMapper(prepReport);
            return excelService.generate(Constants.PREP_SHEET, data, Constants.PrEP_HEADER);
        } catch (Exception e) {
            log.error("Error Occurred when generating PREP !!!");
            e.printStackTrace();
        }
        log.info("End generate PREP...");
        return null;
    }

    @Override
    public ByteArrayOutputStream generateFlatFile(FlatFileRequest flatFileRequest) {
        log.info("Start generating flat file...");
        try {
            List<FlatFile> data = flatFileService.generatingFlatFile(flatFileRequest);
            log.info("result set .........");
            List<Map<Integer, Object>> fullData = GenerateExcelDataHelper.fillFlatFileMapperDataMapper(data);
            log.info("mapping .........");
            return excelService.generate(Constants.FLAT_FILE_LIST, fullData, Constants.FLAT_FILE_HEADER);
        } catch (Exception e) {
            log.error("Error Occurred when generating flat file...", e.getMessage());
            e.printStackTrace();
        }
        log.info("Finished generating flat file....");
        return null;
    }

    @Override
    public ByteArrayOutputStream generateHts(FlatFileRequest flatFileRequest) {
        log.info("Start generating hts...");
        try {
            List<Hts> htsReport = htsService.generatingHtsFile(flatFileRequest);
            List<Map<Integer, Object>> data = excelDataHelper.fillHtsDataMapper(htsReport);
            return excelService.generate(Constants.HTS_SHEET, data, Constants.HTS_HEADER);
        } catch (Exception e) {
            log.error("Error Occurred when generating HTS !!!");
            e.printStackTrace();
        }
        log.info("End generate patient HTS");
        return null;
    }
}