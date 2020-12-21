package com.book.govdatafr.departmentList;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.book.govdatafr.departmentList.local.DepartmentLocalDataSource;
import com.book.govdatafr.departmentList.remote.DepartmentDataSource;
import com.book.govdatafr.departmentList.remote.DepartmentRemoteDataSource;
import com.book.govdatafr.models.DepartmentModel;

import java.util.ArrayList;
import java.util.List;

public class DepartmentListRepository  {

    private static DepartmentListRepository instance = null;

    private static DepartmentRemoteDataSource remoteDataSource;
    private static DepartmentLocalDataSource localDataSource;

    /**
     * creates singleton instance, remote and local repository instances for accessing the data
     * @param context
     * @return
     */
    public static DepartmentListRepository getInstance(Context context) {
        if (instance == null) {
            instance = new DepartmentListRepository();
            remoteDataSource = new DepartmentRemoteDataSource();
            localDataSource = new DepartmentLocalDataSource(context);
        }
        return instance;
    }

    private MutableLiveData<List<DepartmentModel>> data = new MutableLiveData<>();

    public MutableLiveData<List<DepartmentModel>> getAllDepartments() {
        calls();
        return data;
    }

    /**
     * method to check local data source first , if data not present call the API
     */
    private void calls() {
        List<DepartmentModel> dataList = localDataSource.getAllDepartmentsData();
        if (dataList != null && dataList.size() > 0) {
            Log.d("coming from DB","DB");
            data.postValue(dataList);
        } else {
            remoteDataSource.getDepartments(new DepartmentDataSource() {
                @Override
                public void onSuccess(List<DepartmentModel> list) {
                    localDataSource.insertData(list);
                    data.postValue(list);
                }

                @Override
                public void onFailure() {
                    data.postValue(null);
                }
            });
        }


    }

}
