/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.sql.*;
import java.util.*;

import classes.*;
/**
 *
 * @author warsame bashir
 */
public class Supplier_Model extends Register{
    
private static final long serialVersionUID = 1L;
	private Connection conn;



public Supplier_Model() throws SQLException{
    
    super();
    this.conn = this.getConnection();

        }        

/*	 
 * creates a table, if is already does not exist
 */
public void createTableCities(){
    
    System.out.println("Got here");
		String query =  "CREATE TABLE IF NOT EXISTS Supplier(id INT NOT NULL AUTO_INCREMENT,"
						+ "PRIMARY KEY(id)," +
							"name VARCHAR(100) NOT NULL," +
							"country VARCHAR(50) NOT NULL," +
							"phone VARCHAR(20) ," +
                                                        "address VARCHAR(100) NOT NULL," +
							"city VARCHAR(50) NOT NULL," +
                                                        "zipcode int NOT NULL" + 
                                                        "goods VARCHAR(100) NOT NULL);";
		if(this.executeQuery(query) == 0){
			System.out.println("Table Supplier was successful created");
		}
		else{
			System.out.println("Table already exists");
		}
	}


/**
 * 
 * @param supplier the new supplier to add to the database.
 * @return 
 */
public int insertNewSupplier(Supplier supplier){

        System.out.println(supplier.formatTostring());
        String query = "INSERT INTO Supplier(id, name, country , phone, address, city, zipcode, goods) VALUES (" + supplier.formatTostring() + ");";
        System.out.println(query);
     
        if(this.executeQuery(query) == 0){
            
                        System.out.println("Supplier added");
			return 0;
		}
		else{
            System.out.println("shit had to");
			return -1;
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

}
