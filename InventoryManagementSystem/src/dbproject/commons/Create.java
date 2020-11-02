package dbproject.commons;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Create{
	  
	  // declaration
	  PreparedStatement pStmt = null;
	  // checks if there are inserted row/s
	  private int iRowInserted = 0;
	  
	  // method insert that returns the number of rows
	  // inserted accepts two parameters of type
	  // Connection and String
	  public int insert(Connection conn, String sql){
	    try{
	      iRowInserted = 0;
	      pStmt = conn.prepareStatement(sql);
	      iRowInserted = pStmt.executeUpdate();
	      System.out.println(iRowInserted);
	    }catch(Exception e){
	      e.printStackTrace();
	    }
	    return iRowInserted;
	  }
	}
