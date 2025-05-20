package classes.database.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "java", "java");
			Statement stmt = conn.createStatement();

			// db 입력
			String insertSql = "INSERT INTO member\n" + "(name, age, height)\n" + "VALUES(?, ?, ?)";
			PreparedStatement pstmt =  conn.prepareStatement(insertSql);
			pstmt.setString(1, "박길동");
			pstmt.setInt(2, 12);
			pstmt.setDouble(3, 168.3);

			int res = pstmt.executeUpdate();

			// db 출력
			String sql = "SELECT * FROM member";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");

				System.out.println(id + " " + name + " " + age + " " + height);
			}

			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버가 존재하지 않습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL예외 발생");
			e.printStackTrace();
		}
	}
}
