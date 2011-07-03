package models;
import java.sql.*;

import java.util.*;

import classes.Balance;
import classes.Address;
import classes.Birthday;
import classes.Client;
import classes.Locality;
import classes.Name;
import classes.PersonalIdentification;
import classes.SocialSecurity;
import classes.Telephone;

public class Balance_Model extends Register{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Connection conn;

		/*
		 * constructor for the class Client_Model
		 * creates a connection to the MySQl database
		 * throws a SQLException if connection fails
		 * 
		 */
		public Balance_Model() throws SQLException {
			super();
			// TODO Auto-generated constructor stub
			this.conn = this.getConnection();
		}
		/*
		 * creates the Table Balance
		 * where shows the current balance of the store
		 * shows all the input and output operations, 
		 * source id describes the id of the operation 
		 * ex. sales id = 100 so sourceId = 100;
		 * 
		 * @access : public
		 * @param : void
		 * @return : void
		 */
		public void createTableBalance(){
				
			//string query
			String query = "CREATE TABLE Balance IF NOT EXISTS ( " +
								  "id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT," +
								  "date DATE NULL," +
								  "time TIME NULL," +
								  "sourceId INTEGER UNSIGNED NULL," +
								  "value FLOAT NULL," +
								  "previousBalance FLOAT NULL," +
								  "currentBalance FLOAT NULL," +
								  "PRIMARY KEY(id))" +
								  "TYPE=InnoDB;";
			
			//if successful
			if(this.executeQuery(query) == 0){
				System.out.println("Table Balance was successful created");
			}
			else{
				System.out.println("Table already exists");
			}
		}
		
		public void insertNewBalance(Balance balance){
			
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
