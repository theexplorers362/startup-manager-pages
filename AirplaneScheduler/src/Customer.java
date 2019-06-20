/**
 * 
 * Customer class that contains customer attributes relevant to a flight scheduler software and getter methods for those attributes
 *
 */

public class Customer {

	private String name, confirmationNumber, breakfast, lunch, dinner, time_departure, time_arrival, destination, seat, luggage;

	
	public Customer(String name,String confirmationNumber, String breakfast, String lunch, String dinner, String seat, 
			String time_departure, String time_arrival, String destination, String luggage)
	{
		this.name = name;
		this.confirmationNumber = confirmationNumber;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.seat = seat;
		this.time_departure = time_departure;
		this.time_arrival = time_arrival;
		this.destination = destination;
		this.luggage = luggage;
	}
	
	//Getters

	public String getName()
	{
		return name;
	}
	
	public String getConfirmationNumber()
	{
		return confirmationNumber;
	}
	
	public String getBreakfast()
	{
		return breakfast;
	}
	
	public String getLunch()
	{
		return lunch;
	}
	
	public String getDinner()
	{
		return dinner;
	}
	
	public String getDepartureTime()
	{
		return time_departure;
	}
	
	public String getArrivalTime()
	{
		return time_arrival;
	}
	
	public String getDestination()
	{
		return destination;
	}
	
	public String getSeat()
	{
		return seat;
	}
	
	public String getLuggage() {
		return luggage;
	}
	

}
