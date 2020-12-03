package Programma;

import java.util.*;

public class Scheda {
	
	public String tipo;
	public Cliente cliente;
	public Date data;
	public List<Esercizio> esercizi;
	
	public Scheda(int giorno, int mese, int anno, Cliente cliente, String tipo) {
		this.cliente = cliente;
		this.tipo = tipo;
		esercizi = new ArrayList<Esercizio>();
		
		if(ControllaData(anno, mese, anno)) this.data = new Date(anno, mese, giorno);	
		
	}
	
	private boolean ControllaData(int anno, int mese, int giorno) {
		if(anno<=2018 && mese <=12) {
			if((mese == 4 || mese == 6 || mese == 9 || mese == 11)) if (giorno > 30 || giorno < 1) return false;
			if(mese == 2 ) if(giorno > 28 || giorno < 1) return false;
			if(giorno >= 31 && giorno >=1) return true;
		}
		return false;
		
	}
	
	public void setEsercizio(Esercizio esercizio) {
		esercizi.add(esercizio);
	}
	
	public void removeEsercizio(Esercizio esercizio) {
		if(esercizi.contains(esercizio)) esercizi.remove(esercizio);
	}

}
