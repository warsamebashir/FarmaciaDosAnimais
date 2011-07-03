package models;

import java.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stock_Model extends Register{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	public Stock_Model() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
		this.conn = this.getConnection();
	}
	
	public void createStockTable(){
		
		String query = "CREATE TABLE IF NOT EXITS Stock (productId INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " +
					   "Sales_Balance_id INTEGER UNSIGNED NOT NULL, " +
					   "sales_id INTEGER UNSIGNED NOT NULL, " +
					   "purchase_id INTEGER UNSIGNED NOT NULL, " +
					   "lastChange DATE NOT NULL, " +
					   "time TIME NOT NULL, " +
					   "quantity INTEGER UNSIGNED NULL, " + 
					   "PRIMARY KEY(productId, sales_id, purchase_id), " +
					   "INDEX Stock_FKIndex1(sales_id, purchase_id), " +
					   "FOREIGN KEY(sales_id) REFERENCES Sales(id) ON DELETE NO ACTION ON UPDATE NO ACTION, " + 
					   "FOREIGN KEY(purchase_id) REFERENCES Purchases(id) ON DELETE NO ACTION ON UPDATE NO ACTION)TYPE=InnoDB;";
					   
		if(this.executeQuery(query) == 0){
			System.out.println("Table Stock was successful inserted");
		}
		
		else{
			System.out.println("Table Stock already exists");
		}
	}
	public void getProductsInStockById(Integer id){
		String query = "SELECT id, name, unity, quantity, description FROM Products WHERE id = '" + id.toString() + "';";
	}
	
	public void getProductsInStockByName(String name){
		
		String query = "SELECT id, name, unity, quantity, description FROM Products WHERE name like '" + name + "%';";
		
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
	
	public static void main(String args[]){
		try {
			Stock_Model model = new Stock_Model();
			model.getProductsInStockByName("abobora");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
