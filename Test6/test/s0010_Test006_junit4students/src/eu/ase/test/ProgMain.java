package eu.ase.test;

// This is the Java code playground
// Loc pentru testare obiecte si clase utilizand cod sursa Java

public class ProgMain {

	public static void main(String[] args) {
		
		PremiumSubscriber pv1, pv2, pv3;
		try {
			pv1 = new PremiumSubscriber(11, "Jean", 12, 20, "B123");
			pv2 = new PremiumSubscriber(16, "Jane", 23, 21, "B124");
			pv3 = new PremiumSubscriber(16, "Jane", 23, 21, "B124");
			if (pv1.equals(pv2))
				System.out.println("incorrect true");
			else
				System.out.println("correct false");
			
			if (pv2.equals(pv3))
				System.out.println("correct true");
			else
				System.out.println("incorrect false");
			
			PremiumSubscriber[][] objs = new PremiumSubscriber[][]{{pv1, pv2, null}, {null, pv3, null}};
			System.out.println("lines = " + objs.length + " , columns = " + objs[0].length);
			/*
			Utils m = new Utils();
			m.setMatrix(objs);
			m.displayMatrix();
			// ...
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}

}
