package com.book.govdatafr.departmentDetail.remote;

import com.book.govdatafr.models.DepartmentDetail;

import java.util.List;

public interface DepartmentDetailDataSource {

    void onSuccess(List<DepartmentDetail> list);

    void onFailure();

}

