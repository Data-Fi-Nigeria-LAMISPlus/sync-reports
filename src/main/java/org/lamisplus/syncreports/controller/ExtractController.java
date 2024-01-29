package org.lamisplus.syncreports.controller;

import lombok.RequiredArgsConstructor;
import org.lamisplus.syncreports.domain.entity.FlatFileRequest;
import org.lamisplus.syncreports.domain.entity.Tracker;
import org.lamisplus.syncreports.service.ExtractService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ExtractController {
    private final String BASE_URL = "/api/v1/extract";
    private final ExtractService extractService;

    //@Async
    @PostMapping(BASE_URL+"/{reportId}")
    public Tracker getExtracts(@PathVariable UUID reportId,
                                    @Valid @RequestBody List<String> facilityIds,
                                    @RequestParam String ipName) throws IOException {
        FlatFileRequest flatFileRequest = new FlatFileRequest();
        flatFileRequest.setFy(2024L);
        flatFileRequest.setFacilityIds(facilityIds);
        flatFileRequest.setQuarter("Q1");
        flatFileRequest.setIPName(ipName);
        return extractService.extractAndSaveReport(flatFileRequest, reportId);
    }

    /*@GetMapping(BASE_URL+"/tracker/{reportId}")
    public ResponseEntity<List<Tracker>> getExtractTrackers(@PathVariable UUID reportId) {
        return ResponseEntity.ok(extractService.getExtractTrackers(reportId));
    }*/

    @GetMapping(BASE_URL+"/download/{reportId}")
    public byte[] downloadFile(@RequestParam("url") String url, @PathVariable UUID reportId) {
        ByteArrayOutputStream baos = extractService.downloadFile (reportId, url);

        return baos.toByteArray ();
    }
}
