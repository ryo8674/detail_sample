package com.example.peter.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ThumbnailRecyclerAdapter extends RecyclerView.Adapter<ThumbnailRecyclerAdapter.ThumbnailViewHolder> {

    private List<Integer> list;
    private OnThumbnailTapListener listener;

    public ThumbnailRecyclerAdapter(List<Integer> list, OnThumbnailTapListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ThumbnailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.thumbnail_item, parent, false);
        final ThumbnailViewHolder holder = new ThumbnailViewHolder(inflate);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTap(holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThumbnailViewHolder holder, int position) {
        holder.thumbnail.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ThumbnailViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumbnail;

        public ThumbnailViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail_item);
        }
    }

    public interface OnThumbnailTapListener{
        void onTap(int position);
    }
}
