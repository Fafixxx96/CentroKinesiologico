package Programma;

import java.util.*;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.*;

public class Codice {
	
	public LinkedList<Cliente> clienti = new LinkedList<Cliente>();
	public GruppoMuscolare[] gruppiMuscolari= new GruppoMuscolare[10];
	
	public Codice() throws IOException {
		//NuovoCliente("Fabio", "Capparelli");
		gruppiMuscolari = GruppiMuscolari();
		//AddEsercizio("Spalle001","C:\\Users\\fafic\\Desktop\\Gianpiero\\Gruppi Muscolari\\Spalle\\Spalle001.jpg", gruppiMuscolari[2]);
		caricaClienti();
	
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Codice c = new Codice();
		
	}

	
	
	
	private GruppoMuscolare[] GruppiMuscolari() {
		GruppoMuscolare[] gruppi = new GruppoMuscolare[10];
		
		gruppi[0] = new GruppoMuscolare("Petto");
		gruppi[1] = new GruppoMuscolare("Dorsali");
		gruppi[2] = new GruppoMuscolare("Spalle");
		gruppi[3] = new GruppoMuscolare("Bicipiti");
		gruppi[4] = new GruppoMuscolare("Tricipiti");
		gruppi[5] = new GruppoMuscolare("Gambe");
		gruppi[6] = new GruppoMuscolare("AddomeFianchiLombari");
		gruppi[7] = new GruppoMuscolare("Correttiva");
		gruppi[8] = new GruppoMuscolare("Streatching");
		gruppi[9] = new GruppoMuscolare("CardioFitness");
		
		return gruppi;
		
	}
	
	@SuppressWarnings("resource")
	private void caricaClienti() throws IOException{
		String f = "C:\\Users\\fafic\\OneDrive\\Desktop\\Gianpiero\\Clienti\\Clienti.txt";
		
		File file = new File(f);
		BufferedReader br;
		StringTokenizer st;
		br = new BufferedReader(new FileReader(file));
		String line;
		
		for(;;) {
			line = br.readLine();
			if(line == null) break;
			st = new StringTokenizer(line);
			
			String nome = st.nextToken();
			String cognome = st.nextToken();
			
			Cliente c = new Cliente(nome, cognome);
			clienti.add(c);
		}
			
		
	}
	public void NuovoCliente(String nome, String cognome) throws IOException {
		
		Cliente c = new Cliente(nome, cognome);
		clienti.addLast(c);
		
		creaCartella(nome + " " + cognome, "C:\\Users\\fafic\\OneDrive\\Desktop\\Gianpiero\\Clienti");
		
        
		String f = "C:\\Users\\fafic\\OneDrive\\Desktop\\Gianpiero\\Clienti\\Clienti.txt";
		@SuppressWarnings("unused") boolean b = false;
		File file = new File(f);
		
		if(!file.exists()) b = file.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		for (Cliente cl: clienti) {
			bw.write(cl.toString());
			bw.newLine();
			bw.flush();
			
		}
		bw.close();
		
		
	}

	public void AddEsercizio(String nome, String path, String g) throws IOException {
		
		GruppoMuscolare gruppo = new GruppoMuscolare("");
		
		switch(g) {
		case "Petto" : gruppo = gruppiMuscolari[0]; break;
		case "Dorsali" : gruppo = gruppiMuscolari[1]; break;
		case "Spalle" : gruppo = gruppiMuscolari[2]; break;
		case "Bicipiti" : gruppo = gruppiMuscolari[3]; break;
		case "Tricipiti" : gruppo = gruppiMuscolari[4]; break;
		case "Gambe" : gruppo = gruppiMuscolari[5]; break;
		case "AddomeFianchiLombari" :gruppo = gruppiMuscolari[6]; break;
		case "Correttiva" : gruppo = gruppiMuscolari[7]; break;
		case "Stretching" : gruppo = gruppiMuscolari[8]; break;
		case "CardioFitness" :  gruppo = gruppiMuscolari[9]; break;
		
		}
		
		Esercizio e = new Esercizio(nome, path, gruppo); 
		
		String f = "C:\\Users\\fafic\\OneDrive\\Desktop\\Gianpiero\\Gruppi Muscolari\\" + gruppo.nome + "\\" + gruppo.nome +".txt";
		@SuppressWarnings("unused") boolean b = false;
		File file = new File(f);
		
		if(!file.exists()) b = file.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(e.nome);
		bw.newLine();
		bw.flush();
		bw.close();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		boolean bo = false;
		for(;;) {
			line = br.readLine();
			if(line == null) break;
			if(nome.equals(line)) {bo = true; break;}
		}
		br.close();
		
		
		
		
		switch(gruppo.nome) {
		case "Petto" : gruppiMuscolari[0].addEsercizio(e); break;
		case "Dorsali" : gruppiMuscolari[1].addEsercizio(e); break;
		case "Spalle" : gruppiMuscolari[2].addEsercizio(e); break;
		case "Bicipiti" : gruppiMuscolari[3].addEsercizio(e); break;
		case "Tricipiti" : gruppiMuscolari[4].addEsercizio(e); break;
		case "Gambe" : gruppiMuscolari[5].addEsercizio(e); break;
		case "AddomeFianchiLombari" : gruppiMuscolari[6].addEsercizio(e); break;
		case "Correttiva" : gruppiMuscolari[7].addEsercizio(e); break;
		case "Stretching" : gruppiMuscolari[8].addEsercizio(e); break;
		case "CardioFitness" : gruppiMuscolari[9].addEsercizio(e); break;
		
		}

	}
	private void caricaEsercizi(String gruppo, int i) throws IOException{
		String f = "C:\\Users\\fafic\\OneDrive\\Desktop\\Gianpiero\\"+ gruppo + "\\" + gruppo + ".txt";
		String path ="C:\\Users\\fafic\\OneDrive\\Desktop\\Gianpiero\\" + gruppo + "\\";
		
		File file = new File(f);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		
		for(;;) {
			line = br.readLine();
			if(line == null) break;
			
			Esercizio e = new Esercizio(line, path + line + ".jpg", gruppiMuscolari[i]);
			gruppiMuscolari[i].addEsercizio(e);
			
		}br.close();
		
	}
    private void caricaEsercizi() throws IOException {
    	caricaEsercizi("Petto", 0);
    	caricaEsercizi("Dorsali", 1);
    	caricaEsercizi("Spalle", 2);
    	caricaEsercizi("Bicipiti", 3);
    	caricaEsercizi("Tricipiti", 4);
    	caricaEsercizi("Gambe", 5);
    	caricaEsercizi("AddomeFianchiLombari", 6);
    	caricaEsercizi("Correttiva", 7);
    	caricaEsercizi("Stretching", 8);
    	caricaEsercizi("CardioFitness", 9);
    	
    }

    private void creaCartella(String dir, String path) {
        boolean success = (new File(dir)).mkdir();
        dir = path + "\\" + dir;
        success = (new File(dir)).mkdirs();


    }
    
    public void salvaScheda(Panel panel, String path, String name) throws IOException, AWTException {
    	
    	
    	Robot robot = new Robot();
        String fileName = path + "\\" + name + ".jpg";
        
        File f = new File(fileName);
        boolean b = false;
        if(!f.exists()) b = f.createNewFile();
        

        Rectangle screenRect = new Rectangle(panel.getX()+358, panel.getY()+190, panel.getWidth(), panel.getHeight());
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
        ImageIO.write(screenFullImage, "jpg", new File(fileName));
    	
    	
    }
    
    
    
}

