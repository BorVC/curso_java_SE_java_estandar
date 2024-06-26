package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCalcu extends JFrame {

	//Constructor
	public VentanaCalcu() {
		super("JCalcu");
		this.setBounds(100,80,800,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Creacion y configueracion de controles
		initComponents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		this.setLayout(null);
		JLabel num1 = new JLabel("Número1: ");
		JLabel num2 = new JLabel("Número2: ");
		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JButton jbtSum = new JButton("Suma");
		JButton jbtMulti = new JButton("Multiplicación");
		JLabel jbl = new JLabel("Resultado: ");
		
		num1.setBounds(150,50,130,40);//Posición x ,y ,Ancho ,Alto		
		num2.setBounds(150,130,130,40);
		jtf1.setBounds(250,50,150,40);
		jtf2.setBounds(250,130,150,40);
		jbtSum.setBounds(120,220,150,50);
		jbtMulti.setBounds(360,220,150,50);
		jbl.setBounds(150,310,130,40);
		
		this.add(num1);
		this.add(num2);
		this.add(jtf1);
		this.add(jtf2);
		this.add(jbtSum);
		this.add(jbtMulti);
		this.add(jbl);
		
	}
}
