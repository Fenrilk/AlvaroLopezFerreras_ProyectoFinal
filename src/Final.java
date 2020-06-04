import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class Final {

	public static JFrame frmJuego;
	public static JLabel descripcion;
	private Image imagen;
	
	/**
	 * Ventana final donde te dice tu motivo de haber perdido o ganado y dos botones que son 
	 * el de volver a jugar o de salir del juego.
	 */
	public Final() {
		
		frmJuego = new JFrame();
		frmJuego.setTitle("Juego");
		
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
		//generar ventana
        frmJuego.setBounds(100, 100, 881, 544);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuego.getContentPane().setLayout(null);
		frmJuego.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 875, 515);
		frmJuego.getContentPane().add(panel);
		panel.setLayout(null);
		//Cuadro de texto
		JLabel fin = new JLabel("Tu final");
		fin.setFont(new Font("Kristen ITC", Font.BOLD, 74));
		fin.setHorizontalAlignment(SwingConstants.CENTER);
		fin.setForeground(Color.RED);
		fin.setBounds(214, 57, 419, 80);
		panel.add(fin);
		//Boton de volver a jugar que ejecuta de nuevo el juego
		JButton reinicio = new JButton("Volver a jugar");
		reinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comienzo repetir =new Comienzo();
				Slimo slime = new Slimo(12,0);
				slime.setEs_amigo(false);
				repetir.frmJuego.setVisible(true);
				frmJuego.setVisible(false);
			}
		});
		reinicio.setBounds(343, 358, 157, 23);
		panel.add(reinicio);
		
		//Cuadro de texto donde se genera la frase personalizada de tu final
		descripcion = new JLabel("");
		descripcion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		descripcion.setForeground(Color.WHITE);
		descripcion.setBackground(Color.BLACK);
		descripcion.setBounds(10, 252, 845, 95);
		panel.add(descripcion);
		
		//Boton de salir del juego
		JButton btnSalir = new JButton("salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(371, 458, 89, 23);
		panel.add(btnSalir);
	}
}
