package com.book.govdatafr.networkUtils;

import com.book.govdatafr.models.DepartmentDetail;
import com.book.govdatafr.models.DepartmentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    /**
     * GET call for all department list
     * @return
     */
    @GET("/departements")
    Call<List<DepartmentModel>> getDepartments();

    /**
     * GET call for all municipality list
     * @param code
     * @param fields
     * @return
     */
    @GET("/departements/{code}/communes")
    Call<List<DepartmentDetail>> getDepartmentDetails(@Path("code") String code, @Query("fields") String fields);

}
