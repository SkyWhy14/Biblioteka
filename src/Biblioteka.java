import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;



public class Biblioteka {
//galvena klase  Biblioteka 
	//Ar JOptionPane dialogiem nodrosina izveles izdarisanas funnkcionalitati veicamajam darbibam,Tiek nodrosinata ievaddatu validacija
	//galvena klase ir iespejams izvieodt jaunu klasu objektus (Uzglabat kada no datu stukturam) apskatit jau izveidotus objektus,dzest objektus ,izsaukt metodes
	
	public static void main(String[] args) {
		String izvele;
		
		String[] darbibas = {"Jauna grāmata", "Jauns rakstu darbs",
				"Grāmatu saraksts", "Rakstu darbu saraksts",
				"Dzēst grāmatu", "Dzēst rakstu darbu",
				"Izsaukt metodi", "Aizvērt programmu"};
		
		String [] gramatasVeidi = {"Bērnu grāmata"};
		String [] rakstuDarbiVeidi = {"Zinātniskais rakstu darbs"};
		ArrayList<Object> gramatas = new ArrayList<>();
		ArrayList<Object> rakstuDarbi = new ArrayList<>();
		int izvelesID;
		JOptionPane.showMessageDialog(null, "Laipni lūdzam bibliotēkā!",
				"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību",
					"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
					,darbibas, darbibas[0]);
			if(izvele == null) break;
			izvelesID = java.util.Arrays.asList(darbibas).indexOf(izvele);
			switch(izvelesID) {
			case 0:
				izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies grāmatas veidu",
						"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
						,gramatasVeidi, gramatasVeidi[0]);
				if (izvele == null)break;
				switch(izvele) {
				case "Bērnu grāmata":
					gramatas.add(Metodes.izveidotBernuGramatu());
					JOptionPane.showMessageDialog(null, "Veiksmīgi izveidota bērnu grāmata",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				break;
				case 1:
					izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies rakstu darba veidu",
						"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
						,rakstuDarbiVeidi, rakstuDarbiVeidi[0]);
					if (izvele == null)break;
					switch(izvele) {
					case "Zinātniskais rakstu darbs":
						rakstuDarbi.add(Metodes.izveidotZinatniskoRakstuDarbu());
						JOptionPane.showMessageDialog(null, "Veiksmīgi izveidots zinātniskais rakstu darbs",
								"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
						break;
						
						
					}
					break;
				
					
					
				
					}
		
		}while(izvele != null && !izvele.equals("Aizvērt programmu"));
		JOptionPane.showMessageDialog(null, "Paldies, ka izmantojāt bibliotēkas programmu!",
				"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
	}
}
