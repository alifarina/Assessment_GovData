package com.book.govdatafr.departmentList.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.book.govdatafr.models.DepartmentModel;

import java.util.List;

@Dao
public interface DepartmentListDao {

    /**
     * Query to get list of all departments from the "department" table
     *
     * @return list of departments
     */
    @Query("select * from Department")
    List<DepartmentModel> getAllDepartmenst();

    /**
     * insert all department data with primary key department code
     * @param depTList
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertData(List<DepartmentModel> depTList);
}
