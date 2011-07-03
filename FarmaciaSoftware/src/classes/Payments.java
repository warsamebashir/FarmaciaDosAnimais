package classes;
import java.sql.Time;

public class Payments{
	
	private Integer id;
	private Integer type;
	private Date date;
	private Time time;
	private Double value;
	private String description;
	
	@SuppressWarnings("deprecation")
	public Payments(){
		this.id = 0;
		this.type = 0;
		this.date = new Date();
		this.time = new Time(0, 0, 0);
		this.value = 0.00;
		this.description = "";
	}
	
	public Payments(Integer type, Date date, Time time, Double value, String description){
		
		this.setType(type);
		this.setDate(date);
		this.setTime(time);
		this.setValue(value);
		this.setDescription(description);
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setValue(Double v){
		
		if(v > 0.00){
			this.value = v;
		}
		else{
			this.value = 0.00;
		}
	}
	public void setTime(Time time){
		this.time = time;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public void setType(Integer type){
		
		switch(type){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				this.type = type;
				
			default:
				this.type = 0;
		}
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public Double getValue(){
		return this.value;
	}
	
	public Time getTime(){
		return this.time;
	}
	public Date getDate(){
		return this.date;
	}
	
	public void setId(Integer id){
		if(id > 0){
			this.id = id;
		}
		else{
			this.id = 0;
		}
	}
	public Integer getType(){
		return this.type;
	}
	
	public Integer getId(){
		return this.id;
	}
}
