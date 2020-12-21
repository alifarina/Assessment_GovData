package com.book.govdatafr.departmentDetail;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.book.govdatafr.departmentDetail.local.DetailLocalDataSource;
import com.book.govdatafr.departmentDetail.remote.DepartmentDetailDataSource;
import com.book.govdatafr.departmentDetail.remote.DepartmentDetailsRemoteDataSource;
import com.book.govdatafr.models.DepartmentDetail;
import com.book.govdatafr.models.DepartmentModel;
import com.book.govdatafr.models.DetailDisplayModel;

import java.util.List;

public class DepartmentDetailsRepo {

    private DepartmentDetailsRepo() {
    }

    private static DepartmentDetailsRepo instance = null;
    private static DepartmentDetailsRemoteDataSource remoteDataSource;
    private static DetailLocalDataSource localDataSource;

    /**
     * creates singleton instance, remote and local repository instances for accessing the data
     * @param context
     * @return
     */
    public static DepartmentDetailsRepo getInstance(Context context) {
        if (instance == null) {
            instance = new DepartmentDetailsRepo();
            remoteDataSource = new DepartmentDetailsRemoteDataSource();
            localDataSource=new DetailLocalDataSource(context);
        }
        return instance;
    }

    private MutableLiveData<DetailDisplayModel> data = new MutableLiveData<>();

    public MutableLiveData<DetailDisplayModel> getDepartmentDetails(String code){
        getDetails(code);
        return data;
    }

    /**
     * method to check local data source first , if data not present call the API
     * @param code
     */
    private void getDetails(final String code) {
      final DetailDisplayModel dataArray=  localDataSource.getDepartmentDetailsData(code);
        Log.d("TAG", "getDetails: "+dataArray);
      if(dataArray==null || dataArray.getRegionName()==null){
          remoteDataSource.getDepartments(code, "codeDepartement,departement,codeRegion,region,population",
                  new DepartmentDetailDataSource() {
                      @Override
                      public void onSuccess(List<DepartmentDetail> list) {
                          localDataSource.insertData(list);
                          DetailDisplayModel dataArray=  localDataSource.getDepartmentDetailsData(code);
                          data.postValue(dataArray);
                      }

                      @Override
                      public void onFailure() {
                          data.postValue(null);
                      }
                  });
      }else {
          data.postValue(dataArray);
      }

    }

}
