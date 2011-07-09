package models;
import java.sql.*;

public class Register{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private DatabaseConn conn;
	private TestConn conn;
        private Connection connection;
	
	public Register() throws SQLException{
		
		this.conn = new TestConn();
		this.connection = this.conn.getConnection();
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
	
}
