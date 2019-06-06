package eu.ase.test;

/*
 * Grade 4: Create the class PremiumSubscriber which extends Subscriber implements Cloneable and Comparable<Subscriber> interfaces.
 * 
 * Besides the fields and methods inherited from the abstract class Subscriber, the class PremiumSubscriber has the following private fields:
 * premiumShortNo : String for the premium short number associated with the subscriber
 * serialVersionUID : static long
 * 
 * Create the constructor method with 5 parameters: 
 * "subscriberId" of type int, "name" of type String, "subscriberNo" of type float, "subscriptionCost" of type float, "premiumShortNo" of type String
 * The constructor should throw an Exception if the subscriber number (subscriberNo) is less than 0 or the premiumShortNo is null
 * 
 * Implement proper get/set method(s) and override equals method:
 * public method equals(Object o) which returns boolean
 * The setPremiumShortNo method must throw an exception if the parameter is a null String.
 * 
 * Implement consistently the clone method for creating deep copy of the current object:
 * public clone() which return Object and may throw CloneNotSupportedException
 * 
 * Override the methods from Comparable (compareTo() -> returns int and it compares passengers in terms of premiumShortNo)
 * 
 * Override method getAbstractSubscriberId() which returns a String 
 * which represents the concatenation of the inherited value
 * for the subscriberId and premiumShortNo filed value
 * 
 * Override toString() -> String method in terms of returning the String concatenation of the fields content
 */

/*
 * Nota 4: Creati clasa PremiumSubscriber ce este derivata din Subscriber si implementeaza interfetele Cloneable si Comparable<Subscriber> .
 * 
 * Pe langa campurile si metodele mostenite din clasa abstracta Subscriber, clasa PremiumSubscriber are urmatoarele campuri private:
 * premiumShortNo : String pentru numarul scurt al abonatului de tip premium
 * serialVersionUID : static long
 * 
 * Implementati metoda constructor cu 5 parameteri: 
 * "subscriberId" de tip int, "name" de tip String, "subscriberNo" de tip float, "subscriptionCost" de tip float, "premiumShortNo" de tip String
 * Constructorul arunca o exceptie din clasa Exception daca numarul abonatului (subscriberNo) este mai mic de 0 sau premiumShortNo este null
 * 
 * Implementati corespunsator metodele get/set si supra-screti metoda equals:
 * metoda publica equals(Object o) ce returneaza boolean
 * Metoda setPremiumShortNo produce o exceptie din clasa Exception daca parametrul este null.
 * 
 * Implementati consistent metoda clone pentru a creeea obiecte clona de tip "deep copy" din obiectul curent:
 * public clone() -> return Object si "throw CloneNotSupportedException"
 * 
 * Supra-scrieti metoda compareTo din interfata Comparable (compareTo() -> return int ce compara pasagerii in functie de campul premiumShortNo)
 * 
 * Supra-scrieti si implementati metoda getAbstractSubscriberId() ce returneaza un obiect de tip String 
 * ce reprezinta concatenarea valoarea mostenita pentru subscriberId si valoarea capului premiumShortNo
 * 
 * Supra-scrieti metoda toString() -> String astfel incat sirul de caractere returnat sa contina textual reprezentarea tuturor campurilor din clasa
 */

public class PremiumSubscriber extends Subscriber implements Cloneable, Comparable<PremiumSubscriber>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8606768663644178565L;
	private String premiumShortNo;
	
	
	public PremiumSubscriber(int subscriberId, String name, float subscriberNo, float subscriptionCost, String premiumShortNo) throws Exception {
	
			super(subscriberId,name, subscriberNo, subscriptionCost);
			if(subscriberNo < 0 || premiumShortNo==null) {
				throw new Exception();
			}
			this.premiumShortNo=premiumShortNo;
	}
	
	
	
	
	public String getPremiumShortNo() {
		return premiumShortNo;
	}



	public void setPremiumShortNo(String premiumShortNo) throws Exception {
		if(premiumShortNo==null) {
			throw new Exception();
		}
		this.premiumShortNo = premiumShortNo;
	}


	public static long getSerialversionUID() {
		return serialVersionUID;
	}




	@Override
	public boolean equals(Object obj) {
		
		if(obj==null || !(obj instanceof PremiumSubscriber)) {
			return false;
		}
		
		PremiumSubscriber premiumSubscriber=(PremiumSubscriber)obj;

		return premiumSubscriber.getName().equals(this.getName()) &&
				premiumSubscriber.getSubscriberId()==this.getSubscriberId() &&
				premiumSubscriber.getSubscriberNo()==this.getSubscriberNo() &&
				premiumSubscriber.getSubscriptionCost()==this.getSubscriptionCost()&&
				premiumSubscriber.premiumShortNo.equals(this.premiumShortNo);
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	public Object clone() throws CloneNotSupportedException {
		
		PremiumSubscriber premiumSubscriber=(PremiumSubscriber)super.clone();
		premiumSubscriber.premiumShortNo=this.premiumShortNo;
		
		return premiumSubscriber;
	}
	


	@Override
	public int compareTo(PremiumSubscriber o) {
		
		
		return this.premiumShortNo.compareTo(o.premiumShortNo);
	}

	@Override
	public String getAbstractSubscriberId() {
	
		return new String(this.getSubscriberId()+this.premiumShortNo);
	}

	
}
	
