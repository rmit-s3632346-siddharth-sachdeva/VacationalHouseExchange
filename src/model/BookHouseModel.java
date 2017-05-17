package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Constants;
import database.DBOperations;

public class BookHouseModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null;
	int  resultInsert = -1;

	public String bookHouseModel(String ownerEmailId , String requesterEmailID){
		try{
			String sqlQuery = "SELECT 0 FROM Book_House_Table WHERE ownerEmailId='" + ownerEmailId + ";";
			ResultSet resultSet = dbOperations.getData(sqlQuery);

			while (resultSet.next()) {
				response = resultSet.getString("0");
			}

			if (response != null && response.equalsIgnoreCase("0")) {
				String updateRequester = "Update Book_House_Table set requesterEmailId = '"+requesterEmailID+"' where ownerEmailId = '"+ownerEmailId+"';";
				resultInsert = dbOperations.updateData(updateRequester);
				
			} else {
				String insertBooking = "Insert into Book_House_Table (ownerEmailId, requesterEmailId) values('"+ownerEmailId+"', '"+requesterEmailID+"');";
				resultInsert = dbOperations.updateData(insertBooking);
			}
			if(resultInsert == 1){
				String updateHouseStatus = "Update House_Details set availabilityOfHouse = '"+Constants.WAITING_STATUS+"' where email_id = '"+ownerEmailId+"';";
				
				int resultUpd = dbOperations.updateData(updateHouseStatus);
				
				if(resultUpd == 1){
					statusCode = "0";
				}else{
					statusCode="1.1";
				}
				
			}else{
				statusCode = "1";
			}
		}catch(SQLException se){
			se.printStackTrace();
			statusCode ="1";
		}
		return statusCode;
	}
}
