package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import views.Services_View;
import models.Services_Model;
import classes.Services;

public class Services_Controller {

	private Services_View servicesView;
	private Services_Model servicesModel;
	private Services services;
	
	public Services_Controller(Services_View view, Services_Model model){
		this.services = new Services();
		this.servicesModel = model;
		this.servicesView = view;
		
		view.addCancelListener(new CancelListener());
		view.addCloseListener(new CloseListener());
		view.addDeleteListener(new DeleteListener());
		view.addSaveListener(new SaveListener());
		view.addSearchListener(new SearchListener());
	}
	
	public void displayServiceView(){
		this.servicesView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.servicesView.setVisible(true);
	}
	class SearchListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			servicesView.search();
		}
	}
	class SaveListener implements ActionListener{
		
		public  void actionPerformed(ActionEvent event){
			servicesView.save();
		}
	}
	class DeleteListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			servicesView.delete();
		}
	}
	class CloseListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			servicesView.close();
		}
	}
	class CancelListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			servicesView.cancel();
		}
	}
}
