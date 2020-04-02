package entities;

public class Teacher {
    private int id;
    private int name;

    public Teacher(int id, int name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }
}
