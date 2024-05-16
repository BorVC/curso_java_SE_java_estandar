package graficos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import adaptadores.ComboboxModelComunidadesImpl;
import adaptadores.ComboboxModelProvinciasImpl;
import adaptadores.TablemodelMunicipiosImpl;
import model.Provincia;

public class VentanaComunidades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComunidades frame = new VentanaComunidades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaComunidades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COMUNIDADES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 32, 109, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProvincias = new JLabel("PROVINCIAS");
		lblProvincias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProvincias.setBounds(29, 72, 109, 14);
		contentPane.add(lblProvincias);
		
		//ComnoboxProvincias
		JComboBox<Provincia> comboProvincias = new JComboBox();
		comboProvincias.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String codigoProv=((Provincia)comboProvincias.getSelectedItem()).getCodigoProvincia();//Casting objeto Provincia
				if(e.getStateChange()==ItemEvent.SELECTED) {
					table.setModel(new TablemodelMunicipiosImpl(codigoProv));
				}
			}
		});
		comboProvincias.setBounds(160, 70, 168, 22);
		contentPane.add(comboProvincias);
		
		//ComboboxComunidades
		JComboBox<String> comboComunidades = new JComboBox();
		comboComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String comunidad = (String)comboComunidades.getSelectedItem();
				comboProvincias.setModel(new ComboboxModelProvinciasImpl(comunidad));
				
				//para borrar la tabla de municipios
				//de selecciones previas
				table.setModel(new DefaultTableModel());
				
			}
		});
		comboComunidades.setBounds(160, 30, 168, 22);
		contentPane.add(comboComunidades);
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 156, 434, 254);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel tableMunicipios = new JLabel("MUNICIPIOS");
		tableMunicipios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableMunicipios.setBounds(29, 131, 76, 14);
		contentPane.add(tableMunicipios);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaComunidades.this.dispose();
			}
		});
		btnSalir.setBounds(202, 440, 89, 23);
		contentPane.add(btnSalir);
		
		//CARGA DE COMUNIDADES
		comboComunidades.setModel(new ComboboxModelComunidadesImpl());
		
		JLabel jblReloj = new JLabel("");
		jblReloj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jblReloj.setBounds(401, 51, 85, 14);
		contentPane.add(jblReloj);
		
		//hilo reloj
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(() ->{
			//actulizar reloj cada medio segundo
			while(true) {
				LocalTime hora = LocalTime.now();
				jblReloj.setText(hora.toString());//Cambiar el texto del label pasando la hora a String
				Thread.sleep(500);//Actualizarlo cada 1/2 segundo
			}
		});
	}
}
