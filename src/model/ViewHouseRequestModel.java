package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Constants;
import database.DBOperations;

public class ViewHouseRequestModel {

	private DBOperations dbOperations = new DBOperations();
	public String viewHouseRequest(String ownerEmailId) throws SQLException {
		
		String sqlQuery = "SELECT requesterEmailId FROM House_... WHERE ownerEmailId='"+ownerEmailId+"'";
		ResultSet resultSet = dbOperations.getData(sqlQuery);
		String requesterEmailId = null;
		while(resultSet.next()){
			requesterEmailId = resultSet.getString(Constants.requesterEmailId);
		}
		
		return requesterEmailId;
	}
	
	

}
