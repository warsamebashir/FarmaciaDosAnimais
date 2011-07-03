package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Companies_Model extends Register{

	private Connection conn;
	
	public Companies_Model() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
		this.conn = super.getConnection();
	}
	
	public void createTableCompanies(){
		String query =  "CREATE TABLE Companies (id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " +
						"name VARCHAR(100) NOT NULL, " +
						"address VARCHAR(100) NOT NULL, " +
						"telephone VARCHAR(30) NOT NULL, " +
						"stateId VARCHAR(30) NOT NULL, " +
						"federald VARCHAR(30) NOT NULL, " +
						"PRIMARY KEY(id))TYPE=InnoDB;";
		
		if(this.executeQuery(query) == 0){
			System.out.println("Table Services was successful inserted");
		}
		
		else{
			System.out.println("Table Services already exists");
		}
	}
	
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
	/*
	 * executes the query, given the string
	 */
	public int executeQuery(String query){
		int status = 0;
		
		Statement stmt;
		try {
			stmt = this.conn.createStatement();
				stmt.execute(query);
				status = 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
