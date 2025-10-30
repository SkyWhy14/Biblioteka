import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BernuGramata extends RakstuDarbs {

    private String ilustrators;
    private int ieteicamaisVecums;

    public BernuGramata(String autors, String nosaukums, int lappuses, double cena,
                        String ilustrators, int ieteicamaisVecums) {
        super(autors, nosaukums, lappuses, cena, ilustrators);
        this.ilustrators = ilustrators;
        this.ieteicamaisVecums = ieteicamaisVecums;
    }

    public String getIlustrators() {
        return ilustrators;
    }

    public int getIeteicamaisVecums() {
        return ieteicamaisVecums;
    }

    @Override
    public String izvadit() {
        return "Bērnu grāmatas autors: " + getAutors() +
               "\nBērnu grāmatas nosaukums: " + getNosaukums() +
               "\nBērnu grāmatas lappušu skaits: " + getLappuses() +
               "\nBērnu grāmatas cena: " + getCena() + " EUR" +
               "\nIlustrators: " + getIlustrators() +
               "\nIeteicamais vecums: " + getIeteicamaisVecums() + " gadiem";
    }

	public void atskanotAudioGramatu()  throws MalformedURLException, UnsupportedAudioFileException, IOException,
	LineUnavailableException {
	
		File f = new File(".//audio//"+"gramata.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
		Clip c = AudioSystem.getClip();
		c.open(ais);
		c.start();
		
	}
	

    
}