package edu.ucsd.cse110.lab5_room.model.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class, Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase singletonInstance;

    public static AppDatabase singleton(Context context) {
        if(singletonInstance == null)
        {
            singletonInstance = Room.databaseBuilder(context, AppDatabase.class, "persons.db")
                    .createFromAsset("starter-persons.db")
                    .allowMainThreadQueries()
                    .build();
        }

        return singletonInstance;
    }

    public abstract PersonWithNotesDao personWithNotesDao();
    public abstract NotesDAO notesDAO();
}
