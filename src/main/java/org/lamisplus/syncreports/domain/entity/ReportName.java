package org.lamisplus.syncreports.domain.entity;

import lombok.Getter;

public enum ReportName {

    RADET("radet"),
    PREP("prep"),
    HTS("hts"),
    FLAT_FILE("flatfile")
    ;

    @Getter
    private final String text;

    /**
     * @param text
     */
    ReportName(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static ReportName getReportName(String name){
        for(ReportName reportName : ReportName.values()){
            if (reportName.getText().equals(name)){
                return reportName;
            }
        }
        return null;
    }
}
