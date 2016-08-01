package com.noteapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shopclues on 29/7/16.
 */

public class Note implements Parcelable {

    public String title;
    public String description;
    public String createdDateTime;
    public String modifiedDateTime;
//    public String createdTime;
//    public String modifiedTime;
    public int noteType;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.createdDateTime);
        dest.writeString(this.modifiedDateTime);
        dest.writeInt(this.noteType);
    }

    public Note() {
    }

    public Note(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.createdDateTime = in.readString();
        this.modifiedDateTime = in.readString();
        this.noteType = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
