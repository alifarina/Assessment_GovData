package com.book.govdatafr.departmentList.remote;

import com.book.govdatafr.models.DepartmentModel;
import com.book.govdatafr.networkUtils.ApiClient;
import com.book.govdatafr.networkUtils.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DepartmentRemoteDataSource {
    private final ApiInterface apiInterface;

    public DepartmentRemoteDataSource() {
        Retrofit client = ApiClient.getInstance().getClient();
        apiInterface = client.create(ApiInterface.class);
    }

    public void getDepartments(final DepartmentDataSource sourceContext) {
        Call<List<DepartmentModel>> response = apiInterface.getDepartments();
        response.enqueue(new Callback<List<DepartmentModel>>() {
            @Override
            public void onResponse(Call<List<DepartmentModel>> call, Response<List<DepartmentModel>> response) {
                if (response.code() == 200) {
                    sourceContext.onSuccess(response.body());
                } else {
                    sourceContext.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<DepartmentModel>> call, Throwable t) {
                sourceContext.onFailure();
            }
        });
    }
}
