package eu.ase.java.models;

import java.io.Serializable;

public abstract class Pasager implements Serializable{

	private String nume;
	private float numarLoc;
	private float varsta;
	private final int idRezervare = 1;
	private static final long serialVersionUID = 2L;
	
	public Pasager(String nume, float numarLoc, float varsta) {
		this.nume = nume;
		this.numarLoc = numarLoc;
		this.varsta = varsta;
	}
	
	public String getNume() {
		return nume;
	}
	
	public float getNumarLoc() {
		return numarLoc;
	}
	
	public float getVarsta() {
		return varsta;
	}
	
	public abstract String getIdRezervare();
	
}
