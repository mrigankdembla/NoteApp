package com.noteapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.noteapp.R;
import com.noteapp.models.Note;

import java.util.ArrayList;

/**
 * Created by shopclues on 29/7/16.
 */

public class AdapterMainNotes extends RecyclerView.Adapter<AdapterMainNotes.CustomViewHolder> {
    private ArrayList<Note> arrayListNote;

    public AdapterMainNotes(ArrayList<Note> list){
        this.arrayListNote = list;
    }

    public void setList(ArrayList<Note> list) {
        this.arrayListNote = list;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View noteCard = inflater.inflate(R.layout.note_main_card,null,false);
        CustomViewHolder customViewHolder = new CustomViewHolder(noteCard);
        return customViewHolder;

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Note note = arrayListNote.get(position);

        holder.etTitle.setText(note.title);
        holder.etDescription.setText(note.description);
        holder.tvDate.setText(note.createdDate);
        holder.tvTime.setText(note.createdTime);
        holder.tvSave.setVisibility(View.GONE);




    }




    @Override
    public int getItemCount() {
        return arrayListNote.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder{

        private EditText etTitle;
        private EditText etDescription;
        private TextView tvTime, tvDate, tvSave;
      //  private String createdDate,createdTime;
        public CustomViewHolder(View itemView) {
            super(itemView);
            etTitle = (EditText) itemView.findViewById(R.id.etNoteTitle);
            etDescription = (EditText) itemView.findViewById(R.id.etDescriptionNote);

            tvDate = (TextView) itemView.findViewById(R.id.tvNoteDate);
            tvTime = (TextView) itemView.findViewById(R.id.tvNoteTime);

            tvSave = (TextView) itemView.findViewById(R.id.tv_save_note);
        }
    }
}
