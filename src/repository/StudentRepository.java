package repository;

import model.Student;

import java.io.*;
import java.util.ArrayList;

public class StudentRepository {

    private final String filePath = "data/students.txt";

    public void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Student student : students) {
                writer.write(
                        student.getId() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getCourse()
                );
                writer.newLine();
            }

            System.out.println("Students saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];

                    students.add(
                            new Student(id, name, age, course)
                    );
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }

        return students;
    }
}