package com.book.govdatafr.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Department")
public class DepartmentModel {

    @ColumnInfo(name = "nom")
    private String nom;

    @NonNull
    @PrimaryKey( autoGenerate = false)
    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "codeRegion")
    private String codeRegion;

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

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }


}
