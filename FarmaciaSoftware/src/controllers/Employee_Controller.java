package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import classes.Employee;
import models.Employee_Model;
import views.Employee_View;

public class Employee_Controller {
	
	private Employee_View employeeView;
	private Employee_Model employeeModel;
	private Employee employee;
	
	public Employee_Controller(Employee_View view, Employee_Model model) throws SQLException{
		this.employee = new Employee();
		this.employeeModel = model;
		this.employeeView = view;
		
		view.addCancelListener(new CancelListener());
		view.addCloseListener(new CloseListener());
		view.addSaveListener(new SaveListener());
	}
	
	public void displayEmployeeView(){
		this.employeeView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.employeeView.setVisible(true);
	}
	
	//inner class SaveListener
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				//gets the locality from the employeeView
				employeeView.add();
				employee = employeeView.getEmployee();
				//if it was successfully inserted into the db, the show a 
				//successful message
				if(employeeModel.insertNewEmployee(employee) == 0){
					JOptionPane.showMessageDialog(null, "New employee was sucessfully added");
				}
				else{
					JOptionPane.showMessageDialog(null, "An error happened");
				}
			}
			catch(Exception ex){
				System.out.println("An error happened");
			}
		}
		
	}
	class CloseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			employeeView.close();
		}
	}

	/*
	 * inner class ClearListener, performs a clear operation in the JTextFields
	 * or any other component of the JFrame
	 */
	class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			employeeView.reset();
		}
	}// end of the
}
