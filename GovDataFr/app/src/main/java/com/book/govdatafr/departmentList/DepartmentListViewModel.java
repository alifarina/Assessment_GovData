package com.book.govdatafr.departmentList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.book.govdatafr.models.DepartmentModel;

import java.util.List;

public class DepartmentListViewModel extends AndroidViewModel {

    private MutableLiveData<List<DepartmentModel>> departments = new MutableLiveData<>();

    private DepartmentListRepository mDepartmentRepo;

    public DepartmentListViewModel(@NonNull Application application) {
        super(application);
        mDepartmentRepo = DepartmentListRepository.getInstance(application.getApplicationContext());
    }

    /**
     * initializing live data variable, it will be updated from the repository, either locally or from API response
     */
    public void init(){
        departments=  mDepartmentRepo.getAllDepartments();
    }

    /**
     * livedata for observing changes
     * @return
     */
    public LiveData<List<DepartmentModel>> getDepartmentsList() {
        return departments;
    }

}
