package jtable_jugueteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Modelo 
{
	Connection con;
	List<Juguete> toyList;
	List<Proveedor> supplierList;
	private void conectConn() 
	{
		String server = "jdbc:mysql://localhost/jugueteriajc";
		String user = "andres";
		String password = "qwerty123456";
		
		try {
			con = DriverManager.getConnection(server,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con==null)
		{
			System.out.println("Erro en la conexion!!");
		}
	}
	
	//imprime los datos de cada juguete de la lista
	public void showToys()
	{
		readToys();		
		System.out.println("\nId_Toy\tNom\tPre\tMarc\tCat\tStock\tId_Prov");
		for (Juguete jug : toyList) 
		{
			System.out.println(jug.toString());
		}
	}
	
	//lee registros bd y los guarda en una lista
	private void readToys() 
	{
		conectConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT * FROM juguetes;";
		
		toyList = new ArrayList<>();
		try 
		{
			pstm = con.prepareStatement(query);
			rs=pstm.executeQuery();
			
			while(rs.next())
			{
				toyList.add(new Juguete(
						rs.getInt("id_jug"),
						rs.getString("nom_jug"),
						rs.getDouble("pre_jug"),
						rs.getString("marc_jug"),
						rs.getInt("cat_jug"),
						rs.getInt("stock_jug"),
						rs.getInt("prov_jug")
						));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		closeConn();
	}
	
	public DefaultTableModel showToysTable(DefaultTableModel modelo) 
	{
		readToys();
		Object[][] datos = new Object[toyList.size()][7];
		for(int i=0;i<toyList.size();i++)
		{
			datos[i][0] = toyList.get(i).getId_jug();
			datos[i][1] = toyList.get(i).getNom_jug();
			datos[i][2] = toyList.get(i).getPre_jug();
			datos[i][3] = toyList.get(i).getMarc_jug();
			datos[i][4] = toyList.get(i).getCat_jug();
			datos[i][5] = toyList.get(i).getStock_jug();
			datos[i][6] = toyList.get(i).getProv_jug();
		}
		String[] Encabezados = {"Id","Nombre","Precio","Marca","Categoria","Stock","Proveedor"};
		return modelo = new DefaultTableModel(datos, Encabezados);
	}
	
	public void showSuppliers() 
	{
		readSuppliers();
		System.out.println("\nId_Prov\tNom\tTel\tMail");
		for (Proveedor prov : supplierList) 
		{
			System.out.println(prov.toString());
		}
	}
	
	private void readSuppliers() 
	{
		conectConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "SELECT * FROM proveedores;";
		
		supplierList = new ArrayList<>();
		try 
		{
			pstm = con.prepareStatement(query);
			rs=pstm.executeQuery();
			
			while(rs.next())
			{
				supplierList.add(new Proveedor(
						rs.getInt("id_prov"),
						rs.getString("nom_prov"),
						rs.getString("tel_prov"),
						rs.getString("mail_prov")
						));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		closeConn();
	}
	
	private void closeConn() 
	{
		try {
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

