import java.util.*;

public class StudentSearch {
    public static Student searchById(ArrayList<Student> students, int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public static Student searchByName(ArrayList<Student> students, String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.addStudent(new Student(1, "Archana", 88));
        list.addStudent(new Student(2, "Rahul", 75));

        Student found = searchByName(list.getStudents(), "Archana");
        System.out.println(found != null ? "Found: " + found : "Student not found!");
    }
}