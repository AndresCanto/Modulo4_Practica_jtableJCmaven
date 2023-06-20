package jtable_jugueteria;

public class Lanzador 
{
	public static void main(String[] args) 
	{
		Modelo mod = new Modelo();
		Vista vis = new Vista();
		Controlador cont =  new Controlador(mod,vis);
	}	
}
