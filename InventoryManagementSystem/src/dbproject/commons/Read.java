package dbproject.commons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read{
	  // declare ResultSet, Statement/PreparedStatement object
	  private ResultSet rs = null;
	  PreparedStatement pStmt = null;
	  // private Statement stmt = null;
	  
	  public ResultSet select(Connection con, String sql){
	    try{
	      // create JDBC statements
	      pStmt = con.prepareStatement(sql);
	      // stmt = con.createStatement();
	      
	      // execute statements
	      rs = pStmt.executeQuery();
	      //rs = stmt.executeQuery(sql);
	      
	    }catch(Exception ex){
	      // TODO: handle exception
	      ex.printStackTrace();
	    }
	    
	    // returns ReusltSet object to reading
	    return rs;
	  }
	}
