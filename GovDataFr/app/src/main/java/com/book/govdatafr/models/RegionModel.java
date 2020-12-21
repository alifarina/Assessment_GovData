package com.book.govdatafr.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionModel {
    @ColumnInfo(name = "region_name")
    @SerializedName("nom")
    @Expose
    private String nom;

    @SerializedName("code")
    @ColumnInfo(name = "region_code")
    @Expose
    private String code;

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
}
