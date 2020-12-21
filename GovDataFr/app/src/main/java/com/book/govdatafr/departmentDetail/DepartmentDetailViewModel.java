package com.book.govdatafr.departmentDetail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.book.govdatafr.models.DetailDisplayModel;

public class DepartmentDetailViewModel extends AndroidViewModel {

    private  DepartmentDetailsRepo repository;

    public DepartmentDetailViewModel(@NonNull Application application) {
        super(application);
         repository= DepartmentDetailsRepo.getInstance(application);
    }

    /**
     * initializing live data variable, it will be updated from the repository, either locally or from API response
     * @param code
     */
    public void init(String code){
        departmentDetails= repository.getDepartmentDetails(code);
    }

    private MutableLiveData<DetailDisplayModel> departmentDetails = new MutableLiveData<>();

    /**
     * livedata for observing changes
     * @return
     */
    public LiveData<DetailDisplayModel> getDepartmentDetails(){
       return departmentDetails;
    }
 }
