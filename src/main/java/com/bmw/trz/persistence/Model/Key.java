package com.bmw.trz.persistence.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "key")
@XmlAccessorType(XmlAccessType.FIELD)
public class Key {

    private String vin;
    private String rawData;
    private String timeStamp;

    public Key(){}

    public Key(String vin, String rawData, String timeStamp){
        this.vin = vin;
        this.rawData = rawData;
        this.timeStamp = timeStamp;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
