/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Supplier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import views.Supplier_View;
import models.Supplier_Model;
/**
 *
 * @author warz07
 */
public class Supplier_Controller {

     
    
	private Supplier_View supplierView;
	private Supplier_Model supplierModel;
        private Supplier supplier = new Supplier();
 
        public Supplier_Controller(Supplier_Model model, Supplier_View view){
  
  
        supplierView = view;
        supplierModel = model;
        view.addSaveListener(new SaveListener());
        view.addCloseListener(new CloseListener());
    }  
  
       public void displayProductView(){
		this.supplierView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                this.supplierView.setVisible(true);
	} 
        
        
  /**
   * 
   */
    class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
                                    


        try{
                                   
                        supplierView.setSupplier();
                        System.out.println(supplier.formatTostring());  
                       //gets the product from the Product View
                        supplierView.setSupplier();
                      
                        supplier = supplierView.getSupplier();
                       
                        if(supplierModel.insertNewSupplier(supplier) == 0){
					JOptionPane.showMessageDialog(null, "New supplier was sucessfully added");
				}
				else{
					JOptionPane.showMessageDialog(null, "An error happened");
				}
                    
                    
                    }
       catch(Exception evt){
                    
                   System.out.println("Error: Something went wrong");
                    
                    }
        
        
        
        
        
        
        }

    
    }
    
    class CloseListener implements ActionListener {

        public CloseListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
              supplierView.close();
        }
    }
    
    
}
