package com.book.govdatafr.departmentDetail.local;

import android.content.Context;
import android.util.Log;

import com.book.govdatafr.models.DepartmentDetail;
import com.book.govdatafr.models.DepartmentModel;
import com.book.govdatafr.models.DetailDisplayModel;
import com.book.govdatafr.networkUtils.DatabaseHolder;

import java.util.List;

public class DetailLocalDataSource {
    private DatabaseHolder db;
    public DetailLocalDataSource(Context mContext){
        db = DatabaseHolder.getAppDatabase(mContext);
    }

    public void insertData(List<DepartmentDetail> departmentList){
        db.departmentDetailDao().insertDepartmentDetails(departmentList);
    }

    public DetailDisplayModel getDepartmentDetailsData(String code){
        return db.departmentDetailDao().getDepartmentDetailList(code);
    }
}
