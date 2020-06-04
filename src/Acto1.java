import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Acto1 {

	public static JFrame frmJuego;
	public static JLabel txt_evento;
	public  JLabel espada;
	public  JLabel libro;
	public static JLabel datos_pro;
	public static JLabel slime;
	private Image imagen;
	
	/**
	 * Ventana en la que solamente se hara la pelea contra el boss que dependiendo de lo que hayas 
	 * seleccionado tendra un final distinto
	 */
	public Acto1() {
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
		frmJuego.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 875, 90);
		frmJuego.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Boton pelear que ejecuta el evento final
		JButton luchar = new JButton("Pelear");
		luchar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento_final();
				frmJuego.setVisible(false);
			}
		});
		//generar boton
		luchar.setForeground(Color.WHITE);
		luchar.setFont(new Font("Arial Black", Font.PLAIN, 18));
		luchar.setBounds(721, 11, 134, 68);
		luchar.setBackground(Color.GRAY);
		panel.add(luchar);
		
		//Cuadro de texto donde aparace los datos del prota
		Comienzo datos=new Comienzo();
		datos_pro = new JLabel("");
		datos_pro.setForeground(Color.WHITE);
		datos_pro.setFont(new Font("Algerian", Font.BOLD, 13));
		datos_pro.setText(datos.getDatos());
		datos_pro.setBackground(Color.BLACK);
		datos_pro.setBounds(0, 0, 429, 90);
		panel.add(datos_pro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 379, 875, 136);
		frmJuego.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//Cuadro de texto donde se genera la frase de lo que paso en el evneto anterior
		txt_evento = new JLabel("");
		txt_evento.setForeground(Color.WHITE);
		txt_evento.setBounds(10, 11, 845, 42);
		panel_1.add(txt_evento);
		
		//Cuadro de texto
		JLabel txt_luchafinal = new JLabel("Ahora es la batalla final, si derrota al fantasma puede ser que te recuerden como un h\u00E9roe, ve a por tu preciada victoria");
		txt_luchafinal.setForeground(Color.WHITE);
		txt_luchafinal.setBounds(10, 41, 845, 42);
		panel_1.add(txt_luchafinal);
		ImageIcon protag=new ImageIcon(getClass().getResource("prota.png"));
		//Imagen de espada
		espada = new JLabel("");
		espada.setBounds(37, 284, 28, 37);
		ImageIcon sword=new ImageIcon(getClass().getResource("espada.png"));
		ImageIcon swordAj=new ImageIcon(sword.getImage().getScaledInstance(espada.getWidth(), espada.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(espada);
		espada.setIcon(swordAj);
		//Imagen de libro
		libro = new JLabel("");
		libro.setBounds(31, 297, 28, 26);
		ImageIcon book=new ImageIcon(getClass().getResource("libromago.png"));
		ImageIcon bookAj=new ImageIcon(book.getImage().getScaledInstance(libro.getWidth(), libro.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(libro);
		libro.setIcon(bookAj);
		
		//Imagen de slime
	    slime = new JLabel("");
		slime.setBounds(51, 297, 47, 37);
		ImageIcon sli=new ImageIcon(getClass().getResource("slime.png"));
		ImageIcon slimeAj=new ImageIcon(sli.getImage().getScaledInstance(slime.getWidth(), slime.getHeight(), Image.SCALE_SMOOTH));
		
		//Imagen de prota
		JLabel prota = new JLabel("");
		prota.setBounds(31, 284, 47, 37);
		ImageIcon protagAj=new ImageIcon(protag.getImage().getScaledInstance(prota.getWidth(), prota.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(prota);
		prota.setIcon(protagAj);
		frmJuego.getContentPane().add(slime);
		slime.setIcon(slimeAj);

		//Imagen del boss
		JLabel boss = new JLabel("");
		boss.setBounds(557, 144, 244, 350);
		ImageIcon jefe=new ImageIcon(getClass().getResource("boss.png"));
		ImageIcon jefeAj=new ImageIcon(jefe.getImage().getScaledInstance(boss.getWidth(), boss.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(boss);
		boss.setIcon(jefeAj);
		
		//Imgen del suelo
		JLabel sueloBoss = new JLabel();
		sueloBoss.setBounds(0, 310, 547, 72);
		ImageIcon suelo=new ImageIcon(getClass().getResource("sueloBoss.png"));
		ImageIcon sueloAj=new ImageIcon(suelo.getImage().getScaledInstance(sueloBoss.getWidth(), sueloBoss.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(sueloBoss);
		sueloBoss.setIcon(sueloAj);

		//Imagen del fondo
		JLabel fondo_boss = new JLabel("");
		fondo_boss.setBounds(0, 85, 875, 297);
		ImageIcon fondo=new ImageIcon(getClass().getResource("fondoBoss.png"));
		ImageIcon fondoAj=new ImageIcon(fondo.getImage().getScaledInstance(fondo_boss.getWidth(), fondo_boss.getHeight(), Image.SCALE_SMOOTH));
		frmJuego.getContentPane().add(fondo_boss);
		fondo_boss.setIcon(fondoAj);
		

	}
	
	/**
	 * evento final donde se generará la ventana final y dependiendo de las elecciones 
	 * tendras distinto tipo de lucha
	 */
	private void evento_final() {
		Final fin = new Final();
		Comienzo personaje =  new Comienzo();
		Slimo slime = new Slimo(12,0);
		Boss jefe = new Boss(13,13);
		//Si en el evento anterior si se ha hecho amigo del slime entonces se generará las
		//frases personalizadas en la ventana final 
		//Pero si no eres amgo entonces se generará frases distintas personalizadas
		if(slime.getEs_amigo()) {
			fin.descripcion.setText(
					jefe.morir(personaje.getResultado_final2(), slime.getEs_amigo()));
				
		}else {
			fin.descripcion.setText(
			jefe.morir(personaje.getResultado_final1()));
		}
		datos_pro.setText(personaje.getDatos());
	fin.frmJuego.setVisible(true);	
		
	}
}