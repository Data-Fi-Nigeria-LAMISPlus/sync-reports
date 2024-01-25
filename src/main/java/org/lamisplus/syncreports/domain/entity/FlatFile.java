package org.lamisplus.syncreports.domain.entity;


public interface FlatFile {
    String getDatimId() ;
    String getPeriod() ;
    String getDataElement() ;
    String getDataElementName() ;
    String getCategoryOptionCombo() ;
    String getCategoryOptionComboName() ;
    String getAttributeOptionCombo();
    Integer getValue();
    String getFacilityName() ;
    String getFacilityState() ;
    String getFacilityLga() ;
    String getIpName();
}
