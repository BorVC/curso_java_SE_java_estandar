package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		jbt1.setBounds(50, 50, 300, 50);
		this.add(jbt1);//Añade el componente botón a la ventana
		
	}

}
