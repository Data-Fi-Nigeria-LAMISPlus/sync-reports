package org.lamisplus.syncreports.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.syncreports.domain.entity.Radet;
import org.lamisplus.syncreports.domain.entity.FlatFileRequest;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class GenerateExcelServiceImpl implements GenerateExcelService {
    private final RadetExtractService radetExtractService;
    private final ExcelService excelService;
    private final GenerateExcelDataHelper excelDataHelper;

    @Override
    public ByteArrayOutputStream generateRadet(FlatFileRequest flatFileRequest) {
        log.info("Start generating RADET");
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
}