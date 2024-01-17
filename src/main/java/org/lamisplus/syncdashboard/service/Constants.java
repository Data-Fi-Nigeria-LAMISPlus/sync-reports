package org.lamisplus.syncdashboard.service;

import java.util.Arrays;
import java.util.List;

public class Constants {

    // EXTENSION
    public static final String EXCEL_EXTENSION_XLSX = ".xlsx";
    public static final String EXCEL_EXTENSION_XLS = ".xls";

    // Sheet name
    public static final String FLAT_FILE_LIST = "flat_file";
    public static final String HTS_FLAT_FILE_LIST = "hts_flat_file";
    public static final String PREP_SHEET = "prep";

    public static final String PHARMACY_SHEET = "Pharmacy";
    public static final String PATIENT_SHEET = "Patient";

    public static final String RADET_SHEET = "radet";
    public static final String HTS_SHEET = "hts";

    public static final List<String> FLAT_FILE_HEADER =
            Arrays.asList(
                    "Datim Id",
                    "Period",
                    "Data Element",
                    "Data Element Name",
                    "Category Option Combo",
                    "Category Option Combo Name",
                    "Attribute Option Combo",
                    "Value",
                    "Facility Name",
                    "Facility State",
                    "Facility LGA",
                    "IP"
            );

    public static final List<String> HTS_HEADER =
            Arrays.asList(
                    "S/No",
                    "Facility Id (Datim)",
                    "Facility",
                    "Client Code",
                    "First Name",
                    "Surname",
                    "Other Names",
                    "Sex",
                    "Target Group",
                    "Age",
                    "Date Of Birth (yyyy-mm-dd)",
                    "Phone Number",
                    "Marital Status",
                    "Client Address",
                    "LGA of Residence",
                    "State Of Residence",
                    "Education",
                    "Occupation",
                    "Date of Visit (yyyy-mm-dd)",
                    "First Time Visit",
                    "Number of wives",
                    "Number of Children",
                    "Index Client",
                    "Previously Tested",
                    "Referred From",
                    "Testing Setting",
                    "Counseling Type",
                    "Pregnancy Status",
                    "Breastfeeding",
                    "Index Type",
                    "If Recency Testing Opt In",
                    "Recency Id",
                    "Recency Test Type",
                    "Recency Test Date (yyyy-mm-dd)",
                    "Recency Interpretation",
                    "Final Recency Result",
                    "Viral Load Sample Collection Date",
                    "Viral Load Result Classification",
                    "Viral Load Confirmation Result",
                    "Viral Load Confirmation Date (yyyy-mm-dd)",
                    "Assessment Code",
                    "Modality",
                    "Syphilis Test Result",
                    "Hepatitis B Result",
                    "Hepatitis C Result",
                    "CD4 Type",
                    "CD4 Test Result",
                    "HIV Test Result",
                    "Final HIV Test Result",
                    "Date Of HIV Testing (yyyy-mm-dd)",
                    "Prep Offered",
                    "Prep Accepted",
                    "Number of condoms given",
                    "Number of lubricant given",
                    "HTS Latitude",
                    "HTS Longitude"
            );

    public static final List<String> PrEP_HEADER =
            Arrays.asList(
                    "S/No",
                    "Facility Id (Datim)",
                    "State",
                    "LGA",
                    "Facility Name",
                    "Patient Identifier",
                    "Hospital Number",
                    "First Name",
                    "Surname",
                    "Other Names",
                    "Sex",
                    "Target Group",
                    "Age",
                    "Date Of Birth (yyyy-mm-dd)",
                    "Phone Number",
                    "Marital Status",
                    "Client Address",
                    "LGA of Residence",
                    "State Of Residence",
                    "Education",
                    "Occupation",
                    "Date Of Registration (yyyy-mm-dd)",
                    "Date Of Commencement (yyyy-mm-dd)",
                    "Baseline Regimen",
                    "Baseline Systolic bp",
                    "Baseline Diastolic bp",
                    "Baseline Weight (kg)",
                    "Baseline Height (cm)",
                    "Baseline Creatinine",
                    "Baseline Hepatitis B",
                    "Baseline Hepatitis C",
                    "HIV status at PrEP Initiation",
                    "Baseline Urinalysis",
                    "Baseline Urinalysis Date",
                    "Indication for PrEP",
                    "Current Regimen",
                    "Date Of Last Pickup (yyyy-mm-dd)",
                    "Current Status",
                    "Date Of Current Status (yyyy-mm-dd)",
                    "Current Systolic bp",
                    "Current Diastolic bp",
                    "Current Weight (kg)",
                    "Current Height (cm)",
                    "Current HIV Status",
                    "Date of Current HIV Status (yyyy-mm-dd)",
                    "Current Urinalysis",
                    "Date of Current Urinalysis",
                    "Pregnancy Status",
                    "Reasons for discontinuation/Stopped",
                    "Date of Discontinuation/Stopped",
                    "Date Of HIV Enrollment (yyyy-mm-dd)"
            );

