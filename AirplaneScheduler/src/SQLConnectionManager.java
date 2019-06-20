

/**
 * 
 * Manages the connection to the SQL server and retrieves the data needed to generate a passenger list/report for managers
 *
 */
import java.sql.*;
import java.util.Vector;

public class SQLConnectionManager {
	
	
	//Your user information for DB connection
	String url = "jdbc:mysql://localhost:3306/booked_flights?verifyServerCertificate=false&useSSL=true";
	String user = "root";
	String password = "somePassword";
	
	Vector<Customer> customerList = new Vector<Customer>();
	
	public Vector<Customer> connectToDatabase() 
	{
	try {
			
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select Reserved.passenger_name, Reserved.destination, Reserved.departureTime, Reserved.arrivalTime,"
					+ "Reserved.bkmealplan, Reserved.lunchmealplan, Reserved.dinnermealplan, Reserved.confirmation, Reserved.luggage, ConfirmedSeats.seats "
					+ "FROM Reserved "
					+ "INNER JOIN ConfirmedSeats ON Reserved.confirmation = ConfirmedSeats.ConfirmationNum"
					+ " ORDER BY departureTime");
			
			while(result.next()) {
				
				//Data that is retrieved from DB
				String name = result.getString("passenger_name");
				String destination = result.getString("destination");
				String departureTime = result.getString("departureTime");
				String arrivalTime = result.getString("arrivalTime");
				String breakfast = result.getString("bkmealplan");
				String lunch = result.getString("lunchmealplan");
				String dinner = result.getString("dinnermealplan");
				String confirmationNumber = result.getString("confirmation");
				String luggage = result.getString("luggage");
				String seat = result.getString("seats");
				
				//Create new customer for each reservation in DB
				Customer customer = new Customer(name, confirmationNumber, breakfast, lunch, dinner, seat, departureTime, arrivalTime, destination, luggage);
				customerList.add(customer);

			}
			
			connection.close();
			
	
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	
	return customerList;
	}

}
