package org.lamisplus.syncreports.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "final_htsquery_datamart", schema = "hts_prep_datamart")
public class Hts {
    @Id
    @Column(name = "clientcode")
    private String clientCode;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "othername")
    private String otherName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "maritalstatus")
    private String maritalStatus;

    @Column(name = "lgaofresidence")
    private String lgaOfResidence;

    @Column(name = "stateofresidence")
    private String stateOfResidence;

    @Column(name = "facility")
    private String facility;

    @Column(name = "state")
    private String state;

    @Column(name = "lga")
    private String lga;

    @Column(name = "patientid")
    private String patientId;

    @Column(name = "education")
    private String education;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "datim_id")
    private String datimCode;

    @Column(name = "htslatitude")
    private String htsLatitude;

    @Column(name = "htslongitude")
    private String htsLongitude;

    @Column(name = "clientaddress")
    private String clientAddress;

    @Column(name = "datevisit")
    private LocalDate dateVisit;

    @Column(name = "firsttimevisit")
    private String firstTimeVisit;

    @Column(name = "numberofchildren")
    private Integer numberOfChildren;

    @Column(name = "numberofwives")
    private Integer numberOfWives;

    @Column(name = "indexclient")
    private String indexClient;

    @Column(name = "prepoffered")
    private String prepOffered;

    @Column(name = "prepaccepted")
    private String prepAccepted;

    @Column(name = "previouslytested")
    private String previouslyTested;

    @Column(name = "targetgroup")
    private String targetGroup;

    @Column(name = "referredfrom")
    private String referredFrom;

    @Column(name = "testingsetting")
    private String testingSetting;

    @Column(name = "counselingtype")
    private String counselingType;

    @Column(name = "pregnancystatus")
    private String pregnacyStatus;

    @Column(name = "breastfeeding")
    private Boolean breastFeeding;

    @Column(name = "indextype")
    private String indexType;

    @Column(name = "ifrecencytestingoptin")
    private String ifrecencyTestingOptIn;

    @Column(name = "recencyid")
    private String recencyId;

    @Column(name = "recencytesttype")
    private String recencyTestType;

    @Column(name = "recencytestdate")
    private LocalDate recencyTestDate;

    @Column(name = "recencyinterpretation")
    private String recencyInterpretation;

    @Column(name = "finalrecencyresult")
    private String finalRecencyResult;

    @Column(name = "viralloadresult")
    private String viralLoadResult;

    @Column(name = "viralloadsamplecollectiondate")
    private LocalDate viralLoadSampleCollectionDate;

    @Column(name = "viralloadconfirmationresult")
    private String viralLoadConfirmationResult;

    @Column(name = "viralloadconfirmationdate")
    private LocalDate viralLoadConfirmationDate;

    /*@Column(name = "assessmentcode")
    private String assessmentCode;*/

    @Column(name = "modality")
    private String modality;

    @Column(name = "syphilistestresult")
    private String syphilisTestResult;

    @Column(name = "hepatitisbtestresult")
    private String hepatitisBTestResult;

    @Column(name = "hepatitisctestresult")
    private String hepatitisCTestResult;

    @Column(name = "cd4type")
    private String cd4Type;

    @Column(name = "cd4testresult")
    private String cd4TestResult;

    @Column(name = "hivtestresult")
    private String hivTestResult;

    @Column(name = "finalhivtestresult")
    private String finalHivTestResult;

    @Column(name = "dateofhivtesting")
    private LocalDate dateOfHivTesting;

    @Column(name = "numberofcondomsgiven")
    private String numberOfCondomsGiven;

    @Column(name = "numberoflubricantsgiven")
    private String numberOfLubricantsGiven;

    /*@Column(name = "htsuniqueno")
    private String htsUniqueNo;*/

    /*@Column(name = "period")
    private String period;*/

    /*@Column(name = "submissiontime")
    private LocalDateTime submissionTime;

    @Column(name = "uuid")
    private String uuid;*/
}
