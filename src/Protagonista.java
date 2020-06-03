
public class Protagonista extends Item{
String nombre;

  
  public String getNombre() {
	  return this.nombre;
  }
  public void setNombre(String nombre) {
	  this.nombre=nombre;
  }
  
  public Protagonista(int vida, int damage, String arma, String nombre) {
		super(vida, damage, arma);
		this.nombre=nombre;
		super.vida=vida;
		super.damage=damage;
	}
  
  public String devuelve_datos() {      //getter
		return getNombre()+"\n"
				+"   vida: "+getVida()+"\n"
				+"   daño: "+getDamage();
	}
  
  public int comprobar_nombre() {
	  if(nombre.length()>=3) {
		  return 1;
	  }else {
		  return 0; 
	  }
  }
  
  public int combate(int damage_prota,int vida_slime) {	
		if(damage_prota>vida_slime) {
			return 1;
		}else {
			return 0;
		}
}
  
  public int combate(int damage_prota,int vida_prota,int damage_boss,int vida_boss) {	
		if(damage_prota>damage_boss && vida_prota>vida_boss) {
			return 1;
		}else {
			return 0;
		}
  }
  
  public int combate(int damage_prota,int vida_prota,int vida_slime,int damage_boss,int vida_boss) {	
		if(damage_prota>damage_boss && (vida_prota+vida_slime)>vida_boss) {
			return 1;
		}else {
			return 0;
		}
}
  
  
}
