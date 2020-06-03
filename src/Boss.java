
public class Boss extends Estadistica {

	public Boss(int vida, int damage) {
		super(vida, damage);
		this.vida=13;
		this.damage=13;
	}
	
	public static String morir(int numero) {
		if(numero==1) {
			return "Con tu gran poder magico que tenías escondido derrotaste "
					+ "al fantasma pero por desgracia no había princesa para salvar";
		}else {
			return "Tu impresionante ego y tu ignorancia te llevo a la muerte";
		}
	}
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
