package com.example.kh2315.swipedeleterecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    List<RecyclerEntity> list;

    public RecyclerAdapter(List<RecyclerEntity> list) {
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        RecyclerEntity entity = list.get(position);
        holder.title.setText(entity.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void removeItem(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    public RecyclerEntity getEntity(int adapterPosition) {
        return list.get(adapterPosition);
    }

    public void undoDelete(RecyclerEntity entity, int position) {
        list.add(position, entity);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
