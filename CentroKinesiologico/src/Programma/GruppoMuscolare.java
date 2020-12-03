package Programma;


import java.util.*;

public class GruppoMuscolare {
	
	String nome;
	LinkedList<Esercizio> esercizi;
	
	public GruppoMuscolare(String nome) {
		this.nome = nome;
		esercizi  = new LinkedList<Esercizio>();
	}
	
	public void addEsercizio(Esercizio esercizio) {
		if(!esercizi.contains(esercizio)) esercizi.addLast(esercizio);
	}
	
	public void removeEsercizio(Esercizio esercizio) {
		if(esercizi.contains(esercizio)) esercizi.remove(esercizio);
	}
	
	

}
