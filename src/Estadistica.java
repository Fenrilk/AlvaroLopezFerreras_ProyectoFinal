
public abstract class Estadistica {
	 int vida;
	 int damage; 
	 
	 public int getVida() {
		 return vida;
	 }

	 public void setVida(int vida) {
		 this.vida = vida;
	 }
	 
	 public int getDamage() {
		 return damage;
	 }

	 public void setDamage(int damage) {
		 this.damage = damage;
	 }
	 
	 public Estadistica(int vida, int damage) {
		 vida=this.vida;
		 damage=this.damage;
	 }

}
