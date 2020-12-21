package com.book.govdatafr.departmentDetail.remote;

import android.util.Log;

import com.book.govdatafr.models.DepartmentDetail;
import com.book.govdatafr.networkUtils.ApiClient;
import com.book.govdatafr.networkUtils.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DepartmentDetailsRemoteDataSource {
    private final ApiInterface apiInterface;
//    private DepartmentDataSource sourceContext;

    public DepartmentDetailsRemoteDataSource() {
//        this.sourceContext = sourceContext;
        Retrofit client = ApiClient.getInstance().getClient();
        apiInterface = client.create(ApiInterface.class);
    }

    public void getDepartments(String code,String fields,final DepartmentDetailDataSource sourceContext) {
        Call<List<DepartmentDetail>> response = apiInterface.getDepartmentDetails(code,fields);
        response.enqueue(new Callback<List<DepartmentDetail>>() {
            @Override
            public void onResponse(Call<List<DepartmentDetail>> call, Response<List<DepartmentDetail>> response) {
                Log.d("onResponse", "onResponse: "+response);
                if (response.code() == 200) {
                    sourceContext.onSuccess(response.body());
                } else {
                    sourceContext.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<DepartmentDetail>> call, Throwable t) {
                sourceContext.onFailure();
            }
        });
    }
}
