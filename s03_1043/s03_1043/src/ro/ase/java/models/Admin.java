package ro.ase.java.models;

public class Admin extends User1 implements UserService {
	private String companyName;
	
  public Admin(String username, String password, String companyName)
  {
	  super(username, password);
	  this.companyName=companyName;
  }
  
  public void setCompanyName(String companyName)
  {
	  this.companyName=companyName;
  }
  public String getCompanyname()
  {
	  return this.companyName;
  }
  
  public void authenticate(String username, String password)
  {
	  if(this.getUsername().equals(username) && this.getPassword().equals(password))
	  {
		  System.out.println("Adinistrator authenticated with succes.");
	  } else
	  {
		  System.out.println("Invalid.");
	  }
  }
  
}
