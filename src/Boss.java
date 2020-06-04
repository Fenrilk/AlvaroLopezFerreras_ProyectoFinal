
public class Boss extends Estadistica {
//Constructor
	/**
	 * 
	 * @param vida sera igual a 13
	 * @param damage sera igual a 13
	 */
	public Boss(int vida, int damage) {
		super(vida, damage);
		this.vida=13;
		this.damage=13;
	}
	//Polimorfismo
	/**
	 * Resultado de combate de prota vs boss
	 * @param numero variable que indica el resultado del combate
	 * @return devuelve una frase dependiendo de si el prota gana al boss o no
	 */
	public static String morir(int numero) {
		if(numero==1) {
			return "Con tu gran poder magico que tenías escondido derrotaste "
					+ "al fantasma pero por desgracia no había princesa para salvar";
		}else {
			return "Tu impresionante ego y tu ignorancia te llevo a la muerte";
		}
	}
	/**
	 * Resultado de combate de prota y slime vs boss
	 * @param numero variable que indica el resultado del combate
	 * @param slime_amigo confirmar si es amigo el slime
	 * @return devuelve una frase dependiendo de si el prota con el slime gana al boss o no
	 */
	public static String morir(int numero,boolean slime_amigo) {
		if(numero==1&&slime_amigo) {
			return "Con tu increible poder mágico y por el poder de la amistad derrotasteis al gran fantasma "
					+ "o eso creían ellos";
		}else {
			return "Mandaste a tu amigo slime que se lo comiera pero se cayó al vacio entonces te "
					+ "lanzaste, pero caiste tambien";
		}
	}

}
