package com.noteapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shopclues on 29/7/16.
 */

public class AdapterMainNotes extends RecyclerView.Adapter<AdapterMainNotes.CustomViewHolder> {



    public class CustomViewHolder extends RecyclerView.ViewHolder{

        public CustomViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

    }




    @Override
    public int getItemCount() {
        return 0;
    }
}
