package ui;

import javax.swing.*;
import dao.StudentDAO;
import model.Student;

public class StudentForm extends JFrame {
    public StudentForm() {
        setTitle("Student Form");
        setSize(300, 300);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 10, 160, 25);
        add(nameField);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(100, 50, 100, 25);
        add(saveButton);

        saveButton.addActionListener(e -> {
            Student s = new Student();
            s.setName(nameField.getText());
            s.setEmail("test@email.com");
            s.setCourse("Java");
            try {
                new StudentDAO().save(s);
                JOptionPane.showMessageDialog(null, "Saved!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}