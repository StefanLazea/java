package ro.ase.java.models;

public class Customer extends User1 implements UserService{
	private String fullName;
	
	public Customer(String username, String password, String fullName)
	{
		super(username,password);
		this.fullName=fullName;
	}
	
	public void setFullName(String fullname)
	{
		this.fullName=fullname;
	}
	
	public String getFullName()
	{
		return this.fullName;
	}

	@Override
	public void authenticate(String username, String password) {
		if(this.getUsername().equals(username) && this.getPassword().equals(password))
		{
			System.out.println("Customer authenticated successfully.");
		}else
			System.out.println("Invalid credentials. Please try again.");
		
	}
}
//In Java nu avem mostenire multipla
//nu se pot extinde mai multe clase din una singura