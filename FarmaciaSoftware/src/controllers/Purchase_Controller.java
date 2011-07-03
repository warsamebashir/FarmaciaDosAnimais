package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import classes.Purchases;

import views.Purchase_View;
import models.Purchase_Model;

public class Purchase_Controller{
	
	private Purchase_View purchaseView;
	private Purchase_Model purchaseModel;
	private Purchases purchases;
	
	public Purchase_Controller(Purchase_View view, Purchase_Model model){
		this.purchaseModel = model;
		this.purchaseView = view;
		this.purchases = new Purchases();
		
		view.addCancelListener(new CancelListener());
		view.addCloseListener(new CloseListener());
		view.addSaveListener(new SaveListener());
		view.addDeleteListener(new DeleteListener());
		view.addSearchListener(new SearchListener());
	}
	
	public void displayPurchaseView(){
		this.purchaseView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.purchaseView.setVisible(true);
	}
	
	class DeleteListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			purchaseView.delete();
		}
	}
	class SearchListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			purchaseView.search();
		}
	}
	class SaveListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			purchaseView.save();
		}
	}
	
	class CloseListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			purchaseView.close();
		}
	}
	
	class CancelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			purchaseView.cancel();
		}
	}
	
}
