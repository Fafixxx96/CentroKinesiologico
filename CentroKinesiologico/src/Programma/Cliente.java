package Programma;

import java.util.*;

public class Cliente {
	
	public int id;
	public String nome, cognome;
    //public Date dataNascita;
	public ArrayList<Scheda> schede;

	
	
	public Cliente( String nome, String cognome) {
		//this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		
		//if(ControllaData(anno, mese, anno)) this.dataNascita = new Date(anno, mese, giorno);			
	}
	
	//private boolean ControllaData(int anno, int mese, int giorno) {
		//if(anno<=2018 && mese <=12) {
			//if((mese == 4 || mese == 6 || mese == 9 || mese == 11)) if (giorno > 30 || giorno < 1) return false;
			//if(mese == 2 ) if(giorno > 28 || giorno < 1) return false;
			//if(giorno >= 31 && giorno >=1) return true;
		//}
		//return false;
		
//	}
	
	public String toString() {
		return nome + " " +  cognome;
	}
	
	
		

}
