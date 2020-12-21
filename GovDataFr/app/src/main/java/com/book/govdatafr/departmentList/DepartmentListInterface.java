package com.book.govdatafr.departmentList;

import android.app.Activity;

import com.book.govdatafr.models.DepartmentModel;

public interface DepartmentListInterface {

    void onListItemClick(DepartmentModel departmentModel);

    Activity getActivity();
}
