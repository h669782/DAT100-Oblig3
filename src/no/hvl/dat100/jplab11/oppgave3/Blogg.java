package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
	    for (int i = 0; i < innleggtabell.length; i++) {
	        if (this.innleggtabell[i] != null && this.innleggtabell[i].getId() == innlegg.getId()) {
	            return i;
	        }
	    }
	    return -1;
	}


	public boolean finnes(Innlegg innlegg) {
	    for (int i = 0; i < nesteledig; i++) {
	        if (innleggtabell[i] != null && innleggtabell[i].getId() == innlegg.getId()) {
	            return true;
	        }
	    }
	    return false;
	}


	public boolean ledigPlass() {
		if(nesteledig <= 0) {
			return false;
		}
		if(nesteledig < innleggtabell.length) {
			return true;
		}
		
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(nesteledig >= innleggtabell.length) {
			return false;
		}
		
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}
	
	public String toString() {
		String txt = nesteledig + "\n";
		for(int i = 0; i < nesteledig; i++) {
			txt += innleggtabell[i].getId() + "\n" + 
				   innleggtabell[i].getBruker() + "\n" + 
				   innleggtabell[i].getDato() + "\n" +
				   innleggtabell[i].getLikes() + "\n";
		}
		return txt;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}