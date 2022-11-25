package com.shakawat.learn_volley_android.JsonObjectRequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shakawat.learn_volley_android.JsonArrayRequest.DataModel;
import com.shakawat.learn_volley_android.R;

import java.util.List;

public class ArrayAdapterForObject extends RecyclerView.Adapter<ArrayAdapterForObject.myViewHolder> {
    Context context;
    List<MyJsonObject> allProductsList;

    public ArrayAdapterForObject(Context context, List<MyJsonObject> allProductsList) {
        this.context = context;
        this.allProductsList = allProductsList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayoutforarrayobject, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.id.setText(allProductsList.get(position).getId());
        holder.name.setText(allProductsList.get(position).getName());
        holder.fileName.setText(allProductsList.get(position).getFileName());
        holder.details.setText(allProductsList.get(position).getDetails());
//        Glide
//                .with(context)
//                .load(allProductsList.get(position).getBaseUrl() + allProductsList.get(position).getFileName())
//                .centerCrop()
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return allProductsList.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, details, fileName;
        ImageView imageView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.idid);
            name = itemView.findViewById(R.id.name);
            details = itemView.findViewById(R.id.details);
            fileName = itemView.findViewById(R.id.filename);
        }
    }
}
