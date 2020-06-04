
public abstract class Item extends Estadistica{

	String arma;// Variable string de arma
	
	//Getters and setters 
	/**
	 * 
	 * @return devuelve el arma en formato String
	 */
	 public String getArma() {
		  return this.arma;
	  }
	 /**
	  * 
	  * @param arma recoge el arma de formato String
	  */
	  public void setArma(String arma) {
		  this.arma=arma;
	  }
	//Constructor
	  /**
	   * 
	   * @param vida recoge la vida en formato int
	   * @param damage recoge el daño en formato int
	   * @param arma recoge el arma en formato String
	   */
	public Item(int vida, int damage,String arma) {
		super(vida, damage);	
		this.arma=arma;
	}
	
	//Funcion abstracta
	public abstract String devuelve_datos();
}
