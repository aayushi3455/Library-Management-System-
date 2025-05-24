package dao;

import model.Student;
import util.DBUtil;
import java.sql.*;

public class StudentDAO {
    public void save(Student s) throws SQLException {
        Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO students(name, email, course) VALUES (?, ?, ?)");
        stmt.setString(1, s.getName());
        stmt.setString(2, s.getEmail());
        stmt.setString(3, s.getCourse());
        stmt.executeUpdate();
        conn.close();
    }
}