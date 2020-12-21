package com.book.govdatafr.departmentDetail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.book.govdatafr.R;
import com.book.govdatafr.models.DetailDisplayModel;

public class DepartmentDetailActivity extends AppCompatActivity {
    private String departmentCode = "";
    private DepartmentDetailViewModel departmentDetailViewModel;
    private TextView regionName, population, municipalityCount,deptName;
    private String departmentName="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dept_detail_layout);
        departmentCode = getIntent().getStringExtra("Code_dept");
        departmentName=getIntent().getStringExtra("Dept_name");
        initViews();


        departmentDetailViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(DepartmentDetailViewModel.class);
        departmentDetailViewModel.init(departmentCode);
        departmentDetailViewModel.getDepartmentDetails().observe(this, new Observer<DetailDisplayModel>() {
            @Override
            public void onChanged(DetailDisplayModel departmentDetail) {
                if(departmentDetail!=null){
                    regionName.setText(departmentDetail.getRegionName());
                    population.setText(departmentDetail.getTotalPopulation()+"");
                    municipalityCount.setText(departmentDetail.getNumMunicipalities()+"");
                }

            }
        });
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Department Details");
        setSupportActionBar(toolbar);
        regionName = findViewById(R.id.region_name);
        population = findViewById(R.id.population);
        municipalityCount = findViewById(R.id.num_municipality);
        deptName=findViewById(R.id.name);

        deptName.setText(departmentName);

    }

    public void goBack(View view) {
        this.finish();
    }
}
