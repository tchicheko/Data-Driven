package Practice.Data_Driven;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Resources.base;
import pageObjects.userListTable;

public class addUser extends base {
	

	excelUtility d= new excelUtility();
	dataProvider dataSource= new dataProvider();
	SoftAssert softAssert= new SoftAssert();
	
	@BeforeTest
	public void inititialize() throws IOException {
		
		//Webdriver initialization
		driver= initializeDriver();
	
		
		driver.get(prop.getProperty("url"));
	
	}
	
	
	@Test(dataProvider="getData", dataProviderClass= dataProvider.class)
	public void addUser(String name, String surname, String username, String password,String customer,String role, String email,String cellphone ) {
		
		
		//Creating object for pageObject model  userListTable class
		userListTable userlist= new userListTable(driver);
	
		
		//Validating that user is on User List table
		softAssert.assertTrue(userlist.getTableHeader().isDisplayed());
		
		
		//Parsing data and performing actions to web elements
		userlist.getAddUserButton().click();
		
		userlist.getName().clear();
		userlist.getSurname().clear();		
		userlist.getUsername().clear();
		userlist.getPassword().clear();
		userlist.getEmail().clear();
		userlist.getCellPhone().clear();
		
		
		userlist.getName().sendKeys(name);
		userlist.getSurname().sendKeys(surname);		
		userlist.getUsername().sendKeys(username);
		userlist.getPassword().sendKeys(password);
		
		
		
		
		
		//Checking option to select for the Customer field considering data provided by the DataProvider
		if(customer.equals("Company AAA")) {
			
			userlist.getCompanyAAA().click();
		
			
		}
		else {
			
			userlist.getCompanyBBB().click();
		
			
		}
		
		//Checking option to select for the Role field considering data provided by the DataProvider
		if(role.equals("Sales Team")) {
			
			userlist.getRole().selectByValue("0");
			}
		
			else if(role.equals("Customer")){
				
				userlist.getRole().selectByValue("1");
				
			}
		
			else if(role.equals("Admin")){
				
				userlist.getRole().selectByValue("2");
			}
		
		//Parsing data and performing actions to web elements
		userlist.getEmail().sendKeys(email);
		userlist.getCellPhone().sendKeys(cellphone);
		
		WebDriverWait w= new WebDriverWait(driver, 8);
		w.until(ExpectedConditions.visibilityOf(userlist.getSubmitbutton()));
				
		//Click submit to add user
		userlist.getSubmitbutton().click();
		
		
		w.until(ExpectedConditions.invisibilityOf(userlist.getSubmitbutton()));
		
				
		//Ensuring user has been added to the list
		//softAssert.assertEquals(userlist.getTable().getText(), username);
		
		softAssert.assertAll();
		
		
		
	}
	
	//Closing the browser
	@AfterTest
	public void teardown() {
		
		driver.close();
		
		
	}
	
	
	
	
	/*
	@DataProvider
	public Object [][] getData() throws IOException{
		
		ArrayList user1data=d.getData("AddUser1");
		ArrayList user2data=d.getData("AddUser2");
		
	
		
		Object [][]users= new Object[2][8];
		users[0][0]=user1data.get(1);
		users[0][1]=user1data.get(2);
		users[0][2]=user1data.get(3);
		users[0][3]=user1data.get(4);
		users[0][4]=user1data.get(5);
		users[0][5]=user1data.get(6);
		users[0][6]=user1data.get(7);
		users[0][7]=user1data.get(8);
		
		users[1][0]=user2data.get(1);
		users[1][1]=user2data.get(2);
		users[1][2]=user2data.get(3);
		users[1][3]=user2data.get(4);
		users[1][4]=user2data.get(5);
		users[1][5]=user2data.get(6);
		users[1][6]=user2data.get(7);
		users[1][7]=user2data.get(8);
		
		return users;
		
	}*/
	


}