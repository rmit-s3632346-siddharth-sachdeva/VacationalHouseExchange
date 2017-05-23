package model;

import java.sql.SQLException;

import common.Constants;
import database.DBOperations;

public class RejectBookHouseRequestModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null;
	public String rejectBookingReqModel(String ownerEmailId){
		String sqlQuery = "Delete from Book_House where "+Constants.ownerEmailId+" = '"+ownerEmailId+"';";
		int rows = dbOperations.updateData(sqlQuery);
		if(rows>0){
			String updateHouseStatus = "Update House_Details set availabilityOfHouse = '"+Constants.AVAILABLE_STATUS+"' where email_id = '"+ownerEmailId+"';";
			int resultUpd = dbOperations.updateData(updateHouseStatus);
			if(resultUpd >0){
				statusCode = "0";
			}else{
				statusCode = "1.1";
			}
			
		}else{
			statusCode = "1";
		}
		return statusCode;
	}
	
}
