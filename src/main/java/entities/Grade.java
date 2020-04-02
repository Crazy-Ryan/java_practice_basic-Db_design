package entities;

public class Grade {
    private int id;
    private int studentId;
    private int subjectId;
    private int score;

    public Grade(int id, int studentId, int subjectId, int score) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getScore() {
        return score;
    }
}
