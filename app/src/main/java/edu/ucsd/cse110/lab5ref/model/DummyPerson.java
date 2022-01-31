package edu.ucsd.cse110.lab5ref.model;

import java.util.List;

public class DummyPerson extends IPerson {
    private final String name;
    private final String[] notes;

    public DummyPerson(String name, String[] notes) {
        this.name = name;
        this.notes = notes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getNotes() {
        return notes;
    }
}
