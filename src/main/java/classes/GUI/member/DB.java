package classes.GUI.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

	private static Connection conn;

	public static void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "java", "java");

			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버가 존재하지 않습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL예외 발생");
			e.printStackTrace();
		}
	}

	public static ResultSet executeQuery(String sql, Object... params) {
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			setParams(pstmt, params);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int excuteUpdate(String sql, Object... params) {

		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			setParams(pstmt, params);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	private static void setParams(PreparedStatement pstmt, Object... params) {
		for (int i = 0; i < params.length; i++) {
			try {
				pstmt.setObject(i + 1, params[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
