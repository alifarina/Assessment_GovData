package com.book.govdatafr.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "departmentDetail")
public class DepartmentDetail {
    @ColumnInfo(name = "department_code")
    @SerializedName("codeDepartement")
    @Expose
    private String codeDepartement;

    @SerializedName("codeRegion")
    @Expose
    private String codeRegion;

    @ColumnInfo(name = "population")
    @SerializedName("population")
    @Expose
    private Integer population;

    @SerializedName("nom")
    @Expose
    private String nom;
    @ColumnInfo(name = "mun_unique_code")
    @SerializedName("code")
    @PrimaryKey
    @NonNull
    @Expose
    private String code;
    @SerializedName("departement")
    @Expose
    @Ignore
    private DepartmentModel departement;

    @SerializedName("region")
    @Expose
    @Embedded
    private RegionModel region;

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DepartmentModel getDepartement() {
        return departement;
    }

    public void setDepartement(DepartmentModel departement) {
        this.departement = departement;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }
}
