package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Constants;
import database.DBOperations;

public class AcceptHouseRequestModel {

	private String statusCode = "1";
	private DBOperations dbOperations = new DBOperations();
	
	public String acceptHouseRequest(String ownerEmailId) throws SQLException {
		
		
		String fetchRequesterEmailIdSQLQuery = "SELECT requesterEmailId From Book_House WHERE ownerEmailId ='"+ownerEmailId+"';"; 
		
		ResultSet resultSet = dbOperations.getData(fetchRequesterEmailIdSQLQuery);
		String requesterEmailId = null;
		
		while (resultSet.next()) {
			requesterEmailId = resultSet.getString(Constants.requesterEmailId);
		}
		
		String fetchRequesterCreditsSQL = "SELECT credits FROM User WHERE email_id='"+requesterEmailId+"'";
		String fetchOwnerCreditsSQL = "SELECT credits FROM User WHERE email_id='"+ownerEmailId+"'";
		String fetchOwnerHousePointsRequiredSQL = "SELECT points_required FROM House_Details WHERE email_id='"+ownerEmailId+"'";
		String requesterCredits = null;
		String ownerCredits = null;
		String ownerHousePointsRequired = null;
		
		ResultSet fetchRequesterCreditsResultSet = dbOperations.getData(fetchRequesterCreditsSQL);
		ResultSet fetchOwnerCreditsResultSet = dbOperations.getData(fetchOwnerCreditsSQL);
		ResultSet fetchOwnerHousePointsRequiredResultSet = dbOperations.getData(fetchOwnerHousePointsRequiredSQL);
		
		while(fetchOwnerCreditsResultSet.next()){
	//if gives error create separate while loop for each resultset.
			try {
				ownerCredits = fetchOwnerCreditsResultSet.getString(Constants.credits);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		while(fetchRequesterCreditsResultSet.next()){
			requesterCredits = fetchRequesterCreditsResultSet.getString(Constants.credits);
		}
		
		while(fetchOwnerHousePointsRequiredResultSet.next()){
			ownerHousePointsRequired = fetchOwnerHousePointsRequiredResultSet.getString(Constants.pointsRequired);

		}
		
		
		String updateRequesterCreditsSQL ="UPDATE User SET credits ='"+(Integer.parseInt(requesterCredits) - Integer.parseInt(ownerHousePointsRequired)+"' WHERE email_id ='"+requesterEmailId+"'");
		String updateOwnerCreditsSQL = "UPDATE User SET credits ='"+(Integer.parseInt(ownerCredits) + Integer.parseInt(ownerHousePointsRequired)+"' WHERE email_id ='"+ownerEmailId+"'");
		String updateHouseStatus = "UPDATE House_Details SET availabilityOfHouse = 'booked' WHERE email_id ='"+ownerEmailId+"'";
		
		dbOperations.updateData(updateRequesterCreditsSQL);
		dbOperations.updateData(updateOwnerCreditsSQL);
		dbOperations.updateData(updateHouseStatus);
		
		statusCode = "0";
		return statusCode;
	}

}
