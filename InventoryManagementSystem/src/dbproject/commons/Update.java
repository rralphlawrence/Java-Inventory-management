package dbproject.commons;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Update {
	PreparedStatement pStmt = null;
	private int iRowUpdated = 0;
	
	public int update (Connection conn, String sql){
		try {
			iRowUpdated = 0;
			pStmt = conn.prepareStatement(sql);
			iRowUpdated = pStmt.executeUpdate();	
			System.out.println(iRowUpdated);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iRowUpdated;
	}
}
