package controllers;

import classes.ListTableModel;
import classes.Product;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import models.Product_Model;
import views.Product_View;

public class Product_Controller {

    

	private Product_View productView;
	private Product_Model productModel;
        private Product product;
	
	public Product_Controller(Product_Model model, Product_View view){
		this.productModel = model;
		this.productView = view;
		
		view.addSaveListener(new SaveListener());
		view.addCloseListener(new CloseListener());
                view.addSearchSingleListener(new SearchListener());
	}
	
	public void displayProductView(){
		this.productView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                this.productView.setVisible(true);
	}
	
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
                    
                    try{
                       //gets the product from the Product View
                        productView.setProduct();
                        System.out.println("Product Name " + productView.getName());
                        product = productView.getProduct();
                       
                        if(productModel.addNewProduct(product) == 0){
					JOptionPane.showMessageDialog(null, "New product was sucessfully added");
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
	
	class CloseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			productView.close();
		}
	}
        
        class SearchListener implements ActionListener {

        public SearchListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            ListTableModel model = null;
            String prodName = productView.getProductName();
            JTable tempTable = productView.getSearchTable();

            model = productModel.getProduct(prodName, model);
            tempTable.setModel(model);
            
        }
    }
}
