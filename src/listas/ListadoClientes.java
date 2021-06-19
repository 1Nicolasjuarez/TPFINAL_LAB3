package listas;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.ErrorDeBusquedaExcepcion;
import genericos.Listado;
import modelos.Cliente;
import modelos.Empleado;
import modelos.Gerente;

public class ListadoClientes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Listado<Cliente> clientes;
	
	public ListadoClientes() {	
		clientes = new Listado<Cliente>();
	}
	
	
	public ListadoClientes(ListadoClientes listaClientes) {
		
		clientes = new Listado<Cliente>();
		this.agregarListaDeClientes(listaClientes.devolverClientes()); 
	}
	
	
	public boolean agregarCliente(Cliente elemento) {
		return clientes.agregarElemento(elemento);
	}
	
	
	
	public boolean eliminarClienteObj(Cliente elemento) {
		return clientes.eliminarElementoObj(elemento);
	}
	
	public Cliente buscarClienteIndex(int  index) {
		return clientes.buscarElemento(index);
	}
	
	
	public String listarClientes() {
		return clientes.listarElementos();
	}
	
	
	public int cantidadDeClientes() {
		return clientes.contarElementos();
	}
	
	public boolean existeCliente(Cliente cliente) {
		return clientes.existeElemento(cliente);
	}
	
	public ArrayList<Cliente> devolverClientes() {
		ArrayList<Cliente> listaDeclientes = new ArrayList<Cliente>();
		
		for(int i = 0 ; i < clientes.contarElementos() ; i++) {
			listaDeclientes.add(clientes.buscarElemento(i));
		}

		return listaDeclientes;
	} 
	
	public void agregarListaDeClientes(ArrayList<Cliente> listaDeClientes) {
		
		for(Cliente cliente : listaDeClientes) {
			this.clientes.agregarElemento(cliente);
		}
	}	
	
	public boolean eliminarCliente(String dni)throws ErrorDeBusquedaExcepcion
	{
		boolean rta=false;
		
		for (int i = 0; i < clientes.contarElementos(); i++) 
		{
			if(clientes.buscarElemento(i).getDni().equals(dni))
			{
				clientes.eliminarElementoIndice(i);
				rta=true;
			}
		}
		
		if(!rta)
		{
			throw new ErrorDeBusquedaExcepcion("Cliente no encontrado");
		}
		
		return rta;
		
	}
	
	
	public int existeCliente(String dni) throws ErrorDeBusquedaExcepcion
	{
		int resp=-1;	
		boolean existe=false;
				

			for (int i = 0; i < clientes.contarElementos(); i++) 
			{
				if(clientes.buscarElemento(i).getDni().equals(dni))
				{	
					resp=i;
					existe=true;
					
				}		
			}	
			
			if(!existe)
			{
				throw new ErrorDeBusquedaExcepcion("Cliente no encontrado");
			}
						
			return resp;
			
	}
	public String listarClientes1()
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<Cliente> arrayClientes = devolverClientes();
		
		for (Cliente cliente : arrayClientes) 
		{
			
				builder.append(cliente.toString());
			
			
		}
		if(builder.isEmpty())
		{
			builder.append("El archivo esta vacio.");
		}
		return builder.toString();
		
	}
	
	

}