    public static final List<String> RADET_HEADER =
            Arrays.asList(

                    "S/No.",

                    //bio hospital number & state, lga & facility
                    "State",
                    "L.G.A",
                    "LGA Of Residence",
                    "Facility Name",
                    "DatimId",
                    "Patient ID",
                    "NDR Patient Identifier",
                    "Hospital Number",
                    "Unique Id",

                    //ovc
                    "Household Unique No",
                    "OVC Unique ID",

                    "Sex",
                    "Target group",
                    "Current Weight (kg)",
                    "Pregnancy Status",
                    "Date Birth (yyyy-mm-dd)",

                    "Age",
                    "Care Entry Point",
                    "Date of Registration",
                    "Enrollment  Date (yyyy-mm-dd)",
                    "ART Start Date (yyyy-mm-dd)",
                    "Last Pickup Date (yyyy-mm-dd)",
                    "Months of ARV Refill",


                    "Regimen Line at ART Start",
                    "Regimen at ART Start",
                    "Date of Start of Current ART Regimen",
                    "Current Regimen Line",
                    "Current ART Regimen",

                    //cd4
                    "Clinical Staging at Last Visit",
                    "Date of Last CD4 Count",
                    "Last CD4 Count",

                    //vl
                    "Date of Viral Load Sample Collection (yyyy-mm-dd)",
                    "Date of Current ViralLoad Result Sample (yyyy-mm-dd)",
                    "Current Viral Load (c/ml)",
                    "Date of Current Viral Load (yyyy-mm-dd)",
                    "Viral Load Indication",
                    "Viral Load Eligibility Status",
                    "Date of Viral Load Eligibility Status",

                    //current status
                    "Current ART Status",
                    "Date of Current ART Status",
                    "Cause of Death",
                    "VA Cause of Death",

                    //previous status
                    "Previous ART Status",
                    "Confirmed Date of Previous ART Status",

                    "ART Enrollment Setting",

                    //TB
                    "Date of TB Screening (yyyy-mm-dd)",
                    "TB status at Last Visit",
                    "TB Screening Outcome",

                    //tb lab
                    "Date of TB Sample Collection (yyyy-mm-dd)",
                    "TB Diagnostic Test Type",
                    "Date of TB Diagnostic Result Received (yyyy-mm-dd)",
                    "TB Diagnostic Result",


                    "Date of Start of TB Treatment (yyyy-mm-dd)",
                    "TB Treatment Type (new, relapsed etc)",
                    "Date of Completion of TB Treatment (yyyy-mm-dd)",
                    "TB Treatment Outcome",
                    "Date of TB-LAM",
                    "TB-LAM result",

                    //TPT
                    "Date of TPT Start (yyyy-mm-dd)",
                    "TPT Type",
                    "TPT Completion date (yyyy-mm-dd)",
                    "TPT Completion status",

                    //EAC
                    "Date of commencement of EAC (yyyy-mm-dd)",
                    "Number of EAC Sessions Completed",
                    "Date of last EAC Session Completed",
                    "Date of Extended EAC Completion (yyyy-mm-dd)",
                    "Date of Repeat Viral Load - Post EAC VL Sample collected (yyyy-mm-dd)",
                    "Repeat Viral load result (c/ml)- POST EAC",
                    "Date of Repeat Viral load result- POST EAC VL",

                    //DSD MOdel
                    "DSD Model",
                    "Date Commenced DSD (yyyy-mm-dd)",
                    "Date of Return of DSD Client to Facility (yyyy-mm-dd)",

                    //chronic care
                    "Screening for Chronic Conditions",
                    "Co-morbidities",

                    //cervicalCancerScreeningType
                    "Date of Cervical Cancer Screening (yyyy-mm-dd)",
                    "Cervical Cancer Screening Type",
                    "Cervical Cancer Screening Method",
                    "Result of Cervical Cancer Screening",

                    //Precancerous
                    "Date of Precancerous Lesions Treatment (yyyy-mm-dd)",
                    "Precancerous Lesions Treatment Methods",

                    //Crytococal Antigen
                    "Last Cryptococcal Antigen",
                    "Date of Last Cryptococcal Antigen (yyyy-mm-dd)",

                    //biometrics
                    "Date Biometrics Enrolled (yyyy-mm-dd)",
                    "Number of Fingers Captured",
                    "Valid Biometrics(Hexadecimal/Base64 Unique Identifier)",

                    //case manager
                    "Case Manager"
            );

    public static final List<String> PHARMACY_HEADER =
            Arrays.asList(
                    "S/No",
                    "Datim Id",
                    "Patient Id",
                    "Date Visit(yyyy-mm-dd)",
                    "Regimen Line",
                    "Regimens(Include supported Drugs)",
                    "Regimens Code Description",
                    "Refill Period",
                    "MMD Type",
                    "Next Appointment (yyyy-mm-dd)",
                    "DSD Model"
            );

    public static final List<String> PATIENT_LINE_LIST_HEADER = Arrays.asList(
            "State",
            "LGA",
            "Facility Name",
            "Datim Id",
            "Patient Id",
            "Hospital Num",
            "Date Of Birth (yyyy-mm-dd)",
            "Age",
            "Gender",
            "Marital Status",
            "Education",
            "Occupation",
            "State of Residence",
            "Lga of Residence",
            "Address",
            "Phone"
    );
}