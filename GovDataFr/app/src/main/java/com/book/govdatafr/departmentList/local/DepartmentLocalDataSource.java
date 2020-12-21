package com.book.govdatafr.departmentList.local;

import android.content.Context;

import com.book.govdatafr.models.DepartmentModel;
import com.book.govdatafr.networkUtils.DatabaseHolder;

import java.util.List;

public class DepartmentLocalDataSource {
    private DatabaseHolder db;
    public DepartmentLocalDataSource(Context mContext){
         db = DatabaseHolder.getAppDatabase(mContext);
    }

    public void insertData(List<DepartmentModel> departmentList){
        db.departmentListDao().insertData(departmentList);
    }

    public List<DepartmentModel> getAllDepartmentsData(){
       return db.departmentListDao().getAllDepartmenst();
    }


}
