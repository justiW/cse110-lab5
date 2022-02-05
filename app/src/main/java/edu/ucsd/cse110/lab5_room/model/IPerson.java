package edu.ucsd.cse110.lab5_room.model;

import java.util.List;

public interface IPerson {
    int getID();
    String getName();
    List<String> getNotes();
}
