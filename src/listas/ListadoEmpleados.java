package listas;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.ErrorDeBusquedaExcepcion;
import genericos.Listado;
import modelos.Cajero;
import modelos.Empleado;
import modelos.Gerente;
import modelos.Vendedor;

/**
 * @author Nicolas Juarez
 * 
 * Esta clase posee métodos para controlar una Lista de Empleados
 */

public class ListadoEmpleados implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Listado<Empleado> empleados;
	private ArrayList<Empleado> lista;
	
	public ListadoEmpleados() {
		empleados = new Listado<Empleado>();
	}
	
	public ListadoEmpleados(ListadoEmpleados listaEmpleados) {
		
		empleados = new Listado<Empleado>();
		this.agregarListaDeEmpleados(listaEmpleados.devolverEmpleados()); 
	}
	
	
	public ArrayList<Empleado> getEmpleados() {
		return lista;
	}

	public boolean agregarEmpleado(Empleado elemento) {
		return empleados.agregarElemento(elemento);
	}
	
	
	public Empleado buscarEmpleadoIndex(int  index) {
		return empleados.buscarElemento(index);
	}
	
	public String listarEmpleados() {
		return empleados.listarElementos();
	}
	
	public int cantidadDeEmpleados() {
		return empleados.contarElementos();
	}
	
	
	// no me sirve
	public boolean existeEmpleado(Empleado empleado) {
		return empleados.existeElemento(empleado);
	}
	
	public int existeEmpleado(String dni) throws ErrorDeBusquedaExcepcion
	{
		int resp=-1;	
		boolean existe=false;
				

			for (int i = 0; i < empleados.contarElementos(); i++) 
			{
				if(empleados.buscarElemento(i).getDni().equals(dni))
				{	
					resp=i;
					existe=true;
					
				}		
			}	
			
			if(!existe)
			{
				throw new ErrorDeBusquedaExcepcion("Empleado no encontrado");
			}
						
			return resp;
			
	}
	
	public ArrayList<Empleado> devolverEmpleados() {
		ArrayList<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
		
		for(int i = 0 ; i < empleados.contarElementos() ; i++) {
			listaDeEmpleados.add(empleados.buscarElemento(i));
		}
		
		return listaDeEmpleados;
	} 
	
	
	
	public boolean eliminarEmpleado(String dni)throws ErrorDeBusquedaExcepcion
	{
		boolean rta=false;
		
		for (int i = 0; i < empleados.contarElementos(); i++) 
		{
			if(empleados.buscarElemento(i).getDni().equals(dni))
			{
				empleados.eliminarElementoIndice(i);
				rta=true;
			}
		}
		
		if(!rta)
		{
			throw new ErrorDeBusquedaExcepcion("Cliente no encontrado");
		}
		
		return rta;
		
	}
	
	
	
	public int modificarEmpleado(String dni)
	{
		int borrar = -1;
		
		boolean rta=false;
		//Empleado empleado = null;
		
		for (int i = 0; i < empleados.contarElementos(); i++) 
		{
			if(empleados.buscarElemento(i).getDni().equals(dni))
			{
				borrar=i;	
			}		
		}	
		return borrar;
	}
	
	
	
	
	
	
	
	
	public String devolverVendedores()
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<Empleado> arrayEmpleados = devolverEmpleados();
		
		for (Empleado empleado : arrayEmpleados) 
		{
			if(empleado instanceof Vendedor)
			{
				builder.append(empleado.toString());
			}
			
		}
		if(builder.isEmpty())
		{
			builder.append("El archivo esta vacio.");
		}
		return builder.toString();
		
	}
	
	public String devolverCajeros()
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<Empleado> arrayEmpleados = devolverEmpleados();
		
		for (Empleado empleado : arrayEmpleados) 
		{
			if(empleado instanceof Cajero)
			{
				builder.append(empleado.toString());
			}
			
		}
		
		if(builder.isEmpty())
		{
			builder.append("El archivo esta vacio.");
		}
		return builder.toString();
		
	}
	
	public String devolverGerentes()
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<Empleado> arrayEmpleados = devolverEmpleados();
		
		for (Empleado empleado : arrayEmpleados) 
		{
			if(empleado instanceof Gerente)
			{
				builder.append(empleado.toString());
			}
			
		}
		if(builder.isEmpty())
		{
			builder.append("El archivo esta vacio.");
		}
		return builder.toString();
		
	}
	
	
	
	
	
	
	
	
	
	/*
	 * ESTO GUARDA EN EL ARCHIVO 
	 */
	
	public void agregarListaDeEmpleados(ArrayList<Empleado> listaDeEmpleado) {
		
		for(Empleado empleado : listaDeEmpleado) {
			this.empleados.agregarElemento(empleado);
		}
	}	
	
}
