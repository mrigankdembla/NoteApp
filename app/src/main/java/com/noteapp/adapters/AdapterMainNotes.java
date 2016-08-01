package com.noteapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.noteapp.R;
import com.noteapp.models.Note;

import java.util.ArrayList;

/**
 * Created by shopclues on 29/7/16.
 */

public class AdapterMainNotes extends RecyclerView.Adapter<AdapterMainNotes.CustomViewHolder> {
    private ArrayList<Note> arrayListNote;
    private CustomChildClickListener customChildClickListener;
    private final static int FADE_DURATION = 1000; // in milliseconds

    public AdapterMainNotes(ArrayList<Note> list){
        this.arrayListNote = list;
    }

    public void setList(ArrayList<Note> list) {
        this.arrayListNote = list;
    }

    public void setOnNoteItemClickListener(CustomChildClickListener customChildClickListener){
        this.customChildClickListener = customChildClickListener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View noteCard = inflater.inflate(R.layout.note_show_card,null,false);
        CustomViewHolder customViewHolder = new CustomViewHolder(noteCard);
        return customViewHolder;

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Note note = arrayListNote.get(position);

        holder.tvTitle.setText(note.title);
        holder.tvDescription.setText(note.description);
        holder.tvDate.setText(note.modifiedDateTime);
       // holder.tvTime.setText(note.modifiedTime);
        holder.tvDelete.setVisibility(View.GONE);
        holder.tvEdit.setVisibility(View.GONE);

        holder.viewDivider.setVisibility(View.GONE);


    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }


    @Override
    public int getItemCount() {
        return arrayListNote.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvTitle;
        private TextView tvDescription;
        private TextView tvTime, tvDate, tvEdit, tvDelete;
        private View viewDivider;
      //  private String createdDate,createdTime;
        public CustomViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.etNoteTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.etDescriptionNote);

            tvDate = (TextView) itemView.findViewById(R.id.tvNoteDate);
            tvTime = (TextView) itemView.findViewById(R.id.tvNoteTime);

            tvEdit = (TextView) itemView.findViewById(R.id.tv_edit_note);
            tvDelete = (TextView) itemView.findViewById(R.id.tv_delete_note);

            viewDivider = (View) itemView.findViewById(R.id.tempview);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if(customChildClickListener!=null){
                customChildClickListener.onClickNoteItem(arrayListNote.get(getLayoutPosition()),getLayoutPosition(),v);
            }
        }
    }

    public interface CustomChildClickListener{
        public void onClickNoteItem(Note note,int position,View v);
    }
}
