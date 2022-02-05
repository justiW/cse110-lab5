package edu.ucsd.cse110.lab5_room.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface NotesDAO {
    @Transaction
    @Query("SELECT * FROM notes WHERE person_id=:personID")
    List<Note> getForPerson(int personID);

    @Query("SELECT * FROM notes WHERE id=:id")
    Note get(int id);

    @Query("SELECT COUNT(*) FROM notes")
    int count();

    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);
}
