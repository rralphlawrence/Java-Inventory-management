package dbproject.commons;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete{
	  
	  // declaration
	  PreparedStatement pStmt = null;
	  // checks if there are deleted row/s
	  private int iRowDeleted = 0;
	  
	  // method delete that returns the number of rows deleted
	  // delete accepts two parameters of type
	  // Connection and String
	  public int delete(Connection conn, String sql){
	    try{
	      iRowDeleted = 0;
	      pStmt = conn.prepareStatement(sql);
	      iRowDeleted = pStmt.executeUpdate();
	      System.out.println(iRowDeleted);
	    }catch(Exception e){
	      e.printStackTrace();
	    }
	    return iRowDeleted;
	 }
}
