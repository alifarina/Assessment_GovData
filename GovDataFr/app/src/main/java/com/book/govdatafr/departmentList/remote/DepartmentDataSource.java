package com.book.govdatafr.departmentList.remote;

import com.book.govdatafr.models.DepartmentModel;

import java.util.List;

public interface DepartmentDataSource {

    void onSuccess(List<DepartmentModel> list);

    void onFailure();

}

