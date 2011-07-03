package models;
import java.sql.*;

import classes.Purchases;


public class Purchase_Model extends Register{
	
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	public Purchase_Model() throws SQLException{
		
		super();
		this.conn = super.getConnection();
	}
	
	public void createPurchaseTable(){
		String query =  "CREATE TABLE IF NOT EXISTS Purchases (id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " +
					    "product_id INTEGER UNSIGNED NOT NULL, " +
					    "supplier_id INTEGER UNSIGNED NOT NULL, " +
					    "date DATE NOT NULL, " +
						"time TIME NOT NULL, " +
						"quantity INTEGER UNSIGNED NOT NULL, " +
						"value FLOAT NOT NULL, " +
						"PRIMARY KEY(id, product_id, supplier_id), " +
						"INDEX Purchases_FKIndex1(supplier_id), " +
						"INDEX Purchases_FKIndex4(product_id), " +
						"FOREIGN KEY(supplier_id) REFERENCES Supplier(id) ON DELETE NO ACTION ON UPDATE NO ACTION, " + 
						"FOREIGN KEY(Product_id) REFERENCES Product(id) ON DELETE NO ACTION ON UPDATE NO ACTION)TYPE=InnoDB;";
						
		if(this.executeQuery(query) == 0){
			System.out.println("Table Purchases was successful created");
		}
		else{
			System.out.println("Table already exists");
		}
	}
	
	public void insertNewPurchase(Purchases purchase){
		
	}
	
	public void updatePurchase(Purchases purchase){
		
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
	
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
}
