package service;

import model.Student;
import repository.StudentRepository;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students;
    private StudentRepository repository;

    public StudentService() {
        repository = new StudentRepository();
        students = repository.loadStudents();
    }

    public void addStudent(Student student) {

        if (searchStudent(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);
        repository.saveStudents(students);

        System.out.println("Student added successfully.");
    }

    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public boolean deleteStudent(int id) {

        Student student = searchStudent(id);

        if (student != null) {
            students.remove(student);
            repository.saveStudents(students);
            return true;
        }

        return false;
    }

    public boolean updateStudent(
            int id,
            String name,
            int age,
            String course) {

        Student student = searchStudent(id);

        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);

            repository.saveStudents(students);

            return true;
        }

        return false;
    }
}