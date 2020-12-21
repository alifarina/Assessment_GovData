package com.book.govdatafr.models;

import androidx.room.ColumnInfo;

public class DetailDisplayModel {

    private  long totalPopulation;
    @ColumnInfo(name = "region_name")
    private String regionName;

    public long getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public long getNumMunicipalities() {
        return numMunicipalities;
    }

    public void setNumMunicipalities(long numMunicipalities) {
        this.numMunicipalities = numMunicipalities;
    }

    private long numMunicipalities;
}
