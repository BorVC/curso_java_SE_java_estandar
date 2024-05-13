package graficos;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaControles extends JFrame {
	//Constructor
	public VentanaControles() {
		super("Ventana Cpontroles");
		this.setBounds(100,80,800,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Creacion y configueracion de controles
		initComponents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		//Para colocar los componentes de forma manual
		this.setLayout(null);
		JButton jbt1 = new JButton("Pulsar aqui");
		JLabel jlbl1=new JLabel();
		JButton jbt2 = new JButton("Colorear");
		
		jbt1.setBounds(50, 50, 300, 50);
		jlbl1.setBounds(100, 100, 150, 40);
		jbt2.setBounds(100,100,150,40);
		
		//Añade el componente botón a la ventana
		this.add(jbt1);
		this.add(jlbl1);
		this.add(jbt2);
		
		//Gestión de eventos
		//ActionListener listener = e -> jbt1.setText("Ha pulsado");//Evento del BOTÓN
		ActionListener listener=e -> jlbl1.setText("Ha pulsado");//EVENTO EN EL LABEL
		ActionListener listener2 = e -> VentanaControles.this.getContentPane().setBackground(Color.yellow);
		
		
		//Asociar el evento al componente(poner a la escucha)
		//jbt1.addActionListener(listener);
		jbt1.addActionListener(listener);
		jbt2.addActionListener(listener2);
		
	}

}
