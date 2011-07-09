package classes;

/* 
 * class written by Philippe Gabriel Souza Moraes Ribeiro
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * class Address, defines an address
 * 
 *  private String addressStreetName: defines the house number and avenue/street/highway name e.g: 125 Larpenteur Avenue West
 *  private addressZipCode: defines the address' zip code e.g: 55113
 *  private Locality locality: defines the remaining locality of an address  e.g: Dinkytown, Minneapolis, Minnesota, USA
 */
public class Address {
	/*
	 * defines the address
	 */
	private String streetAddress;
	/*
	 * defines the address' zipCode
	 */
	private String addressZipCode;
	/*
	 * defines the remaining of the address
	 */
	private Locality locality;

        private String addressCity;
        
	/*
	 * default constructor
	 */
	public Address(){
		this.streetAddress = "";
		this.addressZipCode = "";
		this.locality = new Locality();
	}

	/*
	 * overrode constructor, takes 4 arguments
	 */
	public Address(String street,  String zipCode, Locality locality){
		this.setStreetAddress(street);
		this.setAddressZipCode(zipCode);
		this.setAddressLocality(locality);
	}

	/*
	 * sets the locality
	 */
	public void setAddressLocality(Locality locality){
		this.locality = locality;
	}
	/*
	 * need a regular expression to format 
	 * the zip code as xxxxx - xxxx
	 */
	public void setAddressZipCode(String zipCode) {
		// TODO Auto-generated method stub
		this.addressZipCode = zipCode;
	}

        public void setAddressCity(String city){
        
            this.addressCity = city;
        
        }
        
	/*
	 * sets the street name
	 */
	public void setStreetAddress(String street) {
		// TODO Auto-generated method stub
		this.streetAddress = street;
	}

	/*
	 * returns the zipCode
	 */
	public String getAddressZipCode(){
		return this.addressZipCode;
	}

	/*
	 * returns the name
	 */
	public String getStreetAddress(){
		return this.streetAddress;
	}

	/*
	 * returns the locality
	 */
	public Locality getAddressLocality(){
		return this.locality;
	}
        
        public String getAddressCity(){
        
        return this.addressCity;
        
        }
        
        
	/*
	 * examples:
	 * 1855 Larpenteur Avenue West Apt 6 Saint Paul Minnesota USA - 55113
	 * 
	 */
	public String formatToString(){
		String address = '"' + this.getStreetAddress() + ", " + this.locality.formatToString() + " - " + this.getAddressZipCode() + '"';
		return address;
	}
}