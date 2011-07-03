package models;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Sellers_Model extends Register{

		private static final long serialVersionUID = 1L;
		private Connection conn;
		
		public Sellers_Model() throws SQLException {
			super();
			// TODO Auto-generated constructor stub
			this.conn = super.getConnection();
		}
		
		public void createTableSellers(){
			String query =  "CREATE TABLE IF NOT EXISTS Sellers (id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " +
							"employees_id INT NOT NULL, " +
							"payingCommission BOOL NOT NULL, " +
							"username VARCHAR(30) NOT NULL, " +
							"password VARCHAR(30) NOT NULL, " +
							"PRIMARY KEY(id), " +
							"INDEX Seller_FKIndex1(employees_id), " +
							"FOREIGN KEY(Employees_id) REFERENCES Employees(id) ON DELETE NO ACTION ON UPDATE NO ACTION) TYPE=InnoDB;";
			
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
