import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Metodes  extends Biblioteka{
	public static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}
	public static int skaitlaParbaude(String zinojums, double min, double max, String noklusejums) {
		String ievade;
		int skaitlis;
		while(true) {
			ievade = (String)JOptionPane.showInputDialog(null, zinojums, 
					"Datu ievade", JOptionPane.INFORMATION_MESSAGE, null, null, noklusejums); 
			if(ievade == null)
				return -1;
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis < min || skaitlis > max) {
					JOptionPane.showMessageDialog(null, 
					"Norādīts nederīgs skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
					"Netika ievadīts pareizs skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
			}
		}
}
	public static BernuGramata izveidotBernuGramatu() {
		String autors = virknesParbaude("Ievadi grāmatas autoru:", "Anna Bērziņa");
		if(autors == null) return null;
		String nosaukums = virknesParbaude("Ievadi grāmatas nosaukumu:", "Pasaka par draudzību");
		if(nosaukums == null) return null;
		int lappuses = skaitlaParbaude("Ievadi grāmatas lappušu skaitu:", 1, 10000, "23");
		if(lappuses == -1) return null;
		double cena = skaitlaParbaude("Ievadi grāmatas cenu EUR:", 0.01, 1000, "23");
		if(cena == -1) return null;
		String ilustrators = virknesParbaude("Ievadi grāmatas ilustratoru:", "Maija Kalniņa");
		if(ilustrators == null) return null;
		int ieteicamaisVecums = skaitlaParbaude("Ievadi ieteicamo vecumu gadiem:", 0, 18, "3");
		if(ieteicamaisVecums == -1) return null;
		
		return new BernuGramata(autors, nosaukums, lappuses, cena, ilustrators, ieteicamaisVecums);
	}
	public static RakstuDarbs izveidotZinatniskoRakstuDarbu() {
		String autors = virknesParbaude("Ievadi rakstu darba autoru:", "Kārlis Ozols");
		if(autors == null) return null;
		String nosaukums = virknesParbaude("Ievadi rakstu darba nosaukumu:", "Pētniecība par klimata pārmaiņām");
		if(nosaukums == null) return null;
		int lappuses = skaitlaParbaude("Ievadi rakstu darba lappušu skaitu:", 1, 10000, "50");
		if(lappuses == -1) return null;
		double cena = skaitlaParbaude("Ievadi rakstu darba cenu EUR:", 0.01, 1000, "");
		if(cena == -1) return null;
		
		return new RakstuDarbs(autors, nosaukums, lappuses, cena, "");
	
	}
	
	public static int gramatasIzvele(ArrayList<Object> gramatas) {
		String[] gramatuSar = new String[gramatas.size()];
		for(int i = 0; i < gramatas.size(); i++) {
			gramatuSar[i] = ((BernuGramata)gramatas.get(i)).getNosaukums();
		}
		String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies grāmatu kuru atskaņot",
				"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
				,gramatuSar, gramatuSar[0]);
		if(izvele == null) return -1;
		return java.util.Arrays.asList(gramatuSar).indexOf(izvele);
	}
	
	
	
	 public static void pardevetGramatuVaiRakstuDarbu(ArrayList<Object> gramatas, ArrayList<Object> rakstuDarbi) {
		  ArrayList<String> pardevetieObjekti = new ArrayList<>();
		  		for(int i=0; i<gramatas.size(); i++) {
		  			pardevetieObjekti.add("Bērnu grāmata: "+((BernuGramata)gramatas.get(i)).getNosaukums());
		  		}
		  		for(int i=0; i<rakstuDarbi.size(); i++) {
		  			pardevetieObjekti.add("Zinātniskais rakstu darbs: "+((RakstuDarbs)rakstuDarbi.get(i)).getNosaukums());
		  		}
		  		String[] pardevetieObjektiArray = pardevetieObjekti.toArray(new String[0]);
		  		String pardevetaisObjekts = (String) JOptionPane.showInputDialog(null, "Izvēlies grāmatu vai rakstu darbu, ko pārdēvēt",
		  				"Pārdēvēt grāmatu/rakstu darbu", JOptionPane.QUESTION_MESSAGE, null,
		  				pardevetieObjektiArray, pardevetieObjektiArray[0]);
		  		if(pardevetaisObjekts != null) {
		  			int index = pardevetieObjekti.indexOf(pardevetaisObjekts);
		  			String jaunsNosaukums = virknesParbaude("Ievadi jauno nosaukumu:", "Jaunais nosaukums");
		  			if(jaunsNosaukums != null) {
		  				if(pardevetaisObjekts.startsWith("Bērnu grāmata: ")) {
		  					((BernuGramata)gramatas.get(index)).setNosaukums(jaunsNosaukums);
		  				}else {
		  					((RakstuDarbs)rakstuDarbi.get(index - gramatas.size())).setNosaukums(jaunsNosaukums);
		  				}
		  				JOptionPane.showMessageDialog(null, "Veiksmīgi pārdēvēts: "+pardevetaisObjekts,
		  						"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		  			}else {
		  				JOptionPane.showMessageDialog(null, "Pārdēvēšana atcelta",
		  						"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		  			}
		  			}else {
		  				JOptionPane.showMessageDialog(null, "Pārdēvēšana atcelta",
		  						"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		  			
		  		}
	  }
	
	public static void sadedzinatGramatuRakstuDarbuSkaitu(ArrayList<Object> gramatas, ArrayList<Object> rakstuDarbi) {
		int kopSkaits = gramatas.size() + rakstuDarbi.size();
		JOptionPane.showMessageDialog(null, "Bibliotēkā ir kopā "+kopSkaits+" grāmatas  kas tiks sadedzināti.",
				"Sadedzināt grāmatu/rakstu darbu skaitu", JOptionPane.INFORMATION_MESSAGE);
		gramatas.clear();
		rakstuDarbi.clear();
		JOptionPane.showMessageDialog(null, "Visi grāmatu un rakstu darbu skaits bibliotēkā ir sadedzināts.",
				"Sadedzināšana pabeigta", JOptionPane.INFORMATION_MESSAGE);
	}
 
	
	
}
