package entities;

import java.util.Objects;

public class Subject {
    private int id;
    private String name;
    private int teacherId;

    public Subject(int id, String name, int teacherId) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
