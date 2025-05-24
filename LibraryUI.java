import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LibraryUI extends JFrame {
    private JTextField idField, titleField, authorField;
    private JButton addButton;
    private BookDAO bookDAO;

    public LibraryUI() {
        super("Library Management System");
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JLabel idLabel = new JLabel("Book ID:");
        JLabel titleLabel = new JLabel("Title:");
        JLabel authorLabel = new JLabel("Author:");

        idField = new JTextField();
        titleField = new JTextField();
        authorField = new JTextField();

        addButton = new JButton("Add Book");

        add(idLabel); add(idField);
        add(titleLabel); add(titleField);
        add(authorLabel); add(authorField);
        add(new JLabel()); add(addButton);

        try {
            bookDAO = new BookDAO();
        } catch (SQLException e) {
            showError("Database connection failed.");
        }

        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String author = authorField.getText();
                Book book = new Book(id, title, author);
                bookDAO.addBook(book);
                showMessage("Book added successfully!");
            } catch (Exception ex) {
                showError("Error adding book: " + ex.getMessage());
            }
        });

        setVisible(true);
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryUI::new);
    }
}
