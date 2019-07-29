package com.example.colordetect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.colordetect.R;
import com.example.colordetect.component.DataComponent;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private List<DataComponent> __dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView no_responden, nama_perawat;
        public ImageView photo_data;

        public MyViewHolder(View view) {
            super(view);
            no_responden = (TextView) view.findViewById(R.id._no_responden_data);
            nama_perawat = (TextView) view.findViewById(R.id._nama_perawat_data);
            photo_data = (ImageView) view.findViewById(R.id._photo_data);
        }
    }


    public DataAdapter(List<DataComponent> __dataList) {
        this.__dataList = __dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataComponent dataComponent = __dataList.get(position);
        holder.no_responden.setText(dataComponent.getNo_responden());
        holder.nama_perawat.setText(dataComponent.getNama_perawat());
        holder.photo_data.setImageResource(dataComponent.getPhoto_data());
    }

    @Override
    public int getItemCount() {
        return __dataList.size();
    }
}
