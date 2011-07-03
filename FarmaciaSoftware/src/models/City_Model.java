package models;
import classes.Locality;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 * Class City_Model, deals with the 'Cities' table;
 * class written by Philippe Ribeiro, 
 * University of Minnesota, Minneapolis, Minnesota, USA - 55113
 * 
 * the only field variable of the class is Connection Conn
 * June 9th, 2010
 * 
 */
public class City_Model extends Register{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	public static String[] columns = {"Region", "City", "State", "Country"};
	private final int length = 10;
	private Object[][] elements;
	
	public City_Model() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
		this.conn = this.getConnection();
		this.elements = null;
	}
	/*
	 * creates a table, if is already does not exist
	 */
	public void createTableCities(){
		String query =  "CREATE TABLE IF NOT EXISTS Cities(id INT NOT NULL AUTO_INCREMENT,"
						+ "PRIMARY KEY(id)," +
							"region VARCHAR(100) NOT NULL," +
							"city VARCHAR(100) NOT NULL," +
							"state VARCHAR(10) NOT NULL," +
							"country VARCHAR(30) NOT NULL);";
		if(this.executeQuery(query) == 0){
			System.out.println("Table cities was successful created");
		}
		else{
			System.out.println("Table already exists");
		}
	}
	/*
	 * inserts a new city into the database
	 */
	public int insertNewCity(Locality locality){
		
		System.out.println(locality.formatToString());
		String query = "INSERT INTO Cities(region, city, state, country) VALUES (" + locality.formatToString() + ");";
		System.out.println(query);
		if(this.executeQuery(query) == 0){
			return 0;
		}
		else{
			return -1;
		}
	}
	/*
	 * updates the values of a given locality
	 * needs some testing and refinements
	 */
	public void updateCity(Locality locality){
		
		String query = "UPDATE Cities SET region, city, state, country = " + locality.formatToString();
		if(this.executeQuery(query) == 0){
			System.out.println("Updates were sucessfully performed");
		}
		else{
			System.out.println("The update was unsucessful");
		}
	}
	/*
	 * gets all the Cities
	 * and returns it as an
	 * ArrayList<Locality>
	 * 
	 */
	public JTable getAllCities(){
		String query = "SELECT * FROM Cities;";
		
		String[] columns = { "Region", "City", "State", "Country" };
		
		JTable table = null;
		Statement stmt;
		
		try {
			stmt = this.conn.createStatement();
			stmt.executeQuery (query);
			ResultSet rs = stmt.getResultSet ();
			
			elements = new Object[10][4];
			
			//store row data
			//the number of iterations must be equal to rowSize
			//in order for this to work
			int index = 0;
			while(rs.next()) {
				
				if (index+1 % length == 0) {
					resize();
				}
				
				elements[index][0] = rs.getString("region");
				elements[index][1] = rs.getString("city");
				elements[index][2] = rs.getString("state");
				elements[index][3] = rs.getString("country");
				
				//System.out.println(rs.getString("region") + " " + rs.getString("city") + " " + rs.getString("state") + " " + rs.getString("country"));
				
				index++;
				
				
			}
			
			table = new JTable(elements, columns);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		return table;
	}

	// Creates a new array with a length double the size of the previous array
	// Copies all information in the array to new array
	public void resize(){
		Object[][] temp = elements;
		
		int size = elements.length;
		
		elements = new Object[size*2][4];
		
		int i = 0;
		while (i < temp.length) {
			for (int j = 0; j < 4; j++) {
				elements[i][j] = temp[i][j];
			}
		}
	}
	
	/*
	 * Queries into the database given a city, returns
	 * all the values associates with that city
	 * and stores the result into a ArrayList
	 * 
	 *  returns an ArrayList
	 */
	public JTable getCity(String city){
		String query = "SELECT * FROM Cities WHERE city='" + city + "';";
		
		String[] columns = { "Region", "City", "State", "Country" };
		
		JTable table = null;
		Statement stmt;
		
		try {
			stmt = this.conn.createStatement();
			stmt.executeQuery (query);
			ResultSet rs = stmt.getResultSet ();
			
			elements = new Object[10][4];
			//store row data
			//the number of iterations must be equal to rowSize
			//in order for this to work
			int index = 0;
			while(rs.next()) {
				
				if (index+1 % length == 0) {
					resize();
				}
				
				elements[index][0] = rs.getString("region");
				elements[index][1] = rs.getString("city");
				elements[index][2] = rs.getString("state");
				elements[index][3] = rs.getString("country");
				
				index++;
				
				
			}
			
			table = new JTable(elements, columns);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return table;
		
	}
	/*
	 * deletes a given city
	 */
	public int deleteCity(String city){
		String query = "DELETE FROM Cities WHERE city='" + city + "';";
		
		if(this.executeQuery(query) == 0){
			return 0;
		}
		else{
			return 1;
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
	
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
}
