package com.example.kyzer.psidemo.Class;

import java.util.List;

/**
 * Created by kyzer on 8/7/17.
 */

public class PSI {
    private List<PSIRegionMetadata> region_metadata = null;
    private List<PSIItem> items = null;
    private PSIApiInfo PSIApiInfo;

    public List<PSIRegionMetadata> getRegion_metadata() {
        return region_metadata;
    }

    public void setRegion_metadata(List<PSIRegionMetadata> region_metadata) {
        this.region_metadata = region_metadata;
    }

    public List<PSIItem> getPSIItems() {
        return items;
    }

    public void setPSIItems(List<PSIItem> PSIItems) {
        this.items = PSIItems;
    }

    public PSIApiInfo getPSIApiInfo() {
        return PSIApiInfo;
    }

    public void setPSIApiInfo(PSIApiInfo PSIApiInfo) {
        this.PSIApiInfo = PSIApiInfo;
    }
}
