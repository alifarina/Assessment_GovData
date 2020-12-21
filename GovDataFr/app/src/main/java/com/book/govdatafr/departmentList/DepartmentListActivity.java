package com.book.govdatafr.departmentList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.book.govdatafr.R;
import com.book.govdatafr.departmentDetail.DepartmentDetailActivity;
import com.book.govdatafr.models.DepartmentModel;

import java.util.ArrayList;
import java.util.List;


public class DepartmentListActivity extends AppCompatActivity implements DepartmentListInterface{

    private DepartmentListViewModel departmentListViewModel;
    private RecyclerView recyclerview;
    private DepartmentListAdapter adapter;
    private List<DepartmentModel> departmentsList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_list);
        initViews();

        departmentListViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(DepartmentListViewModel.class);

        departmentListViewModel.init();

        departmentListViewModel.getDepartmentsList().observe(this, new Observer<List<DepartmentModel>>() {
            @Override
            public void onChanged(List<DepartmentModel> departmentModels) {
                if(departmentModels!=null){
                    Log.d("data in observer", String.valueOf(departmentModels));
                    departmentsList.clear();
                    departmentsList.addAll(departmentModels);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        setAdapter();
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Department List");
        setSupportActionBar(toolbar);

        recyclerview = findViewById(R.id.list_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setAdapter() {
        Log.d("set adapter", String.valueOf(departmentsList));
        adapter = new DepartmentListAdapter(this, departmentsList);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void onListItemClick(DepartmentModel departmentModel) {
        Intent detailActivity = new Intent(this, DepartmentDetailActivity.class);
        detailActivity.putExtra("Code_dept",departmentModel.getCode());
        detailActivity.putExtra("Dept_name",departmentModel.getNom());
        startActivity(detailActivity);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
