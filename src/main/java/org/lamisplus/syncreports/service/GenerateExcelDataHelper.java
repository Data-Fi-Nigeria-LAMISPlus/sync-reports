package org.lamisplus.syncreports.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.syncreports.domain.entity.Radet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class GenerateExcelDataHelper {
    List<Object> errorObjects = new ArrayList<Object>();

    public List<Map<Integer, Object>> fillRadetDataMapper(@NonNull List<Radet> reportDtos) {
        List<Map<Integer, Object>> result = new ArrayList<>();
        //deleteErrorFile();
        int sn = 1;
        log.info("converting RADET db records to excel ....");
        Radet currentRecord = null;
        for (Radet radetReportDto : reportDtos) {
            try {
                currentRecord = radetReportDto;
                Map<Integer, Object> map = new HashMap<>();
                String personUuid = radetReportDto.getUniquePersonUuid();
                Double repeatVl = null;
                String tbStatusOutCome = null;
                int index = 0;

                //sn
                map.put(index++, sn);

                //bio hospital number & state, lga & facility
                map.put(index++, radetReportDto.getState());
                map.put(index++, radetReportDto.getLga());
                map.put(index++, radetReportDto.getLga());
                map.put(index++, radetReportDto.getFacilityName());
                map.put(index++, radetReportDto.getDatimId());
                map.put(index++, personUuid);
                map.put(index++, radetReportDto.getDatimId() + "_" + radetReportDto.getUniquePersonUuid());
                map.put(index++, radetReportDto.getHospitalNumber());
                map.put(index++, radetReportDto.getUniqueId());

                //ovc
                map.put(index++, radetReportDto.getHouseholdNumber());
                map.put(index++, radetReportDto.getOvcNumber());

                //bio data
                map.put(index++, radetReportDto.getGender());
                map.put(index++, radetReportDto.getTargetGroup());
                map.put(index++, radetReportDto.getCurrentWeight());
                map.put(index++, radetReportDto.getPregnancyStatus());
                map.put(index++, radetReportDto.getDateOfBirth());

                map.put(index++, radetReportDto.getAge());
                map.put(index++, getStringValue(String.valueOf(radetReportDto.getCareEntry())));
                map.put(index++, radetReportDto.getDateOfRegistration());
                map.put(index++, radetReportDto.getDateOfEnrollment());
                map.put(index++, radetReportDto.getArtStartDate());
                map.put(index++, radetReportDto.getLastPickupDate());
                map.put(index++, radetReportDto.getMonthsOfArvRefill());

                map.put(index++, radetReportDto.getRegimenLineAtStart());
                map.put(index++, radetReportDto.getRegimenAtStart());
                map.put(index++, radetReportDto.getDateOfStartOfCurrentARTRegimen());
                map.put(index++, radetReportDto.getCurrentRegimenLine());
                map.put(index++, radetReportDto.getCurrentArtRegimen());

                //cd4
                map.put(index++, null); //TODO Clinical Staging at Last Visit
                map.put(index++, radetReportDto.getDateOfLastCd4Count());
                map.put(index++, radetReportDto.getLastCd4Count());

                //vl
                map.put(index++, radetReportDto.getDateOfViralLoadSampleCollection());
                map.put(index++, radetReportDto.getDateOfCurrentViralLoadSample());
                map.put(index++, radetReportDto.getCurrentViralLoad());
                map.put(index++, radetReportDto.getDateOfCurrentViralLoad());
                map.put(index++, radetReportDto.getViralLoadIndication());
                map.put(index++, radetReportDto.getVlEligibilityStatus());
                map.put(index++, radetReportDto.getDateOfVlEligibilityStatus());

                //current status
                map.put(index++, radetReportDto.getCurrentStatus());
                map.put(index++, radetReportDto.getDateOfCurrentARTStatus());
                map.put(index++, radetReportDto.getCauseOfDeath());
                map.put(index++, radetReportDto.getVaCauseOfDeath());

                //previous status
                map.put(index++, radetReportDto.getPreviousStatus());
                map.put(index++, radetReportDto.getPreviousStatusDate());

                map.put(index++, radetReportDto.getEnrollmentSetting());

                //TB
                map.put(index++, radetReportDto.getDateOfTbScreened());
                map.put(index++, radetReportDto.getTbStatus());
                map.put(index++, tbStatusOutCome);

                //tb lab
                map.put(index++, radetReportDto.getDateOfTbSampleCollection());
                map.put(index++, radetReportDto.getTbDiagnosticTestType());
                map.put(index++, radetReportDto.getDateOfTBDiagnosticResultReceived());
                map.put(index++, radetReportDto.getTbDiagnosticResult());

                map.put(index++, radetReportDto.getTbTreatmentStartDate());
                map.put(index++, radetReportDto.getTbTreatmentType());
                map.put(index++, radetReportDto.getTbCompletionDate());
                map.put(index++, radetReportDto.getTbTreatmentOutcome());
                map.put(index++, radetReportDto.getDateOfLastTbLam());
                map.put(index++, radetReportDto.getTbLamResult());


                //TPT
                map.put(index++, radetReportDto.getDateOfIptStart());
                map.put(index++, radetReportDto.getIptType());
                map.put(index++, radetReportDto.getIptCompletionDate());
                map.put(index++, radetReportDto.getIptCompletionStatus());

                //EAC
                map.put(index++, radetReportDto.getDateOfCommencementOfEac());
                map.put(index++, radetReportDto.getNumberOfEacSessionsCompleted());
                map.put(index++, radetReportDto.getDateOfLastEacSessionCompleted());
                map.put(index++, radetReportDto.getDateOfExtendedEacCompletion());
                map.put(index++, null); //TODO Date of Repeat Viral Load - Post EAC VL Sample collected (yyyy-mm-dd)
                map.put(index++, repeatVl);
                map.put(index++, radetReportDto.getDateOfRepeatViralLoadResult());

                //DSD MOdel
                map.put(index++, radetReportDto.getDsdModel());
                map.put(index++, null); //TODO Date Commenced DSD (yyyy-mm-dd)
                map.put(index++, null); //TODO Date of Return of DSD Client to Facility (yyyy-mm-dd)

                //chronic care
                map.put(index++, null); //TODO Screening for Chronic Conditions
                map.put(index++, null); //TODO Co-morbidities

                //cervicalCancerScreeningType
                map.put(index++, radetReportDto.getDateOfCervicalCancerScreening());
                map.put(index++, radetReportDto.getCervicalCancerScreeningType());
                map.put(index++, radetReportDto.getCervicalCancerScreeningMethod());
                map.put(index++, radetReportDto.getResultOfCervicalCancerScreening());

                //Precancerous
                map.put(index++, radetReportDto.getTreatmentMethodDate());
                map.put(index++, radetReportDto.getCervicalCancerTreatmentScreened()); //Date of Precancerous Lesions Treatment

                //Crytococal Antigen
                map.put(index++, radetReportDto.getLastCrytococalAntigen());
                map.put(index++, radetReportDto.getDateOfLastCrytococalAntigen());


                //biometrics
                map.put(index++, radetReportDto.getDateBiometricsEnrolled());
                map.put(index++, radetReportDto.getNumberOfFingersCaptured());
                map.put(index++, null); //TODO Valid Biometrics(Hexadecimal/Base64 Unique Identifier)

                //case manager
                map.put(index, radetReportDto.getCaseManager());

                result.add(map);
                sn++;
            } catch (Exception e) {
                log.error("An error occurred when converting db record to excel for patient id {}", currentRecord);
                //writeToErrorFile(currentRecord);
                log.error("The error message is: " + e.getMessage());
            }
        }
        log.info("Done converting db records total size " + result.size());
        return result;
    }

    private static String getStringValue(String value) {
        return value.replace("null", "");
    }
}
