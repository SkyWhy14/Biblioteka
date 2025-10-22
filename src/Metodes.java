import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Metodes {
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
	}
