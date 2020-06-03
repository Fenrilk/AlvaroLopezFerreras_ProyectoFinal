
public abstract class Item extends Estadistica{

	String arma;
	
	 public String getArma() {
		  return this.arma;
	  }
	  public void setArma(String arma) {
		  this.arma=arma;
	  }
	
	public Item(int vida, int damage,String arma) {
		super(vida, damage);	
		this.arma=arma;
	}
	
	
	public abstract String devuelve_datos();
}
