package org.lamisplus.syncreports.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.lamisplus.syncreports.domain.entity.*;
import org.lamisplus.syncreports.repository.RadetRepository;
import org.lamisplus.syncreports.repository.RadetTrackerRepository;
import org.lamisplus.syncreports.repository.ReportRepository;
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
public class ExtractService {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String dateAnother;
    public static String HOME_DIR = System.getProperty("user.dir");
    public String PATH_MAKER = File.separator;
    public static final SimpleDateFormat DATE_FORMAT_ANOTHER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String ipName;
    public static String zipFileName;
    private final RadetTrackerRepository radetTrackerRepository;
    private final GenerateExcelService generateExcelService;
    private final ReportRepository reportRepository;

    /*public File getRadetExtracts(ArrayList<String> datimIds) {
        List<Radet> radetExtractList = new ArrayList<>(radetExtractRepository.findAllByDatimIdIn(datimIds));

        String fileName = "Radet_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".csv";
        File dir = new File(HOME_DIR + File.separator + RADET_FOLDER);

        if(!dir.exists()) dir.mkdir();
        File file = new File(dir.getPath() + File.separator + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;//convertToCsv(radetExtractList, file.getPath(), datimIds.get(0), all);
    }*/

    public Tracker creatTrackers(Tracker fileTracker) {
        return radetTrackerRepository.save(fileTracker);
    }

   /* public List<Tracker> getExtractTrackers(UUID reportId){
        return radetTrackerRepository.allTrackers(reportId);
    }*/

    public ByteArrayOutputStream downloadFile(UUID reportId, String url) {
        log.info("downloading report ...");
        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
        Report report = reportRepository.findById(reportId).orElseThrow(()-> new EntityNotFoundException("reportId not found" + reportId));


        try (InputStream is = new FileInputStream (HOME_DIR + File.separator + report.getUrl() + File.separator + url)) {
            IOUtils.copy (is, baos);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return baos;
    }


    public Tracker extractAndSaveReport(FlatFileRequest flatFileRequest, UUID reportId) throws IOException {
        Report report = getValidReportsStatus(reportId);
        FileOutputStream fos = null;
        File file = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        log.info("report is {}", report.getUrl());
        try {
            switch (ReportName.getReportName(report.getUrl())) {
                case RADET:
                    byteArrayOutputStream = generateExcelService.generateRadet(flatFileRequest);
                    break;
                case PREP:
                    byteArrayOutputStream = generateExcelService.generatePrep(flatFileRequest);
                    break;
                case FLAT_FILE:
                    byteArrayOutputStream = generateExcelService.generateFlatFile(flatFileRequest);
                    break;
                case HTS:
                    byteArrayOutputStream = generateExcelService.generateHts(flatFileRequest);
                    break;
                default:
                    log.error("report not known {}", report.getUrl());
                    break;
            }
            if(byteArrayOutputStream != null) {

                String filePath = HOME_DIR + PATH_MAKER + report.getUrl().trim() + PATH_MAKER;
                zipFileName = flatFileRequest.getIPName() + "-" + flatFileRequest.getFy() + flatFileRequest.getQuarter() + "-" + DATE_FORMAT.format(new Date()) + ".xls";

                File dir = new File(filePath);

                if (!dir.exists()) dir.mkdir();
                file = new File(filePath + zipFileName);
                fos = new FileOutputStream(file);
                byteArrayOutputStream.writeTo(fos);
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if(fos != null) {
                fos.close();
            }
        }

        try {
            Tracker fileTracker = new Tracker();
            ipName = flatFileRequest.getIPName();
            Date date = new Date();

            dateAnother = DATE_FORMAT_ANOTHER.format(date);

            fileTracker.setCreatedDate(dateAnother);
            fileTracker.setFiscalYear(flatFileRequest.getFy());
            fileTracker.setIpCode(flatFileRequest.getFacilityIds().get(0));
            fileTracker.setReportingQuarter(flatFileRequest.getQuarter());
            fileTracker.setIpName(ipName +"_("+ file.length()/1000000.00D + "MB)");
            fileTracker.setLinks(zipFileName.replace(".xlx", ""));
            fileTracker.setStatus("Complete");
            fileTracker.setReportId(reportId);
            return creatTrackers(fileTracker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO: handle the return
        return null;
    }

    private Report getValidReportsStatus (UUID reportId){
        return reportRepository
                .findByIdAndArchived(reportId, 0)
                .orElseThrow(()-> new EntityNotFoundException(reportId.toString() + " not found"));
    }
}
