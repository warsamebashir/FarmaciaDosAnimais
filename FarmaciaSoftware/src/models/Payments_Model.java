
package models;
import java.sql.*;


public class Payments_Model extends Register{
	
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	public Payments_Model() throws SQLException{
		super();
		this.conn = super.getConnection();
	}
	
	public void createPaymentsTable(){
		String query =  "CREATE TABLE IF NOT EXISTS Payments (id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " +
						"type INTEGER UNSIGNED NOT NULL, " +
						"date DATE NOT NULL, " +
						"time TIME NOT NULL, " +
						"value FLOAT NOT NULL, " +
						"PRIMARY KEY(id)) TYPE=InnoDB;";
		
		if(this.executeQuery(query) == 0){
			System.out.println("Table Payments was successful inserted");
		}
		
		else{
			System.out.println("Table Payments already exists");
		}
	}
	
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
	
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
}


