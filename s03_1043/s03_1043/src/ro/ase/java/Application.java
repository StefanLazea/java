package ro.ase.java;

import ro.ase.java.models.Admin;
import ro.ase.java.models.Customer;
import ro.ase.java.models.User1;

public class Application {
	public static void main(String[] args)
	{
		Admin a1=new Admin("administrator","@dm1n", "SC RANDOM SRL"); //ctrl+space si face automat import pt clasa Admin
		System.out.println(a1.getCompanyname());
		System.out.println(a1.getPassword());
		System.out.println(a1.getUsername());
		
		Customer c1=new Customer("customer","P@ssw0rd", "Jane Doe");
		System.out.println(c1.getFullName());
		System.out.println(c1.getPassword());
		System.out.println(c1.getUsername());
		
		//DOWNCASTING EXPLICIT
		User1 u1=new Admin("administrator","@dm1n","SC ANOTHER SRL");
		User1 u4=new Customer("customer","P@ssw0rd","John Doe");
		System.out.println(((Admin)u1).getCompanyname());  //u1 devine de tip Admin si pot accesa metoda
		
		//UPCASTING EXPLICIT
		User1 u2=(User1)c1;
		System.out.println(u2.getUsername());
		
		/*
		User1 u3=new User1("user","pass");
		System.out.println(((Admin)u3).getCompanyname());
		*/
		
		//Polymorphism example
		((Admin)a1).authenticate("administrator","@dm1n");
		((Customer)u4).authenticate("customer","P@ssw0rd");
		
		
	}
	
}
//Nu exista mostenire multipla
//Interfata este o clasa ce contine doarr metode abstracte