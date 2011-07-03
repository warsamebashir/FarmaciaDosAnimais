package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.Company;

import models.Companies_Model;

import views.Companies_View;

public class Companies_Controller {

	private Companies_View companiesView;
	private Companies_Model companiesModel;
	private Company company;
	
	public Companies_Controller(Companies_Model model, Companies_View view){
		this.companiesModel = model;
		this.companiesView = view;
		this.company = new Company();
		
		view.addCancelListener(new CancelListener());
		view.addCloseListener(new CloseListener());
		view.addSaveListener(new SaveListener());
		view.addSearchListener(new SearchListener());
		view.addDeleteListener(new DeleteListener());
	}
	class SearchListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			companiesView.search();
		}
	}
	class SaveListener implements ActionListener{
		
		public  void actionPerformed(ActionEvent event){
			companiesView.save();
		}
	}
	class DeleteListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			companiesView.delete();
		}
	}
	class CloseListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			companiesView.close();
		}
	}
	class CancelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			companiesView.cancel();
		}
	}
}
