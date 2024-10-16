package org.example;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudManagement {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        JPanel personal_table = new JPanel();
        JPanel personal_details = new JPanel();
        JPanel personal_function = new JPanel();

        frame.setSize(1145, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Prevent resizing

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Table for showing student information
        personal_table.setBounds(360, 15, 760, 615);
        personal_table.setBorder(new LineBorder(Color.BLUE, 3));

        // Panel for input fields
        personal_details.setBounds(10, 15, 340, 615);
        personal_details.setBorder(new LineBorder(Color.blue, 3));
        personal_details.setLayout(null);

        // Buttons for actions (add, update, delete, search, exit)
        JButton addButton = new JButton("Add ➕"); // Update with your icon path
        JButton updateButton = new JButton("Update Marks ♻️"); // Update with your icon path
        JButton deleteButton = new JButton("Delete 🚮"); // Update with your icon path
        JButton searchButton = new JButton("Search 🔎"); // Update with your icon path
        JButton exitButton = new JButton("Exit 🚶‍➡️"); // Update with your icon path

        // Set bounds for action buttons
        addButton.setBounds(50, 270, 250, 50);
        updateButton.setBounds(50, 340, 250, 50);
        deleteButton.setBounds(50, 410, 250, 50);
        searchButton.setBounds(50, 480, 250, 50);
        exitButton.setBounds(50, 550, 250, 50);

        // Add buttons to the input panel
        personal_details.add(addButton);
        personal_details.add(updateButton);
        personal_details.add(deleteButton);
        personal_details.add(searchButton);
        personal_details.add(exitButton);

        // Input labels and text fields for user input
        JLabel StudNameLabel = new JLabel("Name: ");
        JLabel StudNumberLabel = new JLabel("Student No.: ");
        JLabel CourseLabel = new JLabel("Course: ");
        JLabel MarksLabel = new JLabel("Marks: ");

        StudNameLabel.setBounds(30, 50, 200, 12);
        StudNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        StudNumberLabel.setBounds(30, 100, 200, 12);
        StudNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        CourseLabel.setBounds(30, 150, 200, 12);
        CourseLabel.setFont(new Font("Arial", Font.BOLD, 18));
        MarksLabel.setBounds(30, 200, 200, 12);
        MarksLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Add labels to the input panel
        personal_details.add(StudNameLabel);
        personal_details.add(StudNumberLabel);
        personal_details.add(CourseLabel);
        personal_details.add(MarksLabel);

        // Text fields for student information
        JTextField StudentName = new JTextField();
        JTextField StudentNumber = new JTextField();
        JTextField StudCourse = new JTextField();
        JTextField StudentMarks = new JTextField();

        // Set bounds for text fields
        StudentName.setBounds(170, 40, 155, 25);
        StudentNumber.setBounds(170, 92, 155, 25);
        StudCourse.setBounds(170, 144, 155, 25);
        StudentMarks.setBounds(170, 196, 155, 25);

        // Add text fields to the input panel
        personal_details.add(StudentName);
        personal_details.add(StudentNumber);
        personal_details.add(StudCourse);
        personal_details.add(StudentMarks);

        // Table setup for displaying student details
        String[] columnNames = {"ID", "Student Name", "Student Number", "Course", "Marks"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only the Marks column (index 4) is editable
                return column == 4; // Marks column is editable
            }
        };

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(370, 40, 740, 300);
        frame.add(scrollPane);

        // Add panels to the frame
        frame.add(personal_table);
        frame.add(personal_details);

        // Frame layout and visibility
        frame.setLayout(null);
        frame.setVisible(true);

        // Add Button ActionListener - Add student to the table
        addButton.addActionListener(new ActionListener() {
            private int studentID = 1; // Track student ID

            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String studNumber = StudentNumber.getText();
                String studName = StudentName.getText();
                String course = StudCourse.getText();
                String marks = StudentMarks.getText();

                // Add to table if input fields are not empty
                if (!studName.isEmpty() && !studNumber.isEmpty() && !course.isEmpty() && !marks.isEmpty()) {
                    // Add row to the table
                    model.addRow(new String[]{String.valueOf(studentID), studName, studNumber, course, marks});
                    studentID++; // Increment student ID

                    // Clear the input fields
                    StudentName.setText("");
                    StudentNumber.setText("");
                    StudCourse.setText("");
                    StudentMarks.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields before adding.");
                }
            }
        });

        // Update Button ActionListener - Updates only the marks column
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected row
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Update only the marks column for the selected row
                    model.setValueAt(StudentMarks.getText(), selectedRow, 4); // Column 4 is for marks
                    JOptionPane.showMessageDialog(frame, "Student marks updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a student to update marks.");
                }
            }
        });

        // Delete Button ActionListener
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected row
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Remove selected row from the table
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(frame, "Student record deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a student to delete.");
                }
            }
        });

        // Search Button ActionListener
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchStudNumber = JOptionPane.showInputDialog("Enter Student Number to search:");

                if (searchStudNumber != null && !searchStudNumber.isEmpty()) {
                    boolean found = false;
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (model.getValueAt(i, 2).toString().equals(searchStudNumber)) {
                            // Display found student in input fields
                            StudentName.setText(model.getValueAt(i, 1).toString());
                            StudentNumber.setText(model.getValueAt(i, 2).toString());
                            StudCourse.setText(model.getValueAt(i, 3).toString());
                            StudentMarks.setText(model.getValueAt(i, 4).toString());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(frame, "Student not found!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid student number.");
                }
            }
        });

        // Exit Button ActionListener with confirmation dialog
        exitButton.addActionListener(e -> {
            int confirmExit = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        });
    }
}
