# Student Management System
![image](https://github.com/user-attachments/assets/76b62fc2-1686-435c-809d-cfde471b8584)

## Table of Contents
*Introduction*
*Features*
*System Requirements*
*Installation*
*Usage*
*Interface Description*
*Future Enhancements*
*Author*
*License*
## Introduction
The Student Management System is a desktop-based Java application designed to manage student records efficiently. It allows the user to add, update, delete, search, and display student information in a structured tabular format. The application aims to simplify student data management for academic administrators and tutors.

## Features
Add Student Record: Insert a new student’s information, including name, student number, course, and marks.
Update Marks: Modify the marks of an existing student.
Delete Student Record: Remove a student’s information from the system.
Search Student Records: Search for students by name, student number, or course.
View Student List: Display all student records in a table format for easy viewing.
Exit Application: Safely close the program.
System Requirements
Operating System: Windows, Linux, or macOS
Java Development Kit (JDK): Version 8 or above
IDE (Optional): IntelliJ IDEA, Eclipse, or NetBeans
RAM: Minimum 2GB
Storage: At least 50MB of free space
Installation
Download the source code or clone the repository using the following command:
bash
Copy code
git clone <repository_url>
Open the project in your preferred IDE or compile it using the terminal.
Compile and Run using the following commands:
bash
Copy code
javac Main.java
java Main
Ensure that all necessary dependencies are properly configured (if any).
Usage
Adding a New Student:

Enter the student’s name, student number, course, and marks in the input fields.
Click the Add button to save the record.
Updating Marks:

Select the student from the table.
Modify the marks in the input field.
Click the Update Marks button to apply the changes.
Deleting a Student Record:

Select the student from the table.
Click the Delete button to remove the record.
Searching for a Student:

Enter the search criteria in the relevant field.
Click Search to filter the records based on the entered data.
Exiting the Application:

Click the Exit button to close the application safely.
Interface Description
The graphical user interface (GUI) is divided into two sections:

## Input Panel:

Name: Text field for the student’s name.
Student No.: Text field for the student number.
Course: Text field for the course.
Marks: Text field for the student’s marks.
Action Buttons:
Add: Adds a new student record.
Update Marks: Updates the marks for a selected student.
Delete: Deletes the selected student’s record.
Search: Searches for students based on the entered criteria.
Exit: Closes the application.
Table View:

## Displays all student records with the following columns:
ID: Unique identifier for each student.
Student Name: Name of the student.
Student Number: Student’s registration number.
Course: Course the student is enrolled in.
Marks: Current marks of the student.
Future Enhancements
Database Integration: Store student records in an external database (e.g., MySQL).
Export Feature: Enable exporting student data to Excel or CSV files.
Authentication System: Add user authentication for secure access.
Report Generation: Generate reports for student performance automatically.
Author
This project was developed by My group teams as part of a student management solution. Please feel free to reach out for suggestions or feedback.

License
This project is licensed under the MIT License. See the LICENSE file for more details.
