
public class Slimo extends Estadistica {
	public static boolean es_amigo;

	public Slimo(int vida, int damage) {
		super(vida, damage);
		this.vida=12;
	}
	
	public  boolean getEs_amigo() {
		return this.es_amigo;
	};
	
	public void setEs_amigo(boolean amigo) {
		this.es_amigo=amigo;
	};

	public static String morir(int numero) {
		if(numero==1) {
			return "Mataste a un pobre slime que solo queria ser tu amigo. Eres muy cruel para que lo sepas";
		}else {
			return "Los slimes son adorables pero son las criaturas más peligrosas "
					+ "ya que no les afecta el ataque físico";
		}
	}
}
