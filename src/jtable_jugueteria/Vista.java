package jtable_jugueteria;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;

public class Vista extends JFrame {
	private JPanel contentPane;
	JTable tabla;
	JButton btnMostrarAlumnos;
	boolean vistaLanzada = false;

//	public static void main(String[] args) 
//	{
//		Vista v = new Vista();
//		v.lanzarGUI();
//	}

	public void lanzarGUI() {
		try {
			UIManager.setLookAndFeel( new FlatDarkLaf() ); 
			//new FlatLightLaf()
			//new FlatDarkLaf()
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crearGUI();
					setVisible(true);
					setLocationRelativeTo(null);
					vistaLanzada = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void crearGUI() {
		setResizable(false);
		setTitle("Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnMostrarAlumnos = new JButton("Mostrar Alumnos");
		btnMostrarAlumnos.setBounds(218, 251, 125, 33);
		contentPane.add(btnMostrarAlumnos);

		Object[][] datos = { { "", "", "", "", "", "", "" }, };
		String[] Encabezados = {"Id","Nombre","Precio","Marca","Categoria","Stock","Proveedor"};
		DefaultTableModel modelo = new DefaultTableModel(datos, Encabezados);
		tabla = new JTable(modelo);
		JScrollPane scrollpane = new JScrollPane(tabla);
		scrollpane.setBounds(56, 34, 450, 192);
		contentPane.add(scrollpane);
	}
}
