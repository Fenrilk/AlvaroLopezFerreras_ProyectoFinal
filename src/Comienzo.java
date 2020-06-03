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
	
	public Comienzo() {
		frmJuego = new JFrame();
		frmJuego.setTitle("Juego");
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 865, 505);
		frmJuego.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(Color.WHITE);
		textField.setBounds(342, 136, 184, 20);
		panel.add(textField);
		textField.setColumns(10);
		
	    txt_item = new JLabel("");
		txt_item.setFont(new Font("Tahoma", Font.PLAIN, 5));
		txt_item.setBackground(Color.BLACK);
		txt_item.setBounds(60, 116, 46, 14);
		panel.add(txt_item);
		
		JLabel lblDimeTuNombre = new JLabel("Dime tu nombre");
		lblDimeTuNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblDimeTuNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		lblDimeTuNombre.setForeground(Color.WHITE);
		lblDimeTuNombre.setBounds(277, 62, 313, 50);
		panel.add(lblDimeTuNombre);
		
		JLabel lblEscogeArma = new JLabel("Escoge arma");
		lblEscogeArma.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscogeArma.setForeground(Color.WHITE);
		lblEscogeArma.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
		lblEscogeArma.setBounds(277, 192, 313, 50);
		panel.add(lblEscogeArma);
		
		final Acto vslime=new Acto();
		
	    puno = new JButton("puno");
		puno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento1();
			}
		});
		puno.setBackground(Color.BLACK);
		puno.setBounds(113, 293, 144, 133);
		ImageIcon punch=new ImageIcon(getClass().getResource("puno.png"));
		ImageIcon punchAj=new ImageIcon(punch.getImage().getScaledInstance(puno.getWidth(), puno.getHeight(), Image.SCALE_SMOOTH));
		puno.setIcon(punchAj);
		panel.add(puno);
		
		final JButton espada = new JButton("espada");
		espada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				 evento2();
			}
		});
		espada.setBackground(Color.BLACK);
		espada.setBounds(343, 289, 144, 137);
		ImageIcon sword=new ImageIcon(getClass().getResource("espada.png"));
		ImageIcon swordAj=new ImageIcon(sword.getImage().getScaledInstance(espada.getWidth(), espada.getHeight(), Image.SCALE_SMOOTH));
		espada.setIcon(swordAj);
		panel.add(espada);
		
		final JButton libro = new JButton("libro");
		libro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento3();
			}
		});
		libro.setBackground(Color.BLACK);
		libro.setBounds(573, 293, 165, 133);
		ImageIcon book=new ImageIcon(getClass().getResource("libromago.png"));
		ImageIcon bookAj=new ImageIcon(book.getImage().getScaledInstance(libro.getWidth(), libro.getHeight(), Image.SCALE_SMOOTH));
		libro.setIcon(bookAj);
		panel.add(libro);
		
	}
	
	
	private void evento1(){
		final Acto vslime=new Acto();
		txt_item.setText("puno");
		final Protagonista prota=new Protagonista(10,5,txt_item.getText(),textField.getText());
		if(prota.comprobar_nombre()==1) {
			prota.setNombre(textField.getText());
			//System.out.println(prota.devuelve_datos());
			setArma_select(1);
			vslime.libro.setVisible(false);
			vslime.espada.setVisible(false);
			vslime.datos_pro.setText(prota.devuelve_datos());
			setDatos(prota.devuelve_datos());
			vslime.frmJuego.setVisible(true);
			frmJuego.setVisible(false);
		}else if(prota.comprobar_nombre()==0){
			JOptionPane.showMessageDialog(null, "Debes Ingresar un Nombre con más de tres letras");
		}
		
	}
	
	
	
	private void evento2(){
		final Acto vslime=new Acto();
		txt_item.setText("espada");
		final Protagonista prota=new Protagonista(10,10,txt_item.getText(),textField.getText());
		if(prota.comprobar_nombre()==1) {
			prota.setNombre(textField.getText());
			//System.out.println(prota.devuelve_datos());
			setArma_select(2);
			vslime.libro.setVisible(false);
			vslime.datos_pro.setText(prota.devuelve_datos());
			setDatos(prota.devuelve_datos());
			vslime.frmJuego.setVisible(true);
			frmJuego.setVisible(false);
		}else if(prota.comprobar_nombre()==0){
			JOptionPane.showMessageDialog(null, "Debes Ingresar un Nombre con más de tres letras");
		}
		
	}
	
	
	private void evento3(){
		final Acto vslime=new Acto();
		Slimo slime=new Slimo(12,0);
		Boss vsboss=new Boss(13,13);
		txt_item.setText("libro");
		final Protagonista prota=new Protagonista(15,15,txt_item.getText(),textField.getText());
		setResultado(prota.combate(prota.getDamage(), slime.getVida()));
		setResultado_final2(prota.combate(prota.getDamage(), prota.getVida(),slime.getVida(),vsboss.getDamage(),vsboss.getVida()));
		setResultado_final1(prota.combate(prota.getDamage(), prota.getVida(),vsboss.getDamage(),vsboss.getVida()));
		if(prota.comprobar_nombre()==1) {
			prota.setNombre(textField.getText());
			//System.out.println(prota.devuelve_datos());
			setArma_select(3);
			vslime.espada.setVisible(false);
			vslime.datos_pro.setText(prota.devuelve_datos());
			setDatos(prota.devuelve_datos());
			vslime.informe.setText("El joven mago comenzó su aventura para derrotar al gran jefe que aterraba la ciudad,");
			vslime.frmJuego.setVisible(true);
			frmJuego.setVisible(false);
		}else if(prota.comprobar_nombre()==0){
			JOptionPane.showMessageDialog(null, "Debes Ingresar un Nombre con más de tres letras");
		}
		
	}
	
	public int getResultado() {
		return this.resultado;
	}
	
	public void setResultado(int resultado) {
		this.resultado=resultado;
	}
	
	public int getResultado_final1() {
		return this.resultado1;
	}
	
	public void setResultado_final1(int resultado1) {
		this.resultado1=resultado1;
	}
	
	public int getResultado_final2() {
		return this.resultado2;
	}
	
	public void setResultado_final2(int resultado2) {
		this.resultado2=resultado2;
	}
	public int getArma_select() {
		return this.arma_select;
	}
	
	public void setArma_select(int arma_select) {
		this.arma_select=arma_select;
	}
	
	public String getDatos() {
		return this.datos;
	}
	
	public void setDatos(String datos) {
		this.datos=datos;
	}
	
	
}
