
public class Slimo extends Estadistica {
	public static boolean es_amigo;// Si es amigo el slime

	//Constructor
	/**
	 * 
	 * @param vida del slime
	 * @param damage daño del slime
	 */
	public Slimo(int vida, int damage) {
		super(vida, damage);
		this.vida=12;
	}
	
	//Getters and Setters
	/**
	 * 
	 * @return devuelve una booleana si es amigo o no
	 */
	public  boolean getEs_amigo() {
		return this.es_amigo;
	};
	/**
	 * 
	 * @param amigo recoge una variable booleana si es amigo o no
	 */
	public void setEs_amigo(boolean amigo) {
		this.es_amigo=amigo;
	};

	/**
	 * 
	 * @param numero recoge el resultado de la batalla contra el slime
	 * @return devuelve una frase dependiendo si gana o pierda la batalla contra el slime
	 */
	public static String morir(int numero) {
		if(numero==1) {
			return "Mataste a un pobre slime que solo queria ser tu amigo. Eres muy cruel para que lo sepas";
		}else {
			return "Los slimes son adorables pero son las criaturas más peligrosas "
					+ "ya que no les afecta el ataque físico";
		}
	}
}
