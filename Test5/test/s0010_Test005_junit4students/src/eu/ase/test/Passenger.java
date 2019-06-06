package eu.ase.test;

import java.io.Serializable;

/**
	 * 
	 */
	
/*
 * Grade 3: 
 * Create the abstract class Passenger which implements Cloneable, AutoCloseable and java.io.Serializable interfaces.
 * 
 * The class has the following private fields:
 * bookingId : int which is the id of the booking for the passenger
 * name : String for the name of the passenger
 * placeNo : float for the place number
 * age : float for the age of the passenger
 * serialVersionUID : static long
 * 
 * Create the constructor method without parameters and the one with 4 parameters: 
 * "bookingId" of type int, "name" of type String, "placeNo" of type float, "age" of type float
 * The constructor with parameters should throw an Exception if the place number (placeNo) is less than 0 
 * 
 * Create the private, static and final field className : String with the value "eu.ase.test.Passenger" 
 * and associated public, static get method (getClassName)
 * Create the private, static field passengersNo and and associated public, static get method (getPassengersNo -> returns int). 
 * This variable (passengersNo) / field is used for counting how many objects from this class have been created. 
 * Also be sure this variable is incremented into the constructors and clone method and decremented into close method.
 * 
 * Implement proper get/set methods
 * 
 * Implement consistently the clone method for creating deep copy of the current object:
 * public clone() which return Object and may throw CloneNotSupportedException
 * 
 * AutoCloseable (close() -> returns void)
 * 
 * Declare public abstract method getAbstractBookingId which has no parameter and returns -> String.
 */

/*
 * Nota 3: 
 * implementati clasa abstracta Passenger ce implementeaza interfetele: Cloneable, AutoCloseable si java.io.Serializable .
 * 
 * Clasa are urmatoarele campuri private:
 * bookingId : int ce contine identifcatorul de rezervare
 * name : String ce contine numele pasagerului
 * placeNo : float pentru locul rezervarii
 * age : float pentru varsta pasagerului
 * serialVersionUID : static long
 * 
 * Trebuie implementata metoda constructor fara parameteri si contructorul cu 4 parameteri: 
 * "bookingId" de tip int, "name" de tip String, "placeNo" de tip float, "age" de tip float
 * Constructorul cu parametri trebuie sa dea o exceptie din Exception daca numarul locului (placeNo) este mai mic decat 0 
 * 
 * Clasa contine campul className : String ce este privat, static si final cu valoarea: "eu.ase.test.Passenger" 
 * si metoda de tip get asociata - publica si statica (getClassName)
 * 
 * Clasa mai contine un camp private si static "passengersNo" (numar total de pasageri / obiecte create din aceasta clasa)
 * si metoda publica si statica de tip get asociata (getPassengersNo -> returns int). 
 * Campul (passengersNo) este utilizat pentru a contoriza numarul de obiecte create din aceasta clasa. 
 * Acest camp este incrementat in constructori si metoda clone si decrementat in metoda close.
 * 
 * Implementati metodele get/set in mod crespunzator pentru fiecare camp
 * 
 * Implementati consistent metoda clone pentru a creeea obiecte clona de tip "deep copy" din obiectul curent:
 * public clone() -> return Object si "throw CloneNotSupportedException"
 * 
 * Implementati interfata AutoCloseable (close() -> return void)
 * 
 * Declarati metoda publica si abstracta: getAbstractBookingId ce nu are parametri si returneaza -> String.
 */

public abstract class Passenger implements Cloneable, AutoCloseable, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3391044686829817831L;
	private int bookingId;
	private String name;
	private float placeNo;
	private float age;
	private static final String className = "eu.ase.test.Passenger";
	private static int passengersNo=0;
	
	public Passenger(){
		Passenger.passengersNo++;
	}
	
	
	public Passenger(int bookingid, String name, float placeNo, float age) throws Exception {
		this.bookingId=bookingid;
		this.name=name;
		if(placeNo<0) {
			throw new Exception();
		}
		this.placeNo=placeNo;
		this.age=age;
		passengersNo++;
	}
	
	public static String getClassName() {
		
		return className;
	}
	

	@Override
	public void close() throws Exception {
		
		passengersNo--;
		
	}


	//GETTERS AND SETTERS
	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getPlaceNo() {
		return placeNo;
	}



	public void setPlaceNo(float placeNo) {
		this.placeNo = placeNo;
	}



	public float getAge() {
		return age;
	}



	public void setAge(float age) {
		this.age = age;
	}


	//CLONE
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		Passenger passenger=(Passenger)super.clone();

		return passenger;
	}
	
	
	public abstract String getAbstractBookingId();



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public static String getClassname() {
		return className;
	}


	public static int getPassengersNo() {
		return passengersNo;
	}


	
	
}

