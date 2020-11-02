package dbproject.commons;

import javax.swing.JOptionPane;
import java.sql.*;

public class DbConnection {
	private Connection conn = null;
	
	// Return Connection type object
	public Connection connect(){
		try{
			// Load the vendor specific driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Make the connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","user1","12345");
			
			// Show successful connection
			//JOptionPane.showMessageDialog(null,"Successful connected");
			
			// Return the object with successful connections to the database
			return conn;
		}catch(Exception ex){
			// Shows exception or unsuccessful connection
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
		return null; // return null for unsuccessful connection
	}
}
