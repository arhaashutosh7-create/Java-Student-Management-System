package util;

import exception.InvalidStudentException;

public class Validator {

    public static void validateStudent(
            int id,
            String name,
            int age,
            String course) throws InvalidStudentException {

        if (id <= 0) {
            throw new InvalidStudentException("ID must be greater than 0.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentException("Name cannot be empty.");
        }

        if (age < 1 || age > 100) {
            throw new InvalidStudentException("Age must be between 1 and 100.");
        }

        if (course == null || course.trim().isEmpty()) {
            throw new InvalidStudentException("Course cannot be empty.");
        }
    }
}