//apakskalse  Ber7\nuGramata 
public class BernuGramata  extends RakstuDarbs{
	
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
		return "Bērnu grāmatas autors: "+getAutors()+
				"\nBērnu grāmatas nosaukums: "+getNosaukums()+
				"\nBērnu grāmatas lappušu skaits: "+getLappuses()+
				"\nBērnu grāmatas cena: "+getCena()+" EUR"+
				"\nIlustrators: "+getIlustrators()+
				"\nIeteicamais vecums: "+getIeteicamaisVecums()+" gadiem";
	}
 		
}
