package org.lamisplus.syncreports.controller;

import lombok.RequiredArgsConstructor;
import org.lamisplus.syncreports.domain.entity.FlatFileRequest;
import org.lamisplus.syncreports.domain.entity.RadetTracker;
import org.lamisplus.syncreports.service.GenerateExcelService;
import org.lamisplus.syncreports.service.RadetExtractService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RadetExtractController {
    private final RadetExtractService radetExtractService;
    public static String HOME_DIR = System.getProperty("user.dir");
    public String PATH_MAKER = File.separator;
    private final GenerateExcelService generateExcelService;
    private final String BASE_URL = "/api/v1/radet";

    //@Async
    @PostMapping(BASE_URL+"/extract")
    public RadetTracker getRadetExtracts(@Valid @RequestBody List<String> facilityIds,
                                 @RequestParam String ipName) throws IOException {
        FlatFileRequest flatFileRequest = new FlatFileRequest();
        flatFileRequest.setFy(2023L);
        flatFileRequest.setFacilityIds(facilityIds);
        flatFileRequest.setQuarter("Q1");
        flatFileRequest.setIPName(ipName);
        return saveRadetFile(flatFileRequest);
    }

    @GetMapping(BASE_URL+"/tracker")
    public ResponseEntity<List<RadetTracker>> getRadetExtractTracker() {
        return ResponseEntity.ok(radetExtractService.getRadetExtractTrackers());
    }

    @GetMapping(BASE_URL+"/download")
    public byte[] downloadFile(@RequestParam("url") String url) throws IOException
    {
        ByteArrayOutputStream baos = radetExtractService.downloadFile (url);
        /*response.setHeader ("Content-Type", "application/octet-stream");
        response.setHeader ("Content-Disposition", "attachment;filename=" + url);
        response.setHeader ("Content-Length", Integer.toString (baos.size ()));
        OutputStream outputStream = response.getOutputStream ();*/
        /*outputStream.write (baos.toByteArray ());
        outputStream.close ();
        response.flushBuffer ();*/

        return baos.toByteArray ();
    }

    @Async
    public RadetTracker saveRadetFile(FlatFileRequest flatFileRequest) throws IOException {
        FileOutputStream fos = null;
        File file = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = generateExcelService.generateRadet(flatFileRequest);
            String filePath = HOME_DIR + PATH_MAKER + "radet" + PATH_MAKER;

            File dir = new File(filePath);

            if(!dir.exists()) dir.mkdir();
            file = new File(filePath+ radetExtractService.zipFileName);
            fos = new FileOutputStream(file);
            byteArrayOutputStream.writeTo(fos);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if(fos != null) {
                fos.close();
            }
        }

        try {
            RadetTracker fileTracker = new RadetTracker();
            fileTracker.setCreatedDate(radetExtractService.dateAnother);
            fileTracker.setFiscalYear(flatFileRequest.getFy());
            fileTracker.setIpCode(flatFileRequest.getFacilityIds().get(0));
            fileTracker.setReportingQuarter(flatFileRequest.getQuarter());
            fileTracker.setIpName(radetExtractService.ipName +"_("+ file.length()/1000000.00D + "MB)");
            fileTracker.setLinks(radetExtractService.zipFileName.replace(".xlx", ""));
            fileTracker.setStatus("Complete");
            return radetExtractService.creatTrackers(fileTracker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO: handle the return
        return null;
    }
}
