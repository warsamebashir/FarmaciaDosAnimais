package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import views.Stock_View;
import models.Stock_Model;

public class Stock_Controller {

	private Stock_Model stockModel;
	private Stock_View stockView;
	
	public Stock_Controller(Stock_Model model, Stock_View view){
		
		this.stockModel = model;
		this.stockView = view;
		
		view.addCancelListener(new CancelListener());
		view.addCloseListener(new CloseListener());
		view.addDeleteListener(new DeleteListener());
		view.addSaveListener(new SaveListener());
		view.addSearchListener(new SearchListener());
	}
	
	public void displayStockView(){
		this.stockView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.stockView.setVisible(true);
	}
	
	
	
	class SearchListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			stockView.search();
		}
	}
	class SaveListener implements ActionListener{
		
		public  void actionPerformed(ActionEvent event){
			stockView.save();
		}
	}
	class DeleteListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			stockView.delete();
		}
	}
	class CloseListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			stockView.close();
		}
	}
	class CancelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			stockView.cancel();
		}
	}
}
