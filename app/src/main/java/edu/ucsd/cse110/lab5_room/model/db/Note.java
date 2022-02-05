package edu.ucsd.cse110.lab5_room.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int noteID;

    @ColumnInfo(name = "person_id")
    public int personID;

    @ColumnInfo(name = "text")
    public String text;

    public Note(int noteID, int personID, String text){
        this.noteID = noteID;
        this.personID = personID;
        this.text = text;
    }
}