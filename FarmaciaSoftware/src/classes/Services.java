package classes;
import java.sql.Time;

public class Services {

	private Integer id;
	private Integer employeeId;
	private Date date;
	private Time time;
	private Integer clientId;
	private Double value;
	private String description;
	
	@SuppressWarnings("deprecation")
	public Services(){
		
		this.id = 0;
		this.employeeId = 0;
		this.date = new Date();
		this.time = new Time(0, 0, 0);
		this.clientId = 0;
		this.value = 0.00;
		this.description = "";
	}
	
	public Services(Integer employeeId, Date date, Time time, Integer clientId, Double value, String description){
		
		this.setEmployeeId(employeeId);
		this.setDate(date);
		this.setTime(time);
		this.setClientId(clientId);
		this.setValue(value);
		this.setDescription(description);
	}

	public void setDescription(String description){
		this.description = description;
	}
	public void setValue(Double value) {
		// TODO Auto-generated method stub
		if(value > 0){
			this.value = value;
		}
		else{
			this.value = 0.0;
		}
	}

	public void setClientId(Integer clientId) {
		// TODO Auto-generated method stub
		if(clientId > 0){
			this.clientId = clientId;
		}
		else{
			this.clientId = 0;
		}
	}

	public void setTime(Time time) {
		// TODO Auto-generated method stub
		this.time = time;
	}

	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date = date;
	}

	public void setEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		if(employeeId > 0){
			this.employeeId = employeeId;
		}
		else{
			this.employeeId = 0;
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
	public Date getDate(){
		return this.date;
	}
	
	public Double getValue(){
		return this.value;
	}
	public Time getTime(){
		return this.time;
	}
	public Integer getClientId(){
		return this.clientId;
	}
	public Integer getId(){
		return this.id;
	}
	public Integer getEmployeeId(){
		return this.employeeId;
	}
	
	public String getDescription(){
		return this.description;
	}
}
