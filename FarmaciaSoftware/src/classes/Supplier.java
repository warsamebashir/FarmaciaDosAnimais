package classes;

public class Supplier {

	private String name;
	private Telephone telephone;
	private Company company;
	private Integer supplierId;
	private Address address;
        private String country;
        private String goods;
	
	public Supplier(){
		this.name = "";
		this.telephone = new Telephone();
		this.company = new Company();
		this.address = new Address();
		this.supplierId = 0;
                this.country = "";
	}
	
	public Supplier(String name, String country, String telephone,  String address, String city, String Zipcode, String goods){
		this.setSupplierName(name);
		this.telephone.setTelephoneUSAFormat(telephone);
                this.setSupplierCountry(country);
		//this.setSupplierId(id);
		this.address.setStreetAddress(address);
                this.address.setAddressZipCode(Zipcode);
                this.address.setAddressCity(city);
	}

	public void setSupplierAddress(Address address) {
		// TODO Auto-generated method stub
		this.address = address;
	}

	public void setSupplierId(Integer id) {
		// TODO Auto-generated method stub
		if(id > 0){
			this.supplierId = id;
		}
		else{
			this.supplierId = 0;
		}
	}
        
        
        public void setSupplierGoods(String goods){
        
            this.goods = goods;        
        }
        
	public void setSupplierTelephone(Telephone telephone) {
		// TODO Auto-generated method stub
		this.telephone = telephone;
	}

	public void setSupplierCompany(Company company) {
		// TODO Auto-generated method stub
		this.company = company;
	}
        
        public void setSupplierCountry(String country){
            this.country = country;
        
        }

	public void setSupplierName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
        public String getSupplierGoods(){
        
            return this.goods;
        }
        
	public String getSupplierName(){
		return this.name;
	}
        
        public String getSupplierCountry(){
            return this.country;
        
        }
	
	public Telephone getSupplierTelephone(){
		return this.telephone;
	}
	
	public Company getSupplierCompany(){
		return this.company;
	}
	
        public String getSupplierCity(){
        
        return this.address.getAddressCity();
        }
        
        public String getZipCode(){
        
            return this.address.getAddressZipCode();   
        }
	
        public Address getSupplierAddress(){
		return this.address;
	}
	
	public int getSupplierId(){
		return this.supplierId;
	}
        
        public String formatTostring(){
        
            System.out.println("gets ");
               String supplier;
               supplier = "'" + this.getSupplierId()  + "'," + "'" + this.getSupplierName()  + "', '" + this.getSupplierCountry() + "', '" + this.getSupplierTelephone()
                          + "', '" + this.getSupplierAddress().getStreetAddress() + "', '" + this.getSupplierCity() + "', '" + this.getZipCode() + "', '" + this.getSupplierGoods() + "'"; 
                          
        return supplier;
        }
    }
