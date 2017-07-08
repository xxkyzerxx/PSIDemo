package com.example.kyzer.psidemo.Class;

public class PSIItem {

    private String timestamp;
    private String update_timestamp;
    private PSIReadings readings;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpdate_timestamp() {
        return update_timestamp;
    }

    public void setUpdate_timestamp(String update_timestamp) {
        this.update_timestamp = update_timestamp;
    }

    public PSIReadings getReadings() {
        return readings;
    }

    public void setReadings(PSIReadings PSIReadings) {
        this.readings = PSIReadings;
    }

}