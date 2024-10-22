import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Acto{

	public static JFrame frmJuego;
	public static JLabel datos_pro;
	public static JLabel informe;
	public static JLabel espada;
	public static JLabel libro;
	private Image imagen;

/**
 * venta donde se produce la escena del prota que se encuentra con un slime 
 * En esta ventana se muesta el nombre y las estadistiscas del prota y aparte se muestra un texto narrando la historia
 * Segun que arma haya seleccionado el prota saldr� una frase personalizada en el texto de la historia
 * Te da a elgir entres tres opciones en esta ventana donde el prota puede morir o matar al slime, hacerse amigo del slime o pasar a la siguiente escena
 */
	public Acto() {
		//ejecucion de la ventana
		frmJuego = new JFrame();
		// un try/catch que comprueba si la direccion de imagen icono esta bien y si no te indica el program de que hay un error de icono
        Toolkit miPantalla=Toolkit.getDefaultToolkit();
        try {
			imagen=ImageIO.read(new File("src/iconjuego.png"));
			Image miIcono=miPantalla.getImage("src/iconjuego.png");
		    frmJuego.setIconImage(miIcono);

		} catch (IOException e1) {
			System.out.println("Error al cargar icono");
		}
	    		//frmJuego.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cenec\\eclipse-workspace\\prueba2\\src\\vista\\iconjuego.png"));
		frmJuego.setTitle("Juego");
		frmJuego.setBounds(100, 100, 881, 544);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuego.getContentPane().setLayout(null);
		frmJuego.setResizable(false);//Para no modificar el tama�o de la ventana
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 875, 97);
		frmJuego.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Boton 1 que ejecuta el evento de luchar contra slime
		JButton Opcion1 = new JButton("Opcion1");
		Opcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJuego.setVisible(false);
				evento1();
			}
		});
		//generar boton
		Opcion1.setForeground(Color.WHITE);
		Opcion1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Opcion1.setBounds(721, 11, 134, 68);
		Opcion1.setBackground(Color.GRAY);
		panel.add(Opcion1);
		
		//Boton 2 que ejecuta el evento de no hacer nada con el slime
		JButton Opcion2 = new JButton("Opcion2");
		Opcion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJuego.setVisible(false);
				evento2();
			}
		});
		//generar boton
		Opcion2.setForeground(Color.WHITE);
		Opcion2.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Opcion2.setBackground(Color.GRAY);
		Opcion2.setBounds(524, 11, 134, 68);
		panel.add(Opcion2);
		
		//Boton 3 que ejecuta el evento de hacerse amigo del slime
		JButton Opcion3 = new JButton("Opcion3");
		Opcion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmJuego.setVisible(false);
				evento3();
			}
		});
		// generar boton
		Opcion3.setForeground(Color.WHITE);
		Opcion3.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Opcion3.setBackground(Color.GRAY);
		Opcion3.setBounds(329, 11, 134, 68);
		panel.add(Opcion3);
		
		//Cuadro de texto donde aparece los datos del protagonista
	    datos_pro = new JLabel("");
	    datos_pro.setFont(new Font("Algerian", Font.BOLD, 13));
		datos_pro.setForeground(Color.WHITE);
		datos_pro.setBackground(Color.WHITE);
		datos_pro.setBounds(0, 0, 319, 90);
		panel.add(datos_pro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 379, 875, 136);
		frmJuego.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//Cuadro de texto donde se genera una frase personalizada
	    informe = new JLabel("");
	    informe.setBackground(Color.BLACK);
	    informe.setForeground(Color.WHITE);
		informe.setBounds(10, 0, 845, 26);
		panel_1.add(informe);
		
		//Cuadro de texto donde se genera una frase
		JLabel lblPeroSeEncontr = new JLabel("pero se encontr\u00F3 durante el camino un peque\u00F1o slime adorable \u00BFQu\u00E9 har\u00E1 el joven adventurero?");
		lblPeroSeEncontr.setForeground(Color.WHITE);
		lblPeroSeEncontr.setBounds(10, 26, 845, 26);
		panel_1.add(lblPeroSeEncontr);
		//Cuadro de texto donde se genera una frase
		JLabel informe_1 = new JLabel("Opcion 1-Pegarle una tremenda paliza");
		informe_1.setForeground(Color.WHITE);
		informe_1.setBackground(Color.WHITE);
		informe_1.setBounds(10, 48, 845, 26);
		panel_1.add(informe_1);
		//Cuadro de texto donde se genera una frase
		JLabel informe_2 = new JLabel("Opcion 2-Pasar de esa cosa ya que para que perder el tiempo");
		informe_2.setForeground(Color.WHITE);
		informe_2.setBackground(Color.WHITE);
		informe_2.setBounds(10, 75, 833, 26);
		panel_1.add(informe_2);
		//Cuadro de texto donde se genera una frase
		JLabel informe_3 = new JLabel("Opcion 3-Hacerse amigo del slime");
		informe_3.setForeground(Color.WHITE);
		informe_3.setBackground(Color.WHITE);
		informe_3.setBounds(10, 100, 845, 26);
		panel_1.add(informe_3);
		
		//Imagen del slime
		JLabel slime = new JLabel("");
		slime.setBounds(557, 327, 82, 69);
		ImageIcon sli=new ImageIcon(getClass().getResource("slime.png"));
		ImageIcon slimeAj=new ImageIcon(sli.getImage().getScaledInstance(slime.getWidth(), slime.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(slime);
		slime.setIcon(slimeAj);
		
		//Imagen de la espada
		espada = new JLabel("");
		espada.setBounds(50, 273, 55, 69);
		ImageIcon sword=new ImageIcon(getClass().getResource("espada.png"));
		ImageIcon swordAj=new ImageIcon(sword.getImage().getScaledInstance(espada.getWidth(), espada.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(espada);
		espada.setIcon(swordAj);
		//Imagen  del libro
		libro = new JLabel("");
		libro.setBounds(33, 309, 48, 47);
		ImageIcon book=new ImageIcon(getClass().getResource("libromago.png"));
		ImageIcon bookAj=new ImageIcon(book.getImage().getScaledInstance(libro.getWidth(), libro.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(libro);
		libro.setIcon(bookAj);
		//Imagen del protagonista		
		JLabel prota = new JLabel("");
		prota.setBounds(40, 266, 99, 90);
		ImageIcon protag=new ImageIcon(getClass().getResource("prota.png"));
		ImageIcon protagAj=new ImageIcon(protag.getImage().getScaledInstance(prota.getWidth(), prota.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(prota);
		prota.setIcon(protagAj);
		
		//Imagen del suelo
		JLabel tierra = new JLabel();
		tierra.setBounds(0, 133, 875, 263);
		ImageIcon suelo=new ImageIcon(getClass().getResource("suelo.png"));
		ImageIcon sueloAj=new ImageIcon(suelo.getImage().getScaledInstance(tierra.getWidth(), tierra.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(tierra);
		tierra.setIcon(sueloAj);

		// Un try/catch que comprueba si esta la imagen del fondo
		try {
			imagen=ImageIO.read(new File("cielo.jpg"));
		JLabel fondo_cielo = new JLabel("");
		fondo_cielo.setIcon(new ImageIcon("cielo.jpg"));
		fondo_cielo.setBounds(0, 85, 875, 297);
		frmJuego.getContentPane().add(fondo_cielo);
		}catch(Exception e) {
			JLabel fondo_cielo = new JLabel();
			fondo_cielo.setBounds(0, 85, 875, 297);
			ImageIcon fondo=new ImageIcon(getClass().getResource("cielo.jpg"));
			frmJuego.getContentPane().add(fondo_cielo);
			fondo_cielo.setIcon(fondo);
		}
	}
	
	/**
	 * Evento que realiza una pelea, si en el caso de que gana el slime la pelea 
	 * se abre la ventana final donde te indica con  una frase personalizada lo que te pas�.
	 * En el caso de que gana el prota, se abre la ventana de acto1 donde aparecera una frase 
	 * personalizada de lo que paso al slime 
	 */
	private void evento1() {
		Comienzo pelea = new Comienzo();
		Slimo slime = new Slimo(12,0);
		final Final evento1 = new Final();
		final Acto1 evento2 = new Acto1();
		//En el caso de que el resultado sea distinto de 1 se abre la venta final
		//si es igual a 1 entonces se ejecutar� la ventana de acto1 donde se mostrar� o no se mostrar� las armas 
		//y aparecera una frase personalizada de la muerte del slime
		if(pelea.getResultado()!=1) {
		evento1.descripcion.setText(slime.morir(pelea.getResultado()));
		evento1.frmJuego.setVisible(true);
		}else {
			//Mostrar arma seleccionada
			if(pelea.getArma_select()==1) {
				evento2.libro.setVisible(false);
				evento2.espada.setVisible(false);
			} else if(pelea.getArma_select()==2) {
				evento2.libro.setVisible(false);
			}else if(pelea.getArma_select()==3) {
				evento2.espada.setVisible(false);
			}
			//generar frase personalizada
			evento2.txt_evento.setText(slime.morir(pelea.getResultado()));
			evento2.slime.setVisible(false);
			evento2.frmJuego.setVisible(true);
			
		}
	}
	
	/**
	 * Evento que realiza es pasar del slime, se ejecuta la ventana de acto1.
	 * Se mostrara en la ventana1 el arma que seleccionaste y aparecer� una frase personalizada
	 */
	private void evento2() {
		Comienzo arma = new Comienzo();
		final Acto1 evento2 = new Acto1();
		//Mostrar arma seleccionada
			if(arma.getArma_select()==1) {
				evento2.libro.setVisible(false);
				evento2.espada.setVisible(false);
			} else if(arma.getArma_select()==2) {
				evento2.libro.setVisible(false);
			}else if(arma.getArma_select()==3) {
				evento2.espada.setVisible(false);
			}
			//generar frase personalizada
			evento2.txt_evento.setText("Supuestamente perdonaste la vida del slime, pero entre nosotros dos ten�as miedo de ese slime");
			evento2.slime.setVisible(false);
			evento2.frmJuego.setVisible(true);
		}
	
	/**
	 * Evento en el que se hace amigo del slime, en la ventana de acto1 donde
	 * se mostrar� el slime y el arma que seleccionaste aparte de la frase personalizada
	 */
	private void evento3() {
		Comienzo arma = new Comienzo();
	    Acto1 evento2 = new Acto1();
		Slimo slime = new Slimo(12,0);
		//Mostrar arma seleccionada
			if(arma.getArma_select()==1) {
				evento2.libro.setVisible(false);
				evento2.espada.setVisible(false);
			} else if(arma.getArma_select()==2) {
				evento2.libro.setVisible(false);
			}else if(arma.getArma_select()==3) {
				evento2.espada.setVisible(false);
			}
			//generar frase personalizada
			evento2.txt_evento.setText("Quien iba a decir que el mejor amigo del joven iba a ser un slime");
			slime.setEs_amigo(true);
			evento2.frmJuego.setVisible(true);
		}
	
	}






