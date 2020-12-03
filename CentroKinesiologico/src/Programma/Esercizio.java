package Programma;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;

import javax.imageio.ImageIO;

public class Esercizio {
	
	
	public String nome, path;
	public BufferedImage img;
	public GruppoMuscolare gruppo;
	public int serie, ripetizioni, minuti, velocita, resistenza;
	
	public Esercizio (String nome, String path, GruppoMuscolare gruppo) {
		this.nome = nome;
		this.gruppo = gruppo;
		this.path = path;
		this.img = loadImage(path);
		
	}
	
	public void setSerie(int n) {serie = n;}
	public void setRipetizoni(int n) {ripetizioni = n;}
	public void setMinuti(int n) {minuti = n;}
	public void setVelocita(int n) {velocita = n;}
	public void setResistenza(int n) {resistenza = n;}	
	
	private BufferedImage loadImage(String path) { 
	        Image bimg = null;
	        BufferedImage ret = null;
	        try {bimg = ImageIO.read(new File(path));} 
	        catch (Exception e) { e.printStackTrace(); }
	           	Image newImage = bimg.getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH);
                ret = new BufferedImage(newImage.getHeight(null), newImage.getWidth(null), BufferedImage.SCALE_SMOOTH);
	            Graphics2D g = ret.createGraphics();
	            g.drawImage(newImage, 0, 0, null);
	            g.dispose();
	            return ret; 
	}
	
	
}
