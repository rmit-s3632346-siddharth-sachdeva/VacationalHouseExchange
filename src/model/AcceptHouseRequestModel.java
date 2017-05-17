package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Constants;
import database.DBOperations;

public class AcceptHouseRequestModel {

	private String statusCode = "1";
	private DBOperations dbOperations = new DBOperations();
	
	public String acceptHouseRequest(String requesterEmailId, String ownerEmailID) throws SQLException {
		
		String fetchRequesterCreditsSQL = "SELECT credits FROM User WHERE email_id='"+requesterEmailId+"'";
		String fetchOwnerCreditsSQL = "SELECT credits FROM User WHERE email_id='"+ownerEmailID+"'";
		String fetchOwnerHousePointsRequiredSQL = "SELECT points_required FROM User WHERE email_id='"+ownerEmailID+"'";
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
				requesterCredits = fetchRequesterCreditsResultSet.getString(Constants.credits);
				ownerHousePointsRequired = fetchOwnerHousePointsRequiredResultSet.getString(Constants.pointsRequired);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		
		String updateRequesterCreditsSQL ="UPDATE User SET credits ='"+(Integer.parseInt(requesterCredits) - Integer.parseInt(ownerHousePointsRequired)+"' WHERE email_id ='"+requesterEmailId+"'");
		String updateOwnerCreditsSQL = "UPDATE User SET credits ='"+(Integer.parseInt(ownerCredits) + Integer.parseInt(ownerHousePointsRequired)+"' WHERE email_id ='"+ownerEmailID+"'");
		String updateHouseStatus = "UPDATE House_Details SET status = 'booked' WHERE email_id ='"+ownerEmailID+"'";
		
		dbOperations.updateData(updateRequesterCreditsSQL);
		dbOperations.updateData(updateOwnerCreditsSQL);
		dbOperations.updateData(updateHouseStatus);
		
		
		return statusCode;
	}

}
