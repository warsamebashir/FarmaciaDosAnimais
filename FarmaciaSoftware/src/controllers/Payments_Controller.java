package controllers;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import classes.Payments;
import models.Payments_Model;
import views.Payments_View;

public class Payments_Controller{
	
	private Payments_Model paymentModel;
	private Payments_View paymentView;
	private Payments payments;
	
	public Payments_Controller(Payments_Model model, Payments_View view) throws SQLException{
		this.paymentModel = model;
		this.paymentView = view;
		this.payments = new Payments();
		
		view.addCancelListener(new CancelListener());
		view.addCloseListener(new CloseListener());
		view.addSaveListener(new SaveListener());
		view.addDeleteListener(new DeleteListener());
		view.addSearchListener(new SearchListener());
	}
	
	public void displayPlaymentsView(){
		this.paymentView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.paymentView.setVisible(true);
	}
	
	class SearchListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			paymentView.search();
		}
	}
	class DeleteListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			paymentView.delete();
		}
	}
	class SaveListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			paymentView.save();
		}
	}
	class CancelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			paymentView.cancel();
		}
	}
	
	class CloseListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			paymentView.close();
		}
	}
}
