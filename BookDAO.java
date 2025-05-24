import java.sql.*;

public class BookDAO {
    private Connection conn;

    public BookDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "password");
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (id, title, author) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, book.getId());
        stmt.setString(2, book.getTitle());
        stmt.setString(3, book.getAuthor());
        stmt.executeUpdate();
        stmt.close();
    }
}
