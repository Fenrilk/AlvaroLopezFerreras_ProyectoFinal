
public class Protagonista extends Item{
String nombre;//Nombre del personaje

  //Getters and setters
/**
 * 
 * @return devuelve un nombre en formato String
 */
  public String getNombre() {
	  return this.nombre;
  }
  /**
   * 
   * @param nombre recoge un nombre en formato String
   */
  public void setNombre(String nombre) {
	  this.nombre=nombre;
  }
  
  //Constructor
  /**
   * 
   * @param vida recoge la vida en formato int
   * @param damage recoge el daño en formato int
   * @param arma recoge el arma en formato String
   * @param nombre recoge un nombre en formato String
   */
  public Protagonista(int vida, int damage, String arma, String nombre) {
		super(vida, damage, arma);
		this.nombre=nombre;
		super.vida=vida;
		super.damage=damage;
	}
  
  //variable Abstracta
  //getter
  /**
   * Devuelve los datos del prota en formato String
   */
  public String devuelve_datos() {
		return getNombre()+"\n"
				+"   vida: "+getVida()+"\n"
				+"   daño: "+getDamage();
	}
  
  /**
   * 
   * @return devuelve un 1 si el nombre es mayor de tres espacios y si no devuelve 0 
   */
  public int comprobar_nombre() {
	  if(nombre.length()>=3) {
		  return 1;
	  }else {
		  return 0; 
	  }
  }
  
  //Polimorfismo
  /**
   * Lucha solo contra el slime
   * @param damage_prota daño del prota
   * @param vida_slime vida del slime
   * @return devuelve un 1 si el daño del prota es mayor a la vida y si no entonces devuleve un 0
   */
  public int combate(int damage_prota,int vida_slime) {	
		if(damage_prota>vida_slime) {
			return 1;
		}else {
			return 0;
		}
}
  /**
   * Lucha solo contra el boss
   * @param damage_prota daño del prota
   * @param vida_prota vida deprota
   * @param damage_boss daño del boss
   * @param vida_boss vida del boss
   * @return devuelve 1 si el daño y la vida prota es mayor que a la del boss y sino devuelve 0
   */
  public int combate(int damage_prota,int vida_prota,int damage_boss,int vida_boss) {	
		if(damage_prota>damage_boss && vida_prota>vida_boss) {
			return 1;
		}else {
			return 0;
		}
  }
  
  /**
   * Lucha con amistad contra el boss
   * @param damage_prota daño del prota
   * @param vida_prota vida del prota
   * @param vida_slime vida del slime
   * @param damage_boss daño del boss
   * @param vida_boss vida del boss
   * @return devuelve 1 si el daño y la vida prota junto con la vida del slime es mayor que a la del boss y sino devuelve 0
   */
  public int combate(int damage_prota,int vida_prota,int vida_slime,int damage_boss,int vida_boss) {	
		if(damage_prota>damage_boss && (vida_prota+vida_slime)>vida_boss) {
			return 1;
		}else {
			return 0;
		}
}
  
  
}
