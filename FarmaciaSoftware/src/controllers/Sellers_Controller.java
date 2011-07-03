package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.Seller;

import views.Sellers_View;

import models.Sellers_Model;

public class Sellers_Controller {

	private Sellers_Model sellersModel;
	private Sellers_View sellersView;
	private Seller seller;
	
	public Sellers_Controller(Sellers_Model model, Sellers_View view){
		this.sellersModel = model;
		this.sellersView = view;
		this.seller = new Seller();
		
		view.addCancelListener(new CancelListener());
		view.addCloseListener(new CloseListener());
		view.addDeleteListener(new DeleteListener());
		view.addSaveListener(new SaveListener());
		view.addSearchListener(new SearchListener());
	}
	class SearchListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			sellersView.search();
			}
	}
	class SaveListener implements ActionListener{
		
		public  void actionPerformed(ActionEvent event){
			sellersView.save();
		}
	}
	class DeleteListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			sellersView.delete();
		}
	}
	class CloseListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			sellersView.close();
		}
	}
	class CancelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			sellersView.cancel();
		}
	}
}
