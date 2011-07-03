package models;
import java.sql.*;
import java.util.*;

import classes.*;
import classes.Date;

/*
 * class not completed yet
 */
public class Sale_Model extends Register{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	public Sale_Model() throws SQLException{
		super();
		this.conn = super.getConnection();
	}
	/*
	 * function createSalesTable, creates the sale table
	 * @param: void
	 * @return: void
	 * 
	 * saves the SQL query into a string
	 * then executes that string
	 * 
	 */
	public void createSalesTable(){
		//creates the SQL query
		String query = "CREATE TABLE IF NOT EXISTS Sales ( id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " +
					   "clients_id INTEGER UNSIGNED NOT NULL, " +
					   "seller_id INTEGER UNSIGNED NOT NULL, " +
					   "product_id INTEGER UNSIGNED NOT NULL, " +
					   "time TIME NULL, " +
					   "date DATE NULL, " +
					   "quantity INTEGER UNSIGNED NULL, " +
					   "unityPrice FLOAT NULL, " +
					   "typeSale INTEGER UNSIGNED NULL, " +
					   "totalSale FLOAT NULL, " +
					   "PRIMARY KEY(id) " +
					   "INDEX Sales_FKIndex1(product_id), " +
					   "INDEX Sales_FKIndex2(seller_id), " +
					   "INDEX Sales_FKIndex3(clients_id), " +
					   "FOREIGN KEY(Product_id) REFERENCES Product(id) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
					   "FOREIGN KEY(Seller_id) REFERENCES Seller(id) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
					   "FOREIGN KEY(Clients_id) REFERENCES Clients(id) ON DELETE NO ACTION ON UPDATE NO ACTION) TYPE=InnoDB;";
		
		//checks if it went all right
		if(this.executeQuery(query) == 0){
			System.out.println("Table Sales was successful created");
		}
		else{
			System.out.println("Table already exists");
		}
	}
	
	public void insertNewSale(Sale sale){
		
		String  query = "INSERT INTO TABLE Sales(productId, productName, productQuantity, " +
						"productUnity, unitySalePrice, totalPurchase, clientId, customerName, saleDate) VALUES("
					+	sale.getSaleId().toString() + ", " + sale.getProduct().getProductName() + ", " + sale.getQuantity().toString() + ", " 
					+	sale.getProduct().getProductUnity() + ", " + sale.getProduct().getProductFinalPrice() + ", " + sale.getTotalSale().toString() + ", " 
					+   sale.getClient().getClientId().toString() + ", " + sale.getClient().getPersonName().formatToString() + ", " + sale.getSaleDate().formatToString() + ");";
		
		if(this.executeQuery(query) == 0){
			System.out.println("Product was successful inserted");
		}
		else{
			System.out.println("Table already exists");
		}
	}
	
	public ArrayList<Sale> getAllSales(Date date){
		ArrayList<Sale> sales = new ArrayList<Sale>();
		String query = "SELECT * FROM Sales WHERE date=" + date.formatToString() + ";";
		sales = this.getList(query);
		
		return sales;
	}
	
	public Sale getSaleById(Integer id){
		String query = "SELECT * FROM Sales WHERE id=" + id.toString() + ";";
		
		Sale sale = new Sale();
		return sale;
	}
	
	private int executeQuery(String query){
		int status = 0;
		
		Statement stmt;
		try {
			stmt = this.conn.createStatement();
				stmt.execute(query);
				System.out.println("Query executed Successfully");
				status = 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	private ArrayList<Sale> getList(String query){

		ArrayList<Sale> list = new ArrayList<Sale>();
		Statement stmt;
		try {
				stmt = this.conn.createStatement();
				stmt.execute(query);
				ResultSet rs = stmt.getResultSet ();

				while (rs.next ()){
					Sale sale = new Sale();
					list.add(sale);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String args[]){
		Product p = new Product(1, "Ivomec 50ml", "UN", 12.50, 14.00, 13.00, "matar carrapato");
	
		try {
			Sale_Model model = new Sale_Model();
			model.createSalesTable();
			
			System.exit(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
