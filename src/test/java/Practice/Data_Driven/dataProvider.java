package Practice.Data_Driven;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class dataProvider {
	
	excelUtility d= new excelUtility();

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
		
	}
	
}
