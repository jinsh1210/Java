package toc.gui.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/toc25";
    private static final String USER = "toc25";
    private static final String PASSWORD = "toc25";
    
    private static DB instance;
    private Connection connection;

    private DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }
    
    public boolean inputStudent(String name, int score, String studentid) {
        String sql = "INSERT INTO student (name, score, studentid) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.setString(3, studentid);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // 전체 리스트 로딩
    public void loadTableData(DefaultTableModel tableModel) {
        String[] colNames = { "ID", "이름", "학번", "성적" };
        tableModel.setColumnIdentifiers(colNames);
        tableModel.setRowCount(0);

        String sql = "SELECT id, name, studentid, score FROM student ORDER BY id";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String studentid = rs.getString("studentid");
                int score = rs.getInt("score");

                Object[] row = { id, name, studentid, score };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 특정 학번 로딩
    public void searchStudentById(DefaultTableModel tableModel, String studentId) {
        String[] colNames = { "ID", "이름", "학번", "성적" };
        tableModel.setColumnIdentifiers(colNames);
        tableModel.setRowCount(0);

        String sql = "SELECT id, name, studentid, score FROM student WHERE studentid = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String studentid = rs.getString("studentid");
                int score = rs.getInt("score");

                Object[] row = { id, name, studentid, score };
                tableModel.addRow(row);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

} 
