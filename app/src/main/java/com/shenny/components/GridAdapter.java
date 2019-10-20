package com.shenny.components;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private ArrayList<Component> listComponents;
    public GridAdapter(ArrayList<Component> list){
        this.listComponents = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_hero, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {

        Component component = listComponents.get(position);

        Glide.with(holder.itemView.getContext())
                .load(component.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);

        holder.tvName.setText(component.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext() , DetailActivity.class);
                intent.putExtra("judul", listComponents.get(holder.getAdapterPosition()).getName());
                intent.putExtra("penjelasan" , listComponents.get(holder.getAdapterPosition()).getDetail());
                intent.putExtra("url", listComponents.get(holder.getAdapterPosition()).getURL());
                intent.putExtra("example", listComponents.get(holder.getAdapterPosition()).getExampleCode());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listComponents.size();
    }

     class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;

         GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
        }
    }
}
