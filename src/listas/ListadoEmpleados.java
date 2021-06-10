package listas;

import java.io.Serializable;
import java.util.ArrayList;

import genericos.Listado;
import modelos.Empleado;

public class ListadoEmpleados implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Listado<Empleado> empleados;
	
	public ListadoEmpleados() {
		empleados = new Listado<Empleado>();
	}
	
	public ListadoEmpleados(ListadoEmpleados listaEmpleados) {
		
		empleados = new Listado<Empleado>();
		this.agregarListaDeEmpleados(listaEmpleados.devolverEmpleados()); 
	}
	
	public boolean agregarEmpleado(Empleado elemento) {
		return empleados.agregarElemento(elemento);
	}
	
	public boolean eliminarEmpleado(Empleado elemento)
	{
		return empleados.agregarElemento(elemento);
	}
	
	public boolean eliminarEmpleadoObj(Empleado elemento) {
		return empleados.eliminarElementoObj(elemento);
	}
	
	public Empleado eliminarEmpleadoIndex(int  index) {
		return empleados.buscarElemento(index);
	}
	
	public String listarEmpleados() {
		return empleados.listarElementos();
	}
	
	public int cantidadDeEmpleados() {
		return empleados.contarElementos();
	}
	
	public boolean existeEmpleado(Empleado empleado) {
		return empleados.existeElemento(empleado);
	}
	
	public ArrayList<Empleado> devolverEmpleados() {
		ArrayList<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
		
		for(int i = 0 ; i < empleados.contarElementos() ; i++) {
			listaDeEmpleados.add(empleados.buscarElemento(i));
		}
		
		return listaDeEmpleados;
	} 
	
	public void agregarListaDeEmpleados(ArrayList<Empleado> listaDeEmpleado) {
		
		for(Empleado empleado : listaDeEmpleado) {
			this.empleados.agregarElemento(empleado);
		}
	}	
	
	
}
