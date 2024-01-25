package org.lamisplus.syncreports.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.lamisplus.syncreports.domain.entity.FlatFile;
import org.lamisplus.syncreports.domain.entity.Hts;
import org.lamisplus.syncreports.domain.entity.Prep;
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
                if(radetReportDto.getCurrentStatus() != null &&
                        (StringUtils.containsIgnoreCase("Stopped", radetReportDto.getCurrentStatus()))){
                    radetReportDto.setCurrentStatus("Stopped Treatment");

                }

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
                if(radetReportDto.getCurrentStatus() != null &&
                        (StringUtils.containsIgnoreCase("Stopped", radetReportDto.getCurrentStatus()))){
                    radetReportDto.setCurrentStatus("Stopped Treatment");

                }
                map.put(index++, radetReportDto.getCurrentStatus());
                map.put(index++, radetReportDto.getDateOfCurrentARTStatus());
                map.put(index++, radetReportDto.getClientVerificationStatus());
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

    public  List<Map<Integer, Object>> fillPrepDataMapper(@NonNull List<Prep> preps) {
        List<Map<Integer, Object>> result = new ArrayList<>();
        int sn = 1;
        log.info("converting PrEP db records to excel ....");
        try {
            for (Prep prep : preps) {
                if (prep != null) {
                    Map<Integer, Object> map = new HashMap<>();
                    int index = 0;

                    map.put(index++, String.valueOf(sn));
                    map.put(index++, String.valueOf(String.valueOf(prep.getDatimId())));
                    map.put(index++, String.valueOf(String.valueOf(prep.getState())));
                    map.put(index++, getStringValue(String.valueOf(prep.getLga())));
                    map.put(index++, getStringValue(String.valueOf(prep.getFacilityName())));
                    map.put(index++, String.valueOf(String.valueOf(prep.getPersonUuid())));
                    map.put(index++, getStringValue(String.valueOf(prep.getHospitalNumber())));
                    map.put(index++, getStringValue(String.valueOf(prep.getFirstName())));
                    map.put(index++, getStringValue(String.valueOf(prep.getSurname())));
                    map.put(index++, getStringValue(String.valueOf(prep.getOtherName())));
                    map.put(index++, getStringValue(String.valueOf(prep.getSex())));
                    map.put(index++, getStringValue(String.valueOf(prep.getTargetGroup())));
                    map.put(index++, getStringValue(String.valueOf(prep.getAge())));
                    map.put(index++,prep.getDateOfBirth());
                    map.put(index++,getStringValue(String.valueOf(prep.getPhone())));
                    map.put(index++, getStringValue(String.valueOf(prep.getMaritalStatus())));
                    map.put(index++, getStringValue(prep.getAddress() != null?prep.getAddress().replace("\"", ""):""));
                    map.put(index++, getStringValue(String.valueOf(prep.getResidentialLga())));
                    map.put(index++, getStringValue(String.valueOf(prep.getResidentialState())));
                    map.put(index++, getStringValue(String.valueOf(prep.getEducation())));
                    map.put(index++, getStringValue(String.valueOf(prep.getOccupation())));
                    map.put(index++, prep.getDateOfRegistration());
                    map.put(index++, prep.getPrepCommencementDate());
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineRegimen())));
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineSystolicBp())));
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineDiastolicBp())));
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineWeight())));
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineHeight())));
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineCreatinine())));
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineHepatitisB())));
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineHepatitisC())));
                    map.put(index++, getStringValue(String.valueOf(prep.getHivStatusAtPrepInitiation())));
                    map.put(index++, getStringValue(String.valueOf(prep.getBaselineUrinalysis())));
                    map.put(index++, prep.getBaselineUrinalysisDate());
                    map.put(index++, getStringValue(String.valueOf(prep.getIndicationForPrep())));
                    map.put(index++, getStringValue(String.valueOf(prep.getCurrentRegimen())));
                    map.put(index++, prep.getDateOfLastPickup());
                    map.put(index++, getStringValue(String.valueOf(prep.getCurrentStatus())));
                    map.put(index++, prep.getDateOfCurrentStatus());
                    map.put(index++, getStringValue(String.valueOf(prep.getCurrentSystolicBp())));
                    map.put(index++, getStringValue(String.valueOf(prep.getCurrentDiastolicBp())));
                    map.put(index++, getStringValue(String.valueOf(prep.getCurrentWeight())));
                    map.put(index++, getStringValue(String.valueOf(prep.getCurrentHeight())));
                    map.put(index++, getStringValue(String.valueOf(prep.getCurrentHivStatus())));
                    map.put(index++, prep.getDateOfCurrentHivStatus());
                    map.put(index++, getStringValue(String.valueOf(prep.getCurrentUrinalysis())));
                    map.put(index++, prep.getCurrentUrinalysisDate());
                    map.put(index++, getStringValue(String.valueOf(prep.getPregnancyStatus())));
                    map.put(index++, getStringValue(String.valueOf(prep.getInterruptionReason())));
                    map.put(index++, prep.getInterruptionDate());
                    map.put(index, prep.getHivEnrollmentDate());

                    result.add(map);
                    sn++;
                }
            }
            log.info("Done converting db records total size {}", result.size());
            return result;
        }catch (Exception e) {
            log.error("An error occurred when converting db records to excel");
            log.error("The error message is: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static List<Map<Integer, Object>> fillFlatFileMapperDataMapper(@NonNull List<FlatFile> listFinalResult) {
        List<Map<Integer, Object>> result = new ArrayList<>();
        for (FlatFile flatFile : listFinalResult) {
            if (flatFile != null) {
                Map<Integer, Object> map = new HashMap<>();
                int index = 0;
                map.put(index++, flatFile.getDatimId());
                map.put(index++, flatFile.getPeriod());
                map.put(index++, flatFile.getDataElement());
                map.put(index++, flatFile.getDataElementName());
                map.put(index++, flatFile.getCategoryOptionCombo());
                map.put(index++, flatFile.getCategoryOptionComboName());
                map.put(index++, flatFile.getAttributeOptionCombo());
                map.put(index++, flatFile.getValue());
                map.put(index++, flatFile.getFacilityName());
                map.put(index++, flatFile.getFacilityState());
                map.put(index++, flatFile.getFacilityLga());
                map.put(index++, flatFile.getIpName());
                result.add(map);
            }
        }
        log.info("result: " + result.size()); // going to be one
        return result;
    }

    private static String getStringValue(String value) {
        return value.replace("null", "");
    }

    public  List<Map<Integer, Object>> fillHtsDataMapper(@NonNull List<Hts> htsList) {
        List<Map<Integer, Object>> result = new ArrayList<>();
        int sn = 1;
        log.info("converting HTS db records to excel ....");
        try {
            for (Hts hts : htsList) {
                if (hts != null) {
                    Map<Integer, Object> map = new HashMap<>();
                    int index = 0;

                    map.put(index++, String.valueOf(sn));
                    map.put(index++, getStringValue(String.valueOf(hts.getDatimCode())));
                    map.put(index++, getStringValue(String.valueOf(hts.getFacility())));
                    map.put(index++, getStringValue(String.valueOf(hts.getClientCode())));
                    map.put(index++, getStringValue(String.valueOf(hts.getFirstName())));
                    map.put(index++, getStringValue(String.valueOf(hts.getSurname())));
                    map.put(index++, getStringValue(String.valueOf(hts.getOtherName())));
                    map.put(index++, getStringValue(String.valueOf(hts.getSex())));
                    map.put(index++, getStringValue(String.valueOf(hts.getTargetGroup())));
                    map.put(index++, getStringValue(String.valueOf(hts.getAge())));
                    map.put(index++, hts.getDateOfBirth());
                    map.put(index++, getStringValue(String.valueOf(hts.getPhoneNumber())));
                    map.put(index++, getStringValue(String.valueOf(hts.getMaritalStatus())));
                    map.put(index++, hts.getClientAddress() != null ? getStringValue(String.valueOf(hts.getClientAddress())).replace("\"", ""):"");
                    map.put(index++, getStringValue(String.valueOf(hts.getLgaOfResidence())));
                    map.put(index++, getStringValue(String.valueOf(hts.getStateOfResidence())));
                    map.put(index++, getStringValue(String.valueOf(hts.getEducation())));
                    map.put(index++, getStringValue(String.valueOf(hts.getOccupation())));
                    map.put(index++, hts.getDateVisit());
                    map.put(index++, getStringValue(String.valueOf(hts.getFirstTimeVisit())));
                    map.put(index++, getStringValue(String.valueOf(hts.getNumberOfWives())));
                    map.put(index++, getStringValue(String.valueOf(hts.getNumberOfChildren())));
                    map.put(index++, getStringValue(String.valueOf(hts.getIndexClient())));
                    map.put(index++, getStringValue(String.valueOf(hts.getPreviouslyTested())));
                    map.put(index++, getStringValue(String.valueOf(hts.getReferredFrom())));
                    map.put(index++, getStringValue(String.valueOf(hts.getTestingSetting())));
                    map.put(index++, getStringValue(String.valueOf(hts.getCounselingType())));
                    map.put(index++, getStringValue(String.valueOf(hts.getPregnacyStatus())));
                    map.put(index++, getStringValue(String.valueOf(hts.getBreastFeeding())));
                    map.put(index++, getStringValue(String.valueOf(hts.getIndexType())));
                    map.put(index++, getStringValue(String.valueOf(hts.getIfrecencyTestingOptIn())));
                    map.put(index++, getStringValue(String.valueOf(hts.getRecencyId())));
                    map.put(index++, getStringValue(String.valueOf(hts.getRecencyTestType())));
                    map.put(index++, hts.getRecencyTestDate());
                    map.put(index++, getStringValue(String.valueOf(hts.getRecencyInterpretation())));
                    map.put(index++, getStringValue(String.valueOf(hts.getFinalRecencyResult())));
                    map.put(index++, hts.getViralLoadSampleCollectionDate());
                    map.put(index++, getStringValue(String.valueOf(hts.getViralLoadConfirmationResult())));
                    map.put(index++, getStringValue(String.valueOf(hts.getViralLoadResult())));
                    map.put(index++, hts.getViralLoadConfirmationDate());
                    map.put(index++, getStringValue(String.valueOf(hts.getAssessmentCode())));
                    map.put(index++, getStringValue(String.valueOf(hts.getModality())));
                    map.put(index++, getStringValue(String.valueOf(hts.getSyphilisTestResult())));
                    map.put(index++, getStringValue(String.valueOf(hts.getHepatitisBTestResult())));
                    map.put(index++, getStringValue(String.valueOf(hts.getHepatitisCTestResult())));
                    map.put(index++, getStringValue(String.valueOf(hts.getCd4Type())));
                    map.put(index++, getStringValue(String.valueOf(hts.getCd4TestResult())));
                    map.put(index++, getStringValue(String.valueOf(hts.getHivTestResult())));
                    map.put(index++, getStringValue(String.valueOf(hts.getFinalHivTestResult())));
                    map.put(index++, hts.getDateOfHivTesting());
                    map.put(index++, getStringValue(String.valueOf(hts.getPrepOffered())));
                    map.put(index++, getStringValue(String.valueOf(hts.getPrepAccepted())));
                    map.put(index++, getStringValue(String.valueOf(hts.getNumberOfCondomsGiven())));
                    map.put(index++, getStringValue(String.valueOf(hts.getNumberOfLubricantsGiven())));
                    map.put(index++, getStringValue(String.valueOf(hts.getHtsLatitude())));
                    map.put(index, getStringValue(String.valueOf(hts.getHtsLongitude())));
                    result.add(map);
                    sn++;
                }
            }
            log.info("Done converting db records total size {}", result.size());
            return result;
        }catch (Exception e) {
            log.error("An error occurred when converting db records to excel");
            log.error("The error message is: " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}
