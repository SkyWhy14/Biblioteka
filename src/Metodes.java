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
		String autors = Metodes.virknesParbaude("Ievadi grāmatas autoru:", "Maija Pupolina");
		String nosaukums = Metodes.virknesParbaude("Ievadi grāmatas nosaukumu:","Annas piedzīvojumi");
		int lappuses = Metodes.skaitlaParbaude("Ievadi grāmatas lappušu skaitu:",10,50,"23");
		double cena = Metodes.skaitlaParbaude("Ievadi grāmatas cenu EUR:",2,10,"5");
		String ilustrators = Metodes.virknesParbaude("Ievadi grāmatas ilustratoru:", "Jānis Zīmētājs");
		int ieteicamaisVecums = Metodes.skaitlaParbaude("Ievadi grāmatas ieteicamo vecumu:",4,18,"7");
		return new BernuGramata(autors, nosaukums, lappuses, cena, ilustrators, ieteicamaisVecums);
	}
}
