//virsklase RakstuDarbs
public class RakstuDarbs {
//atributi
	private String autors;
	private String nosaukums;
	private int lappuses;
	private double cena;
	
	//konstruktors
	public RakstuDarbs(String autors, String nosaukums, int lappuses, double cena) {
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
	
	public int getLappuses() {
		return lappuses;
	}
	
	public double getCena() {
		return cena;
	}
	public String izvadit() {
		return "Rakstu darba autors: "+getAutors()+
				"\nRakstu darba nosaukums: "+getNosaukums()+
				"\nRakstu darba lappušu skaits: "+getLappuses()+
				"\nRakstu darba cena: "+getCena()+" EUR";
	}
}
