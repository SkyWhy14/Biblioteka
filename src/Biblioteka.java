import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;



public class Biblioteka {
//galvena klase  Biblioteka 
	//Ar JOptionPane dialogiem nodrosina izveles izdarisanas funnkcionalitati veicamajam darbibam,Tiek nodrosinata ievaddatu validacija
	//galvena klase ir iespejams izvieodt jaunu klasu objektus (Uzglabat kada no datu stukturam) apskatit jau izveidotus objektus,dzest objektus ,izsaukt metodes
	//atbiltosi programmas klasem defienti vairaki to rakturojosi atributi un metodes
	//programma demonstre iekapsulesanu un java Bean klases pamatprincipus
	//programma jegpilnigi nodrosina virsklases un apaksklasu stukturu

	
	

	public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException{
		String izvele;
		
		String[] darbibas = {"Jauna grāmata", 
				 "Rakstu darbu saraksts",
				"Dzēst grāmatu",
				"Izsaukt metodi", "Aizvērt programmu"};
		
		String[] gramatasUnRakstuDarbiVeidi = {"Bērnu grāmata", "Zinātniskais rakstu darbs"};
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
			//var taisit bernu gramatas gan zinatniskos rakstu darbus
			case 0:
				izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies grāmatas veidu",
						"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
						,gramatasUnRakstuDarbiVeidi, gramatasUnRakstuDarbiVeidi[0]);
				if (izvele == null)break;
				switch(izvele) {
				case "Bērnu grāmata":
					BernuGramata bg = Metodes.izveidotBernuGramatu();
					if(bg != null) {
						gramatas.add(bg);
						JOptionPane.showMessageDialog(null, "Veiksmīgi izveidota bērnu grāmata",
								"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Grāmatas izveide atcelta",
								"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case "Zinātniskais rakstu darbs":
					RakstuDarbs rd = Metodes.izveidotZinatniskoRakstuDarbu();
					if(rd != null) {
						rakstuDarbi.add(rd);
						JOptionPane.showMessageDialog(null, "Veiksmīgi izveidots zinātniskais rakstu darbs",
								"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Rakstu darba izveide atcelta",
								"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					}
				break;
				
					
					
					
					//izvada bernu gramatu sarakstu un zinatnisko rakstu darbu sarakstu  ar scrollable text area
				case 1:
					if(gramatas.size()==0 && rakstuDarbi.size()==0) {
						JOptionPane.showMessageDialog(null, "Bibliotēka ir tukša, nav ko rādīt",
								"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
						}else {
							StringBuilder saraksts = new StringBuilder();
							saraksts.append("Bērnu grāmatu saraksts:\n\n");
							for(int i=0; i<gramatas.size(); i++) {
								saraksts.append(((BernuGramata)gramatas.get(i)).izvadit()).append("\n\n");
							}
							saraksts.append("Zinātnisko rakstu darbu saraksts:\n\n");
							for(int i=0; i<rakstuDarbi.size(); i++) {
								saraksts.append(((RakstuDarbs)rakstuDarbi.get(i)).izvadit()).append("\n\n");
							}
							JTextArea textArea = new JTextArea(saraksts.toString());
							textArea.setEditable(false);
							JScrollPane scrollPane = new JScrollPane(textArea);
							scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
							scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
							JOptionPane.showMessageDialog(null, scrollPane, "Grāmatu un rakstu darbu saraksts",
									JOptionPane.INFORMATION_MESSAGE);
						}
					break;
			
					case 2: 
						if(gramatas.size()==0 && rakstuDarbi.size()==0) {
							JOptionPane.showMessageDialog(null, "Bibliotēka ir tukša, nav ko dzēst",
									"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
							}else {
								ArrayList<String> dzestieObjekti = new ArrayList<>();
								for(int i=0; i<gramatas.size(); i++) {
									dzestieObjekti.add("Bērnu grāmata: "+((BernuGramata)gramatas.get(i)).getNosaukums());
								}
								for(int i=0; i<rakstuDarbi.size(); i++) {
									dzestieObjekti.add("Zinātniskais rakstu darbs: "+((RakstuDarbs)rakstuDarbi.get(i)).getNosaukums());
								}
								String[] dzestieObjektiArray = dzestieObjekti.toArray(new String[0]);
								String dzestaisObjekts = (String) JOptionPane.showInputDialog(null, "Izvēlies grāmatu vai rakstu darbu, ko dzēst",
										"Dzēst grāmatu/rakstu darbu", JOptionPane.QUESTION_MESSAGE, null,
										dzestieObjektiArray, dzestieObjektiArray[0]);
								if(dzestaisObjekts != null) {
									int index = dzestieObjekti.indexOf(dzestaisObjekts);
									if(dzestaisObjekts.startsWith("Bērnu grāmata: ")) {
										gramatas.remove(index);
									}else {
										rakstuDarbi.remove(index - gramatas.size());
									}
									JOptionPane.showMessageDialog(null, "Veiksmīgi izdzēsts: "+dzestaisObjekts,
											"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null, "Dzēšana atcelta",
											"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
								}
								
							}
					//izsaukt metodi
					case 3:
					    if (gramatas.size() == 0 && rakstuDarbi.size() == 0) {
					        JOptionPane.showMessageDialog(null, "Bibliotēkā nav grāmatu un rakstu darbu, lai izsauktu metodes",
					                "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					        break;
					    }
					    //pievieno kaut ko metodes izsaukšanai
					    String[] metodes = {
					        "Audio grāmatas atskaņošana",
					        "Pārdēvēt grāmatu vai rakstu darbu",
					        "Sadedzināt grāmatu skaitu bibliotēkā",
					        "Pajautāt darbiniekam par grāmatu ",
					        "Atpakaļ"
					    };

					    while (true) {
					        String metodeIzvele = (String) JOptionPane.showInputDialog(null, "Izvēlies metodi",
					                "Metodes izvēlne", JOptionPane.QUESTION_MESSAGE, null,
					                metodes, metodes[0]);

					        if (metodeIzvele == null || metodeIzvele.equals("Atpakaļ")) {
					            break;
					        }

					        switch (metodeIzvele) {
					            case "Audio grāmatas atskaņošana":
					                int gramatasID = Metodes.gramatasIzvele(gramatas);
					                if (gramatasID != -1) {
					                    ((BernuGramata) gramatas.get(gramatasID)).atskanotAudioGramatu();
					                }
					                break;

					            case "Pārdēvēt grāmatu vai rakstu darbu":
					                Metodes.pardevetGramatuVaiRakstuDarbu(gramatas, rakstuDarbi);
					                break;
					            case "Sadedzināt grāmatu skaitu bibliotēkā":
					         int kopSkaits = gramatas.size() + rakstuDarbi.size();
					         JOptionPane.showMessageDialog(null, "Bibliotēkā kopā ir " + kopSkaits + " grāmatas un rakstu darbi.",
					                 "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					         Metodes.sadedzinatGramatuRakstuDarbuSkaitu(gramatas, rakstuDarbi);
					         
					         	
					            						                
					                break;
					                //vajag lai ir bilde ar darbinieku un tekstu un ir iespeja izvleties gramatu vai rakstu darbu par kuru jautat
					            case "Pajautāt darbiniekam par grāmatu ":
					            	Metodes.pajauttDarbiniekamParGramatuVaiRakstuDarbu(gramatas, rakstuDarbi);
					            						               
					                break;
					            	
					            case "Atpakaļ":
					                break;

					          
					            	
					                
					                
					        }
					    }
					    break;
						
					
					
								
						}
		}while(izvele != null && !izvele.equals("Aizvērt programmu"));
		JOptionPane.showMessageDialog(null, "Paldies, ka izmantojāt bibliotēkas programmu!",
				"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
	}
}
