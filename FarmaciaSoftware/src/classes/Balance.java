package classes;
/*
 * class Balance, defines the current balance of the store
 * this class is used as a helper to the database
 * 
 * date : Date, defines the date of the operation
 * time : Time, defines the time of the operation
 * sourceId : Integer, maps the operation to its source (i.e sales = 1)
 * value : Double, defines the amount of the operation
 * 
 * class written in June 26th, 2011 by Philippe Ribeiro,
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * 
 */
import java.sql.Time;

public class Balance{
	
		private Date date;
		private Time time;
		private Integer sourceId;
		private Integer operationId;
		private Double value;
		
		/*
		 * default constructor
		 * only initilizes the field variables with the default value
		 */
		@SuppressWarnings("deprecation")
		public Balance(){
		
				this.date = new Date();
				this.time = new Time(0, 0, 0);
				this.sourceId = 0;
				this.value = 0.00;
				this.operationId = 0;
		}
		/*
		 * overriden constructor, takes 4 arguments
		 */
		public Balance(Date d, Time t, Integer s, Double v, Integer opId){
			
			this.setDate(d);
			this.setTime(t);
			this.setSourceId(s, opId);
			this.setValue(v);
		}
		/*
		 * sets the value, does not need to be
		 * positive, because a payment is considered negative 
		 * to the balance
		 * 
		 * @access : public
		 * @param : Double
		 * @return : void
		 */
		public void setValue(Double v){
			this.value = v;
		}
		/*
		 * sets the date of the transaction
		 * 
		 * @access : public
		 * @param : Date
		 * @return : void
		 */
		public void setDate(Date d){
			this.date = d;
		}
		
		/*
		 * sets the time of the operation
		 *
		 * @access : public
		 * @param : Time
		 * @return : void
		 * 
		 */
		public void setTime(Time t){
			this.time = t;
		}
		
		/*
		 * sets the source id
		 * maps the operation with its value
		 * and then sets the operation id
		 * which will be helpful 
		 * if something went wrong, assigns it to 0
		 * 
		 * @access : public
		 * @param : Integer, Integer
		 * @return void
		 */
		public void setSourceId(Integer source, Integer opId){
			/*
			 * 1 : sales
			 * 2 : services
			 * 3 : payments
			 * 4 : purchases
			 * 
			 */
			switch(source){
				//this operation is a valid operation
				case 1:
				case 2:
				case 3:
				case 4:
					this.sourceId = source;
					this.operationId = opId;
					
				default:
					this.sourceId = 0;
					this.operationId = 0;
			}
		}
		
		/*
		 * return the operationId
		 * @access : public
		 * @param : void;
		 * @return : Integer
		 */
		public Integer getOperationId(){
			return this.operationId;
		}
		/*
		 * returns the sourceId
		 * @access : public
		 * @param : void
		 * @return : Integer
		 */
		public Integer getSourceId(){
			return this.sourceId;
		}
		
		public Date getDate(){
			return this.date;
		}
		/*
		 * returns the time of the operation
		 * @access : public
		 * @param : void
		 * @return : Time
		 */
		public Time getTime(){
			return this.time;
		}
		/*
		 * retursn the value of the operation
		 * @access : public
		 * @param : void
		 * @return : Double
		 */
		public Double getValue(){
			return this.value;
		}
		
		/*
		 * gets the current balance, just after the last operation
		 * @access : public
		 * @param : Double
		 * @return : Double
		 */
		public Double getCurrentBalance(Double previousBalance){
				return this.value + previousBalance;
		}
}
