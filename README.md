# Java Student Management System

A console-based Student Management System developed using Core Java and Object-Oriented Programming principles.

## Features

- Add Student
- View All Students
- Search Student
- Update Student
- Delete Student
- Save Student Records to File
- Load Student Records from File
- Input Validation
- Custom Exception Handling
- Modular Package Structure

## Technologies Used

- Java 21
- Object-Oriented Programming
- ArrayList
- File Handling
- Exception Handling
- Git
- GitHub

## Project Structure

```text
Task-1/
│
├── data/
│   └── students.txt
│
├── src/
│   ├── exception/
│   │   └── InvalidStudentException.java
│   │
│   ├── model/
│   │   └── Student.java
│   │
│   ├── repository/
│   │   └── StudentRepository.java
│   │
│   ├── service/
│   │   └── StudentService.java
│   │
│   ├── util/
│   │   └── Validator.java
│   │
│   └── Main.java
│
├── .gitignore
└── README.md
