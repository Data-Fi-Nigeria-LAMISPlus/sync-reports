package org.lamisplus.syncdashboard.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "final_radet")
public class Radet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uniquepersonuuid")
    private String uniquePersonUuid;

    @Column(name = "datim_id")
    private String datimId;

    @Column(name = "hospitalnumber")
    private String hospitalNumber;

    @Column(name = "uniqueid")
    private String uniqueId;

    @Column(name = "age")
    private double age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "facilityname")
    private String facilityName;

    @Column(name = "lga")
    private String lga;

    @Column(name = "state")
    private String state;

    @Column(name = "datimid")
    private String datimid;

    @Column(name = "targetgroup")
    private String targetGroup;

    @Column(name = "enrollmentsetting")
    private String enrollmentSetting;

    @Column(name = "artstartdate")
    private LocalDate artStartDate;

    @Column(name = "regimenatstart")
    private String regimenAtStart;

    @Column(name = "dateofregistration")
    private LocalDate dateOfRegistration;

    @Column(name = "dateofenrollment")
    private LocalDate dateOfEnrollment;

    @Column(name = "ovcuniqueid")
    private String ovcUniqueId;

    @Column(name = "householduniqueno")
    private String householdUniqueNo;

    @Column(name = "careentry")
    private String careEntry;

    @Column(name = "regimenlineatstart")
    private String regimenLineAtStart;

    @Column(name = "ndrpatientidentifier")
    private String ndrPatientIdentifier;

    @Column(name = "dateofviralloadsamplecollection")
    private LocalDate dateOfViralLoadSampleCollection;

    @Column(name = "dateofcurrentviralloadsample")
    private LocalDate dateOfCurrentViralLoadSample;

    @Column(name = "vlfacility")
    private long vlFacility;

    @Column(name = "vlarchived")
    private String vlArchived;

    @Column(name = "viralloadindication")
    private String viralLoadIndication;

    @Column(name = "currentviralload")
    private String currentViralLoad;

    @Column(name = "dateofcurrentviralload")
    private LocalDate dateOfCurrentViralLoad;

    @Column(name = "dsdmodel")
    private String dsdModel;

    @Column(name = "lastpickupdate")
    private LocalDate lastPickupDate;

    @Column(name = "currentartregimen")
    private String currentArtRegimen;

    @Column(name = "currentregimenline")
    private String currentRegimenLine;

    @Column(name = "nextpickupdate")
    private LocalDate nextPickupDate;

    @Column(name = "monthsofarvrefill")
    private double monthsOfArvRefill;

    @Column(name = "datebiometricsenrolled")
    private LocalDate dateBiometricsEnrolled;

    @Column(name = "numberoffingerscaptured")
    private long numberOfFingersCaptured;

    @Column(name = "dateofcommencementofeac")
    private LocalDate dateOfCommencementOfEac;

    @Column(name = "numberofeacsessioncompleted")
    private long numberOfEacSessionsCompleted;

    @Column(name = "dateoflasteacsessioncompleted")
    private LocalDate dateOfLastEacSessionCompleted;

    @Column(name = "dateofextendeaccompletion")
    private LocalDate dateOfExtendedEacCompletion;

    @Column(name = "dateofrepeatviralloadresult")
    private LocalDate dateOfRepeatViralLoadResult;

    @Column(name = "repeatviralloadresult")
    private String repeatViralLoadResult;

    @Column(name = "dateofiptstart")
    private LocalDate dateOfIptStart;

    @Column(name = "iptcompletiondate")
    private LocalDate iptCompletionDate;

    @Column(name = "iptcompletionstatus")
    private String iptCompletionStatus;

    @Column(name = "ipttype")
    private String iptType;

    @Column(name = "dateofcervicalcancerscreening")
    private LocalDate dateOfCervicalCancerScreening;

    @Column(name = "treatmentmethoddate")
    private String treatmentMethodDate;

    @Column(name = "cervicalcancerscreeningtype")
    private String cervicalCancerScreeningType;

    @Column(name = "cervicalcancerscreeningmethod")
    private String cervicalCancerScreeningMethod;

    @Column(name = "cervicalcancertreatmentscreened")
    private String cervicalCancerTreatmentScreened;

    @Column(name = "resultofcervicalcancerscreening")
    private String resultOfCervicalCancerScreening;

    @Column(name = "ovcnumber")
    private String ovcNumber;

    @Column(name = "householdnumber")
    private String householdNumber;

    @Column(name = "tbtreatementtype")
    private String tbTreatmentType;

    @Column(name = "tbtreatmentstartdate")
    private LocalDate tbTreatmentStartDate;

    @Column(name = "tbtreatmentoutcome")
    private String tbTreatmentOutcome;

    @Column(name = "tbcompletiondate")
    private LocalDate tbCompletionDate;

    @Column(name = "tbtreatmentpersonuuid")
    private String tbTreatmentPersonUuid;

    @Column(name = "dateoftbsamplecollection")
    private LocalDate dateOfTbSampleCollection;

    @Column(name = "persontbsample")
    private String personTbSample;

    @Column(name = "persontbresult")
    private String personTbResult;

    @Column(name = "date_result_reported")
    private LocalDate dateResultReported;

    @Column(name = "tbdiagnosticresult")
    private String tbDiagnosticResult;

    @Column(name = "tbdiagnostictesttype")
    private String tbDiagnosticTestType;

    @Column(name = "dateoftbscreened")
    private LocalDate dateOfTbScreened;

    @Column(name = "tbstatus")
    private String tbStatus;

    @Column(name = "tbstatusoutcome")
    private String tbStatusOutcome;

    @Column(name = "dateoflasttblam")
    private LocalDate dateOfLastTbLam;

    @Column(name = "tblamresult")
    private String tbLamResult;

    @Column(name = "causeofdeath")
    private String causeOfDeath;

    @Column(name = "vacauseofdeath")
    private String vaCauseOfDeath;

    @Column(name = "previousstatus")
    private String previousStatus;

    @Column(name = "previousstatusdate")
    private LocalDate previousStatusDate;

    @Column(name = "currentstatus")
    private String currentStatus;

    @Column(name = "vleligibilitystatus")
    private LocalDate vlEligibilityStatus;

    @Column(name = "test")
    private int test;

    @Column(name = "dateofvleligibilitystatus")
    private LocalDate dateOfVlEligibilityStatus;

    @Column(name = "lastcd4count")
    private String lastCd4Count;

    @Column(name = "dateoflastcd4count")
    private LocalDate dateOfLastCd4Count;

    @Column(name = "dateoflastcrytococalantigen")
    private LocalDate dateOfLastCrytococalAntigen;

    @Column(name = "lastcrytococalantigen")
    private String lastCrytococalAntigen;

    @Column(name = "casemanager")
    private String caseManager;

    @Column(name = "current_status")
    private String currentStatusText;

    @Column(name = "previous_status")
    private String previousStatusText;

    @Column(name = "clientverificationstatus")
    private String clientVerificationStatus;

    @Column(name = "dateofoutcome")
    private LocalDate dateOfOutcome;

    @Column(name = "period")
    private String period;
}
