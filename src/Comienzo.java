import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Comienzo{

	public static JFrame frmJuego;
	public static JTextField textField;
	public static JLabel txt_item;
	public static JButton puno;
	public static int resultado;
	public static int resultado1;
	public static int resultado2;
	public static int arma_select;
	public static String datos;
	private Image imagen;
	
	/**
	 * Ejecuta una ventana donde pregunta por el nombre y selecciona entre tres botones (que son armas)
	 * Si no introduce un nombre y hace un click a un boton te saltara un aviso de que tiene que introducir un nombre 
	 * Una vez introducido el nombre y hayas seleccionado un boton se ejecuta los eventos que estos eventos guardara los datos del personaje 
	 * y tambien guardará los datos si gana un combate o lo pierde 
	 * Despues de todo este proceso abre la siguiente ventana de Acto
	 */
	public Comienzo() {
		frmJuego = new JFrame();
		//Creacion de ventana
		frmJuego.setTitle("Juego");//titulo de la ventana	
		
		// un try/catch que comprueba si la direccion de imagen icono esta bien y si no te indica el program de que hay un error de icono
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
        try {
			imagen=ImageIO.read(new File("src/iconjuego.png"));
			Image miIcono=miPantalla.getImage("src/iconjuego.png");
		    frmJuego.setIconImage(miIcono);

		} catch (IOException e1) {
			System.out.println("Error al cargar icono");
		}
        //frmJuego.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cenec\\eclipse-workspace\\AlvaroLopezFerreras\\src\\iconjuego.png"));
		
        frmJuego.setBounds(100, 100, 881, 544);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuego.getContentPane().setLayout(null);
		frmJuego.setResizable(false);// Para que la ventana no se modifique su tamaño
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 875, 515);
		frmJuego.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Barra donde recoge el nombre que introduzcas
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(Color.WHITE);
		textField.setBounds(342, 136, 184, 20);
		panel.add(textField);
		textField.setColumns(10);
		//Recoge que item has seleccionado
	    txt_item = new JLabel("");
		txt_item.setFont(new Font("Tahoma", Font.PLAIN, 5));
		txt_item.setBackground(Color.BLACK);
		txt_item.setBounds(60, 116, 46, 14);
		panel.add(txt_item);
		//Texto 
		JLabel lblDimeTuNombre = new JLabel("Dime tu nombre");
		lblDimeTuNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblDimeTuNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		lblDimeTuNombre.setForeground(Color.WHITE);
		lblDimeTuNombre.setBounds(277, 62, 313, 50);
		panel.add(lblDimeTuNombre);
		//Texto
		JLabel lblEscogeArma = new JLabel("Escoge arma");
		lblEscogeArma.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscogeArma.setForeground(Color.WHITE);
		lblEscogeArma.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		lblEscogeArma.setBounds(277, 192, 313, 50);
		panel.add(lblEscogeArma);
		
		final Acto vslime=new Acto();
		//Boton puño que inicia el evento 1
	    puno = new JButton("puno");
		puno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento1();
			}
		});
		//La imagen que contiene boton puño ajustandose al tamaño del boton
		puno.setBackground(Color.BLACK);
		puno.setBounds(113, 293, 144, 133);
		ImageIcon punch=new ImageIcon(getClass().getResource("puno.png"));
		ImageIcon punchAj=new ImageIcon(punch.getImage().getScaledInstance(puno.getWidth(), puno.getHeight(), Image.SCALE_SMOOTH));
		puno.setIcon(punchAj);
		panel.add(puno);
		
		
		//Boton espada que inicia el evento 2
		final JButton espada = new JButton("espada");
		espada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				 evento2();
			}
		});
		//La imagen que contiene boton espada ajustandose al tamaño del boton
		espada.setBackground(Color.BLACK);
		espada.setBounds(343, 289, 144, 137);
		ImageIcon sword=new ImageIcon(getClass().getResource("espada.png"));
		ImageIcon swordAj=new ImageIcon(sword.getImage().getScaledInstance(espada.getWidth(), espada.getHeight(), Image.SCALE_SMOOTH));
		espada.setIcon(swordAj);
		panel.add(espada);
		
		
		//Boton libro que inicia el evento 3
		final JButton libro = new JButton("libro");
		libro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento3();
			}
		});
		//La imagen que contiene boton libro ajustandose al tamaño del boton
		libro.setBackground(Color.BLACK);
		libro.setBounds(573, 293, 165, 133);
		ImageIcon book=new ImageIcon(getClass().getResource("libromago.png"));
		ImageIcon bookAj=new ImageIcon(book.getImage().getScaledInstance(libro.getWidth(), libro.getHeight(), Image.SCALE_SMOOTH));
		libro.setIcon(bookAj);
		panel.add(libro);
		
	}
	
	/**
	 * Ejecuta las funciones de boton puño donde se inicia las estadisticas del prota(con stats de puño), del slime y del boss.
	 * Recoge el resultado de todos los tipos de combates que puede tener el prota e indica en la ventana de Acto que arma se
	 * visualiza, que datos debe mostrar y que frase debe poner.
	 */
	private void evento1(){
		final Acto vslime=new Acto();
		//ejecucion de las estadisticas de cada ser
		Slimo slime=new Slimo(12,0);
		Boss vsboss=new Boss(13,13);
		txt_item.setText("puno");
		final Protagonista prota=new Protagonista(10,5,txt_item.getText(),textField.getText());
		//recoger el resultado de todos los tipos de combate
		setResultado(prota.combate(prota.getDamage(), slime.getVida()));
		setResultado_final2(prota.combate(prota.getDamage(), prota.getVida(),slime.getVida(),vsboss.getDamage(),vsboss.getVida()));
		setResultado_final1(prota.combate(prota.getDamage(), prota.getVida(),vsboss.getDamage(),vsboss.getVida()));
		//Comprueba si en textField si se ha escrito un nombre con mas de tres letras y si no salta una ventana emergente de aviso que tiene que ingresar nombre
		if(prota.comprobar_nombre()==1) {
			//Guarda el nombre
			prota.setNombre(textField.getText());
			//System.out.println(prota.devuelve_datos());
			//Recoge el arma que has seleccionado
			setArma_select(1);
			//Mostrar o no mostrar imagenes de la ventana de acto
			vslime.libro.setVisible(false);
			vslime.espada.setVisible(false);
			//Envia los datos del personaje
			vslime.datos_pro.setText(prota.devuelve_datos());
			vslime.informe.setText("El joven comenzó su aventura para derrotar al gran jefe que aterraba la ciudad,");
			setDatos(prota.devuelve_datos());
			//Ejecuta la ventana Acto
			vslime.frmJuego.setVisible(true);
			frmJuego.setVisible(false);
		}else if(prota.comprobar_nombre()==0){
			JOptionPane.showMessageDialog(null, "Debes Ingresar un Nombre con más de tres letras");
		}
		
	}
	
	
	/**
	 * Ejecuta las funciones de boton puño donde se inicia las estadisticas del prota(con stats de espada), del slime y del boss.
	 * Recoge el resultado de todos los tipos de combates que puede tener el prota e indica en la ventana de Acto que arma se
	 * visualiza, que datos debe mostrar y que frase debe poner.
	 */
	private void evento2(){
		final Acto vslime=new Acto();
		//ejecucion de las estadisticas de cada ser
		Slimo slime=new Slimo(12,0);
		Boss vsboss=new Boss(13,13);
		txt_item.setText("espada");
		final Protagonista prota=new Protagonista(10,10,txt_item.getText(),textField.getText());
		//recoger el resultado de todos los tipos de combate
		setResultado(prota.combate(prota.getDamage(), slime.getVida()));
		setResultado_final2(prota.combate(prota.getDamage(), prota.getVida(),slime.getVida(),vsboss.getDamage(),vsboss.getVida()));
		setResultado_final1(prota.combate(prota.getDamage(), prota.getVida(),vsboss.getDamage(),vsboss.getVida()));
		//Comprueba si en textField si se ha escrito un nombre con mas de tres letras y si no salta una ventana emergente de aviso que tiene que ingresar nombre
		if(prota.comprobar_nombre()==1) {
			//Guarda el nombre
			prota.setNombre(textField.getText());
			//System.out.println(prota.devuelve_datos());
			//Recoge el arma que has seleccionado
			setArma_select(2);
			//Mostrar o no mostrar imagenes de la ventana de acto
			vslime.libro.setVisible(false);
			//Envia los datos del personaje
			vslime.datos_pro.setText(prota.devuelve_datos());
			setDatos(prota.devuelve_datos());
			vslime.informe.setText("El joven espadachín comenzó su aventura para derrotar al gran jefe que aterraba la ciudad,");
			//Ejecuta la ventana Acto
			vslime.frmJuego.setVisible(true);
			frmJuego.setVisible(false);
		}else if(prota.comprobar_nombre()==0){
			JOptionPane.showMessageDialog(null, "Debes Ingresar un Nombre con más de tres letras");
		}
		
	}
	
	/**
	 * Ejecuta las funciones de boton libro donde se inicia las estadisticas del prota(con stats de libro), del slime y del boss.
	 * Recoge el resultado de todos los tipos de combates que puede tener el prota e indica en la ventana de Acto que arma se
	 * visualiza, que datos debe mostrar y que frase debe poner.
	 */
	private void evento3(){
		final Acto vslime=new Acto();
		//ejecucion de las estadisticas de cada ser
		Slimo slime=new Slimo(12,0);
		Boss vsboss=new Boss(13,13);
		txt_item.setText("libro");
		final Protagonista prota=new Protagonista(15,15,txt_item.getText(),textField.getText());
		//recoger el resultado de todos los tipos de combate
		setResultado(prota.combate(prota.getDamage(), slime.getVida()));
		setResultado_final2(prota.combate(prota.getDamage(), prota.getVida(),slime.getVida(),vsboss.getDamage(),vsboss.getVida()));
		setResultado_final1(prota.combate(prota.getDamage(), prota.getVida(),vsboss.getDamage(),vsboss.getVida()));
		//Comprueba si en textField si se ha escrito un nombre con mas de tres letras y si no salta una ventana emergente de aviso que tiene que ingresar nombre
		if(prota.comprobar_nombre()==1) {
			//Guarda el nombre
			prota.setNombre(textField.getText());
			//System.out.println(prota.devuelve_datos());
			//Recoge el arma que has seleccionado
			setArma_select(3);
			//Mostrar o no mostrar imagenes de la ventana de acto
			vslime.espada.setVisible(false);
			vslime.datos_pro.setText(prota.devuelve_datos());
			setDatos(prota.devuelve_datos());
			vslime.informe.setText("El joven mago comenzó su aventura para derrotar al gran jefe que aterraba la ciudad,");
			//Ejecuta la ventana Acto
			vslime.frmJuego.setVisible(true);
			frmJuego.setVisible(false);
		}else if(prota.comprobar_nombre()==0){
			JOptionPane.showMessageDialog(null, "Debes Ingresar un Nombre con más de tres letras");
		}
		
	}
	//Ejecucion de getters and setters
	/**
	 * 
	 * @return devuelve el resultado del combate contra el slime en formato int
	 */
	public int getResultado() {
		return this.resultado;
	}
	/**
	 * 
	 * @param recoge el resultado del combate contra el slime en formato int
	 */
	public void setResultado(int resultado) {
		this.resultado=resultado;
	}
	/**
	 * 
	 * @return devuelve el resultado1 del combate contra el boss sin amistad en formato int
	 */
	public int getResultado_final1() {
		return this.resultado1;
	}
	
	/**
	 * 
	 * @param recoge el resultado1 del combate contra el boss sin amistad en formato int
	 */
	public void setResultado_final1(int resultado1) {
		this.resultado1=resultado1;
	}
	
	/**
	 * 
	 * @return devuelve el resultado2 del combate contra el boss con amistad en formato int
	 */
	public int getResultado_final2() {
		return this.resultado2;
	}
	
	/**
	 * 
	 * @param recoge el resultado1 del combate contra el boss con amistad en formato int
	 */
	public void setResultado_final2(int resultado2) {
		this.resultado2=resultado2;
	}
	
	/**
	 * 
	 * @return devuelve un numero que se asocia a un arma
	 */
	public int getArma_select() {
		return this.arma_select;
	}
	
	/**
	 * 
	 * @return recoge un numero que se asocia a un arma
	 */
	public void setArma_select(int arma_select) {
		this.arma_select=arma_select;
	}
	
	/**
	 * 
	 * @return devuelve los datos en forma de string
	 */
	public String getDatos() {
		return this.datos;
	}
	
	/**
	 * 
	 * @return recoge los datos en forma de string
	 */
	public void setDatos(String datos) {
		this.datos=datos;
	}
	
	
}
