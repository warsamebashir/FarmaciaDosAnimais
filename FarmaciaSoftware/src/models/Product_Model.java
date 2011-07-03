
package models;
import java.sql.*;

import classes.*;
/*
 * this class has been tested by Philippe Ribeiro
 * 
 * ----- Missing testings for Updade --------
 */
public class Product_Model extends Register{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Connection conn;
		
		public Product_Model() throws SQLException{
			super();
			this.conn = this.getConnection();
		}
		
		/*
		 * creates the Product Table, if it has not been created
		 * otherwise just skips it
		 * 
		 * works nicely, successful tested;
		 */
		public int createTableProducts() throws SQLException{
			/*
			 * the other is: 
			 * ALWAYS ASSIGN THE ENGINE TO INNODB(MAKES POSSIBLE TO USE FOREIGN KEY)
			 * 
			 */
			String query =  "CREATE TABLE IF NOT EXISTS Products(" +
							"id INT NOT NULL AUTO_INCREMENT, " +
							"PRIMARY KEY(id)," +
							"name VARCHAR(100) NOT NULL," +
							"unity VARCHAR(5) NOT NULL," +
							"pricecash FLOAT NOT NULL," +
							"priceterm FLOAT NOT NULL," +
							"pricefinal FLOAT NOT NULL," +
							"description VARCHAR(100) NOT NULL)ENGINE=INNODB;";
				
				try{
						Statement st = this.conn.createStatement();
						st.execute(query);
						System.out.println("Table Products created with success!");
                                                return 0;
					}
				catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Table already exists");
						e.printStackTrace();
                                                return 0;
					}
		}
		/*
		 * MySQL query to add a new employee into the database
		 * works nicely
		 * successful tested
		 */
		public int addNewProduct(Product product){
			
			try{
				
	String query =  "INSERT INTO Products(id, name, unity, pricecash, priceterm, pricefinal, description) VALUES ("	+ product.formatToString() + ");";
                            if(this.executeQuery(query) == 0){
                                System.out.println(query);
				System.out.println("Sucessful added");
                                    return 0;
                                }
                                    else{
                                System.out.println("Not added");
                                            return -1;
                                            }
                               					
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Failed to add a new product");
				return -1;
				
			}

		}
		
		public void updateProductInformation(Employee employee){
			
			try{
				Statement st = this.conn.createStatement();
				String query = "UPDATE Employees SET col_string='a new string' WHERE col_string = 'a string'";
			    int updateCount = st.executeUpdate(query);
			    System.out.println(updateCount);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		/*
		 * works nicely ... 
		 * successful tested
		 */
		public void deleteEmployee(Integer productId){
			
			try{
				Statement st = this.conn.createStatement();
				String query = "DELETE FROM Product WHERE id=" + productId.toString() + ";";
				st.execute(query);
				System.out.println("Successful deleted");
			}
			catch(SQLException e){
				System.out.println("Failed to delete the employee");
				e.printStackTrace();
			}
			
		}
                
                
               public ListTableModel getProduct(String productName, ListTableModel model){
		String query = "SELECT * FROM Products WHERE name='" + productName + "';";
		System.out.println("Gets here");
		Statement stmt;
		
		try {
			stmt = this.conn.createStatement();
			stmt.executeQuery (query);
			ResultSet rs = stmt.getResultSet();
                       // writeResultSet(rs);
                        String desc = rs.getString("description");
			model = ListTableModel.createModelFromResultSet(rs);  
			rs.close ();
			stmt.close ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return model;
	} 
         
               private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String unity = resultSet.getString("unity");
			double priceInCash = resultSet.getFloat("pricecash");
			double priceInTerm = resultSet.getFloat("priceterm");
			double priceFinal = resultSet.getFloat("pricefinal");
                        String description = resultSet.getString("description");
                        System.out.println("User: " + id);
			System.out.println("Website: " + unity);
			System.out.println("price cash : " + priceInCash);
			System.out.println("price term : " + priceInTerm);
			System.out.println("price final: " + priceFinal);
                        System.out.println("description " + description);
                }
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
		/*
		 * closes the MySQL connection
		 */
		public void closeConnection() throws SQLException{
			this.conn.close();
		}

}
