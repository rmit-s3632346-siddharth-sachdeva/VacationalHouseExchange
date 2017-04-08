package webservices;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import database.DBOperations;

public class LoginService {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	@POST
	public Response login(String request) throws ParseException{
		
		JSONObject requestObject = new JSONObject();
		JSONParser parser = new JSONParser();
		requestObject = (JSONObject) parser.parse(request);
		String response = null;
		String username = requestObject.get("username").toString();
		String password = requestObject.get("password").toString();
		
		String sqlQuery = "SELECT 0 FROM User WHERE username='"+username+"' AND password='"+password+"';";
		ResultSet resultSet = dbOperations.getData(sqlQuery);
		try {
			while(resultSet.next()){
			response = resultSet.getString("0");
			}
			
			if(response.equalsIgnoreCase("0")){
				statusCode = "0";
			}else{
				statusCode = "1";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			statusCode = "1";
		}
		//System.out.println("im inside:"+test);
		//return statusCode;
		return Response.ok() //200
				.entity(statusCode)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
}