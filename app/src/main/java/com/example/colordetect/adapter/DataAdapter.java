package com.example.colordetect.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.colordetect.R;
import com.example.colordetect.component.DataItem;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> implements Filterable {

    private List<DataItem> itemList;
    private List<DataItem> itemListFull;

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView photo_data;
        TextView txt_no_res, txt_nama;

        MyViewHolder(View itemView) {
            super(itemView);
            photo_data = itemView.findViewById(R.id._photo_data);
            txt_no_res = itemView.findViewById(R.id._no_responden_data);
            txt_nama = itemView.findViewById(R.id._nama_perawat_data);
        }
    }

    public DataAdapter(List<DataItem> itemList) {
        this.itemList = itemList;
        this.itemListFull = itemList;
    }

    @NonNull
    @Override
    public DataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_data, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.MyViewHolder myViewHolder, int i) {
        DataItem currentItem = itemList.get(i);
        myViewHolder.photo_data.setImageResource(currentItem.getPhoto_data());
        myViewHolder.txt_no_res.setText(currentItem.getNo_responden());
        myViewHolder.txt_nama.setText(currentItem.getNama_perawat());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<DataItem> filteredList = new ArrayList<>();
                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(itemListFull);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();

                    for (DataItem item : itemListFull) {
                        if (item.getNo_responden().toLowerCase().contains(filterPattern) ||
                                item.getNama_perawat().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                itemList.clear();
                itemList.addAll((ArrayList<DataItem>) results.values);
                notifyDataSetChanged();
            }
        };
    }
}
