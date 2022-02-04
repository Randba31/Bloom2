package com.example.bloom2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.Task;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<TimeMangClass> mData;
    private LayoutInflater mInflater;
    private static Adapter.ItemClickListener mClickListener;
    // data is passed into the constructor
    Adapter(Context context, List<TimeMangClass> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row, parent, false);
        return new Adapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        TimeMangClass task = mData.get(position);
        holder.tvNameTaskRow.setText(task.getTask());
        //holder.ivPhoto.setImageDrawable(rest.getPhoto());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNameTaskRow;


        ViewHolder(View itemView) {
            super(itemView);
            tvNameTaskRow = itemView.findViewById(R.id.tvNameTaskRow);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    TimeMangClass getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(Adapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

