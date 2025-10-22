//apakskalse  BernuGramata 
public class BernuGramata  extends RakstuDarbs{
	
	private String ilustrators;
	private int ieteicamaisVecums;
	
	
	public BernuGramata(String autors, String nosaukums,
			int lappuses, double cena,
			String ilustrators, int ieteicamaisVecums) {
		super(autors, nosaukums, lappuses, cena);
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
		return super.izvadit()+
				"\nIlustrators: "+getIlustrators()+
				"\nIeteicamais vecums: "+getIeteicamaisVecums()+" gadi";
	}
 		
}
