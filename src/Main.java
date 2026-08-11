import exception.InvalidStudentException;
import model.Student;
import service.StudentService;
import util.Validator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {

                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Enter Course: ");
                        String course = scanner.nextLine();

                        try {

                            Validator.validateStudent(
                                    id,
                                    name,
                                    age,
                                    course
                            );

                            service.addStudent(
                                    new Student(id, name, age, course)
                            );

                        } catch (InvalidStudentException e) {

                            System.out.println(
                                    "Invalid input: " + e.getMessage()
                            );
                        }

                        break;

                    case 2:

                        service.displayStudents();
                        break;

                    case 3:

                        System.out.print("Enter student ID: ");
                        int searchId = scanner.nextInt();

                        Student student = service.searchStudent(searchId);

                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found.");
                        }

                        break;

                    case 4:

                        System.out.print("Enter student ID: ");
                        int updateId = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Enter new course: ");
                        String newCourse = scanner.nextLine();

                        try {

                            Validator.validateStudent(
                                    updateId,
                                    newName,
                                    newAge,
                                    newCourse
                            );

                            if (service.updateStudent(
                                    updateId,
                                    newName,
                                    newAge,
                                    newCourse
                            )) {

                                System.out.println(
                                        "Student updated successfully."
                                );

                            } else {

                                System.out.println(
                                        "Student not found."
                                );
                            }

                        } catch (InvalidStudentException e) {

                            System.out.println(
                                    "Invalid input: " + e.getMessage()
                            );
                        }

                        break;

                    case 5:

                        System.out.print("Enter student ID: ");
                        int deleteId = scanner.nextInt();

                        if (service.deleteStudent(deleteId)) {

                            System.out.println(
                                    "Student deleted successfully."
                            );

                        } else {

                            System.out.println(
                                    "Student not found."
                            );
                        }

                        break;

                    case 6:

                        System.out.println("Exiting application...");
                        scanner.close();
                        return;

                    default:

                        System.out.println(
                                "Invalid choice. Enter 1-6."
                        );
                }

            } catch (java.util.InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.nextLine();
            }
        }
    }
}