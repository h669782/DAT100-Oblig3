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
	
	@Override
	public String toString() {
	    StringBuilder txt = new StringBuilder();
	    txt.append(nesteledig).append("\n");

	    for (int i = 0; i < nesteledig; i++) {
	        Innlegg innlegg = innleggtabell[i];
	        txt.append(innlegg.toString());
	    }

	    return txt.toString();
	}




	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[innleggtabell.length * 2];
		int antall = 0;
		for(int i = 0; i < innleggtabell.length; i++) {
			if(innleggtabell[i] != null) {
				ny[antall] = innleggtabell[i];
				antall++;
			}
		}
		innleggtabell = ny;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if(!leggTil(innlegg)) {
			utvid();
			leggTil(innlegg);
			return true;
		}
		return true;
	}
	
	public boolean slett(Innlegg innlegg) {
		if(finnes(innlegg)) {
			innleggtabell[finnInnlegg(innlegg)] = null;
			nesteledig--;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
	    int antall = 0;
	    int[] tempResultater = new int[innleggtabell.length];
	    
	    for (int i = 0; i < innleggtabell.length; i++) {
	        if (innleggtabell[i] != null && innleggtabell[i].toString().contains(keyword)) {
	            tempResultater[antall] = innleggtabell[i].getId();
	            antall++;
	        }
	    }
	    
	    int[] resultater = new int[antall];
	    System.arraycopy(tempResultater, 0, resultater, 0, antall);

	    return resultater;
	}

}