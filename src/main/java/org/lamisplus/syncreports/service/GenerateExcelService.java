package org.lamisplus.syncreports.service;

import org.lamisplus.syncreports.domain.entity.FlatFileRequest;

import java.io.ByteArrayOutputStream;

public interface GenerateExcelService {
    ByteArrayOutputStream generateRadet(FlatFileRequest flatFileRequest);
    ByteArrayOutputStream generatePrep(FlatFileRequest flatFileRequest);
    ByteArrayOutputStream generateFlatFile(FlatFileRequest flatFileRequest);
    ByteArrayOutputStream generateHts(FlatFileRequest flatFileRequest);

}
