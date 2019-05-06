package eu.ase.java.models;

public class PasagerEc extends Pasager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private String nrCardEc;

	public PasagerEc(
			String nume,
			float numarLoc, 
			float varsta, 
			String nrCardEc
		) {
		super(nume, numarLoc, varsta);
		if(numarLoc<0) {
			throw new ArithmeticException("Negativ");
		}
		this.nrCardEc = nrCardEc;
	}

	public String getNrCardEc() {
		return this.nrCardEc;
	}
	
	@Override
	public String getIdRezervare() {
		return this.getIdRezervare() + " cu cardul " + this.nrCardEc;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		PasagerEc ec = (PasagerEc) super.clone();
		if(!this.nrCardEc.isEmpty()) {
			ec.nrCardEc = this.nrCardEc;
		}
		return ec;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PasagerEc)) {
			return false;
		}
		
		PasagerEc ec = (PasagerEc) obj;
		return ec.nrCardEc.equals(this.nrCardEc);
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNume() + " " + this.getVarsta() + " Economic";
	}
}
