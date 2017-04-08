package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection connectSparkDB() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://173.199.142.216:3306/ansalhei_sparkvhe", "ansalhei_3632346",
					"8y]iV-)~cvry");
			if (!con.isClosed()) {
				System.out.println("Database Connected!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
