package jtable_jugueteria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener 
{
	Modelo mod;
	Vista vis;
	public Controlador(Modelo mod, Vista vis) 
	{
		this.mod = mod;
		this.vis = vis;
		addListeners();
	}
	
	private void addListeners() 
	{
		vis.lanzarGUI();
		while(!vis.vistaLanzada)
		{
			System.out.println("cargando..");
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vis.btnMostrarAlumnos.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == vis.btnMostrarAlumnos)
		{
			startTable();
		}
	}
	
	private void startTable() 
	{
		DefaultTableModel model = (DefaultTableModel) vis.tabla.getModel();
		DefaultTableModel modelToys = mod.showToysTable(model);
		vis.tabla.setModel(modelToys);
		JOptionPane.showMessageDialog(null, "Juguetes listados correctamente!");
	}
}
