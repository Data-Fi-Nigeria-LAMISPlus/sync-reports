package org.lamisplus.syncdashboard.service;

//import liquibase.util.csv.CSVWriter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
        import org.lamisplus.syncdashboard.domain.entity.AggregateData;
import org.lamisplus.syncdashboard.domain.entity.Radet;
import org.lamisplus.syncdashboard.domain.entity.FlatFileRequest;
import org.lamisplus.syncdashboard.domain.entity.RadetTracker;
import org.lamisplus.syncdashboard.repository.AggregateDataRepository;
import org.lamisplus.syncdashboard.repository.RadetRepository;
import org.lamisplus.syncdashboard.repository.RadetTrackerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
        import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RadetExtractService {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String dateAnother;
    public static String dateName;
    public static String HOME_DIR = System.getProperty("user.dir");
    public String PATH_MAKER = File.separator;
    public static final SimpleDateFormat DATE_FORMAT_ANOTHER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String RADET_FOLDER = "radet";

    public static String ipName;
    public static String zipFileName;
    private final RadetRepository radetExtractRepository;
    private final RadetTrackerRepository radetTrackerRepository;
    private final AggregateDataRepository aggregateDataRepository;
    public File getRadetExtracts(ArrayList<String> datimIds, boolean all) {
        List<Radet> radetExtractList = new ArrayList<>(radetExtractRepository.findAllByDatimidIn(datimIds));

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
    }

    public void creatTrackers(RadetTracker fileTracker) {
        radetTrackerRepository.save(fileTracker);
    }

    public List<RadetTracker> getRadetExtractTrackers(){
        return radetTrackerRepository.allTrackers();
    }

    private void SaveRadetTracker(String link, String firstId, Boolean all){
        RadetTracker tracker = new RadetTracker();
        String now = String.valueOf(LocalDateTime.now());
        tracker.setCreatedDate(now);
        tracker.setLinks(link);
        tracker.setReportingQuarter("2023Q4");
        tracker.setFiscalYear(2023L);
        tracker.setStatus("Success");
        Optional<AggregateData> aggregateDataOptional;
        if (all) {
            tracker.setIpCode("123456");//TODO
            tracker.setIpName("Combined_Radet_" + now);
        }else {
            aggregateDataOptional = this.aggregateDataRepository.findAggregateDataByFacilityId(firstId);
            if(aggregateDataOptional.isPresent()) {
                tracker.setIpCode(aggregateDataOptional.get().getIpCode());
                tracker.setIpName(aggregateDataOptional.get().getIpName());
            }
        }

        radetTrackerRepository.save(tracker);
    }

    /*
    public File convertToCsv(List<CentralRadet> objects, String filePath, String firstId, boolean all) {
        if (objects.isEmpty()) {
            log.info("List is empty. Nothing to convert to CSV.");
            return null;
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            Class<?> clazz = objects.get(0).getClass();
            Field[] fields = clazz.getDeclaredFields();

            // Write header
            String[] header = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                header[i] = fields[i].getName();
            }
            csvWriter.writeNext(header);

            // Write data rows
            for (CentralRadet object : objects) {
                String[] data = new String[fields.length];
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    field.setAccessible(true); // Ensure private fields are accessible
                    try {
                        Object value = field.get(object);
                        data[i] = value != null ? value.toString() : "";
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                csvWriter.writeNext(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        File file = new File(filePath);
        SaveRadetTracker(file.getName(), firstId, all);
        return file;
    }
*/
    //============================Dr Karim==============================
    @SneakyThrows
    public ByteArrayOutputStream downloadFile(String url) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream ();


        try (InputStream is = new FileInputStream (HOME_DIR + File.separator + RADET_FOLDER + File.separator + url)) {
            IOUtils.copy (is, baos);
        } catch (IOException ignored) {
        }

        return baos;
    }

    public List<Radet> generatingRadetFile(FlatFileRequest flatFileRequest) {
        log.info("radet request " + flatFileRequest);
        Date date1 = new Date();
        final String FILE_NAME_DATE = DATE_FORMAT.format(date1);
        dateAnother = DATE_FORMAT_ANOTHER.format(date1);
        String period = flatFileRequest.getFy() + flatFileRequest.getQuater();
        List<String> DatimIds = flatFileRequest.getFacilityIds();
        dateName = FILE_NAME_DATE;

        ipName = flatFileRequest.getIPName();
        zipFileName = ipName + "-" + period + "-" + dateName + ".xls";

        return radetExtractRepository.findAllByDatimidInAndPeriod(DatimIds, period);
    }
}
