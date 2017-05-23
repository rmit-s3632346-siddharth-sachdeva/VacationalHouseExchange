package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	static Connection con;
	static{
		con = DBConnection.connectSparkDB();
	}
	
	public ResultSet getData(String sqlQuery){
		ResultSet resultSet = null;
		try {
			Statement stmt = con.createStatement();
			resultSet = stmt.executeQuery(sqlQuery);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resultSet;
	}

	public int updateData(String sqlQuery){
		int noOfRowsAffected = 0;
		try {
			Statement stmt = con.createStatement();
			noOfRowsAffected = stmt.executeUpdate(sqlQuery);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return noOfRowsAffected;
	}
	
	public int callProcedure(String procName){
		return 0;
		/*Statement stmt = con.prepareCall("{call GET_SUPPLIER_OF_COFFEE(?, ?)}");

		stmt.setString(1, "");
		stmt.registerOutParameter(2, Types.VARCHAR);
		stmt.executeQuery();

		String supplierName = cs.getString(2);
		return 0;*/
		
	}
	
}
