package org.lamisplus.syncdashboard.service;

import org.lamisplus.syncdashboard.domain.entity.FlatFileRequest;

import java.io.ByteArrayOutputStream;

public interface GenerateExcelService {
    ByteArrayOutputStream generateRadet(FlatFileRequest flatFileRequest);
}
