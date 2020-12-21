package com.book.govdatafr.departmentList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.book.govdatafr.R;
import com.book.govdatafr.models.DepartmentModel;

import java.util.List;

public class DepartmentListAdapter extends RecyclerView.Adapter<DepartmentListAdapter.ItemsHolder> {

    private List<DepartmentModel> departmentList;
    private DepartmentListInterface context;

    public DepartmentListAdapter(DepartmentListInterface context, List<DepartmentModel> departmentList){
        this.departmentList=departmentList;
        this.context=context;
    }
    @NonNull
    @Override
    public DepartmentListAdapter.ItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemsHolder(LayoutInflater.from(context.getActivity()).inflate(R.layout.item_department_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentListAdapter.ItemsHolder holder, final int position) {
        holder.name.setText(departmentList.get(position).getNom());
        holder.code.setText(departmentList.get(position).getCode());
        holder.region.setText(departmentList.get(position).getCodeRegion());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            context.onListItemClick(departmentList.get(position));
            }
        });
}

    @Override
    public int getItemCount() {
        return departmentList.size();
    }

    class ItemsHolder extends RecyclerView.ViewHolder {
        TextView name, code, region;
        LinearLayout mainLayout;

        public ItemsHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            code = itemView.findViewById(R.id.code);
            region = itemView.findViewById(R.id.region);
            mainLayout= itemView.findViewById(R.id.main_item_layout);
        }
    }
}
