package caja;

import java.util.Date;

import listas.ListadoVentas;
import modelos.Empleado;

public class Caja {
	
	
	private boolean isAbierta;
	private Date fechaActual;
	private ListadoVentas listVentas;
	private double totalRecaudado;
	private Empleado cajero;
	
	public Caja(Empleado x) {

		isAbierta=true;
		fechaActual=new Date();
		listVentas = new ListadoVentas();
		totalRecaudado =0;
	}
	

	public void cerrarCaja()
	{
		
	}
	
}
