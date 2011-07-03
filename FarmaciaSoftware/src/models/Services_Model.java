package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Services_Model extends Register{

	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	public Services_Model() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
		this.conn = super.getConnection();
	}
	
	public void createTableServices(){
		String query =  "CREATE TABLE IF NOT EXISTS Services (id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " +
				  		"clients_id INTEGER UNSIGNED NOT NULL, " +
				  		"employees_id INT NOT NULL, " +
				  		"date INTEGER UNSIGNED NOT NULL, " +
				  		"time INTEGER UNSIGNED NOT NULL, " +
				  		"value FLOAT NULL, " +
				  		"PRIMARY KEY(id), " +
				  		"INDEX Services_FKIndex2(employees_id), " +
				  		"INDEX Services_FKIndex3(clients_id), " +
				  		"FOREIGN KEY(employees_id) REFERENCES Employees(id) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
				  		"FOREIGN KEY(clients_id) REFERENCES Clients(id) ON DELETE NO ACTION ON UPDATE NO ACTION) TYPE=InnoDB;";
		
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
