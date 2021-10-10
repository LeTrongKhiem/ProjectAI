
package Util;

import java.sql.*;

public class ConnectDB {
	public Connection conn;
	public Statement stm;
	public ResultSet rs;

//    private final String driver = "org.mysql.Driver";
	private final String root = "jdbc:mysql://localhost:3306/facial_recognition";
	private final String user = "root";
	private final String pass = "";

	public void connect() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(root, user, pass);
			System.out.println("Connected Success!");
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		}
	}

	public void disconnect() {
		try {
			conn.close();

		} catch (SQLException e) {
			System.out.println("Error:" + e);
		}
	}

	public void executeSQL(String sql) {
		try {
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		ConnectDB db = new ConnectDB();
		db.connect();
	}
}
