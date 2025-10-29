//virsklase RakstuDarbs

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class RakstuDarbs  extends Biblioteka{
//atributi
	private String autors;
	private String nosaukums;
	private int lappuses;
	private double cena;
	private String ilustrators;
	
	//konstruktors
	public RakstuDarbs(String autors, String nosaukums, int lappuses, double cena, String ilustrators) {
		this.autors = autors;
		this.nosaukums = nosaukums;
		this.lappuses = lappuses;
		this.cena = cena;
	}
	
	//getteri
	public String getAutors() {
		return autors;
	}
	
	public String getNosaukums() {
		return nosaukums;
	}
	public void setNosaukums(String nosaukums) {
		this.nosaukums = nosaukums;
	}
	
	public int getLappuses() {
		return lappuses;
	}
	
	public double getCena() {
		return cena;
	}
	public String ilustrators() {
		return ilustrators;
	}
	public String izvadit() {
		return "Rakstu darba autors: "+getAutors()+
				"\nRakstu darba nosaukums: "+getNosaukums()+
				"\nRakstu darba lappušu skaits: "+getLappuses()+
				"\nRakstu darba cena: "+getCena()+" EUR";
	}
	
}
