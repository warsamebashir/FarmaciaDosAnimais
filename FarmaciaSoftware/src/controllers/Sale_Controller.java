package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import views.Sales_View;
import models.Sale_Model;
import classes.Sale;

public class Sale_Controller {

	private Sale_Model saleModel;
	private Sales_View saleView;
	private Sale sale;
	
	/*
	 * constructor of Sale_Controller
	 * takes two arguments: a Sale_Model and a Sales_View
	 * throws a SQLException in case of failure
	 */
	public Sale_Controller(Sale_Model model, Sales_View view) throws SQLException{
		
		this.saleModel = model;
		this.saleView = view;
		
		view.addSaveListener(new SaveListener());
		view.addCancelListener(new CancelListener());
		view.addCloseListener(new CloseListener());
		view.addDeleteListener(new DeleteListener());
		view.addSearchListener(new SearchListener());
		
	}
	/*
	 * makes the view to show in the main menu
	 */
	public void displaySaleView(){
		this.saleView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.saleView.setVisible(true);
	}
	/*
	 * registers a new event into the database
	 * storing the user's input into the db.
	 * 
	 */
	class SaveListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			saleView.save();
		}
	}
	/*
	 * implements the close operation for a 
	 * button in the page
	 */
	class CloseListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			saleView.close();
		}
	}
	/*
	 * erases all the fields in the tables,
	 * making a clear form
	 * 
	 */
	class CancelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			saleView.cancel();
		}
	}
	
	/*
	 * deletes a sale previously stores into the database
	 */
	class DeleteListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			saleView.delete();
		}
	}
	
	/*
	 * searchs a single item from the database
	 * and displays the result into the table
	 * 
	 */
	class SearchListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			saleView.search();
		}
	}
}
