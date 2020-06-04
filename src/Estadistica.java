
public abstract class Estadistica {
	 int vida;//Vida de cada ser
	 int damage; //Daño de cada ser
	 
	 
	 //Generar getters and setters
	 /**
	  * 
	  * @return devuelve la vida en formato int
	  */
	 public int getVida() {
		 return vida;
	 }

	 /**
	  * 
	  * @param vida recoge la vida en formato int
	  */
	 public void setVida(int vida) {
		 this.vida = vida;
	 }
	 
	 /**
	  * 
	  * @return devuelve el daño de formato int
	  */
	 public int getDamage() {
		 return damage;
	 }

	 /**
	  * 
	  * @param damage recoge el daño en formato int
	  */
	 public void setDamage(int damage) {
		 this.damage = damage;
	 }
	 
	 //Constructor
	 /**
	  * 
	  * @param vida recoge la vida en formato int
	  * @param damage recoge el daño en formato int
	  */
	 public Estadistica(int vida, int damage) {
		 vida=this.vida;
		 damage=this.damage;
	 }

}
