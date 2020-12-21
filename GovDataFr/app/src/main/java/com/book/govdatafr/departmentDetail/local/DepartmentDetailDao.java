package com.book.govdatafr.departmentDetail.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.book.govdatafr.models.DepartmentDetail;
import com.book.govdatafr.models.DetailDisplayModel;

import java.util.List;

@Dao
public interface DepartmentDetailDao {

    /**
     * insert details of department with primary key municipality code
     * @param detailsList
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDepartmentDetails(List<DepartmentDetail> detailsList);

    /**
     * Query for getting total population, region name and num of municipalities from "departmentDetail" table
     * @param departmentCode
     * @return DetailDisplayModel
     */
    @Query("select sum(population) as totalPopulation,region_name,count(mun_unique_code) as numMunicipalities " +
            "from departmentDetail where department_code = :departmentCode")
    DetailDisplayModel getDepartmentDetailList(String departmentCode);

}
