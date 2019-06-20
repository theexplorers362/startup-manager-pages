/**
 * 
 * Manager class with attributes name and pin
 * Existing manager object is needed to log into manager area of software 
 *
 */
public class Manager {


	
	private String name, pin;
	
	Manager(String name, String pin)
	{
		this.name = name;
		this.pin = pin;
	}
	
	
	
	//Verifies if the entered Pin matches with the pin stored for this particular manager
	
	public boolean verifyPin(String enteredPin) 
	{
		return pin.equals(enteredPin);
	}
	
	//Getter
	
	public String getName()
	{
		return name;
	}

}
