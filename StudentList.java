import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void displayStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
