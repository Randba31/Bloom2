package com.example.bloom2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<TaskClass> mData;
    private LayoutInflater mInflater;
    private Context context;
    private final Adapter.ItemClickListener mClickListener = new ItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            //get Task data
            TaskClass task= mData.get(position);
            //upload tasks data
            //goto details activity
            Intent i=new Intent(context,TaskDetailsActivity.class);
            i.putExtra("task",(Serializable) task);
            context.startActivity(i);
        }
    };

    // data is passed into the constructor
    Adapter(Context context, List<TaskClass> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context=context;
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
        TaskClass task = mData.get(position);
        holder.tvNameTaskRow.setText(task.getTask());

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
    TaskClass getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    /*
    void setClickListener(Adapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }*/

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

