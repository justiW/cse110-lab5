package edu.ucsd.cse110.lab5_room.model;

public class DummyPerson implements IPerson {
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
