package classes;
import java.sql.Time;

public class Purchases{
	
	private Integer id;
	private Integer productId;
	private Integer supplierId;
	private Date date;
	private Time time;
	private Integer quantity;
	private Double unityPrice;
	
	@SuppressWarnings("deprecation")
	public Purchases(){
		
		this.id = 0;
		this.productId = 0;
		this.supplierId = 0;
		this.date = new Date();
		this.time = new Time(0, 0, 0);
		this.quantity = 0;
		this.unityPrice = 0.00;
	}
	
	public Purchases(Integer productId, Integer supplierId, Date date, Time time, Integer quantity, Double unityPrice){
		
		this.setProductId(productId);
		this.setSupplierId(supplierId);
		this.setDate(date);
		this.setTime(time);
		this.setQuantity(quantity);
		this.setUnityPrice(unityPrice);
	}
	
	public void setUnityPrice(Double unityPrice){
		
		if(unityPrice > 0.00){
			this.unityPrice = unityPrice;
		}
		else{
			this.unityPrice = 0.00;
		}
	}
	public void setQuantity(Integer quantity){
		if(quantity > 0){
			this.quantity = quantity;
		}
		
		else{
			this.quantity = 0;
		}
	}
	public void setTime(Time time){
		this.time = time;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public void setSupplierId(Integer id){
		if(id > 0){
			this.supplierId = id;
		}
		else{
			this.supplierId = 0;
		}
	}
	
	public void setProductId(Integer id){
		
		if(id > 0){
			this.productId = id;
		}
		
		else{
			this.productId = 0;
		}
	}
	
	public void setId(Integer id){
		
		if(id > 0){
			this.id = id;
		}
		else{
			this.id = 0;
		}
	}
	
	public Double getUnityPrice(){
		return this.unityPrice;
	}
	
	public Time getTime(){
		return this.time;
	}
	
	public Integer getQuantity(){
		return this.quantity;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public Integer getSupplierId(){
		return this.supplierId;
	}
	
	public Integer getProductId(){
		return this.productId;
	}
	
	public Double getPurchaseValue(){
		return this.unityPrice * this.quantity;
	}
	
	public Integer getId(){
		return this.id;
	}
}
