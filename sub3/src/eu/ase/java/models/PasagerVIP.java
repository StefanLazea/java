package eu.ase.java.models;

public class PasagerVIP extends Pasager{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private String nrCardVip;
	
	public PasagerVIP(String nume, float numarLoc, float varsta, String nrCardVip) throws ArithmeticException {
		super(nume, numarLoc, varsta);
		this.nrCardVip = nrCardVip;
		if(numarLoc < 0) {
			throw new ArithmeticException("E negativ boss");
		}
	}
	
	@Override
	public String getIdRezervare() {
		return this.getIdRezervare() + this.nrCardVip;
	}

	public String getNrCardVip() {
		return nrCardVip;
	}

	public void setNrCardVip(String nrCardVip) {
		this.nrCardVip = nrCardVip;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		PasagerVIP vip = (PasagerVIP) super.clone();
		
		if(!this.nrCardVip.isEmpty()) {
			vip.nrCardVip = this.nrCardVip;
		}
		
		return vip;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof PasagerVIP)) {
			return false;
		}
		
		PasagerVIP vip = (PasagerVIP) obj;
		return vip.nrCardVip.equals(this.nrCardVip);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNume() + " " + this.getVarsta() + " vip";
	}
}
