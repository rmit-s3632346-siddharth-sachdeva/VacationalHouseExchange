package test;

import org.junit.Test;

import junit.framework.TestCase;
import model.ViewHouseModel;

public class ViewHouseTest extends TestCase{

	ViewHouseModel viewHouseDetailsModel;
	String statusCode;
	
	public void setUp(){
		viewHouseDetailsModel = new ViewHouseModel();
	}
	
	@Test
	public void testViewHouses(){
		viewHouseDetailsModel.viewHouses();
	}
	
}
